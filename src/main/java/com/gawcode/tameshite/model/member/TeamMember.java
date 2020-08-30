package com.gawcode.tameshite.model.member;

import com.gawcode.tameshite.model.member.role.NamedRole;
import com.gawcode.tameshite.model.member.role.Role;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document("team-members")
public class TeamMember {
    @Id
    private long id;

    private String email, password;

    private Role role;

    public boolean has(NamedRole namedRole) {
        return this.role != null && this.role.has(namedRole.getRole());
    }
}
