package main;

import fr.nantes.univ.alma.reallysweetsadistic.api.impl.FlowManager;

public class Client {
	
	public Client() {
		System.out.println("[Client] Salut c'est moi!");
	}
	
	public void sayCoucou() {
		System.out.println("[Client] Coucou! Tu veux voir mon code?");
	}
	
	public void list() {
		
	}
	
	public static void main(String[] args) {
		FlowManager flowManager=new FlowManager();
		Client c=new Client();
		c.sayCoucou();
	}
	
}
