/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.services.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

import fr.nantes.univ.alma.reallysweetsadistic.api.IUser;
import fr.nantes.univ.alma.reallysweetsadistic.api.IUserManager;

/**
 * @author Maël
 *
 */
public class Authentifier {
	private List<IUser> connected;
	private IUserManager userManager;
	
	public Authentifier(IUserManager manager){
		this.connected = new LinkedList<IUser>();
		this.userManager = manager;
	}
	
	/**
	 * Send an authentication request to API for this user with
	 * the given password
	 * @param password {@link String} - The password to submit
	 * @return {@link Boolean boolean} - <code>true</code> if the authentication
	 * was correct, <code>false</code> otherwise
	 */
	public boolean auth(String userName, String password) {
       
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
                
        String encryptPassword = null;
        try {
			md.update(password.getBytes("UTF-8"));
	        byte[] md5 = md.digest();
	        encryptPassword = new String(md5,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("[ERROR] UTF-8 Disabled...");
			e.printStackTrace();
		}
        if(encryptPassword == null){
        	return false;
        }

        IUser user = this.userManager.authentication(userName, encryptPassword);
        this.connected.add(user);
        
        return true;
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public boolean disconnect(String userName){
		for (int i = this.connected.size() ; i > 0 ; i --) {
			if(this.connected.get(i).getUserName() == userName){
				 return this.connected.remove(this.connected.get(i));
			}
		}
		return false;
	}
}
