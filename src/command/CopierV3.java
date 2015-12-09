package command;

import client.Editeur;
import invoker.IHM;
import memento.Memento;
import receiver.IMoteurEdition;
/**
 * Classe CopierV3
 * Concrete command for the Command design pattern
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class CopierV3 extends Copier {

	private IMoteurEdition moteur;

		/**
		 * Constructeur
		 * @param mMoteurEdition : moteur
		 */
		public CopierV3(IMoteurEdition mMoteurEdition) {
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
			IMoteurEdition moteur = super.getMoteurEdition().cloner();
			
			Editeur.getSaisir().set(moteur);
			
			super.getMoteurEdition().addMemento(Editeur.getSaisir().storeInMemento());
			
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
