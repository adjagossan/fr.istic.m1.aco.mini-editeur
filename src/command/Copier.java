package command;

import receiver.IEnregistreur;
import receiver.IMoteurEdition;

public class Copier implements ICommand {

	private IMoteurEdition moteurEdition = null;
	private IEnregistreur enregistreur = null;

	public Copier(IMoteurEdition moteurEdition, IEnregistreur enregistreur){
		this.moteurEdition = moteurEdition;
		this.enregistreur = enregistreur;
	}

	
	public void execute() {
		moteurEdition.copier();
		enregistreur.enregistrer(this);
	}

}
