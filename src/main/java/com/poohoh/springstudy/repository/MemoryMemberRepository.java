package com.poohoh.springstudy.repository;

import com.poohoh.springstudy.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

/*
 * 동시성 문제 고려 X, 실무에서는 ConcurrentHashMap, AtomicLong 고려
 */
@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<Member>(store.values());  // ArrayList를 생성하면서 인자로 Collection을 전달하면 순서대로 리스트에 저장됨.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    public void clearStore() {
        store.clear();
    }


}
