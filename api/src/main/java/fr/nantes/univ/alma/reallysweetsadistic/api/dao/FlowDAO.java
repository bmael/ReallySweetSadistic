package fr.nantes.univ.alma.reallysweetsadistic.api.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.nantes.univ.alma.reallysweetsadistic.api.IFlow;
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
		this.newFLow(new Flow(address, title, content));
	}
	
	public void newFLow(IFlow flow) {
		this.em.getTransaction().begin();
		this.em.persist(flow);
		this.em.getTransaction().commit();
	}

	public IFlow getFlow(int idFlow) {
		this.em.getTransaction().begin();
		IFlow flow = this.em.find(Flow.class, idFlow);
		this.em.getTransaction().commit();
		return flow;
	}

	@SuppressWarnings("unchecked")
	public List<IFlow> getFlows() {
		this.em.getTransaction().begin();
		ArrayList<IFlow> list;
		try {
			list = (ArrayList<IFlow>) this.em.createQuery(
					"select f from Flow f order by f.id asc").getResultList();
		} catch (ClassCastException e) {
			e.printStackTrace();
			return null;
		}
		this.em.getTransaction().commit();
		return list == null ? new ArrayList<IFlow>() : list;
	}
}
