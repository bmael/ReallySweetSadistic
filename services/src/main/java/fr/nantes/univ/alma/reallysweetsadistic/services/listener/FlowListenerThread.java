/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.services.listener;

import fr.nantes.univ.alma.reallysweetsadistic.services.IReader;

/**
 * @author Maël
 * 
 */
public class FlowListenerThread extends Thread {

//	private List<IFlow> flows;
	
	public FlowListenerThread(IReader reader) {
		super();
//		this.flows = reader.getFlows();
	}

	@Override
	public void run() {
		int timeToWait = 10000;
		try {
			while (!Thread.currentThread().isInterrupted()) {
				// TODO: update the reader flows.
				Thread.sleep(timeToWait);
			}
		} catch (InterruptedException e) {
			// Killed
		}
	}

	@Override
	public void interrupt() {
		System.out.println("[FlowListener] Im dead! R.I.P.");
		super.interrupt();
	}

}
