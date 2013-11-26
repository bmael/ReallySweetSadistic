/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.api.impl;

import java.util.Calendar;
import java.util.Date;

import fr.nantes.univ.alma.reallysweetsadistic.api.IFlow;

/**
 * @author Maël
 *
 */
public class Flow implements IFlow {

	private String address;
	private String title;
	private String content;
	private Date lastUpdate;

	/**
	 * Contruct a new instance of Flow.
	 * @param address of the flow
	 * @param title of the flow
	 * @param content of the flow
	 */
	public Flow(String address, String title, String content) {
		super();
		this.address = address;
		this.title = title;
		this.setContent(content);
	}

	@Override
	public String getAddress() {
		return this.address;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getContent() {
		return this.content;
	}

	@Override
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	@Override
	public void setContent(String content) {
		this.content = content;
		this.lastUpdate = Calendar.getInstance().getTime();
	}

}
