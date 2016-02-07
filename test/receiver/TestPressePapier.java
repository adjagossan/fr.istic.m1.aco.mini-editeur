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
	private IMoteurEdition moteurEdition;
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
	public void testContenu() throws Exception
	{
		presse_papier.setContenu("toto");
		assertTrue("contenu n'est pas égal à toto", presse_papier.getContenu() == "toto");
		presse_papier.setContenu("test");
		assertTrue("contenu n'est pas égal à test", presse_papier.getContenu() == "test");
	}
	
	@Test
	public void testSetMoteurEdition() throws Exception
	{
		moteurEdition = new MoteurEditionImpl();
		presse_papier.setMoteurEdition(moteurEdition);
		assertSame("method setMoteurEdition(moteurEdition) failed",presse_papier.getMoteurEdition(), moteurEdition);
	}

}
