package command;

import memento.MementoSaisir;
import invoker.IHM;
import receiver.IEnregistreur;
import receiver.IMoteurEdition;
import util.IMemento;


public class SaisirEnregistreur extends Saisir implements ICommandEnreg {
	
	private IEnregistreur enregistreur;
	private String state;
	private IHM ihm;
	
	public SaisirEnregistreur(IMoteurEdition moteurEdition, IEnregistreur enregistreur, IHM ihm)
	{
		super(moteurEdition, ihm);
		this.enregistreur = enregistreur;
		this.ihm = ihm;
	}
	
	@Override
	public IMemento getMemento() {
		this.state = ihm.getInputCharacter();
		return new MementoSaisir(state);
	}

	@Override
	public void setMemento(IMemento memento) {
		this.state = ((MementoSaisir)memento).getState();
		ihm.setInputCharacter(state);
		this.execute();
	}

	@Override
	public void execute() {
		super.execute();
		enregistreur.enregistrer(this);
	}

	@Override
	public void enregistrer() {
	}	
}