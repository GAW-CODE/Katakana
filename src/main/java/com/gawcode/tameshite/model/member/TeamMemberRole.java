package com.gawcode.tameshite.model.member;

import com.gawcode.tameshite.model.member.TeamMember;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class TeamMemberRole {
    @Id
    private long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<TeamMember> teamMembers;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<TeamMemberRolePrivilege> privileges;
}
