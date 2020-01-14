package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dto.UserDetailsDTO;
import com.app.entities.PortalUserDetails;
import com.app.exception.UserNotFoundException;
import com.app.repositories.PortalUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PortalUserRepository portalUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		PortalUserDetails appUser = portalUserRepository.findByUsername(username);

		if (null == appUser) {
			throw new UserNotFoundException("Incorrect username or password");
		}

		UserDetails userDetails = new UserDetailsDTO(appUser);

		return userDetails;
	}
}
