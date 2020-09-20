package com.ravali.oauth2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private String email;
	private boolean enabled;
	private boolean accountNotExpired;
	private boolean credentialsNotExpired;
	private boolean accountNotLocked;

	
   @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

	public User() {
	}

	public User(User user) {
		this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.isEnabled();
        this.accountNotExpired = user.isAccountNotExpired();
        this.credentialsNotExpired = user.isCredentialsNotExpired();
        this.accountNotLocked = user.isAccountNotLocked();
        this.roles = user.getRoles();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isAccountNotExpired() {
		return accountNotExpired;
	}
	public void setAccountNotExpired(boolean accountNotExpired) {
		this.accountNotExpired = accountNotExpired;
	}
	public boolean isCredentialsNotExpired() {
		return credentialsNotExpired;
	}
	public void setCredentialsNotExpired(boolean credentialsNotExpired) {
		this.credentialsNotExpired = credentialsNotExpired;
	}
	public boolean isAccountNotLocked() {
		return accountNotLocked;
	}
	public void setAccountNotLocked(boolean accountNotLocked) {
		this.accountNotLocked = accountNotLocked;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
