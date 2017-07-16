package com.bdsoft.web2p0.ch12;

public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String name) {
		super(name);
	}

}
