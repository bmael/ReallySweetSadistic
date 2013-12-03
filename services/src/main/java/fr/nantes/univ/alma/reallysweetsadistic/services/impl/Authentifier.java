/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.services.impl;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.Context;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.nantes.univ.alma.reallysweetsadistic.api.IUser;
import fr.nantes.univ.alma.reallysweetsadistic.api.impl.UserManager;

/**
 * @author Maël
 * 
 */
@Controller
@RequestMapping("authentifier")
public class Authentifier {
	private List<IUser> connected;
//	@Context
//	private UserManager userManager;
	
	public Authentifier() {
		this.connected = new LinkedList<IUser>();
	}

//	public Authentifier(@Context IUserManager manager) {
//		this.connected = new LinkedList<IUser>();
//		this.userManager = manager;
//	}

	/**
	 * Send an authentication request to API for this user with the given
	 * password
	 * 
	 * @param password
	 *            {@link String} - The password to submit
	 * @return {@link Boolean boolean} - <code>true</code> if the authentication
	 *         was correct, <code>false</code> otherwise
	 */
    @RequestMapping(value="authentication", method = RequestMethod.GET)
    @ResponseBody
	public boolean auth(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password) {
    	System.out.println("HAVE to login: " + userName);
		IUser user = UserManager.getInstance().authentication(userName,
				UserManager.getMD5Encryption(password));
		this.connected.add(user);

		return true;
	}

	/**
	 * 
	 * @param userName
	 * @return
	 */
    @RequestMapping(value="disconnection", method = RequestMethod.POST)
    @ResponseBody
	public boolean disconnect(@RequestParam(value = "userName") String userName) {
		for (int i = this.connected.size(); i > 0; i--) {
			if (this.connected.get(i).getUserName() == userName) {
				return this.connected.remove(this.connected.get(i));
			}
		}
		return false;
	}
}
