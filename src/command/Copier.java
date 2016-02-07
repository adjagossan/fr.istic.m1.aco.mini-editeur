package command;

import receiver.IMoteurEdition;
/**
 * Classe Copier
 * Concrete command for the Command design pattern
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class Copier implements ICommand {

	private IMoteurEdition moteurEdition;

	/**
	 * Constructeur
	 * @param moteurEdition : moteur
	 */
	public Copier(IMoteurEdition moteurEdition){
		this.moteurEdition = moteurEdition;
	}

	public void execute() {
		moteurEdition.copier();
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
