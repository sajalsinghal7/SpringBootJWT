package com.sajalinghal7.jwtAuthApi.services;

import com.sajalinghal7.jwtAuthApi.entities.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class SajalUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDataService userDataService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserData userData = userDataService.getPersonByEmail(email);
        return new User(userData.getEmail(), userData.getPassword(), new ArrayList<>());
//        return new User("public", "123", new ArrayList<>());
    }
}
