package com.poohoh.springstudy.repository;

import com.poohoh.springstudy.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Integer>, MemberRepository {

    Optional<Member> findByName(String name);
}
