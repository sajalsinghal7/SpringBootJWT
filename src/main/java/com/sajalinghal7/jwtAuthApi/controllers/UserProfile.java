package com.sajalinghal7.jwtAuthApi.controllers;

import com.sajalinghal7.jwtAuthApi.entities.UserData;
import com.sajalinghal7.jwtAuthApi.models.UserDataPOJO;
import com.sajalinghal7.jwtAuthApi.services.UserDataService;
import com.sajalinghal7.jwtAuthApi.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class UserProfile {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDataService userDataService;

    @RequestMapping(value = "/getUserDetails", method = RequestMethod.GET)
    public UserData getUserData(HttpServletRequest request) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String jwt = authorizationHeader.substring(7); // Removing "Bearer " from begining
        String email = jwtUtil.extractUsername(jwt);
        UserData userData = userDataService.getPersonByEmail(email);
        return userData;
    }

    @RequestMapping(value = "/updateUserDetails", method = RequestMethod.PUT)
    public void updateUserData(HttpServletRequest request, @RequestBody UserDataPOJO userDataPOJO) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String jwt = authorizationHeader.substring(7); // Removing "Bearer " from begining
        String email = jwtUtil.extractUsername(jwt);
        UserData userData = new UserData(email, userDataPOJO.getPassword(), userDataPOJO.getName());
        userDataService.saveOrUpdate(userData);
    }

}
