package fr.nantes.univ.alma.reallysweetsadistic.api.impl;

import java.util.List;

import fr.nantes.univ.alma.reallysweetsadistic.api.IFlow;
import fr.nantes.univ.alma.reallysweetsadistic.api.IFlowManager;
import fr.nantes.univ.alma.reallysweetsadistic.api.dao.FlowDAO;

public class FlowManager implements IFlowManager {

	@Override
	public List<IFlow> getFlows() {
		FlowDAO flowDAO=new FlowDAO();
		return flowDAO.getFlows();
	}

}
