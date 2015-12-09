package client;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import command.Coller;
import command.CollerV3;
import command.Copier;
import command.CopierV3;
import command.Couper;
import command.CouperV3;
import command.ICommand;
import command.SaisirV3;
import command.Selectionner;
import invoker.IHM;
import receiver.Buffer;
import receiver.IMoteurEdition;	
import receiver.MoteurV3;

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
	public static JButton JBUndo = null;
	private JButton JBRedo = null;
	
	private TextArea textArea = null;
	private static ICommand saisir;
	private static IMoteurEdition moteur;
	static int nbEnreg = 0, currentStateMoteur = 0;
	private static String text = "";
	
	
	
	/**
	 * Getter
	 * @return originator
	 */
	public static ICommand getSaisir() {
		return saisir;
	}

	/**
	 * Getter
	 * @return le nombre d'enregistrements
	 */
	public static int getNbEnreg() {
		return nbEnreg;
	}

	/**
	 * Setter
	 * @param nbRengTmp : nombre d'enregistrements
	 */
	public static void setNbEnreg(int nbRengTmp) {
		nbEnreg = nbRengTmp;
	}

	/**
	 * @return l'état du moteur courant
	 */
	public static int getCurrentMoteur() {
		return currentStateMoteur;
	}

	/**
	 * Setter
	 * @param currentArticleTmp : met à jour l'état du moteur
	 */
	public static void setCurrentStateMoteur(int currentArticleTmp) {
		currentStateMoteur = currentArticleTmp;
	}

	/**
	 * Lance l'application mini editeur
	 * @param args : args
	 */
	public static void main(String[] args) {
		
		moteur = new MoteurV3(); // caretaker
		
		IHM ihm = new IHM();
		moteur.register(ihm);
		
		ICommand copier = new CopierV3(moteur);
		ICommand couper = new CouperV3(moteur);
		ICommand coller = new CollerV3(moteur);
		ICommand selectionner = new Selectionner(moteur, ihm);
		saisir = new SaisirV3(moteur, ihm); // originator

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
		
		textArea = new TextArea(ihm, moteur);
		textArea.addCaretListener(textArea);
		textArea.addKeyListener(textArea);
		zoneSaisePanel.add(textArea);
		
		JBCopier = new JButton("Copier");
		JBCopier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ihm.invoke("copier");

				IMoteurEdition currentMoteur = Editeur.getSaisir().restoreFromMemento(moteur.getMemento(currentStateMoteur));

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
		
		JBUndo = new JButton("Undo");
		JBUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if (currentStateMoteur >= 1) {
					currentStateMoteur--;
					
					IMoteurEdition previousMoteur = Editeur.getSaisir().restoreFromMemento(moteur.getMemento(currentStateMoteur));
					// MAJ textArea
					textArea.setText(previousMoteur.getBuffer().toString());
					
					// gestion des boutons
					if (currentStateMoteur>=1)
						JBRedo.setEnabled(true);
					else
						JBUndo.setEnabled(false);

				}
				else {
					JBUndo.setEnabled(false);
				}
				
			}
		});
		
		JBRedo = new JButton("Redo");
		JBRedo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ((nbEnreg-1) > currentStateMoteur) {
					currentStateMoteur++;
					
					IMoteurEdition nextMoteur = saisir.restoreFromMemento(moteur.getMemento(currentStateMoteur));
					// Update text area
					textArea.setText(nextMoteur.getBuffer().toString());
					
					
					JBUndo.setEnabled(true);
					if ((nbEnreg-1) <= currentStateMoteur)
						JBRedo.setEnabled(false);
					
				}
				else {
					JBRedo.setEnabled(false);
				}
			}
		});
		
		JBRedo.setEnabled(false);
		JBUndo.setEnabled(false);
		
		buttonPanel.add(JBCopier);
		buttonPanel.add(JBCouper);
		buttonPanel.add(JBColler);
		buttonPanel.add(JBUndo);
		buttonPanel.add(JBRedo);
		
		contenuFenetre.add(buttonPanel);
		contenuFenetre.add(zoneSaisePanel);
		
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
