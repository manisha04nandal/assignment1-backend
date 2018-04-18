package main.java.com.outsource.platform.hiring.retailStore.model;

import java.util.Date;

/**
 * This class store the user detail for of each user, user can be employee, affiliate or normal customer
 * @author manisha nandal
 *
 */
public class User {

	private String username;
	private int mobile;
	private String email;
	private UserType userType;
	private Date registeredOn = new Date();
	
	public User(UserType userType, Date registerDate) {
		this.userType = userType;
		this.registeredOn = registerDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public Date getRegisteredOn() {
		return registeredOn;
	}
	public void setRegisteredOn(Date registeredOn) {
		this.registeredOn = registeredOn;
	}
	
}
