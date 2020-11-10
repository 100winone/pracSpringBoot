package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // Optional은 java 8에 들어간 기능
    Optional<Member> findByName(String name); //findByName 가져 올 때 null일 수 있는데, 그대로 null반환 보다 optional로 감싸서 반환 하는 것을 선호
    List<Member> findAll();
}
