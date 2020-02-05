package com.shout.edu.config.auth.dto;

import java.io.Serializable;

import com.shout.edu.domian.user.User;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 850053079123599394L;
	private String name;
	private String email;
	private String picture;
	
	public SessionUser(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
	}
}
