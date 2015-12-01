package command;

import memento.Memento;
import receiver.Buffer;
import receiver.IMoteurEdition;
import receiver.MoteurV3;
/**
 * Classe Couper
 * Concrete command for the Command design pattern
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class Couper implements ICommand {
	private IMoteurEdition moteurEdition;

	/**
	 * Constructeur
	 * @param moteurEdition  : moteur
	 */
	public Couper(IMoteurEdition moteurEdition){
		this.moteurEdition = moteurEdition;
	}
	@Override
	public void execute() {
		moteurEdition.couper();
	}
	
	/**
	 * Getter
	 * @return moteurEdition
	 */
	public IMoteurEdition getMoteurEdition() {
		return moteurEdition;
	}
	
	/**
	 * Setter
	 * @param moteurEdition : moteur
	 */
	public void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}
	@Override
	public void set(IMoteurEdition newArticle) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Memento storeInMemento() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IMoteurEdition restoreFromMemento(Memento memento) {
		// TODO Auto-generated method stub
		return null;
	}

}
