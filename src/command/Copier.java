package command;

import receiver.IMoteurEdition;

public class Copier implements ICommand {

	private IMoteurEdition moteurEdition;

	public Copier(IMoteurEdition moteurEdition){
		this.moteurEdition = moteurEdition;
	}

	@Override
	public void execute() {
		moteurEdition.copier();
	}

	public IMoteurEdition getMoteurEdition() {
		return moteurEdition;
	}

	public void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}

}
