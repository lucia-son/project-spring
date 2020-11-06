package lucia.projectspring.repository;

import java.util.List;
import lucia.projectspring.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
