package command;

import receiver.IEnregistreur;

public class Rejouer implements ICommand {

	IEnregistreur enregistreur = null;
	
	public Rejouer (IEnregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}
	
	public void execute() {
		enregistreur.rejouer();
	}

}
