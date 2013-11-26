/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.api;

import java.util.Date;

/**
 * @author Maël
 *
 */
public interface IFlow {
	
	/**
	 * Get the address of this Flow.
	 * @return the address of this Flow.
	 */
	public String getAddress();
	
	/**
	 * Get the title of this Flow.
	 * @return the title of this Flow.
	 */
	public String getTitle();
	
	/**
	 * Get the content of this Flow.
	 * @return the content of this Flow.
	 */
	public String getContent();
	
	/**
	 * Get the last update for this Flow.
	 * @return the last update for this Flow.
	 */
	public Date getLastUpdate();
	
	/**
	 * Set the content of this Flow.
	 */
	public void setContent(String content);
	
}
