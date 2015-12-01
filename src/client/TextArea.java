package client;

import invoker.IHM;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import receiver.IMoteurEdition;
import receiver.Selection;
/**
 * Classe TextArea
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class TextArea extends JTextArea implements CaretListener, KeyListener {
	private IHM ihm = null;
	private IMoteurEdition moteur;
	
	/**
	 * Constructeur
	 * @param ihm : ihm
	 */
	public TextArea(IHM ihm, IMoteurEdition moteur){
		super();
		this.ihm = ihm;
		this.moteur = moteur;
		
		ihm.invoke("saisir"); // TODO : à garder ? -> save in memento 1st state
		Editeur.currentArticle =0;
		Editeur.saveFiles = 1;
		//System.out.println("current art : "+Editeur.getCurrentArticle());
		
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == e.VK_BACK_SPACE)
			ihm.setInputCharacter("backspace");
		else {
			ihm.setInputCharacter(Character.toString(e.getKeyChar()));
			//Editeur.getSaisir().set(Character.toString(e.getKeyChar()));
		}
		
		ihm.invoke("saisir");
		Editeur.JBUndo.setEnabled(true);
		/*moteur.addMemento(Editeur.getSaisir().storeInMemento());
		
		Editeur.setSaveFiles(Editeur.getSaveFiles()+1);
		Editeur.setCurrentArticle(Editeur.getCurrentArticle()+1);
		
		System.out.println("Save Files " + Editeur.getSaveFiles());*/

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void caretUpdate(CaretEvent e) {
		int debut = e.getMark();
		int fin = e.getDot();

		if(fin-debut>=0)
			ihm.setSelection(debut, fin);
		else
			ihm.setSelection(fin, debut);
		
		ihm.invoke("selectionner");
	}

}
