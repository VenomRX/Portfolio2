package com.Mark1_Jobportal.jobportal.repository;

import com.Mark1_Jobportal.jobportal.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {


    Optional<Users> findByEmail(String email);
}
