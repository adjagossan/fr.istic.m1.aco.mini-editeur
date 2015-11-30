package receiver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import receiver.PressePapier;

public class TestPressePapier {
	
	private PressePapier presse_papier;

	@Before
	public void setUp() throws Exception {
		// This is executed before each test case execution
		// We build a typical subject and a mock observer
		presse_papier = new PressePapier();
	}
	
	
	@Test
	public void testContenu() {
		assertNotNull("L'objet initialisé n'est pas vide", presse_papier);
		assertTrue("L'objet initialisé n'est pas vide", presse_papier.getContenu() == "");
		
		presse_papier.setContenu("toto");
		assertTrue("contenu n'est pas égal à toto", presse_papier.getContenu() == "toto");
	}

}
