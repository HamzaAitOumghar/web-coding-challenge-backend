package ma.webcodingchallenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.webcodingchallenge.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
