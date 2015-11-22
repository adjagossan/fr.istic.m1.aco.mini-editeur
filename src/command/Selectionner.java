package command;

import invoker.IHM;
import receiver.IMoteurEdition;
import receiver.Selection;

public class Selectionner implements ICommand {

	private IMoteurEdition mMoteurEdition;
	private IHM ihm;
	
	
	public Selectionner(IMoteurEdition mMoteurEdition, IHM ihm){
		
		this.mMoteurEdition = mMoteurEdition;
		this.ihm = ihm;
	}
		
	@Override
	public void execute() {
		Selection selection = ihm.getSelection();
		mMoteurEdition.selectionner(selection);
		
	}


}
