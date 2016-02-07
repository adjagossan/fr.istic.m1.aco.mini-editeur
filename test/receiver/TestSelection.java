package receiver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSelection {
	
	private Selection selection;
	@Before
	public void setUp() throws Exception {
		selection = new Selection(0, 0);
	}

	@Test
	public void testSetDebutSelction() throws Exception
	{
		selection.setDebutSelection(3);
		assertTrue("debut de la selection non modifié", selection.getDebutSelection()==3);
	}
	
	@Test
	public void testSetFinSelction() throws Exception
	{
		selection.setFinSelection(3);
		assertTrue("fin de la selection non modifié", selection.getFinSelection()==3);
	}
	
	@Test
	public void testSetSelection() throws Exception
	{
		selection.setSelection(5, 10);
		assertTrue("selection non modifiée", selection.getFinSelection()==10 && selection.getDebutSelection()==5);
	}

}
