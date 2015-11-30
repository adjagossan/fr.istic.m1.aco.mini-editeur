package command;

import receiver.IMoteurEdition;

public class Coller implements ICommand {
	
	private IMoteurEdition moteurEdition;
	
	public Coller(IMoteurEdition moteurEdition){
		this.moteurEdition = moteurEdition;
	}

	public void execute() {
		moteurEdition.coller();
	}

	public IMoteurEdition getMoteurEdition() {
		return moteurEdition;
	}

	public void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}

}
