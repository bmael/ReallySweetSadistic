/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.services.impl;

import java.util.LinkedList;
import java.util.List;

import fr.nantes.univ.alma.reallysweetsadistic.api.IUser;
import fr.nantes.univ.alma.reallysweetsadistic.api.IUserManager;
import fr.nantes.univ.alma.reallysweetsadistic.api.impl.UserManager;

/**
 * @author Maël
 * 
 */
public class Authentifier {
	private List<IUser> connected;
	private IUserManager userManager;

	public Authentifier(IUserManager manager) {
		this.connected = new LinkedList<IUser>();
		this.userManager = manager;
	}

	/**
	 * Send an authentication request to API for this user with the given
	 * password
	 * 
	 * @param password
	 *            {@link String} - The password to submit
	 * @return {@link Boolean boolean} - <code>true</code> if the authentication
	 *         was correct, <code>false</code> otherwise
	 */
	public boolean auth(String userName, String password) {

		IUser user = this.userManager.authentication(userName,
				UserManager.getMD5Encryption(password));
		this.connected.add(user);

		return true;
	}

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public boolean disconnect(String userName) {
		for (int i = this.connected.size(); i > 0; i--) {
			if (this.connected.get(i).getUserName() == userName) {
				return this.connected.remove(this.connected.get(i));
			}
		}
		return false;
	}
}
