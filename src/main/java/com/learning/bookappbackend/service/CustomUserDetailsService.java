package com.learning.bookappbackend.service;

import com.learning.bookappbackend.enums.UserRoleEnum;
import com.learning.bookappbackend.model.User;
import com.learning.bookappbackend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User existingUser = userRepo.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found for email "+ email));

        List<UserRoleEnum> roles = List.of(existingUser.getRole());
        List<GrantedAuthority> authorities = roles.stream().map(role -> new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return role.toString();
            }
        }).collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                existingUser.getEmail(),
                existingUser.getPassword(),
                authorities);
    }
}
