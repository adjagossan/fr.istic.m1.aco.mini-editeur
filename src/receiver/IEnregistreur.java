package receiver;

import command.ICommand;

public interface IEnregistreur {
	
	void enregistrer(ICommand cmd);
	void demarrer();
	void arreter();
	void rejouer();
}
