package com.gawcode.tameshite.model.member;

import com.gawcode.tameshite.model.member.role.NamedRole;
import com.gawcode.tameshite.model.member.role.Role;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document("team-members")
@Getter
public class TeamMember {
    @Id
    private long id;

    private String username, email, password;

    private Role role;

    public boolean has(NamedRole namedRole) {
        return this.role != null && this.role.has(namedRole.getRole());
    }
}
