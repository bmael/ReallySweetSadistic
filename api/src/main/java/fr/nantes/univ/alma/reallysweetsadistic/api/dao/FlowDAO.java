package fr.nantes.univ.alma.reallysweetsadistic.api.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.nantes.univ.alma.reallysweetsadistic.api.impl.Flow;


/**
 * <p>
 * The {@link Flow} Data Access Object
 * </p>
 * 
 * <p>
 * <b>date:</b> 26 nov. 2013
 * </p>
 * 
 * @author nemo
 * 
 */
public class FlowDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public FlowDAO() {
		this.emf = Persistence.createEntityManagerFactory("RSS");
		this.em = this.emf.createEntityManager();
	}

	public void newFlow(String address, String title, String content) {
		this.em.getTransaction().begin();
		Flow Flow = new Flow(address, title, content);

		this.em.persist(Flow);
		this.em.getTransaction().commit();
	}

	public Flow getFlow(int idFlow) {
		this.em.getTransaction().begin();
		Flow Flow = this.em.find(Flow.class, idFlow);
		this.em.getTransaction().commit();
		return Flow;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Flow> getFlows() {
		this.em.getTransaction().begin();
		ArrayList<Flow> list;
		try {
			list = (ArrayList<Flow>) this.em.createQuery(
					"select f from Flow f order by f.id asc").getResultList();
		} catch (ClassCastException e) {
			e.printStackTrace();
			return null;
		}
		this.em.getTransaction().commit();
		return list == null ? new ArrayList<Flow>() : list;
	}
}
