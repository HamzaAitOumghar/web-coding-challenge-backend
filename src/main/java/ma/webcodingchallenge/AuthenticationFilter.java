package ma.webcodingchallenge;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import ma.webcodingchallenge.entities.User;
import ma.webcodingchallenge.entities.UserPrincipal;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	
	private AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		User user = null;
		
		
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), User.class);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
	}
	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		UserPrincipal principalUser = (UserPrincipal) authResult
				.getPrincipal();

		String jwToken = Jwts.builder().setSubject(principalUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityUtil.EXPREATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityUtil.SECRET).claim("roles", principalUser.getAuthorities())
				.compact();

		response.addHeader(SecurityUtil.TOKEN_STRING, SecurityUtil.TOKEN_PREFIX + jwToken);

	}
	
	
	
}
