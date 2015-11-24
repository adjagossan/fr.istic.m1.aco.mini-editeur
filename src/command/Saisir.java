package command;

import invoker.IHM;
import receiver.IEnregistreur;
import receiver.IMoteurEdition;

public class Saisir implements ICommand {

	private IMoteurEdition mMoteurEdition; 
	private IHM ihm;
	/*private IEnregistreur mEnregistreur;*/
	
	public Saisir(IMoteurEdition mMoteurEdition, IHM ihm/*, IEnregistreur mEnregistreur*/){
			this.mMoteurEdition = mMoteurEdition;
			this.ihm = ihm;
			/*this.mEnregistreur = mEnregistreur;*/
	}
	
	
	public void execute() {
		String inputCharacter = ihm.getInputCharacter();
		mMoteurEdition.saisir(inputCharacter);
		/*mEnregistreur.enregistrer(this);*/
	}

}
