package ma.webcodingchallenge.entities;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	
	@ManyToMany
	@JoinTable(name="user_role",joinColumns=@JoinColumn(name="user_Id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="role_Id",referencedColumnName="id"))
	private Set<Role> user_roles;
	
	@ManyToMany
	@JoinTable(name="user_shop",joinColumns=@JoinColumn(name="user_Id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="shop_Id",referencedColumnName="id"))
	private Set<Shop> likedShop;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getUser_roles() {
		return user_roles;
	}
	public void setUser_roles(Set<Role> user_roles) {
		this.user_roles = user_roles;
	}
	public Set<Shop> getLikedShop() {
		return likedShop;
	}
	public void setLikedShop(Set<Shop> likedShop) {
		this.likedShop = likedShop;
	}
	
	
	
}
