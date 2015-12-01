package command;

import invoker.IHM;
import memento.Memento;
import receiver.Buffer;
import receiver.IMoteurEdition;
import receiver.MoteurV3;
import receiver.Selection;
/**
 * Classe Selectionner
 * Concrete command for the Command design pattern
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class Selectionner implements ICommand {

	private IMoteurEdition mMoteurEdition;
	private IHM ihm;
	
	/**
	 * Constructeur
	 * @param mMoteurEdition : moteur
	 * @param ihm : ihm
	 */
	public Selectionner(IMoteurEdition mMoteurEdition, IHM ihm){
		
		this.mMoteurEdition = mMoteurEdition;
		this.ihm = ihm;
	}
		
	@Override
	public void execute() {
		Selection selection = ihm.getSelection();
		mMoteurEdition.selectionner(selection);
		
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
	 * @param mMoteurEdition : moteur
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
	 * @param ihm : ihm
	 */
	public void setIhm(IHM ihm) {
		this.ihm = ihm;
	}

	@Override
	public void set(IMoteurEdition newArticle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Memento storeInMemento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMoteurEdition restoreFromMemento(Memento memento) {
		// TODO Auto-generated method stub
		return null;
	}


}
