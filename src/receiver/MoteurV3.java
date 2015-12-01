package receiver;

import java.util.ArrayList;

import memento.Memento;
/**
 * Caretaker
 * @author Florent
 *
 */
public class MoteurV3 extends MoteurEditionImpl {

	ArrayList<Memento> savedArticles = new ArrayList<Memento>();
	
	public MoteurV3() {
		super();
	}
	
	public void addMemento(Memento m) { savedArticles.add(m); }
	
	public Memento getMemento(int index) {
		return savedArticles.get(index);
	}
	
	public MoteurV3 cloner() {
		MoteurV3 moteur = new MoteurV3();
		moteur.setBuffer(getBuffer().clone());
		moteur.setSelection(getSelection());
		
		moteur.setPressePapier(getPressePapier().clone());
		return moteur;
	}
	
	public String toString() {
		return ">buffer : "+super.getBuffer().toString();
	}
	
}
