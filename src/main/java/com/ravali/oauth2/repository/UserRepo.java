package com.ravali.oauth2.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ravali.oauth2.model.User;


public interface UserRepo extends CrudRepository<User, Integer> {
	 Optional<User> findByUsername(String name);
}
