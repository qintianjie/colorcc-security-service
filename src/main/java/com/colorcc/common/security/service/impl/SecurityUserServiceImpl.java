package com.colorcc.common.security.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.colorcc.common.security.mapper.SecurityUserMapper;
import com.colorcc.common.security.model.SecurityUser;
import com.colorcc.common.security.service.SecurityUserService;

public class SecurityUserServiceImpl implements SecurityUserService {

	private static final Logger logger = LoggerFactory.getLogger(SecurityUserServiceImpl.class);

	SecurityUserMapper securityUserMapper;

	public SecurityUserMapper getSecurityUserMapper() {
		return securityUserMapper;
	}

	public void setSecurityUserMapper(SecurityUserMapper securityUserMapper) {
		this.securityUserMapper = securityUserMapper;
	}

	@Override
	public SecurityUser loadUserByEmail(String email) {
		if (logger.isDebugEnabled()) {
			logger.debug("Load user by email: " + email);
		}
		return securityUserMapper.findUserByEmail(email);
	}

}
