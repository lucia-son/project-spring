package lucia.projectspring.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import lucia.projectspring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {

  MemoryMemberRepository repository = new MemoryMemberRepository();

  @AfterEach
  public void afterEach() {
    repository.clearStore();
  }

  @Test
  public void save() {
    Member member = new Member();
    member.setName("spring");
    repository.save(member);

    Member result = repository.findById(member.getId()).get();
    assertThat(result).isEqualTo(member);
  }
  
  @Test
  public void findByName() {
    Member member1 = new Member();
    member1.setName("spring");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("summer");
    repository.save(member2);


    Member result = repository.findByName("spring").get();
    assertThat(result).isEqualTo(member1);
  }

  @Test
  public void findByAll() {
    Member member1 = new Member();
    member1.setName("spring");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("summer");
    repository.save(member2);

    List<Member> members = repository.findAll();
    assertThat(members.size()).isEqualTo(2);
  }

}

