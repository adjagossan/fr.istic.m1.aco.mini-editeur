package client;

import invoker.IHM;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import receiver.Selection;

public class TextArea extends JTextArea implements CaretListener, KeyListener {
	private IHM ihm = null;

	public TextArea(IHM ihm){
		super(5, 5);
		this.ihm = ihm;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		String text = Character.toString(e.getKeyChar());
		ihm.setInputCharacter(text);
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
