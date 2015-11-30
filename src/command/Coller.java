package command;

import receiver.IMoteurEdition;
/**
 * Classe Coller
 * Concrete command for the Command design pattern
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class Coller implements ICommand {
	private IMoteurEdition moteurEdition;

	/**
	 * Constructeur
	 * @param moteurEdition : moteur
	 */
	public Coller(IMoteurEdition moteurEdition){
		this.moteurEdition = moteurEdition;
	}

	@Override
	public void execute() {
		moteurEdition.coller();

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
	 * @param moteurEdition : moteurEdition
	 */
	public void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}

}
