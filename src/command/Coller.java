package command;

import receiver.IEnregistreur;
import receiver.IMoteurEdition;

public class Coller implements ICommand {
	
	private IMoteurEdition moteurEdition = null;
	
	public Coller(IMoteurEdition moteurEdition){
		this.moteurEdition = moteurEdition;
	}

	
	public void execute() {
		moteurEdition.coller();
	}

}
