package com.gawcode.toraiautsu.repository;

import com.gawcode.toraiautsu.model.member.TeamMember;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamMemberRepository extends MongoRepository<TeamMember, Long> {
    TeamMember findByEmail(String email);

    TeamMember findByUsernameIgnoreCase(String username);
}
