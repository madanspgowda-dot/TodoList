package com.example.TodoList.Repository;

import com.example.TodoList.Entity.SignUpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SignUpRepository extends JpaRepository<SignUpEntity,Integer> {
    Optional<SignUpEntity> findByEmail(String email);
}
