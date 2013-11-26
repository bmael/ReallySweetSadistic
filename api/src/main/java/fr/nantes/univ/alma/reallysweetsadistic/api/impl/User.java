/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.api.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import fr.nantes.univ.alma.reallysweetsadistic.api.IUser;

/**
 * @author Maël
 *
 */
@Entity
public class User implements IUser {

	@Id
	@GeneratedValue
	private int id;
	private String userName;
	private String password;
	
	/**
	 * Construct a new User with given name and password.
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
