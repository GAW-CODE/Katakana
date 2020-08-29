package com.gawcode.tameshite.model.member;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Collection;

@Document("team-members")
public class TeamMember {
    @Id
    private long id;

    @DBRef
    private Collection<TeamMemberRole> roles;
}
