package command;

import client.Editeur;
import invoker.IHM;
import memento.Memento;
import receiver.Buffer;
import receiver.IMoteurEdition;
import receiver.MoteurV3;
/**
 * Classe SaisirV3
 * Concrete command for the Command design pattern
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class SaisirV3 extends Saisir {

	private IMoteurEdition moteur;

	/**
	 * Constructeur
	 * @param mMoteurEdition : moteur
	 * @param ihm : ihm
	 */
	public SaisirV3(IMoteurEdition mMoteurEdition, IHM ihm) {
		super(mMoteurEdition, ihm);
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
		IMoteurEdition moteur = super.getmMoteurEdition().cloner();
		
		Editeur.getSaisir().set(moteur);
		
		super.getmMoteurEdition().addMemento(Editeur.getSaisir().storeInMemento());
		
		Editeur.setNbEnreg(Editeur.getNbEnreg()+1);
		Editeur.setCurrentStateMoteur(Editeur.getCurrentMoteur()+1);
		
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
