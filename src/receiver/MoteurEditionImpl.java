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
		obs = new ArrayList<>();
	}

	@Override
	public void couper() 
	{
		copier();
		buffer.delete(
				selection.getDebutSelection(), 
				selection.getFinSelection()
				);


		String keyword = "couper";
		setValue(new Signal(keyword, null, null));
	}

	@Override
	public void copier() {
		int deb = selection.getDebutSelection();
		int fin = selection.getFinSelection();
		String subString = buffer.subString(deb, fin);
		pressePapier.setContenu(subString);

	}

	@Override
	public void coller() {
		String content = pressePapier.getContenu();
		this.saisir(content);
		
		String keyword = "coller";
		String text = pressePapier.getContenu();
		setValue(new Signal(keyword, text, null));
	}

	@Override
	public void saisir(String texte) {
		int debutSelection = selection.getDebutSelection();
		buffer.insert(debutSelection, texte);
		//setValue(new Signal("saisir", null, selection));

	}

	@Override
	public void selectionner(Selection selection) {
		this.selection = selection;
		setValue(new Signal("selctionner", null, selection));
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
