package com.example.springscheduledevelop.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/", "/users/signup", "/auth/login","/auth/logout", "/schedules/all"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        log.info("로그인 필터 로직 실행");

        //WHITE LIST에 포함된 경우 true -> !true -> false
        if(!isWhiteList(requestURI)){

            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute("user")== null) {
                throw new RuntimeException("로그인 해주세요.");
            }

            log.info("로그인에 성공했습니다.");

        }
        // WHITE LIST에 등록된 URI면 filterChain.doFilter() 호출
        // 등록 안된 URI면 필터로직 통과 후 다음필터나 Servlet 호출
        // 다음 필터 없으면 Servlet -> Controller, 다음 필터 있으면 다음 Filter 호출
        filterChain.doFilter(request, response);
    }

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST,requestURI);
    }
}
