package receiver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import memento.Memento;

/**
 * Classe de test sur le undo/redo
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class TestV3 {

	private IMoteurEdition moteur;

	@Before
	/**
	 * This is executed before each test case execution
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		moteur = new MoteurV3();
	}
	
	@Test
	/**
	 * Test undo / redo
	 */
	public void testUndoRedo() {
		assertNotNull("L'objet est null lors de l'initialisation", moteur);
		String txt = "toto";
		Buffer buffer = moteur.getBuffer();
		
		moteur.setBuffer(new Buffer(new StringBuffer(txt)));
		
		assertEquals("Buffer différent",txt, moteur.getBuffer().toString());
		
		
		moteur.addMemento(new Memento(moteur.cloner()));
		
		String txt2 = "titi";
		moteur.setBuffer(new Buffer(new StringBuffer(txt+txt2)));
		moteur.addMemento(new Memento(moteur.cloner()));
		
		// undo
		Memento mem2 = moteur.getMemento(0);
		
		String resu = mem2.getState().getBuffer().toString();
		assertEquals("Buffer différent",txt, resu);
		
		// redo
		String concate = txt + txt2; // concate = tototiti
		Memento mem3 = moteur.getMemento(1);
		
		String resu2 = mem3.getState().getBuffer().toString();
		
		assertEquals("Buffer différent",concate, resu2);
		
		// couper
		int lenghtConcate = txt.length() + txt2.length();
		Selection selection = new Selection(txt.length(), lenghtConcate);
		moteur.setSelection(selection);
		moteur.couper(); // buffer = toto
		moteur.addMemento(new Memento(moteur.cloner())); // index = 2
		
		// coller
		Selection selection2 = new Selection(0,0);
		moteur.setSelection(selection2);
		moteur.coller(); // buffer = tititoto
		moteur.addMemento(new Memento(moteur.cloner())); // index = 3
		
		// coller
		selection.setDebutSelection(lenghtConcate);
		moteur.setSelection(selection);
		moteur.coller(); // buffer = tititototiti
		moteur.addMemento(new Memento(moteur.cloner())); // index = 4
		
		Memento mem4 = moteur.getMemento(2);
		String resu3 = mem4.getState().getBuffer().toString();
		
		assertEquals("Buffer différent",txt, resu3);

		Memento mem5 = moteur.getMemento(4);
		String resu4 = mem5.getState().getBuffer().toString();
		String concatDouble = txt2 + txt + txt2;
		assertEquals("Buffer différent",concatDouble, resu4);
		
	}
	
}
