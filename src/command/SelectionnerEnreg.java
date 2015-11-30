package command;

import invoker.IHM;
import memento.MementoSelectionner;
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
		int deb = super.getIhm().getSelection().getDebutSelection();
		int fin = super.getIhm().getSelection().getFinSelection();
		return new MementoSelectionner(deb, fin);
	}

	@Override
	public void setMemento(IMemento memento) {
		this.deb = ((MementoSelectionner) memento).getDeb();
		this.fin = ((MementoSelectionner) memento).getFin();
		super.getIhm().setSelection(deb, fin);
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
