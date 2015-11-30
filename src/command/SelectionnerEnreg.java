package command;

import invoker.IHM;
import receiver.IEnregistreur;
import receiver.IMoteurEdition;
import util.IMemento;

public class SelectionnerEnreg extends Selectionner implements ICommandEnreg {

	private IEnregistreur enregistreur;
	private int deb;
	private int fin;
	
	public SelectionnerEnreg(IMoteurEdition mMoteurEdition, IEnregistreur enregistreur, IHM ihm) {
		super(mMoteurEdition, ihm);
		this.enregistreur = enregistreur;
	}

	@Override
	public IMemento getMemento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMemento(IMemento menento) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void execute(){
		super.execute();
		this.enregistrer();
	}
	
	@Override
	public void enregistrer() {
		enregistreur.enregistrer(this);
	}

}
