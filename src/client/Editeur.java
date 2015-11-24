package client;

import receiver.EnregistreurImpl;
import receiver.IEnregistreur;
import receiver.IMoteurEdition;
import receiver.MoteurEditionImpl;
import invoker.IHM;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import command.Coller;
import command.Copier;
import command.Couper;
import command.ICommand;
import command.Saisir;
import command.Selectionner;

public class Editeur  extends JFrame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IMoteurEdition moteur = new MoteurEditionImpl();
		IEnregistreur enregistreur = new EnregistreurImpl();
		
		IHM ihm = new IHM();
		moteur.register(ihm);
		
		ICommand copier = new Copier(moteur, enregistreur);
		ICommand couper = new Couper(moteur, enregistreur);
		ICommand coller = new Coller(moteur, enregistreur);
		ICommand selectionner = new Selectionner(moteur, ihm);
		ICommand saisir = new Saisir(moteur, ihm, enregistreur);

		ihm.addCommand("couper", couper);
		ihm.addCommand("coller", coller);
		ihm.addCommand("copier", copier);
		ihm.addCommand("selectionner", selectionner);
		ihm.addCommand("saisir", saisir);

		Editeur editeur = new Editeur(moteur, ihm);

	}
	
	public Editeur(IMoteurEdition moteur, IHM ihm){
		
		
	}

}
