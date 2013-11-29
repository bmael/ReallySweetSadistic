/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.services.impl;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.nantes.univ.alma.reallysweetsadistic.api.IFlow;
import fr.nantes.univ.alma.reallysweetsadistic.api.IFlowManager;
import fr.nantes.univ.alma.reallysweetsadistic.api.impl.FlowManager;
import fr.nantes.univ.alma.reallysweetsadistic.services.IReader;
import fr.nantes.univ.alma.reallysweetsadistic.services.listener.FlowListenerThread;

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
@Path("Reader")
public class Reader implements IReader {
	private FlowListenerThread listener;
	private List<String> urls;
	private IFlowManager flowManager;
	
	/**
	 * Constructor for an user
	 * @param userName {@link String} - The user name
	 */
	public Reader() {
		this.urls = new LinkedList<String>();
		this.listener = new FlowListenerThread(this);
		this.flowManager = new FlowManager();
		
		this.init();
	}
	
	@Override
	public IFlow displayFlow(String url) {
		for (IFlow flow: this.flowManager.getFlows()) {
			if(flow.getAddress().equals(url)){
				return flow;
			}
		}
		return null;
	};
	
	/**
	 * Initialize all basics RSS Feed.
	 */
	private void init(){
		this.urls.add("http://magazine.developpez.com/magazine-rss.xml");
	}
	
	@Override
	@GET
	public List<String> getFlows() {
		return this.urls;
	}
}
