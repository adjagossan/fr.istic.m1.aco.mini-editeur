package memento;

import receiver.Buffer;
import receiver.IMoteurEdition;

/**
 * Memento
 * @author Florent
 *
 */
public class Memento {
	private IMoteurEdition state;
	
	public Memento(IMoteurEdition state) {
		this.state = state;
	}
	
	public IMoteurEdition getState() {
		return state;
	}
	
	public void setState(IMoteurEdition state) {
		this.state = state;
	}
}
