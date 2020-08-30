package com.gawcode.tameshite.service.impl;

import com.gawcode.tameshite.model.member.TeamMember;
import com.gawcode.tameshite.repository.TeamMemberRepository;
import com.gawcode.tameshite.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TeamMemberServiceImpl implements TeamMemberService {
    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Override
    public Optional<TeamMember> find(long id) {
        return this.teamMemberRepository.findById(id);
    }

    @Override
    public Optional<TeamMember> find(String email) {
        return Optional.ofNullable(this.teamMemberRepository.findByEmail(email));
    }

    @Override
    public Optional<TeamMember> findByUsername(String username) {
        return Optional.ofNullable(this.teamMemberRepository.findByUsernameIgnoreCase(username));
    }
}
