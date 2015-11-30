package command;

import receiver.IEnregistreur;
import receiver.IMoteurEdition;
import util.IMemento;

public class CouperEnreg extends Couper implements ICommandEnreg {
	private IEnregistreur enregistreur;
	
	public CouperEnreg(IMoteurEdition moteurEdition, IEnregistreur enregistreur)
	{
		super(moteurEdition);
		this.enregistreur = enregistreur;
	}

	@Override
	public void execute() {
		super.execute();
		this.enregistrer();
	}

	@Override
	public void enregistrer() {
		this.enregistreur.enregistrer(this);
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

}
