/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.services;

import java.util.List;

import fr.nantes.univ.alma.reallysweetsadistic.api.IFlow;

/**
 * <p>
 * Reader service interface
 * </p>
 * 
 * <p>
 * <b>date:</b> 26 nov. 2013
 * </p>
 * 
 * @author nemo
 *
 */
public interface IReader {
	
	/**
	 * Returns the user name
	 * @return {@link String} - The user name
	 */
	public String getName();
	
	/**
	 * Returns all the {@link IFlow flows} that user subscribed
	 * @return {@link List}<{@link IFlow}> - The flows list
	 */
	public List<IFlow> getFlows();
	
	/**
	 * Display a specific flow
	 * @param flow {@link IFlow} - The flow to display
	 */
	public void displayFlow(IFlow flow);
}
