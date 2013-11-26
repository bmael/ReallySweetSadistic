/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.api.impl;

import fr.nantes.univ.alma.reallysweetsadistic.api.IFlow;
import fr.nantes.univ.alma.reallysweetsadistic.api.IUserManager;

/**
 * @author Maël
 *
 */
public class UserManager implements IUserManager {

	@Override
	public void authentication(String userName, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void register(String userName, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean subscribe(String userName, IFlow flow) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unsubscribe(String userName, IFlow flow) {
		// TODO Auto-generated method stub
		return false;
	}

}
