package com.grobuz.model;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "UserDetails")
@Component

public class Register {

	//private String id;
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Id
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column
	private String phone;
	
	@Column
	private String address;
	@Column
	private String Role;

	

	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}


	/*public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
*/
	public String getFirstname() {
		return firstname;
	}

	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	
	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
