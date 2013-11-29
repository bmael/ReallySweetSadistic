/**
 * 
 */
package fr.nantes.univ.alma.reallysweetsadistic.services.listener;

/**
 * @author Maël
 * 
 */
public class FlowListenerThread extends Thread {

	public FlowListenerThread() {
		super();
	}

	@Override
	public void run() {
		int timeToWait = 10000;
		try {
			while (!Thread.currentThread().isInterrupted()) {
				// TODO: ACTION A FAIRE
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
