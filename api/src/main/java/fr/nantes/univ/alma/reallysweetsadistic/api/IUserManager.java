/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.api;

/**
 * @author Maël
 *
 */
public interface IUserManager {
	
	/**
	 * User authentication with user name and password.
	 * @param userName the user name of the user who wants to be authenticated.
	 * @param password associated with the userName.
	 */
	public void authentication(String userName, String password);
	
	/**
	 * Register a new user. Storing userName and associated password.
	 * @param userName of the new user.
	 * @param password of the new user.
	 */
	public void register(String userName, String password);
	
	/**
	 * A user subscribe to a Flow.
	 * @param userName of the user who wants to subscribe to a flow.
	 * @param flow the flow that the user wants to subscribe.
	 * @return a boolean indicate if subscribe operation is OK or KO.
	 */
	public boolean subscribe(String userName, IFlow flow);
	
	/**
	 * A user unsubscribe to a Flow.
	 * @param userName of the user who wants to subscribe to a flow.
	 * @param flow the flow that the user wants to subscribe.
	 * @return a boolean indicate if subscribe operation is OK or KO.
	 */
	public boolean unsubscribe(String userName, IFlow flow);
}
