package com.gawcode.tameshite.repository;

import com.gawcode.tameshite.model.member.TeamMember;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamMemberRepository extends MongoRepository<TeamMember, Long> {
    TeamMember findByEmail(String email);

    TeamMember findByUsernameIgnoreCase(String username);
}
