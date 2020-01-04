package com.app.services;

import com.app.dto.UserDetailsDTO;

public interface LoginService {

	UserDetailsDTO getUserById(Long id);

	Long saveUser(UserDetailsDTO userDetailsDTO);

	UserDetailsDTO updateUserDetails(UserDetailsDTO userDetailsDTO);

}
