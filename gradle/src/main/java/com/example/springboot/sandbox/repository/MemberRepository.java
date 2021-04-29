package com.example.springboot.sandbox.repository;

import com.example.springboot.sandbox.repository.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query(nativeQuery = false, value = "SELECT m.name as name FROM Member m WHERE m.name = :searchingName")
    MemberProjection getTelephoneProjectionBy(@Param("searchingName") String searchingName);

    @Query(nativeQuery = true, value = "SELECT \"name\" as name FROM \"member\" as m WHERE \"name\" = :searchingName")
    MemberProjection getTelephoneProjectionByNative(@Param("searchingName") String searchingName);

}
