package com.gawcode.tameshite.model.member.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum NamedRole {
    GUEST("Guest", new Role(0L)),
    MEMBER("Member", new Role(1L << 1)),
    EDITOR("Editor", new Role(1L << 2)),
    MANAGER("Manager", new Role(1L << 3)),
    ADMIN("Admin", new Role(1L << 4));

    private final String name;
    private final Role role;
}
