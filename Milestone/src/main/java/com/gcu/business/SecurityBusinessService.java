package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.model.LoginModel;

@Service
public class SecurityBusinessService {
	public boolean authenticate(LoginModel l) {

		List<LoginModel> users = new ArrayList<LoginModel>();

		users.add(new LoginModel("test", "test"));

		String u = l.getUsername();
		String p = l.getPassword();
		System.out.println("In SecurityBusinessService with " + u + ", " + p);

		for (LoginModel user : users) {
			if (user.equals(l)) {
				return true;
			}
		}
		return false;
	}

}
