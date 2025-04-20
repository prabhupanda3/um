package com.fmt.Umd.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fmt.Umd.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Set<Role> findByAuthority(String Authority); 
	@Query("SELECT r.authority FROM Role r WHERE r.parentRole= :authority")
	List<String> findAuthorityByParentRole(@Param("authority") String authority);
	public List<String> findParentRoleByRoleName(String roleName);
	public Set<Role> findAllByParentRoleIn(List<String> authority);
    public Role	findAllByAuthority(String authorityName);


}
