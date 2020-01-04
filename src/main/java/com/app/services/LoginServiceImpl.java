package com.app.services;

import java.util.Date;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserDetailsDTO;
import com.app.entities.PortalUserDetails;
import com.app.repositories.PortalUserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger log = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	private PortalUserRepository portalUserRepository;

	@Override
	public UserDetailsDTO getUserById(Long id) {
		UserDetailsDTO userDetailsDTO = null;
		PortalUserDetails portalUserDetails = portalUserRepository.findById(id).orElse(null);
		entityToDTO(userDetailsDTO, portalUserDetails);
		return userDetailsDTO;
	}

	private void entityToDTO(UserDetailsDTO userDetailsDTO, PortalUserDetails portalUserDetails) {
		if (Objects.nonNull(portalUserDetails)) {
			userDetailsDTO = new UserDetailsDTO();
			userDetailsDTO.setPassword(portalUserDetails.getPassword());
			userDetailsDTO.setUsername(portalUserDetails.getUsername());
			userDetailsDTO.setUserId(portalUserDetails.getId());
		}
	}

	private PortalUserDetails dtoToEntity(UserDetailsDTO userDetailsDTO) {
		PortalUserDetails portalUserDetails = new PortalUserDetails();
		portalUserDetails.setUsername(userDetailsDTO.getUsername());
		portalUserDetails.setPassword(userDetailsDTO.getPassword());
		portalUserDetails.setCreatedDate(new Date());
		portalUserDetails.setUpatedDate(new Date());
		return portalUserDetails;

	}

	@Override
	public Long saveUser(UserDetailsDTO userDetailsDTO) {
		return portalUserRepository.save(dtoToEntity(userDetailsDTO)).getId();
	}

	@Override
	public UserDetailsDTO updateUserDetails(UserDetailsDTO userDetailsDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
