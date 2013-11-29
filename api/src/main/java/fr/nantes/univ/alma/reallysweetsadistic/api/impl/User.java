package fr.nantes.univ.alma.reallysweetsadistic.api.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import fr.nantes.univ.alma.reallysweetsadistic.api.IUser;

/**
 * @author Maël
 * 
 */
@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"id", "userName" }) })
public class User implements IUser {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(nullable=false)
	private String userName;
	@Column(nullable=false)
	private String password;

	public User() {
		this(null, null);
	}

	/**
	 * Construct a new User with given name and password.
	 * 
	 * @param userName
	 * @param password
	 */
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String getUserName() {
		return this.userName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

}
