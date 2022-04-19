package com.gcu.business;

import com.gcu.model.LoginModel;

public interface UsersBusinessInterface {

	// Print test
	public void test();

	// CRUD
	public boolean login(LoginModel model);

	// Lifecycles
	public void init();

	public void destroy();
}
