package com.theblues.theblues.Repository;

import com.theblues.theblues.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByMember_id(String member_id);

}
