package receiver;

import memento.Memento;
import util.ISubject;
/**
 * Interface IMoteurEdition
 * receiver for the Command design pattern
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */

public interface IMoteurEdition extends ISubject {
	
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
	 * Setter
	 * @param buffer : buffer
	 */
	void setBuffer(Buffer buffer);
	/**
	 * Getter
	 * @return presse papier
	 */
	PressePapier getPressePapier();
	
	/**
	 * Setter
	 * @param pressePapier : presse papier
	 */
	void setPressePapier(PressePapier pressePapier);
	/**
	 * Getter
	 * @return selection
	 */
	Selection getSelection();
	
	/**
	 * Setter
	 * @param selection : selection
	 */
	void setSelection(Selection selection);
	
	/**
	 * Ajoute memento à l'arrayList
	 * @param m : memento
	 */
	void addMemento(Memento m);
	
	/**
	 * 
	 * @param index : indice de l'arrayList
	 * @return le memento de l'arrayList à l'indice index
	 */
	Memento getMemento(int index);
	
	/**
	 * @return un clone du moteur
	 */
	MoteurV3 cloner();
}
