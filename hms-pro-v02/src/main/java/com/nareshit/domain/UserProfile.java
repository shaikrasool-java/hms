package com.nareshit.domain;

import java.io.Serializable;

public class UserProfile implements Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String userId;
  private String firstName;
  private String lastName;
  private String email;
  private Long mobile;
  private String password;
  private String confPswd;
  private boolean status;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getMobile() {
	return mobile;
}
public void setMobile(Long mobile) {
	this.mobile = mobile;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfPswd() {
	return confPswd;
}
public void setConfPswd(String confPswd) {
	this.confPswd = confPswd;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
  
  
}
