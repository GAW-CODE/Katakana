package com.gawcode.toraiautsu.service;

import com.gawcode.toraiautsu.model.member.TeamMember;

import java.util.Optional;

public interface TeamMemberService {
    Optional<TeamMember> find(long id);

    Optional<TeamMember> find(String email);

    Optional<TeamMember> findByUsername(String username);
}
