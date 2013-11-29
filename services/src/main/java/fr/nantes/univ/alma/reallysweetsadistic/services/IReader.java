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
	 * Returns all the {@link IFlow flows} that user subscribed
	 * @return {@link List}<{@link IFlow}> - The flows list
	 */
	public List<IFlow> getFlows();
	
	/**
	 * Return the flow with the url given in parameter.
	 * @param url {@link String} - The flow url.
	 * @return {@link IFlow} - The flow.
	 */
	public IFlow displayFlow(String url);

}
