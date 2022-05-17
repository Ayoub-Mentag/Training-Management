package com.example.espacebenificiere.security.services;


import com.example.espacebenificiere.security.entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private SecurityServiceImpl securityService;

    public UserDetailsServiceImpl(SecurityServiceImpl securityService) {
        this.securityService = securityService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = securityService.loadByUserName(username);
        //use the streams
        Collection<GrantedAuthority> authorities1 =
                appUser.getAppRoles()
                        .stream()
                        .map(role->new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());

        User user = new User(appUser.getEmail() , appUser.getPassword() , authorities1);
        return user;
    }
}
