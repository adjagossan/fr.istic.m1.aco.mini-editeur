package command;

import receiver.IEnregistreur;

public class Demarrer implements ICommand {

	private IEnregistreur enregistreur = null;
	
	public Demarrer (IEnregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}
	
	public void execute() {
		// TODO Auto-generated method stub
		enregistreur.demarrer();
		
	}

}
