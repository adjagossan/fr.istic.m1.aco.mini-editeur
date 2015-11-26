package memento;

import util.IMemento;

public class MementoSaisir implements IMemento {
	private String text;
	
	public MementoSaisir(String text){
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
