package com.example.FormValidation.entities;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginData {

	@NotBlank(message = "User name cannot be empty.")
	@Size(min = 3, max = 12, message = "User name must be between 3 to 12 characters.")
	private String userName;

	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Email ID is invalid.")
	private String email;
	
	@AssertTrue(message = "Must agree terms and conditions.")
	private boolean agreed;
	
	public LoginData() {
		
	}
		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAgreed() {
		return agreed;
	}
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
	
}
