package receiver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import invoker.IHM;

import org.junit.Before;
import org.junit.Test;

import command.ICommandEnreg;
import command.SaisirEnregistreur;
import command.SelectionnerEnreg;

public class TestEnregistreurImpl {
	
	private MoteurEditionImpl moteur;
	private EnregistreurImpl mEnregistreurImpl;
	private ICommandEnreg saisirEnreg;
	private ICommandEnreg selectionnerEnreg;
	private IHM ihm;
	
	@Before
	public void setUp() throws Exception {
		moteur = new MoteurEditionImpl();
		mEnregistreurImpl = new EnregistreurImpl();
		ihm = new IHM();
	}

	@Test
	public void testDemarrer() throws Exception
	{
		mEnregistreurImpl.demarrer();
		assertTrue("EnregistreurImpl n'a pas demarre ", mEnregistreurImpl.isStart());
		assertEquals("Liste de commandes enregistrables non vide", mEnregistreurImpl.getCmds().isEmpty(), true);
		assertEquals("Liste de mementos non vide", mEnregistreurImpl.getMementos().isEmpty(), true);
	}
	
	@Test
	public void testEnregistrer() throws Exception
	{
		testDemarrer();
		
		saisirEnreg = new SaisirEnregistreur(moteur, mEnregistreurImpl, ihm);
		mEnregistreurImpl.enregistrer(saisirEnreg);
		assertEquals("Taille de la liste de commandes enregistrables differente de 1", mEnregistreurImpl.getCmds().size(), 1);
		assertEquals("Taille de la liste de memento differente de 1", mEnregistreurImpl.getMementos().size(), 1);
		
		testArreter();
		
		selectionnerEnreg = new SelectionnerEnreg(moteur, mEnregistreurImpl, ihm);
		mEnregistreurImpl.enregistrer(selectionnerEnreg);
		assertEquals("Taille de la liste de commandes enregistrables differente de 1", mEnregistreurImpl.getCmds().size(), 1);
		assertEquals("Taille de la liste de memento differente de 1", mEnregistreurImpl.getMementos().size(), 1);

	}
	
	@Test
	public void testArreter() throws Exception
	{
		mEnregistreurImpl.arreter();
		assertEquals("EnregistreurImpl en marche", mEnregistreurImpl.isStart(), false);
	}
	
	@Test
	public void testRejouer() throws Exception
	{
		testArreter();
		assertEquals(
				"Les listes de commandes enregistrables et de memento sont de taille différente",
				mEnregistreurImpl.getCmds().size(), mEnregistreurImpl.getMementos().size());
	}

}
