package memento;

import util.IMemento;

public class MementoSelectionner implements IMemento {
	
	private int deb;
	private int fin;
	
	public MementoSelectionner(int deb, int fin)
	{
		this.deb = deb;
		this.fin = fin;
	}

	public int getDeb() {
		return deb;
	}

	public void setDeb(int deb) {
		this.deb = deb;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}
}
