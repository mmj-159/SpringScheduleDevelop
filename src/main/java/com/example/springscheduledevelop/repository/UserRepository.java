package com.example.springscheduledevelop.repository;

import com.example.springscheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

   default User findUserByUsernameOrElseThrow(String username){
       return findUserByUsername(username)
               .orElseThrow(
                       () -> new ResponseStatusException(
                       HttpStatus.NOT_FOUND,
                       "Does not exist username = " + username
               )
       );
   }


    default User findByIdOrElseThrow(Long id){
       return findById(id).orElseThrow(
               () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 id 없음")
       );
    }

    Optional<User> findByEmail(String email);
}
