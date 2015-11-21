package receiver;

public class Selection {
	
	private int debutSelection;
	private int finSelection;
	private IMoteurEdition moteurEdition;

	public IMoteurEdition getMoteurEdition() {
		return moteurEdition;
	}

	public void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}

	public Selection(int debutSelection, int finSelection) {
		this.debutSelection = debutSelection;
		this.finSelection = finSelection;
	}

	public int getDebutSelection() {
		return debutSelection;
	}

	public void setDebutSelection(int debutSelection) {
		this.debutSelection = debutSelection;
	}

	public int getFinSelection() {
		return finSelection;
	}

	public void setFinSelection(int finSelection) {
		this.finSelection = finSelection;
	}
}
