package com.app.dto;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.entities.PortalUserDetails;

public class UserDetailsDTO implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PortalUserDetails portalUserDetails;

	public UserDetailsDTO(PortalUserDetails portalUserDetails) {
		this.portalUserDetails = portalUserDetails;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (Objects.isNull(portalUserDetails)) {
			return null;
		}

		List<String> authoritiesNames = portalUserDetails.getAuthorities().stream().map(auth -> {
			return auth.getAuthority().name();
		}).collect(Collectors.toList());

		List<GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(authoritiesNames.toArray(new String[authoritiesNames.size()]));
		return authorities;
	}

	@Override
	public String getPassword() {
		return portalUserDetails.getPassword();
	}

	@Override
	public String getUsername() {
		return portalUserDetails.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return "N".equalsIgnoreCase(portalUserDetails.getIsAcccountLocked());
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return "Y".equalsIgnoreCase(portalUserDetails.getIsEnabled());
	}

	@Override
	public String toString() {
		return "UserDetailsDTO [portalUserDetails=" + portalUserDetails + "]";
	}

}
