package com.sajalinghal7.jwtAuthApi.repository;

import com.sajalinghal7.jwtAuthApi.entities.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserDataDao extends CrudRepository<UserData, String> {}