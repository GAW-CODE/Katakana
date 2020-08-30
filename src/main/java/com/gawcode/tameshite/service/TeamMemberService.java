package com.gawcode.tameshite.service;

import com.gawcode.tameshite.model.member.TeamMember;

import java.util.Optional;

public interface TeamMemberService {
    Optional<TeamMember> find(long id);

    Optional<TeamMember> find(String email);

    Optional<TeamMember> findByUsername(String username);
}
