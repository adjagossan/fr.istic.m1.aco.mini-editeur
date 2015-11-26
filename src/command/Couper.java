package command;

import receiver.IEnregistreur;
import receiver.IMoteurEdition;

public class Couper implements ICommand {
	private IMoteurEdition moteurEdition = null;

	public Couper(IMoteurEdition moteurEdition){
		this.moteurEdition = moteurEdition;
	}

	public void execute() {
		moteurEdition.couper();

	}

}
