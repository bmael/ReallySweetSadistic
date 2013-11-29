package fr.nantes.univ.alma.reallysweetsadistic.api.impl;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import fr.nantes.univ.alma.reallysweetsadistic.api.IFlow;

/**
 * @author Maël
 * 
 */
@Entity
@Table(name = "FLOW", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class Flow implements IFlow {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String content;
	@Column(nullable=false)
	private Date lastUpdate;

	public Flow() {
		this(null, "", "");
	}

	/**
	 * Contruct a new instance of Flow.
	 * 
	 * @param address
	 *            of the flow
	 * @param title
	 *            of the flow
	 * @param content
	 *            of the flow
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
