package command;

import invoker.IHM;
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

	public IMoteurEdition getmMoteurEdition() {
		return mMoteurEdition;
	}

	public void setmMoteurEdition(IMoteurEdition mMoteurEdition) {
		this.mMoteurEdition = mMoteurEdition;
	}

	public IHM getIhm() {
		return ihm;
	}

	public void setIhm(IHM ihm) {
		this.ihm = ihm;
	}

}
