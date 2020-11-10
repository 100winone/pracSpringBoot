package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

// 구현체 구현
public class MemoryMemberRepository implements MemberRepository{ // implements하고 command + N 해서 다 추가, 구현 위해

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 실무에선 동시성 문제를 고려해서 단순 long을 사용하지는 않음
    @Override
    public Member save(Member member) {
        member.setId(++sequence); // member save 할 경우
        store.put(member.getId(), member); // store에 넣기 전에 id 값을 셋팅 해주는 것
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) { // 그냥 store에서 꺼내면됨
        return Optional.ofNullable(store.get(id)); // null이 반환될 가능성이 있을 때 Optional로 감싸서 반환해줌, 이렇게 해주면 클라이언트에서 뭘 할 수가있음
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        /*store에서 루프를 돌리는 것, filter에서 람다 싸용, getName이 파라미터로 넘어온 name과 같은지 확인
        * findAny() 그냥 찾으면 반환, Optional로 반환이 됨, 그냥 하나 찾아지면, 끝까지 했는 데 없으면 옵셔널 Null로해서 반환*/
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store에 있는 values값 멤버들 반환
    }
}
