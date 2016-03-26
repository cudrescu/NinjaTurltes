package com.endava.hackathon.service.security;

import com.endava.hackathon.model.UserEntity;
import com.endava.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userService.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("The user with email " + email + " was not found");
        }

        return getCustomUser(user);
    }

    private UserDetails getCustomUser(UserEntity user) {
        final Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRoleEntity().getDescription()));
        return new CustomUserDetails(user.getEmail(), user.getPassword(), true, true, true, true, authorities, user.getEmail());
    }

}
