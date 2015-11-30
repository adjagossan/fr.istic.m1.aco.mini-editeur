package command;

import receiver.IMoteurEdition;

public class Couper implements ICommand {
	private IMoteurEdition moteurEdition;

	public Couper(IMoteurEdition moteurEdition){
		this.moteurEdition = moteurEdition;
	}

	public void execute() {
		moteurEdition.couper();

	}
	public IMoteurEdition getMoteurEdition() {
		return moteurEdition;
	}
	public void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}

}
