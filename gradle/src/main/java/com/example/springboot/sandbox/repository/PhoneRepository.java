package com.example.springboot.sandbox.repository;

import com.example.springboot.sandbox.repository.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
}
