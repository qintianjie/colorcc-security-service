package com.colorcc.common.security.service;

import com.colorcc.common.security.model.SecurityUser;

public interface SecurityUserService {
	
	public SecurityUser loadUserByEmail(String email);
	
}
