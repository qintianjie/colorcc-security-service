package com.colorcc.common.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.colorcc.common.security.model.SecurityRole;
import com.colorcc.common.security.model.SecurityUser;
import com.colorcc.common.security.service.SecurityRoleService;
import com.colorcc.common.security.service.SecurityUserService;

public class UserDetailsServiceImpl implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	private final static String ROLE_USER = "ROLE_USER";

	SecurityRoleService securityRoleService;
	SecurityUserService securityUserService;
	
	public SecurityRoleService getSecurityRoleService() {
		return securityRoleService;
	}

	public void setSecurityRoleService(SecurityRoleService securityRoleService) {
		this.securityRoleService = securityRoleService;
	}


	public SecurityUserService getSecurityUserService() {
		return securityUserService;
	}

	public void setSecurityUserService(SecurityUserService securityUserService) {
		this.securityUserService = securityUserService;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		SecurityUser user = securityUserService.loadUserByEmail(username);

		if (user != null) {
			UserDetailsImpl userDetails = new UserDetailsImpl();

			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(ROLE_USER));
			for (SecurityRole role : securityRoleService.getUserRoles(user.getId())) {
				authorities.add(new SimpleGrantedAuthority(role.getRole()));
			}

			userDetails.setId(user.getId());
			userDetails.setEmail(user.getEmail());
			userDetails.setPassword(user.getPasswd());
			userDetails.setAuthorities(authorities);

			if (logger.isDebugEnabled()) {
				logger.debug("Do verify for the user [ " + user.getEmail() + " ]");
			}
			return userDetails;
		}

		return null;
	}
}
