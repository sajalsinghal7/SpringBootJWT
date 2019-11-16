package com.sajalinghal7.jwtAuthApi.controllers;

import com.sajalinghal7.jwtAuthApi.entities.UserData;
import com.sajalinghal7.jwtAuthApi.models.AuthenticationResponse;
import com.sajalinghal7.jwtAuthApi.models.UserDataPOJO;
import com.sajalinghal7.jwtAuthApi.services.SajalUserDetailsService;
import com.sajalinghal7.jwtAuthApi.services.UserDataService;
import com.sajalinghal7.jwtAuthApi.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUp {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private SajalUserDetailsService sajalUserDetailsService;

    @Autowired
    private UserDataService userDataService;

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDataPOJO userDataPOJO) throws Exception {

        UserData userData = userDataService.getPersonByEmail(userDataPOJO.getEmail());
        if(userData == null) {
            UserData newUser = new UserData(userDataPOJO.getEmail(), userDataPOJO.getPassword(), userDataPOJO.getName());
            userDataService.saveOrUpdate(newUser);
        } else {
            throw new Exception("User Already Exists");
        }


        final UserDetails userDetails = sajalUserDetailsService
                .loadUserByUsername(userDataPOJO.getEmail());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
