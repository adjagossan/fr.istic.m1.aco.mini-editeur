package command;

import client.Editeur;
import memento.Memento;
import receiver.IMoteurEdition;
/**
 * Classe CouperV3
 * Concrete command for the Command design pattern
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class CouperV3 extends Couper {

	private IMoteurEdition moteur;

	/**
	 * Constructeur
	 * @param mMoteurEdition : moteur
	 */
	public CouperV3(IMoteurEdition mMoteurEdition) {
		super(mMoteurEdition);
	}

	@Override
	public void execute() {
		super.execute();
		enregistrer();

	}

	/**
	 * Enregistre le moteur dans le memento
	 */
	public void enregistrer() {
		// clone du moteur
		IMoteurEdition moteur = super.getMoteurEdition().cloner();

		// définir la valeur du moteur
		Editeur.getSaisir().set(moteur);

		super.getMoteurEdition().addMemento(Editeur.getSaisir().storeInMemento());

		Editeur.setNbEnreg(Editeur.getNbEnreg() + 1);
		Editeur.setCurrentStateMoteur(Editeur.getCurrentMoteur() + 1);

	}

	public void set(IMoteurEdition newMoteur) {
		this.moteur = newMoteur;
	}

	public Memento storeInMemento() {
		return new Memento(moteur);
	}

	public IMoteurEdition restoreFromMemento(Memento memento) {
		moteur = memento.getState();
		return moteur;
	}
}
