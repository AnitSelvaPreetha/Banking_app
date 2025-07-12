package com.project.the_banking_app.repository;

import com.project.the_banking_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

Boolean existsByEmail(String email);





}
