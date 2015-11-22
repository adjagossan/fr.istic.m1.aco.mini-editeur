package receiver;

import util.ISubject;

public interface IMoteurEdition extends ISubject{
	
	void couper();

	void copier();

	void coller();

	void selectionner(Selection selection);

	void saisir(String texte);
}
