package receiver;

import java.util.ArrayList;

import memento.Memento;

/**
 * Classe MoteurV3
 * Caretaker dans le design pattern Memento
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class MoteurV3 extends MoteurEditionImpl {

	ArrayList<Memento> savedMoteurs = new ArrayList<Memento>();
	
	/**
	 * Constructeur
	 */
	public MoteurV3() {
		super();
	}
	
	public void addMemento(Memento m) { savedMoteurs.add(m); }
	
	public Memento getMemento(int index) {
		return savedMoteurs.get(index);
	}
	
	public MoteurV3 cloner() {
		MoteurV3 moteur = new MoteurV3();
		moteur.setBuffer(getBuffer().clone());
		moteur.setSelection(getSelection());
		
		/* Le presse papier ne fait pas parti de l'état du moteur
		   On ne le sauvegarde donc pas dans le memento
		 */
		//moteur.setPressePapier(getPressePapier().clone());
		return moteur;
	}
	
	/**
	 * Override de toString
	 */
	public String toString() {
		return ""+super.getBuffer().toString();
	}
	
}
