/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.api.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import fr.nantes.univ.alma.reallysweetsadistic.api.IFlow;
import fr.nantes.univ.alma.reallysweetsadistic.api.IUser;
import fr.nantes.univ.alma.reallysweetsadistic.api.IUserManager;
import fr.nantes.univ.alma.reallysweetsadistic.api.dao.UserDAO;

/**
 * @author Maël
 *
 */
public class UserManager implements IUserManager {

	private static UserManager instance;
	@PersistenceUnit(unitName="RSS")
	private EntityManagerFactory emf;
	
	private UserManager(){
//		this.emf=Persistence.createEntityManagerFactory("RSS");
	}
	
	public static UserManager getInstance() {
		if(UserManager.instance==null) {
			UserManager.instance = new UserManager();
		}
		return UserManager.instance;
	}
	
	@Override
	public IUser authentication(String userName, String password) {
		UserDAO userDao=new UserDAO(this.emf);
		IUser user;
		try {
			user=userDao.getUser(userName);
		} catch (NoResultException e) {
			System.err.println("[ERROR] User named \""+userName+"\" not found");
			return null;
		}
		System.out.println(password+" ?= "+user.getPassword());
		if(password.equals(user.getPassword())) {
			return user;
		}
		System.err.println("[ERROR] Authentication failed for \""+userName+"\"");
		return null;
	}

	@Override
	public boolean register(String userName, String password) {
		UserDAO userDao=new UserDAO(this.emf);
		for(IUser user:userDao.getUsers()) {
			if(user.getUserName().equalsIgnoreCase(userName)) {
				System.err.println("[UserManager] The user name \""+userName+"\" already exists");
				return false;
			}
		}
		userDao.newUser(userName, password);
		return true;
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
	
	public static String getMD5Encryption(String password) {
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
			md.update(password.getBytes("ASCII"));
	        byte[] md5 = md.digest();
	        encryptPassword=new String(md5,"ASCII");
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
//		FlowDAO flowDAO=new FlowDAO();
//		flowDAO.newFlow("address1", "title 1", "content 1");
//		flowDAO.newFlow("address1", "title 2", "content 2");
//		flowDAO.newFlow("address1", "title 3", "content 3");
		UserDAO userDAO = new UserDAO(UserManager.getInstance().emf);
//		userDAO.newUser("Nemolovich", UserManager.getMD5Encryption("motdepasse"));
//		userDAO.newUser("Mamelon", UserManager.getMD5Encryption("password"));
//		userDAO.newUser("Niiner", UserManager.getMD5Encryption("motdepasse"));
		
		List<IUser> users=userDAO.getUsers();
		for(IUser user:users) {
			System.out.println("User: "+user.getUserName());
//			userDAO.remUser(user);
		}
		
		
		IUser me = UserManager.getInstance().authentication("Mamelon", UserManager.getMD5Encryption("password"));
		if(me!=null) {
			System.out.println("Im logged as: "+me.getUserName());
		}
		
//		userDAO.reset();
		
	}

}
