package com.gawcode.tameshite.model.member;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Collection;

@Document("team-member-roles")
public class TeamMemberRole {
    @Id
    private long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<TeamMember> teamMembers;

    @DBRef
    private Collection<TeamMemberRolePrivilege> privileges;
}
