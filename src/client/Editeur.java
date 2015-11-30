package client;


import invoker.IHM;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import receiver.EnregistreurImpl;
import receiver.IEnregistreur;
import receiver.IMoteurEdition;
import receiver.MoteurEditionImpl;

import command.Arreter;
import command.Coller;
import command.CollerEnreg;
import command.Copier;
import command.CopierEnreg;
import command.Couper;
import command.CouperEnreg;
import command.Demarrer;
import command.ICommand;
import command.Rejouer;
import command.Saisir;
import command.SaisirEnregistreur;
import command.Selectionner;
import command.SelectionnerEnreg;


public class Editeur extends JFrame {
	
	private Container contenuFenetre = null;
	private TextArea textArea = null;
	private JButton JBCopier = null;
	private JButton JBCouper = null;
	private JButton JBColler = null;
	private JButton JBDemarrer;
	private JButton JBArreter;
	private JButton JBRejouer;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IMoteurEdition moteur = new MoteurEditionImpl();
		IEnregistreur enregistreur = new EnregistreurImpl();
		
		IHM ihm = new IHM();
		moteur.register(ihm);
		
		/*ICommand copier = new Copier(moteur);
		ICommand couper = new Couper(moteur);
		ICommand coller = new Coller(moteur);
		ICommand selectionner = new Selectionner(moteur, ihm);
		ICommand saisir = new Saisir(moteur, ihm);*/
		
		ICommand copier = new CopierEnreg(moteur, enregistreur);
		ICommand couper = new CouperEnreg(moteur, enregistreur);
		ICommand coller = new CollerEnreg(moteur, enregistreur);
		ICommand selectionner = new SelectionnerEnreg(moteur, enregistreur, ihm);
		ICommand saisir = new SaisirEnregistreur(moteur, enregistreur, ihm);
		
		ICommand demarrer = new Demarrer(enregistreur);
		ICommand arreter = new Arreter(enregistreur);
		ICommand rejouer = new Rejouer(enregistreur);

		ihm.addCommand("couper", couper);
		ihm.addCommand("coller", coller);
		ihm.addCommand("copier", copier);
		ihm.addCommand("selectionner", selectionner);
		ihm.addCommand("saisir", saisir);
		ihm.addCommand("demarrer", demarrer);
		ihm.addCommand("rejouer", rejouer);
		ihm.addCommand("arreter", arreter);

		Editeur editeur = new Editeur(moteur, ihm);
	}
	
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
		
		JBDemarrer = new JButton("Demarrer");
		JBDemarrer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ihm.invoke("demarrer");
			}	
		});
		
		JBArreter = new JButton("Arreter");
		JBArreter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ihm.invoke("arreter");
			}	
		});
		
		JBRejouer = new JButton("Rejouer");
		JBRejouer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ihm.invoke("rejouer");
			}	
		});
		
		buttonPanel.add(JBCopier);
		buttonPanel.add(JBCouper);
		buttonPanel.add(JBColler);
		buttonPanel.add(JBDemarrer);
		buttonPanel.add(JBArreter);
		buttonPanel.add(JBRejouer);
		
		contenuFenetre.add(buttonPanel);
		contenuFenetre.add(zoneSaisePanel);
		
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
