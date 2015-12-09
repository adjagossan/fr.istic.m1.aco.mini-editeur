package receiver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import memento.Memento;

/**
 * Classe de test sur le buffer
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
	 * Test undo
	 */
	public void testUndo() {
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
		String concate = txt + txt2;
		Memento mem3 = moteur.getMemento(1);
		
		String resu2 = mem3.getState().getBuffer().toString();
		
		assertEquals("Buffer différent",concate, resu2);
		
	}
	
}
