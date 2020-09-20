package com.ravali.oauth2.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends User implements UserDetails {

	private static final long serialVersionUID = 1L;

	public CustomUserDetails(User user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		getRoles().forEach(role -> {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
			role.getPermissions().forEach(permission -> {
				grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
			});

		});
		return grantedAuthorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.isAccountNotExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.isAccountNotLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.isCredentialsNotExpired();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}
}
