package ma.webcodingchallenge.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ma.webcodingchallenge.entities.User;
import ma.webcodingchallenge.entities.UserPrincipal;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		
		User user = this.userRepository.findByEmail(email);


		
		if (user == null) {
			throw new UsernameNotFoundException("email" + email + "not found ");
		}

		Set<GrantedAuthority> authorities = new HashSet<>();

		user.getUser_roles().forEach(
				r -> {
					authorities.add(new SimpleGrantedAuthority(r.getName()));
				});
		
		return new UserPrincipal(user, authorities);
	}

}
