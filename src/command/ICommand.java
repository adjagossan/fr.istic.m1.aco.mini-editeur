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
	
	void set(IMoteurEdition newArticle);
	
	Memento storeInMemento();
	
	IMoteurEdition restoreFromMemento(Memento memento);
}
