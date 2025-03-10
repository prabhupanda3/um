package com.fmt.Umd.Repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.model.Role;
import com.fmt.Umd.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
public Optional<User> findByUsername(String username);
@Query("SELECT u.role FROM User u WHERE u.username = :username")
public Role getUSerRoleByUseName(String username);
User findByUsernameOrPasswordOrEmail(String username,String password,String email);
User findAllByUsername(String username);

}
