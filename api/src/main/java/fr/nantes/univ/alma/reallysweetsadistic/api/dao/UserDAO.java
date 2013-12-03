package fr.nantes.univ.alma.reallysweetsadistic.api.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import fr.nantes.univ.alma.reallysweetsadistic.api.IUser;
import fr.nantes.univ.alma.reallysweetsadistic.api.impl.User;

public class UserDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public UserDAO(EntityManagerFactory emf) {
		this.emf = emf;
		this.em=this.emf.createEntityManager();
	}

//	public UserDAO() {
//	}
	
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void newUser(String userName, String password) {
		IUser user = new User(userName, password);
		this.addUser(user);
	}

	public void addUser(IUser user) {
		this.em.getTransaction().begin();
		System.out.println("[USER_DAO] Adding user: " + user.getUserName());
		this.em.persist(user);
		this.em.getTransaction().commit();
	}

	public void updateUser(IUser user) {
		this.em.getTransaction().begin();
		System.out.println("[USER_DAO] Modifying user: " + user.getUserName());
		this.em.merge(user);
		this.em.getTransaction().commit();
	}

	public void remUser(IUser user) {
		this.em.getTransaction().begin();
		System.out.println("[USER_DAO] Deleting user: " + user.getUserName());
		this.em.remove(user);
		this.em.getTransaction().commit();
	}

	public IUser getUser(int idUser) {
		this.em.getTransaction().begin();
		IUser user = this.em.find(User.class, idUser);
		this.em.getTransaction().commit();
		return user;
	}

	public IUser getUser(String userName) throws NoResultException {
		this.em.getTransaction().begin();
		IUser user = null;
		try {
			user = (IUser) this.em.createQuery(
					"select u from User u where u.userName='" + userName + "'")
					.getSingleResult();
		} catch (ClassCastException e) {
			e.printStackTrace();
			return null;
		} catch (NonUniqueResultException e) {
			System.err.println("[ERROR] There is many users with"
					+ " the same name \"" + userName + "\"");
			return null;
		}
		this.em.getTransaction().commit();
		return user;
	}

	public void reset() {
		this.em.getTransaction().begin();
		System.out.println("[USER_DAO] Reseting USER table");
		Query query = this.em.createNativeQuery("TRUNCATE TABLE USER");
		query.executeUpdate();
		this.em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<IUser> getUsers() {
		this.em.getTransaction().begin();
		ArrayList<IUser> list;
		try {
			list = (ArrayList<IUser>) this.em.createQuery(
					"select u from User u order by u.id asc").getResultList();
		} catch (ClassCastException e) {
			e.printStackTrace();
			return null;
		}
		this.em.getTransaction().commit();
		return list == null ? new ArrayList<IUser>() : list;
	}

}
