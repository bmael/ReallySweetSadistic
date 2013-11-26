/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.api;

/**
 * @author Maël
 *
 */
public interface IUser {
	/**
	 * Return the user name.
	 * @return the user name.
	 */
	public String getUserName();
	
	/**
	 * Return the user password.
	 * @return the user password.
	 */
	public String getPassword();
}
