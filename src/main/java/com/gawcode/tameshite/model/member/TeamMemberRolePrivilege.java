package com.gawcode.tameshite.model.member;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class TeamMemberRolePrivilege {
    @Id
    private long id;

    private String name;
}
