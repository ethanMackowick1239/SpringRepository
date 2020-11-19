package com.tcs.auth.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.auth.model.User;
import com.tcs.auth.repository.RoleRepository;
import com.tcs.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	//@Transactional
	@Override
	public String registerUser(User user) {
		// TODO Auto-generated method stub
		
		if(userRepository.existsByEmail(user.getEmail())) {
			return "existing email";
		}
		if(userRepository.existsByUsername(user.getUsername())) {
			return "existing user";
		}
		User user2 = userRepository.save(user);
		
		return user2!=null?"success":"fail";
	}

}
