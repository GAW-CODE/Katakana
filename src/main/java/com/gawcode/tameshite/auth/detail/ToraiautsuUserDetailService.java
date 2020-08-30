package com.gawcode.tameshite.auth.detail;

import com.gawcode.tameshite.model.member.TeamMember;
import com.gawcode.tameshite.model.member.role.NamedRole;
import com.gawcode.tameshite.service.TeamMemberService;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ToraiautsuUserDetailService implements UserDetailsService {
    @Autowired
    private TeamMemberService teamMemberService;

    private static final EmailValidator EMAIL_VALIDATOR = new EmailValidator();

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return (EMAIL_VALIDATOR.isValid(s, null) ? this.teamMemberService.find(s.toLowerCase(Locale.ENGLISH)) : this.teamMemberService.findByUsername(s)).map(this::createSpringSecurityUser).orElseThrow(() -> new RuntimeException("The team member with username/email " + s + " does not exist"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(TeamMember teamMember) {
        List<GrantedAuthority> grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(teamMember.getRole() == null ? NamedRole.GUEST.getName() : teamMember.getRole().toNamed().getName()));
        return new org.springframework.security.core.userdetails.User(teamMember.getUsername(),
                teamMember.getPassword(),
                grantedAuthorities);
    }
}
