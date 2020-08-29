package com.gawcode.tameshite.model.member;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "team_members")
public class TeamMember {
    @Id
    @Column(name = "team_member_id")
    private long id;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<TeamMemberRole> roles;
}
