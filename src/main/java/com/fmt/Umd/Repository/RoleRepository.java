package com.fmt.Umd.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmt.Umd.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Set<Role> findByAuthority(String Authority); 
	public Set<Role> findAllByParentRole(String authority);
	List<String> findParentRoleByRoleName(String roleName);

}
