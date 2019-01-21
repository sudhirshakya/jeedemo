package com.example.jeedemo.restclients;

import lombok.Data;

@Data
public class PersonalInfo {
	private String fullname;
	private String email;
	private long age;

	public PersonalInfo() {
	}

	public PersonalInfo(String fullname, String email, long age) {
		this.fullname = fullname;
		this.email = email;
		this.age = age;
	}
}