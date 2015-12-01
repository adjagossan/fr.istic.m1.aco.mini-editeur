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
	
	/*@Test
	/**
	 * Test la suppression de texte dans le buffer
	 */
	/*public void testDelete() {
		assertNotNull("L'objet est null lors de l'initialisation", buffer);
		
		// 1er test : suppression totale du buffer
		String txt1 = "tpACO";
		buffer.insert(0,0, txt1);
		
		buffer.delete(0, txt1.length());
		assertEquals("Le buffer n'est pas vide", buffer.getContenu().length(), 0);
		assertTrue("Le contenu du buffer n'est pas égal à celui effacé", buffer.getContenu().toString().isEmpty());
		
		// 2ème test : suppression partielle du buffer
		buffer.insert(0,0, txt1);
		
		int indiceFin = txt1.length()-3;
		buffer.delete(0, indiceFin); // indiceFin exclu
		System.out.println(buffer.getContenu());
		assertEquals("Le buffer n'a pas la même longueur que celle du texte supprimé", buffer.getContenu().length(), indiceFin+1);
		assertTrue("Le contenu du buffer n'est pas égal à celui effacé", buffer.getContenu().toString().equals(txt1.substring(2, txt1.length())));
		
	}*/

}
