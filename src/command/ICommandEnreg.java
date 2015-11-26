package command;

import util.IOriginator;

public interface ICommandEnreg extends ICommand, IOriginator {
	void enregistrer();
}
