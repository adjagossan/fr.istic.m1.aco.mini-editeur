package command;

import receiver.IEnregistreur;
import receiver.IMoteurEdition;

public class Coller implements ICommand {
	
	private IMoteurEdition moteurEdition = null;
	private IEnregistreur enregistreur = null;
	
	public Coller(IMoteurEdition moteurEdition, IEnregistreur enregistreur){
		this.moteurEdition = moteurEdition;
		this.enregistreur = enregistreur;
	}

	
	public void execute() {
		moteurEdition.coller();
		enregistreur.enregistrer(this);
	}

}
