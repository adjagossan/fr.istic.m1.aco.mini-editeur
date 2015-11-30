package receiver;

import command.ICommandEnreg;

public interface IEnregistreur {
	
	void enregistrer(ICommandEnreg cmd);
	void demarrer();
	void arreter();
	void rejouer();
}
