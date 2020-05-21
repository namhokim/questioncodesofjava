package com.example.springboot.sandbox.repository;

import com.example.springboot.sandbox.repository.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {}
