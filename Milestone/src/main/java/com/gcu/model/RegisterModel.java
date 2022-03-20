package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterModel {

	@NotNull(message="First Name is a required field!")
	@Size(min=1, max=32, message="First Name must be between 1 and 32 characters!")
	private String firstName;
	
	@NotNull(message="Last Name is a required field!")
	@Size(min=1, max=32, message="Last Name must be between 1 and 32 characters!")
	private String lastName;
	
	@NotNull(message="Email Address is a required field!")
	@Size(min=1, max=32, message="Email Address must be between 1 and 32 characters!")
	private String emailAddress;
	
	@NotNull(message="Phone Number is a required field!")
	@Size(min=12, max=12, message="Phone Number must be exactly XXX-XXX-XXXX including hyphens!")
	private String phoneNumber;
	
	@NotNull(message="Username is a required field!")
	@Size(min=1, max=32, message="Username must be between 1 and 32 characters!")
	private String username;
	
	@NotNull(message="Password is a required field!")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters!")
	private String password;

	public RegisterModel () {
		
	}
	/**
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param phoneNumber
	 * @param username
	 * @param password
	 */
	public RegisterModel ( String firstName, String lastName, String emailAddress, String phoneNumber, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}


	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
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
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}