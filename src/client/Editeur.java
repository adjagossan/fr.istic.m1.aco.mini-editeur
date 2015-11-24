package client;

import receiver.IMoteurEdition;
import receiver.MoteurEditionImpl;
import invoker.IHM;

import command.Coller;
import command.Copier;
import command.Couper;
import command.ICommand;
import command.Saisir;
import command.Selectionner;

public class Editeur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IHM ihm = new IHM();

		IMoteurEdition moteur = new MoteurEditionImpl();

		ICommand copier = new Copier(moteur);
		ICommand couper = new Couper(moteur);
		ICommand coller = new Coller(moteur);
		ICommand selectionner = new Selectionner(moteur, ihm);
		ICommand saisir = new Saisir(moteur, ihm);

		ihm.addCommand("couper", couper);
		ihm.addCommand("coller", coller);
		ihm.addCommand("copier", copier);
		ihm.addCommand("selectionner", selectionner);
		ihm.addCommand("saisir", saisir);

		Editeur editeur = new Editeur(moteur, ihm);

	}
	
	public Editeur(IMoteurEdition moteur, IHM ihm){}

}
