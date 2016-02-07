package command;

import receiver.IMoteurEdition;
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

}
