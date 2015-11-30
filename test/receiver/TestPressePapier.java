package receiver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import receiver.PressePapier;
/**
 * Classe de test sur le presse papier
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class TestPressePapier {
	
	private PressePapier presse_papier;

	@Before
	/**
	 * This is executed before each test case execution
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		presse_papier = new PressePapier();
	}
	
	@Test
	/**
	 * Test sur le contenu du pp
	 */
	public void testContenu() {
		assertNotNull("L'objet initialisé n'est pas vide", presse_papier);
		assertTrue("L'objet initialisé n'est pas vide", presse_papier.getContenu() == "");
		
		presse_papier.setContenu("toto");
		assertTrue("contenu n'est pas égal à toto", presse_papier.getContenu() == "toto");
	}

}
