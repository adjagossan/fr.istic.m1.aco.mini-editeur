package command;

import memento.MementoSaisir;
import invoker.IHM;
import receiver.IEnregistreur;
import receiver.IMoteurEdition;
import util.IMemento;


public class SaisirEnregistreur extends Saisir implements ICommandEnreg {
	
	private IEnregistreur enregistreur;
	private String state;
	
	public SaisirEnregistreur(IMoteurEdition moteurEdition, IEnregistreur enregistreur, IHM ihm)
	{
		super(moteurEdition, ihm);
		this.enregistreur = enregistreur;
	}
	
	@Override
	public IMemento getMemento() {
		this.state = super.getIhm().getInputCharacter();
		return new MementoSaisir(state);
	}

	@Override
	public void setMemento(IMemento memento) {
		this.state = ((MementoSaisir)memento).getState();
		super.getIhm().setInputCharacter(state);
	}

	@Override
	public void execute() {
		super.execute();
		this.enregistrer();
	}

	@Override
	public void enregistrer() {
		enregistreur.enregistrer(this);
	}	
}