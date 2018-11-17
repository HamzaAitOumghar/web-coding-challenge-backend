package ma.webcodingchallenge.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.webcodingchallenge.dao.RoleRepository;
import ma.webcodingchallenge.dao.UserRepository;
import ma.webcodingchallenge.entities.Role;
import ma.webcodingchallenge.entities.User;

@RestController
public class UserRestService {
	
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	User newUser(@RequestBody User user) {

		Role role = roleRepository.findByName("ROLE_USER");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Set<Role> user_roles = new HashSet<>();
		user_roles.add(role);
		user.setUser_roles(user_roles);
		
		return this.userRepository.save(user);
	}

}
