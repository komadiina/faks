package org.unibl.etf.ser;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
//	private static final long serialVersionUID = 7760699024774918008L;
	private String username;
	private transient String password;
	private Integer age;
	
	public User() {
		username = password = "default";
		setAge(20);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
