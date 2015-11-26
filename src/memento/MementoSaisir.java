package memento;

import util.IMemento;

public class MementoSaisir implements IMemento {
	private String state;
	
	public MementoSaisir(String state){
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
