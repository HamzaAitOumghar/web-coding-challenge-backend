package ma.webcodingchallenge.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	
	@ManyToMany(mappedBy="user_roles")
	@JsonIgnore
	private Set<User> role_users;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getRole_users() {
		return role_users;
	}
	public void setRole_users(Set<User> role_users) {
		this.role_users = role_users;
	}
	
	
	
	
}
