package command;

import receiver.IMoteurEdition;

public class Coller implements ICommand {
	private IMoteurEdition moteurEdition = null;

	public Coller(IMoteurEdition moteurEdition){
		this.moteurEdition = moteurEdition;
	}

	@Override
	public void execute() {
		moteurEdition.coller();

	}

}
