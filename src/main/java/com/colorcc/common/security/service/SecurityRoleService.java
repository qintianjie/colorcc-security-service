package com.colorcc.common.security.service;

import java.util.List;

import com.colorcc.common.security.model.SecurityRole;

public interface SecurityRoleService {
	
	public List<SecurityRole> getUserRoles(int userId);

}
