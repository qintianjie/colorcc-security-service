package com.colorcc.common.security.service.impl;

import java.util.List;

import com.colorcc.common.security.mapper.SecurityRoleMapper;
import com.colorcc.common.security.model.SecurityRole;
import com.colorcc.common.security.service.SecurityRoleService;

public class SecurityRoleServiceImpl implements SecurityRoleService {
	
	SecurityRoleMapper securityRoleMapper;

	public SecurityRoleMapper getSecurityRoleMapper() {
		return securityRoleMapper;
	}

	public void setSecurityRoleMapper(SecurityRoleMapper securityRoleMapper) {
		this.securityRoleMapper = securityRoleMapper;
	}

	@Override
	public List<SecurityRole> getUserRoles(int userId) {
		return securityRoleMapper.getRolesForUser(userId);
	}

}
