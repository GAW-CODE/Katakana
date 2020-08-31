package com.gawcode.toraiautsu.model.member.role;

import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class Role implements Comparable<Role> {
    private final long identifier;

    public Role add(Role other) {
        return new Role(this.identifier | other.identifier);
    }

    public Role remove(Role other) {
        return new Role(this.identifier & ~other.identifier);
    }

    public Role toggle(Role other) {
        return new Role(this.identifier ^ other.identifier);
    }

    public boolean has(Role other) {
        return (this.identifier & other.identifier) == other.identifier;
    }

    public boolean isEmpty() {
        return this.identifier == 0L;
    }

    @Override
    public int compareTo(Role other) {
        return (int) (this.identifier - other.identifier);
    }

    public static Role fromId(long identifier) {
        return new Role(identifier);
    }

    public NamedRole toNamed() {
        return Stream.of(NamedRole.values()).filter(namedRole -> namedRole.getRole().identifier == this.identifier).findFirst().orElse(null);
    }
}
