package com.fmt.Umd.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.UserDto.UserDTO;
import com.fmt.Umd.user.model.Role;
import com.fmt.Umd.user.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
public Optional<User> findByUsername(String username);
@Query("SELECT u.role FROM User u WHERE u.username = :username")
public Role getUSerRoleByUseName(String username);
User findByUsernameOrPasswordOrEmail(String username,String password,String email);
User findAllByUsername(String username);
public List<User> findAllByParentUser(String parentUser);

}
