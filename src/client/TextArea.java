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
	 * @param moteur : moteur
	 */
	public TextArea(IHM ihm, IMoteurEdition moteur){
		super();
		this.ihm = ihm;
		this.moteur = moteur;
		
		ihm.invoke("saisir"); // TODO : à garder ? -> save in memento 1st state
		Editeur.currentStateMoteur =0;
		Editeur.nbEnreg = 1;
		
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
		}
		
		ihm.invoke("saisir");
		Editeur.JBUndo.setEnabled(true);

	}

	@Override
	public void keyReleased(KeyEvent e) {

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
