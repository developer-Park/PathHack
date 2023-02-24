package com.example.pathhack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pathhack.entity.Coupon;
import com.example.pathhack.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
