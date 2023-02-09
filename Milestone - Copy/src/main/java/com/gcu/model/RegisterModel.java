package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterModel {

	@NotNull(message = "UserName is a required field!")
	@Size(min = 1, max = 32, message = "User Name must be between 1 and 32 characters!")
	private String userName;

	@NotNull(message = "Email Address is a required field!")
	@Size(min = 1, max = 32, message = "Email Address must be between 1 and 32 characters!")
	private String emailAddress;

	@NotNull(message = "Password is a required field!")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters!")
	private String password;

	public RegisterModel() {

	}

	/**
	 * @param Name
	 * @param emailAddress
	 * @param password
	 */
	public RegisterModel(String userName, String emailAddress, String password) {
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}