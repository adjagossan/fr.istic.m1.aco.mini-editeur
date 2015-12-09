package memento;

import receiver.IMoteurEdition;

/**
 * Classe Memento
 * Memento for the Memento design pattern
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class Memento {
	private IMoteurEdition state;
	
	/**
	 * Constructeur
	 * @param state : �tat du moteur
	 */
	public Memento(IMoteurEdition state) {
		this.state = state;
	}
	
	/**
	 * Getter
	 * @return l'�tat du moteur
	 */
	public IMoteurEdition getState() {
		return state;
	}
	
	/**
	 * Setter
	 * @param state : nouvel �tat du moteur
	 */
	public void setState(IMoteurEdition state) {
		this.state = state;
	}
}
