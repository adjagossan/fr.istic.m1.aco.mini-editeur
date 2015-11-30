package client;

import invoker.IHM;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import receiver.Selection;
/**
 * Classe TextArea
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class TextArea extends JTextArea implements CaretListener, KeyListener {
	private IHM ihm = null;

	/**
	 * Constructeur
	 * @param ihm : ihm
	 */
	public TextArea(IHM ihm){
		super();
		this.ihm = ihm;
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == e.VK_BACK_SPACE)
			ihm.setInputCharacter("backspace");
		else
			ihm.setInputCharacter(Character.toString(e.getKeyChar()));
		
		ihm.invoke("saisir");

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
