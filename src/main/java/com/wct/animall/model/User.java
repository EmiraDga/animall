package com.wct.animall.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Size(max = 20)
	@Email
	private String email;

	private String lastname;

	private String firstname;

	private String mobile;

	private String phone;
	@JsonIgnore
	private boolean active;

	private boolean isAccountNonExpired;

	private boolean isAccountNonLocked;

	private boolean isEnabled;

	@NotBlank
	@Size(max = 20)
	private Authority authority;

	@NotBlank
	@Size(max = 120)
	private String password;

	@NotBlank
	@Size(max = 20)
	private String username;

	@OneToMany(mappedBy = "user")
	private List<Announcement> annoucements;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public User() {
	}

	public User(String username, String email, String password, String mobile, String phone, String lastname,
			String firstname, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean active,
			boolean isEnabled, Authority authority) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.phone = phone;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isEnabled = isEnabled;
		this.active = active;
		this.firstname = firstname;
		this.lastname = lastname;
		this.authority = authority;
	}

	public List<Announcement> getAnnoucements() {
		return annoucements;
	}

	public void setAnnoucements(List<Announcement> annoucements) {
		this.annoucements = annoucements;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

}
