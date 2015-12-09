package command;

import memento.Memento;
import receiver.Buffer;
import receiver.IMoteurEdition;
import receiver.MoteurV3;

/**
 * Interface ICommand
 * command for the Command design pattern
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */

public interface ICommand {
	/**
	 * Execute
	 */
	public void execute();
	
	/**
	 * D�finir la valeur pour le moteur
	 * @param newMoteur
	 */
	void set(IMoteurEdition newMoteur);
	
	/**
	 * Cr�e un nouveau memento avec un nouveau moteur
	 * @return memento
	 */
	Memento storeInMemento();
	
	/**
	 * 
	 * @param memento : memento
	 * @return le moteur stock� actuellement dans le memento
	 */
	IMoteurEdition restoreFromMemento(Memento memento);
}
