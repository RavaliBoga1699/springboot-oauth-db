package com.ravali.oauth2.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ravali.oauth2.model.CustomUserDetails;
import com.ravali.oauth2.model.User;
import com.ravali.oauth2.repository.UserRepo;

@Service("userDetailsService")
public class UserService implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 	Optional<User> optionalUser = userRepo.findByUsername(username);

	        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));

	        UserDetails userDetails = new CustomUserDetails(optionalUser.get());
	        new AccountStatusUserDetailsChecker().check(userDetails);
	        return userDetails;
	}

}
