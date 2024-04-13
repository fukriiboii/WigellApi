package se.fk.wigellapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.fk.wigellapi.models.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
