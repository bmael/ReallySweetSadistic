/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.api.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import fr.nantes.univ.alma.reallysweetsadistic.api.IFlow;
import fr.nantes.univ.alma.reallysweetsadistic.api.IUser;
import fr.nantes.univ.alma.reallysweetsadistic.api.IUserManager;
import fr.nantes.univ.alma.reallysweetsadistic.api.dao.FlowDAO;
import fr.nantes.univ.alma.reallysweetsadistic.api.dao.UserDAO;

/**
 * @author Maël
 *
 */
public class UserManager implements IUserManager {

	@Override
	public void authentication(String userName, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void register(String userName, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean subscribe(String userName, IFlow flow) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unsubscribe(String userName, IFlow flow) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private static String getMD5Encryption(String password) {
        if(password.isEmpty())
        {
        	System.err.println("[ERROR] Password can not be empty");
            return null;
        }
        MessageDigest md;
        try
        {
            md = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException ex)
        {
        	ex.printStackTrace();
            return null;
        }
        String encryptPassword=null;
        try {
			md.update(password.getBytes("UTF-8"));
	        byte[] md5 = md.digest();
	        encryptPassword=new String(md5,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(encryptPassword==null) {
        	return null;
        }
        
		return encryptPassword;
	}
	

	public static void main(String[] args) {
		FlowDAO flowDAO=new FlowDAO();
//		flowDAO.newFlow("address1", "title 1", "content 1");
//		flowDAO.newFlow("address1", "title 2", "content 2");
//		flowDAO.newFlow("address1", "title 3", "content 3");
		UserDAO userDAO = new UserDAO();
//		userDAO.newUser("Nemolovich", UserManager.getMD5Encryption("motdepasse"));
//		userDAO.newUser("Mamelon", UserManager.getMD5Encryption("password"));
//		userDAO.newUser("Niiner", UserManager.getMD5Encryption("motdepasse"));
		
		List<IUser> users=userDAO.getUsers();
		for(IUser user:users) {
			System.out.println("User: "+user.getUserName());
//			userDAO.remUser(user);
		}
		
//		if(true) return;
		
		IUser moi=userDAO.getUser(1);
		System.out.println("Moi je suis: "+moi.getUserName());
//
        IUser lui=userDAO.getUser(3);
        System.out.println(moi.getPassword()+" ?= "+lui.getPassword());
        System.out.println(moi.getPassword().equals(lui.getPassword()));
	}

}
