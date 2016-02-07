package command;

import receiver.IEnregistreur;

public class Arreter implements ICommand {

	private IEnregistreur enregistreur = null;

	public Arreter (IEnregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}
	
	public void execute() {
		// TODO Auto-generated method stub
		enregistreur.arreter();
	}

}
