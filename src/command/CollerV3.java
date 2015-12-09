package command;

import client.Editeur;
import memento.Memento;
import receiver.IMoteurEdition;

public class CollerV3 extends Coller {
	private IMoteurEdition moteur;

	/**
	 * Constructeur
	 * @param moteurEdition : moteur
	 */
	public CollerV3(IMoteurEdition moteurEdition){
		super(moteurEdition);
	}

	@Override
	public void execute() {
		super.execute();
		enregistrer();

	}
	
	/**
	 * Ajoute un memento pour sauvegarder le moteur
	 */
	public void enregistrer() {
		IMoteurEdition moteur = super.getMoteurEdition().cloner();

		Editeur.getSaisir().set(moteur);

		super.getMoteurEdition().addMemento(Editeur.getSaisir().storeInMemento());

		Editeur.setNbEnreg(Editeur.getNbEnreg() + 1);
		Editeur.setCurrentStateMoteur(Editeur.getCurrentMoteur() + 1);

	}

	/**
	 * Getter
	 * @return moteurEdition
	 */
	public IMoteurEdition getMoteurEdition() {
		return moteur;
	}

	/**
	 * Setter
	 * @param moteurEdition : moteurEdition
	 */
	public void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteur = moteurEdition;
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
