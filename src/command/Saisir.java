package command;

import invoker.IHM;
import receiver.IEnregistreur;
import receiver.IMoteurEdition;

public class Saisir implements ICommand {

	private IMoteurEdition mMoteurEdition; 
	private IHM ihm;
	
	public Saisir(IMoteurEdition mMoteurEdition, IHM ihm){
			this.mMoteurEdition = mMoteurEdition;
			this.ihm = ihm;
	}
	
	@Override
	public void execute() {
		String inputCharacter = ihm.getInputCharacter();
		mMoteurEdition.saisir(inputCharacter);
		
	}

}
