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
	public void couper() 
	{
		copier();
		buffer.delete(
				selection.getDebutSelection(), 
				selection.getFinSelection()
				);
	}

	@Override
	public void copier() {
		int deb = selection.getDebutSelection();
		int fin = selection.getFinSelection();
		String subString = buffer.subString(deb, fin);
		pressePapier.setContenu(subString);

	}

	@Override
	public void coller() {
		String content = pressePapier.getContenu();
		this.saisir(content);
	}

	@Override
	public void saisir(String texte) {
		int debutSelection = selection.getDebutSelection();
		buffer.insert(debutSelection, texte);

	}

	@Override
	public void selectionner(Selection selection) {
		this.selection = selection;
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregister() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAttach(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValue(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
