package receiver;

import java.util.ArrayList;
import java.util.List;
import util.IObserver;

public class MoteurEditionImpl implements IMoteurEdition {

	private Buffer buffer;
	private PressePapier pressePapier;
	private Selection selection;
	private Signal signal;
	private List<IObserver> obs = null;

	public MoteurEditionImpl () {
		pressePapier = new PressePapier();
		buffer = new Buffer();
		selection = new Selection(0,0);
		signal = new Signal();
		obs = new ArrayList<IObserver>();
	}

	
	public void couper() 
	{
		copier();
		buffer.delete(
				selection.getDebutSelection(), 
				selection.getFinSelection()
				);

		//setValue(new Signal("couper", pressePapier.getContenu()));
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
		this.saisir(content);
		setValue(new Signal("coller", null));
	}

	
	public void saisir(String texte) {
		int debutSelection = selection.getDebutSelection();
		int finSelection = selection.getFinSelection();
		buffer.insert(debutSelection, finSelection, texte);

	}

	
	public void selectionner(Selection selection) {
		this.selection = selection;
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

	private void notifyObservers() {

		for(IObserver observer : obs)
		{
			observer.update(this);
		}
	}
}
