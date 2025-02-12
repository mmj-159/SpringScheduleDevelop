package com.example.springscheduledevelop.service;

import com.example.springscheduledevelop.dto.SignUpResponseDto;
import com.example.springscheduledevelop.dto.UserResponseDto;
import com.example.springscheduledevelop.entity.User;
import com.example.springscheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public SignUpResponseDto signUp(String username, String password, String email) {

        User user   =new User(username,password,email);
        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    @Transactional
    public List<UserResponseDto> findAll(){
        List<User> users = userRepository.findAll();

        List<UserResponseDto> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(new UserResponseDto(user.getId(), user.getUsername(), user.getEmail()));
        }
        return dtos;
    }

    @Transactional
    public UserResponseDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 유저 없음")
        );
        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail());
    }
    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        User findUser = userRepository.findByIdOrElseThrow(id);

        if (!findUser.getPassword().equals(oldPassword)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다");
        }
        findUser.updatePassword(newPassword);
    }
    @Transactional
    public void deleteUserById(@PathVariable Long id) {
        if(!userRepository.existsById(id)){
            throw new IllegalArgumentException("id에 해당하는 User 존재하지 않음");
        }
        userRepository.deleteById(id);
    }
}
