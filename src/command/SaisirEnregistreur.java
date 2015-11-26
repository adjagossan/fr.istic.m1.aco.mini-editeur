package command;

import receiver.IEnregistreur;
import memento.MementoSaisir;
import util.IMemento;
import util.IOriginator;


public class SaisirEnregistreur implements IOriginator, ICommandEnreg {
	
	private Saisir cmdSaisir = null;
	private String message;
	
	private IEnregistreur enregistreur = null;
	
	@Override
	public IMemento getMemento() {
		return null; //new MementoSaisir(text);
	}

	@Override
	public void setMemento(IMemento menento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
	public void execute(ICommandEnreg cmdEnr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enregistrer() {
		// TODO Auto-generated method stub
		
	}


}
