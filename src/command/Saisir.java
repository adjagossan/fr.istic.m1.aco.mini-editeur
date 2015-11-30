package command;

import invoker.IHM;
import receiver.IMoteurEdition;
/**
 * Classe Saisir
 * Concrete command for the Command design pattern
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class Saisir implements ICommand {

	private IMoteurEdition mMoteurEdition; 
	private IHM ihm;
	
	/**
	 * Constructeur
	 * @param mMoteurEdition : moteurEdition
	 * @param ihm : ihm
	 */
	public Saisir(IMoteurEdition mMoteurEdition, IHM ihm){
			this.mMoteurEdition = mMoteurEdition;
			this.ihm = ihm;
	}
	
	@Override
	public void execute() {
		String inputCharacter = ihm.getInputCharacter();
		mMoteurEdition.saisir(inputCharacter);
		
	}

	/**
	 * Getter
	 * @return moteurEdition
	 */
	public IMoteurEdition getmMoteurEdition() {
		return mMoteurEdition;
	}

	/**
	 * Setter
	 * @param mMoteurEdition
	 */
	public void setmMoteurEdition(IMoteurEdition mMoteurEdition) {
		this.mMoteurEdition = mMoteurEdition;
	}

	/**
	 * Getter
	 * @return ihm
	 */
	public IHM getIhm() {
		return ihm;
	}

	/**
	 * Setter
	 * @param ihm
	 */
	public void setIhm(IHM ihm) {
		this.ihm = ihm;
	}

}
