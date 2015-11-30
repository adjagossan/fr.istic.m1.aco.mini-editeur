package client;

import invoker.IHM;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import receiver.IMoteurEdition;
import receiver.MoteurEditionImpl;

import command.Coller;
import command.Copier;
import command.Couper;
import command.ICommand;
import command.Saisir;
import command.Selectionner;

/**
 * Classe Editeur
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */

public class Editeur extends JFrame {

	private JFrame fenetre;
	private Container contenuFenetre;
	
	private JButton JBCopier = null;
	private JButton JBCouper = null;
	private JButton JBColler = null;
	
	private TextArea textArea = null;
	
	/**
	 * Lance l'application mini editeur
	 * @param args : args
	 */
	public static void main(String[] args) {
		
		IMoteurEdition moteur = new MoteurEditionImpl();
		
		IHM ihm = new IHM();
		moteur.register(ihm);
		
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
	
	/**
	 * Constructeur
	 * @param moteur : moteur de l'éditeur
	 * @param ihm : ihm
	 */
	public Editeur(IMoteurEdition moteur, final IHM ihm){
		super("Mini-Editeur");
		contenuFenetre = this.getContentPane();
		contenuFenetre.setLayout(new BoxLayout(contenuFenetre, BoxLayout.PAGE_AXIS));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		JPanel zoneSaisePanel = new JPanel();
		zoneSaisePanel.setLayout(new BoxLayout(zoneSaisePanel, BoxLayout.X_AXIS));
		
		textArea = new TextArea(ihm);
		textArea.addCaretListener(textArea);
		textArea.addKeyListener(textArea);
		zoneSaisePanel.add(textArea);
		
		JBCopier = new JButton("Copier");
		JBCopier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ihm.invoke("copier");
			}
		});
		
		JBCouper = new JButton("Couper");
		JBCouper.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ihm.invoke("couper");
				int start = ihm.getSelection().getDebutSelection();
				int end = ihm.getSelection().getFinSelection();
				textArea.replaceRange("", start, end);
				
			}
		});
		
		JBColler = new JButton("Coller");
		JBColler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ihm.invoke("coller");
				int start = ihm.getSelection().getDebutSelection();
				int end = ihm.getSelection().getFinSelection();
				textArea.replaceRange(ihm.getPressePapier(), start, end);
				
			}
		});
		
		buttonPanel.add(JBCopier);
		buttonPanel.add(JBCouper);
		buttonPanel.add(JBColler);
		
		contenuFenetre.add(buttonPanel);
		contenuFenetre.add(zoneSaisePanel);
		
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
