package ma.webcodingchallenge;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.webcodingchallenge.dao.RoleRepository;
import ma.webcodingchallenge.dao.UserRepository;
import ma.webcodingchallenge.entities.Role;
import ma.webcodingchallenge.entities.User;

@SpringBootApplication
public class WebCodingChallengeApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(WebCodingChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Role role = new Role();
//		role.setName("ROLE_USER");
//		this.roleRepo.save(role);
//		
//		User user = new User();
//		
//		user.setEmail("hamza@hamza.fr");
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		
//		user.setPassword(encoder.encode("hamza"));
//		
//		Set<Role> user_roles = new HashSet<>();
//		user_roles.add(role);
//		
//		user.setUser_roles(user_roles);
//		
//		
//		this.userRepo.save(user);
		
	}
	
	
}
