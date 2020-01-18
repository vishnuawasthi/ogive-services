package com.app.services;

import com.app.dto.UserAuthenticationDetails;

public interface LoginService {

	UserAuthenticationDetails getUserById(Long id);

	Long saveUser(UserAuthenticationDetails userDetailsDTO);

	UserAuthenticationDetails updateUserDetails(UserAuthenticationDetails userDetailsDTO);

}
