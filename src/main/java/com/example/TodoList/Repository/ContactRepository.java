package com.example.TodoList.Repository;

import com.example.TodoList.Entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity,Integer> {
}
