package ma.webcodingchallenge.dao;

import java.util.HashSet;
import java.util.Set;

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

	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.userRepository.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("email" + username + "not found ");
		}

		Set<GrantedAuthority> authorities = new HashSet<>();

		user.getUser_roles().forEach(
				r -> {
					authorities.add(new SimpleGrantedAuthority(r.getName()));
				});
		
		return new UserPrincipal(user, authorities);
	}

}
