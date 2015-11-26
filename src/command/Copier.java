package command;

import receiver.IEnregistreur;
import receiver.IMoteurEdition;

public class Copier implements ICommand {

	private IMoteurEdition moteurEdition = null;

	public Copier(IMoteurEdition moteurEdition){
		this.moteurEdition = moteurEdition;
	}

	
	public void execute() {
		moteurEdition.copier();
	}

}
