package lucia.projectspring.service;

import java.util.List;
import java.util.Optional;
import lucia.projectspring.domain.Member;
import lucia.projectspring.repository.MemberRepository;
import lucia.projectspring.repository.MemoryMemberRepository;

public class MemberService {

  private final MemberRepository memberRepository = new MemoryMemberRepository();

  /**
   * Member Sign in
   */
  public Long join(Member member) {
    validateDuplicatedName(member);
    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicatedName(Member member) {
    memberRepository.findByName(member.getName())
        .ifPresent(m -> {
          throw new IllegalStateException("This is already Existing Name");
        });
  }

  /**
   * List Members
   */
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
