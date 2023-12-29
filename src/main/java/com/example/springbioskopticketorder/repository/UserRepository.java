package com.example.springbioskopticketorder.repository;

import com.example.springbioskopticketorder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
