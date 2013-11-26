/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.services.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import fr.nantes.univ.alma.reallysweetsadistic.api.IFlow;
import fr.nantes.univ.alma.reallysweetsadistic.services.IReader;

/**
 * <p>
 * Reader implementation
 * </p>
 * 
 * <p>
 * <b>date:</b> 26 nov. 2013
 * </p>
 * 
 * @author nemo
 *
 */
public class Reader implements IReader {
	private String userName;
	private boolean logged=false;
	
	/**
	 * Constructor for an user
	 * @param userName {@link String} - The user name
	 */
	public Reader(String userName) {
		this.userName = userName;
	}

	@Override
	public void displayFlow(IFlow flow) {
		// TODO Display flow
	};
	
	@Override
	public List<IFlow> getFlows() {
		// TODO Get all flows subscribed from API
		return null;
	}
	
	@Override
	public String getName() {
		return this.userName;
	}
	
	/**
	 * Send an authentication request to API for this user with
	 * the given password
	 * @param password {@link String} - The password to submit
	 * @return {@link Boolean boolean} - <code>true</code> if the authentication
	 * was correct, <code>false</code> otherwise
	 */
	private boolean auth(String password) {
        if(password.isEmpty())
        {
        	System.err.println("[ERROR] Password can not be empty");
            return false;
        }
        MessageDigest md;
        try
        {
            md = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException ex)
        {
        	ex.printStackTrace();
            return false;
        }
        md.update(password.getBytes(/*"UTF-8"*/));
        byte[] md5 = md.digest();
        String encryptPassword=new String(md5/*,"UTF-8"*/);
        // TODO Get authentication from API
//        auth(this.userName, encryptPassword);
        return true;
	}
}
