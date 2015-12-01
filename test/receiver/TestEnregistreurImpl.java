package receiver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEnregistreurImpl {
	private EnregistreurImpl mEnregistreurImpl;
	
	@Before
	public void setUp() throws Exception {
		mEnregistreurImpl = new EnregistreurImpl();
	}

	@Test
	public void testDemarrer()
	{
		mEnregistreurImpl.demarrer();
		assertTrue("EnregistreurImpl n'a pas demarre ", mEnregistreurImpl.isStart());
		assertEquals("Liste de commandes enregistrables non vide", mEnregistreurImpl.getCmds().isEmpty(), true);
		assertEquals("Liste de mementos non vide", mEnregistreurImpl.getMementos().isEmpty(), true);
	}
	
	public void testArreter()
	{
		mEnregistreurImpl.arreter();
		assertEquals("EnregistreurImpl en marche", mEnregistreurImpl.isStart(), false);
	}
	
	@Test
	public void testRejouer()
	{
		testArreter();
		assertEquals(
				"Les listes de commandes enregistrables et de memento sont de taille différente",
				mEnregistreurImpl.getCmds().size(), mEnregistreurImpl.getMementos().size());
		
	}

}
