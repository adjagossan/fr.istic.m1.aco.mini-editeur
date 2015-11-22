package receiver;

public class MoteurEditionImpl implements IMoteurEdition {

	private Buffer buffer;
	private PressePapier pressePapier;
	private Selection selection;

	public MoteurEditionImpl () {
		pressePapier = new PressePapier();
		buffer = new Buffer();
		selection = new Selection(0,0);
	}

	@Override
	public void couper() {
		// TODO Auto-generated method stub

	}

	@Override
	public void copier() {
		// TODO Auto-generated method stub

	}

	@Override
	public void coller() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saisir(String texte) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectionner(Selection selection) {
		// TODO Auto-generated method stub

	}

}
