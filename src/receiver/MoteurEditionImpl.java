package receiver;

import java.util.ArrayList;
import java.util.List;
import util.IObserver;

/**
 * Classe MoteurEditionImpl
 * Implémtentation de l'interface IMoteurEdition
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class MoteurEditionImpl implements IMoteurEdition {

	private Buffer buffer;
	private PressePapier pressePapier;
	private Selection selection;
	private Signal signal;
	private List<IObserver> obs = null;

	/**
	 * Constructeur
	 */
	public MoteurEditionImpl () {
		pressePapier = new PressePapier();
		buffer = new Buffer();
		selection = new Selection(0,0);
		signal = new Signal();
		obs = new ArrayList<IObserver>();
	}

	
	public Buffer getBuffer() {
		return buffer;
	}

	/**
	 * Setter
	 * @param buffer : buffer
	 */
	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public PressePapier getPressePapier() {
		return pressePapier;
	}

	/**
	 * Setter
	 * @param pressePapier : presse papier
	 */
	public void setPressePapier(PressePapier pressePapier) {
		this.pressePapier = pressePapier;
	}

	@Override
	public Selection getSelection() {
		return selection;
	}

	/**
	 * Setter
	 * @param selection : selection
	 */
	public void setSelection(Selection selection) {
		this.selection = selection;
	}

	@Override
	public void couper() 
	{
		copier();
		buffer.delete(
				selection.getDebutSelection(), 
				selection.getFinSelection()
				);

		setValue(new Signal("couper", pressePapier.getContenu()));
	}

	public void copier() {
		int deb = selection.getDebutSelection();
		int fin = selection.getFinSelection();
		String subString = buffer.subString(deb, fin);
		pressePapier.setContenu(subString);
		setValue(new Signal("copier", pressePapier.getContenu()));

	}

	public void coller() {
		String content = pressePapier.getContenu();
		if(content != null)
			this.saisir(content);
		setValue(new Signal("coller", content));
	}

	
	public void saisir(String texte) 
	{
		int debutSelection = selection.getDebutSelection();
		int finSelection = selection.getFinSelection();
		if(texte.equalsIgnoreCase("backspace"))
		{
			texte = "";
			if(debutSelection == finSelection  && debutSelection > 0)
				debutSelection--;
		}
		buffer.insert(debutSelection, finSelection, texte);
		setValue(new Signal("saisir", texte));
	}

	
	public void selectionner(Selection selection) {
		this.selection = selection;
		setValue(new Signal("selectionner", this.selection));
	}

	
	public void register(IObserver o) {
		if (o == null) {
			throw new IllegalArgumentException("o is null");
		}
		if (obs.contains(o)) {
			throw new IllegalArgumentException("o is registered already");
		}
		obs.add(o);

	}

	
	public void unregister(IObserver o) {
		if (o == null) {
			throw new IllegalArgumentException("o is null");
		}
		if (!obs.contains(o)) {
			throw new IllegalArgumentException("o is not registered");
		}
		obs.remove(o);
	}

	
	public boolean isAttach(Object o) {
		if (o == null) {
			throw new IllegalArgumentException("o is null");
		}
		return obs.contains(o);
	}

	
	public void setValue(Object o) {
		this.signal.update((Signal)o);
		notifyObservers();
	}

	
	public Object getValue() {
		// TODO Auto-generated method stub
		return signal;
	}

	/**
	 * Mise à jour des observers
	 */
	private void notifyObservers() {

		for(IObserver observer : obs)
		{
			observer.update(this);
		}
	}
	
	/**
	 * Surchage toString
	 */
	public String toString() {
		return buffer.toString();
	}
}
