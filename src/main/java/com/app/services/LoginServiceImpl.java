package com.app.services;

import java.util.Date;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserAuthenticationDetails;
import com.app.entities.PortalUserDetails;
import com.app.repositories.PortalUserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger log = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	private PortalUserRepository portalUserRepository;

	@Override
	public UserAuthenticationDetails getUserById(Long id) {
		UserAuthenticationDetails userDetailsDTO = null;
		PortalUserDetails portalUserDetails = portalUserRepository.findById(id).orElse(null);
		//entityToDTO(userDetailsDTO, portalUserDetails);
		return userDetailsDTO;
	}

	

	private PortalUserDetails dtoToEntity(UserAuthenticationDetails userDetailsDTO) {
		PortalUserDetails portalUserDetails = new PortalUserDetails();
		portalUserDetails.setUsername(userDetailsDTO.getUsername());
		portalUserDetails.setPassword(userDetailsDTO.getPassword());
		portalUserDetails.setCreatedDate(new Date());
		portalUserDetails.setUpatedDate(new Date());
		return portalUserDetails;

	}

	@Override
	public Long saveUser(UserAuthenticationDetails userDetailsDTO) {
		return portalUserRepository.save(dtoToEntity(userDetailsDTO)).getId();
	}

	@Override
	public UserAuthenticationDetails updateUserDetails(UserAuthenticationDetails userDetailsDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
