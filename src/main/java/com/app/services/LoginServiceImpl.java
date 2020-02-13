package com.app.services;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.app.dto.UserAuthenticationDetails;
import com.app.dto.UserDetailsDTO;
import com.app.entities.PortalUserDetails;
import com.app.entities.UserAuthority;
import com.app.repositories.PortalUserRepository;
import com.app.repositories.UserAuthoritiesRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger log = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	private PortalUserRepository portalUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserAuthoritiesRepository authoritiesRepository;

	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public UserDetailsDTO getUserById(Long id) {
		
		UserDetailsDTO userDetailsDTO = null;
		
		PortalUserDetails portalUserDetails = portalUserRepository.findById(id).orElse(null);
		
		if(Objects.nonNull(portalUserDetails)) {
			userDetailsDTO = new UserDetailsDTO();
			userDetailsDTO.setUsername(portalUserDetails.getUsername());
			//userDetailsDTO.setPassword(portalUserDetails.getPassword()   );
			userDetailsDTO.setFirstname(portalUserDetails.getFirstname());
			userDetailsDTO.setLastname(portalUserDetails.getLastname());
			userDetailsDTO.setMiddlename(portalUserDetails.getMiddlename());
			userDetailsDTO.setEmail(portalUserDetails.getEmail());
			userDetailsDTO.setGender(portalUserDetails.getGender());
			
			String dateOfBirth  =  portalUserDetails == null ? "": "ConvertAndReturnDateOfBirth";
			userDetailsDTO.setDateOfBirth(dateOfBirth);
			
			if(!CollectionUtils.isEmpty(portalUserDetails.getAuthorities())) {
				List <String> assignedRoles = portalUserDetails.getAuthorities().stream().map(role -> role.getAuthority().name()).collect(Collectors.toList());
				userDetailsDTO.setAssignedRoles(assignedRoles);
			}
			
			
		}
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

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public Long saveUserDetails(UserDetailsDTO userRegistrationDTO) {
		log.info("saveUserDetails() - start");
		String encodedPassword = passwordEncoder.encode(userRegistrationDTO.getPassword());
		userRegistrationDTO.setPassword(encodedPassword);
		
		PortalUserDetails entity  = dtoToEntity( userRegistrationDTO);
		portalUserRepository.save(entity);
		
		UserAuthority authority = new UserAuthority();
		authority.setPortalUserDetails(entity);
		authority.setAuthority(userRegistrationDTO.getUserRoleType());
		authority.setDescription("This role assigned by application to all the api created user.");
		
		log.info("Saving authorities detaails   -> ,"+authority);
		authoritiesRepository.save(authority);
		
		log.info("saveUserDetails() - stop");
		return entity.getId();
	}
	
	public PortalUserDetails dtoToEntity(UserDetailsDTO dto) {
		
		PortalUserDetails portalUserDetails  = new PortalUserDetails();
		portalUserDetails.setFirstname(dto.getFirstname());
		portalUserDetails.setLastname(dto.getLastname());
		portalUserDetails.setMiddlename(dto.getMiddlename());
		portalUserDetails.setUsername(dto.getUsername());
		portalUserDetails.setPassword(dto.getPassword());
		portalUserDetails.setEmail(dto.getEmail());
		portalUserDetails.setGender(dto.getGender());
		portalUserDetails.setIsAcccountLocked("N");
		portalUserDetails.setContactNumber(dto.getContactNumber());
		portalUserDetails.setAlternateContactNumber(dto.getAlternateContactNumber());
		//Set<UserAuthority> authorities = new HashSet<UserAuthority>();
		//portalUserDetails.setAuthorities(authorities);
		return portalUserDetails;
		
	}

	
}
