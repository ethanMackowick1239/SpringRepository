package com.tcs.authdemo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcs.authdemo.model.ERole;
import com.tcs.authdemo.model.Role;
import com.tcs.authdemo.model.User;
import com.tcs.authdemo.payload.request.LoginRequest;
import com.tcs.authdemo.payload.request.SignupRequest;
import com.tcs.authdemo.payload.response.JwtResponse;
import com.tcs.authdemo.payload.response.MessageResponse;
import com.tcs.authdemo.repository.RoleRepository;
import com.tcs.authdemo.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.tcs.authdemo.security.jwt.JwtUtils;
import com.tcs.authdemo.security.services.UserDetailsImpl;
@CrossOrigin("*")
@Controller
@RequestMapping("/api/auth")
public class AuthController {

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	AuthenticationManager authenticationmanager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetailsImpl.getAuthorities().stream().map(i->i.getAuthority()).collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt,userDetailsImpl.getId(),userDetailsImpl.getEmail(),userDetailsImpl.getUsername(),roles));
		
	}
	@PostMapping("/signup")
	
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest ) {
		
		if(userRepository.existsByUsername(signUpRequest.getUsername())) {
			
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken"));
		}
		if(userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use"));
		}
		
		User user = new User(signUpRequest.getUsername(), 
				 signUpRequest.getEmail(),
				signUpRequest.getPassword());
		
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		
		if(strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(()-> new RuntimeException("Error : Role is not available"));
			roles.add(userRole);
		}
		else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
