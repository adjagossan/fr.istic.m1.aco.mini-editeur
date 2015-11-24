package command;

import receiver.IEnregistreur;
import receiver.IMoteurEdition;

public class Couper implements ICommand {
	private IMoteurEdition moteurEdition = null;
	private IEnregistreur enregistreur = null;

	public Couper(IMoteurEdition moteurEdition, IEnregistreur enregistreur){
		this.moteurEdition = moteurEdition;
		this.enregistreur = enregistreur;
	}

	public void execute() {
		moteurEdition.couper();
		enregistreur.enregistrer(this);

	}

}
