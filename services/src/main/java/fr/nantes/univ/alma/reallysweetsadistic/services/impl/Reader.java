/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.services.impl;

import java.util.LinkedList;
import java.util.List;

import fr.nantes.univ.alma.reallysweetsadistic.api.IFlow;
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
public class Reader implements IReader {
	private FlowListenerThread listener;
	private List<String> urls;
	private FlowManager flowManager;
	
	/**
	 * Constructor for an user
	 * @param userName {@link String} - The user name
	 */
	public Reader(FlowManager flowManager) {
		this.urls = new LinkedList<String>();
		this.listener = new FlowListenerThread(this);
		this.flowManager = flowManager;
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
	
	@Override
	public List<IFlow> getFlows() {
		return this.urls;
	}
}
