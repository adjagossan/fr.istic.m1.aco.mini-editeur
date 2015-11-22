package command;

import receiver.IMoteurEdition;

public class Copier implements ICommand {

	private IMoteurEdition moteurEdition = null;

	public Copier(IMoteurEdition moteurEdition){
		this.moteurEdition = moteurEdition;
	}

	@Override
	public void execute() {
		moteurEdition.copier();
	}

}
