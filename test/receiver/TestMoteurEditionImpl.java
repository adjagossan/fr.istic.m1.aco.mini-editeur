package receiver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import receiver.IMoteurEdition;
import receiver.MoteurEditionImpl;
import receiver.Selection;
/**
 * Classe de test sur le moteur
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class TestMoteurEditionImpl {

	private IMoteurEdition moteur;
	private IMoteurEdition moteur2;
	
	@Before
	/**
	 * This is executed before each test case execution
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		moteur = new MoteurEditionImpl();
		moteur2 = new MoteurEditionImpl();
	}

	@Test
	/**
	 * Test la commande couper du moteur
	 */
	public void testCouper() {
		invariant();
		String txt1 = "toto";
		moteur.saisir(txt1);
		moteur.selectionner(new Selection(0, txt1.length()));
		moteur.couper();
		moteur.selectionner(new Selection(0, 0));
		assertTrue("Le contenu du PP n'est pas égal au contenu coupé",moteur.getPressePapier().getContenu().equals(txt1));
		assertTrue("Le contenu coupé n'est pas mis dans le PP", moteur.getBuffer().getContenu().toString().equals(""));
		
		assertEquals("Le début de la sélection n'est pas correcte (après un couper)",0, moteur.getSelection().getDebutSelection());
		assertEquals("La fin de la sélection n'est pas correcte (après un couper)",0, moteur.getSelection().getFinSelection());
		
		// second couper
		String txt2 = "titi";
		moteur.saisir(txt2);
		moteur.selectionner(new Selection(0, txt2.length()));
		moteur.couper();
		moteur.selectionner(new Selection(0, 0));
		assertTrue("Le contenu du PP n'est pas égal au contenu coupé",moteur.getPressePapier().getContenu().equals(txt2));
		assertTrue("Le contenu coupé n'est pas mis dans le PP", moteur.getBuffer().getContenu().toString().equals(""));
		
		assertEquals("Le début de la sélection n'est pas correcte (après un couper)",0, moteur.getSelection().getDebutSelection());
		assertEquals("La fin de la sélection n'est pas correcte (après un couper)",0, moteur.getSelection().getFinSelection());
		
		// couper vide
		moteur.selectionner(new Selection(0, 0));
		moteur.couper();
		assertTrue("Le presse papier n'est pas vide", moteur.getPressePapier().getContenu().equals(""));
		
	}

	@Test 
	/**
	 * Test de la commande copier du moteur
	 */
	public void testCopier() {
		invariant();
		String txt1 = "toto";
		moteur.saisir(txt1);
		moteur.selectionner(new Selection(0, txt1.length()));
		moteur.copier();
		assertTrue("Le contenu du PP n'est pas égal au contenu copié",moteur.getPressePapier().getContenu().equals(txt1));
		assertTrue("Le contenu copié n'est pas mis dans le PP", moteur.getBuffer().getContenu().toString().equals(txt1));
		
		assertEquals("Le début de la sélection n'est pas correcte (après un copier)",0, moteur.getSelection().getDebutSelection());
		assertEquals("La fin de la sélection n'est pas correcte (après un copier)",txt1.length(), moteur.getSelection().getFinSelection());
		
		// second copier
		String txt2 = "titi";
		moteur.selectionner(new Selection(txt1.length(), txt1.length()));
		moteur.saisir(txt2);
		int newSelection = txt1.length() + txt2.length();
		moteur.selectionner(new Selection(txt1.length(), newSelection));
		moteur.copier();
		assertTrue("Le contenu du PP n'est pas égal au contenu copié",moteur.getPressePapier().getContenu().equals(txt2));
		assertTrue("Le contenu copié n'est pas mis dans le PP", moteur.getBuffer().getContenu().toString().equals(txt1+txt2));
		
		assertEquals("Le début de la sélection n'est pas correcte (après un copier)",txt1.length(), moteur.getSelection().getDebutSelection());
		assertEquals("La fin de la sélection n'est pas correcte (après un copier)",newSelection, moteur.getSelection().getFinSelection());
		
		// copier vide
		moteur.selectionner(new Selection(0, 0));
		moteur.copier();
		assertTrue("Le presse papier n'est pas vide", moteur.getPressePapier().getContenu().equals(""));
		
	}

	@Test
	/**
	 * Test de la commande coller du moteur
	 */
	public void testColler() {
		invariant();
		String txt1 = "toto";
		moteur.saisir(txt1);
		moteur.selectionner(new Selection(txt1.length(), txt1.length()));

		// copier vide
		moteur.copier();
		moteur.coller();
		assertTrue("Le buffer a été modifié", moteur.getBuffer().getContenu().toString().equals(txt1));
		
		// copier txt1
		moteur.selectionner(new Selection(0, txt1.length()));
		moteur.copier();
		moteur.coller();
		
		assertTrue("Le buffer a été modifié", moteur.getBuffer().getContenu().toString().equals(txt1));
		moteur.selectionner(new Selection(txt1.length(), txt1.length()));
		
		moteur.coller();
		assertTrue("Le buffer ne contient pas 2 fois le texte collé", moteur.getBuffer().getContenu().toString().equals(txt1+txt1));
		
		// couper tout (sans changement de selection)
		int newSelection = txt1.length()*2;
		moteur.selectionner(new Selection(0, newSelection));
		moteur.couper();
		moteur.coller();
		assertTrue("Le buffer ne contient pas le contenu du couper", moteur.getBuffer().getContenu().toString().equals(txt1+txt1));
		
		// couper tout (avec changement de selection)
		moteur.selectionner(new Selection(newSelection, newSelection));
		moteur.coller();
		assertTrue("Le buffer ne contient pas le contenu du couper (changement selection)", moteur.getBuffer().getContenu().toString().equals(txt1+txt1+txt1+txt1));
		
	}

	@Test 
	/**
	 * Test de la commande sélectionner du moteur
	 */
	public void testSelectionner() {
		invariant();
		assertEquals("La selection n'est pas initialisée à zéro",0, moteur.getSelection().getDebutSelection());
		assertEquals("La selection n'est pas initialisée à zéro",0, moteur.getSelection().getFinSelection());
		String txt1 = "toto";
		moteur.saisir(txt1);
		moteur.selectionner(new Selection(txt1.length(), txt1.length()));
		Selection select = moteur.getSelection();
		assertEquals("La selection n'est pas correcte (après un saisir)",txt1.length(), select.getDebutSelection());
		assertEquals("La selection n'est pas correcte (après un saisir)",txt1.length(), select.getFinSelection());
	
		int debutSelection = 0;
		int finSelection = txt1.length();
		moteur.selectionner(new Selection(debutSelection, finSelection));
		
		assertEquals("La selection n'est pas correcte (après un selectionner)",debutSelection, moteur.getSelection().getDebutSelection());
		assertEquals("La selection n'est pas correcte (après un selectionner)",finSelection, moteur.getSelection().getFinSelection());
	}

	@Test 
	/**
	 * Test de la commande saisir du moteur
	 */
	public void testSaisir() {
		invariant();
		String txt1 = "toto";
		String txt2 = "titi";
		String txtConcat = txt1+txt2;
		moteur.saisir(txt1);
		moteur.selectionner(new Selection(txt1.length(), txt1.length()));
		assertTrue("L'insertion n'est pas correcte", moteur.getBuffer().getContenu().toString().equals(txt1));
		moteur.saisir(txt2);
		moteur2.saisir(txtConcat);
		assertTrue("Insérer 1 + 2 ne revient pas à insérer 1 puis insérer 2", moteur.getBuffer().getContenu().toString().equals(moteur2.getBuffer().getContenu().toString()));
	}
	
	/**
	 * Test de l'invariant - Lancé à chaque début de test
	 */
	private void invariant() {
		assertNotNull("L'objet initialisé n'est pas vide", moteur);
	}


}
