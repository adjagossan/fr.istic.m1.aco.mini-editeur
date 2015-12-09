package receiver;

import java.util.ArrayList;
import java.util.List;

import memento.Memento;
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
		obs = new ArrayList<>();
	}

	@Override
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

	}

	@Override
	public void copier() {
		int deb = selection.getDebutSelection();
		int fin = selection.getFinSelection();
		String subString = buffer.subString(deb, fin);
		pressePapier.setContenu(subString);
		setValue(new Signal("copier", pressePapier.getContenu()));

	}

	@Override
	public void coller() {
		String content = pressePapier.getContenu();
		this.saisir(content);
		setValue(new Signal("coller", null));
	}

	@Override
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
	}
	
	@Override
	public void selectionner(Selection selection) {
		this.selection = selection;
	}

	@Override
	public void register(IObserver o) {
		if (o == null) {
			throw new IllegalArgumentException("o is null");
		}
		if (obs.contains(o)) {
			throw new IllegalArgumentException("o is registered already");
		}
		obs.add(o);

	}

	@Override
	public void unregister(IObserver o) {
		if (o == null) {
			throw new IllegalArgumentException("o is null");
		}
		if (!obs.contains(o)) {
			throw new IllegalArgumentException("o is not registered");
		}
		obs.remove(o);
	}

	@Override
	public boolean isAttach(Object o) {
		if (o == null) {
			throw new IllegalArgumentException("o is null");
		}
		return obs.contains(o);
	}

	@Override
	public void setValue(Object o) {
		this.signal.update((Signal)o);
		notifyObservers();
	}

	@Override
	public Object getValue() {
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

	@Override
	public void addMemento(Memento m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Memento getMemento(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MoteurV3 cloner() {
		return null;
		
	}
}
