package lucia.projectspring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import lucia.projectspring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

  MemberService memberService = new MemberService();

  @Test
  void join() {

    //given
    Member member = new Member();
    member.setName("hello");

    //when
    Long saveId = memberService.join(member);

    //then
    Member resultMember = memberService.findOne(saveId).get();
    assertThat(member.getName()).isEqualTo(resultMember.getName());
  }

  @Test
  void validateException() {
    //given
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");

    //when
    memberService.join(member1);
    try {
      memberService.join(member2);
      fail();
    } catch (IllegalStateException e) {
      assertThat(e.getMessage()).isEqualTo("This is already Existing Name");
    }

    //then

  }

  @Test
  void findMembers() {
  }

  @Test
  void findOne() {
  }
}