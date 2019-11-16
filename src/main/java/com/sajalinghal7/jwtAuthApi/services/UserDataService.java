package com.sajalinghal7.jwtAuthApi.services;

import com.sajalinghal7.jwtAuthApi.entities.UserData;
import com.sajalinghal7.jwtAuthApi.repository.UserDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {
    @Autowired
    UserDataDao userDataDao;

    public void saveOrUpdate(UserData userData) {
        userDataDao.save(userData);
    }
    public UserData getPersonByEmail(String email) {
        UserData userData = null;
        try {
            userData =  userDataDao.findById(email).get();
        } catch (Exception e) {
            userData = null;
        }
        return userData;
    }
}
