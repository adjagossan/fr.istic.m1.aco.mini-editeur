package receiver;

import util.ISubject;
/**
 * Interface IMoteurEdition
 * receiver for the Command design pattern
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */

public interface IMoteurEdition extends ISubject{
	
	/**
	 * Commande couper
	 */
	void couper();

	/**
	 * Commande copier
	 */
	void copier();

	/**
	 * Commande coller
	 */
	void coller();

	/**
	 * Commande selection
	 * @param selection : selection
	 */
	void selectionner(Selection selection);

	/**
	 * Commande saisir du texte
	 * @param texte : texte
	 */
	void saisir(String texte);
	
	/**
	 * Getter
	 * @return buffer
	 */
	Buffer getBuffer();
	/**
	 * Getter
	 * @return pp
	 */
	PressePapier getPressePapier();
	
	/**
	 * Getter
	 * @return selection
	 */
	Selection getSelection();
}
