package fr.nantes.univ.alma.reallysweetsadistic.api.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.nantes.univ.alma.reallysweetsadistic.api.IUser;
import fr.nantes.univ.alma.reallysweetsadistic.api.impl.User;

public class UserDAO {


	private EntityManagerFactory emf;
	private EntityManager em;

	public UserDAO() {
		this.emf = Persistence.createEntityManagerFactory("RSS");
		this.em = this.emf.createEntityManager();
	}

	public void newUser(String userName, String password) {
		this.em.getTransaction().begin();
		IUser user = new User(userName, password);

		this.em.persist(user);
		this.em.getTransaction().commit();
	}

	public void updateUser(IUser user) {
		this.em.getTransaction().begin();
		this.em.merge(user);
		this.em.getTransaction().commit();
	}
	
	public void remUser(IUser user) {
		this.em.getTransaction().begin();
		this.em.remove(user);
		this.em.getTransaction().commit();
	}

	public IUser getUser(int idUser) {
		this.em.getTransaction().begin();
		IUser user = this.em.find(User.class, idUser);
		this.em.getTransaction().commit();
		return user;
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
