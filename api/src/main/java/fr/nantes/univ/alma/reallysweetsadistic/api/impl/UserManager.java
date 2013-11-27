/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.api.impl;

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
	

	public static void main(String[] args) {
		FlowDAO flowDAO=new FlowDAO();
//		flowDAO.newFlow("address1", "title 1", "content 1");
//		flowDAO.newFlow("address1", "title 2", "content 2");
//		flowDAO.newFlow("address1", "title 3", "content 3");
		UserDAO userDAO = new UserDAO();
//		userDAO.newUser("Nemolovich", "PasDePass");
//		userDAO.newUser("Mamelon", "ImpossibleATrouver");
		
		List<IUser> users=userDAO.getUsers();
		for(IUser user:users) {
			System.out.println("User: "+user.getUserName());
		}
		
		IUser moi=userDAO.getUser(1);
		System.out.println("Moi je suis: "+moi.getUserName());

		String password=moi.getPassword();
        if(password.isEmpty())
        {
        	System.err.println("[ERROR] Password can not be empty");
            return;
        }
        MessageDigest md;
        try
        {
            md = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException ex)
        {
        	ex.printStackTrace();
            return;
        }
        md.update(password.getBytes(/*"UTF-8"*/));
        byte[] md5 = md.digest();
        String encryptPassword=new String(md5/*,"UTF-8"*/);
        
        IUser moi2=userDAO.getUser(3);
        System.out.println(encryptPassword+" ?= "+moi2.getPassword());
        System.out.println(encryptPassword.equals(moi2.getPassword()));
        
//        userDAO.newUser(moi.getUserName(), encryptPassword);
	}

}
