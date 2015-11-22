package command;

import receiver.IMoteurEdition;

public class Couper implements ICommand {
	private IMoteurEdition moteurEdition = null;

	public Couper(IMoteurEdition moteurEdition){
		this.moteurEdition = moteurEdition;
	}
	@Override
	public void execute() {
		moteurEdition.couper();

	}

}
