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
	 * @param moteurEdition
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
	 * @param moteurEdition
	 */
	public void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}

}
