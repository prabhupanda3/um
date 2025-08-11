package com.fmt.Umd.user.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fmt.Umd.DeviceManagement.Model.HierarchyMaster;

@Entity
public class User implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Integer user_id;
	@Column
	private String userIdName;
	@Column
	private String password;
	
	@Column(unique=true)
	private String username; 
	@Column
	private String clintId;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String OTP;
	@Column
	private String mobileNumber;
	@Column
	private String address;
	@Column
	private String hierarchy;

	@OneToMany(fetch = FetchType.EAGER)
	 @JoinTable( name = "user_role",
			 joinColumns = {@JoinColumn(name="user_id")},
		        inverseJoinColumns = {@JoinColumn(name="role_id")}
			    )
	 private Set<Role> role;
	@Column
	private String verify;
	@Column
	private String Image;
	@Column
	private String parentUser;
	@OneToMany(fetch = FetchType.EAGER)
	 @JoinTable( name = "uer_hmaster",
			 joinColumns = {@JoinColumn(name="user_id")},
		        inverseJoinColumns = {@JoinColumn(name="hm_id")}
			    )
	private List<HierarchyMaster> hierarchyMaster;
	public User() {
		super();
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	
	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getClintId() {
		return clintId;
	}
	public void setClintId(String clintId) {
		this.clintId = clintId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOTP() {
		return OTP;
	}
	public void setOTP(String oTP) {
		OTP = oTP;
	}
   
	
	public String getVerify() {
		return verify;
	}
	public void setVerify(String verify) {
		this.verify = verify;
	}

	public String getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}

	public String getUserIdName() {
		return userIdName;
	}

	public void setUserIdName(String userIdName) {
		this.userIdName = userIdName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}
	
	

	public String getParentUser() {
		return parentUser;
	}

	public void setParentUser(String parentUser) {
		this.parentUser = parentUser;
	}

	
	
	
	public List<HierarchyMaster> getHierarchyMaster() {
		return hierarchyMaster;
	}

	public void setHierarchyMaster(List<HierarchyMaster> hierarchyMaster) {
		this.hierarchyMaster = hierarchyMaster;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.role;
	}

	@Override 
	public boolean isAccountNonLocked() { 
		  // TODO Auto-generated method stub 
		  return true; 
		  }
	 
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
