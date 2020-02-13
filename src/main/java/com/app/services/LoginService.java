package com.app.services;

import com.app.dto.UserDetailsDTO;

public interface LoginService {

	UserDetailsDTO getUserById(Long id);
	
	
	Long saveUserDetails(UserDetailsDTO userDetailsDTO);
	
	
	
	

}
