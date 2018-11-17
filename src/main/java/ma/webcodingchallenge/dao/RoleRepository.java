package ma.webcodingchallenge.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import ma.webcodingchallenge.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String name);
}
