package receiver;
/**
 * Classe Selection
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class Selection {
	
	private int debutSelection;
	private int finSelection;
	private IMoteurEdition moteurEdition;

	/**
	 * Getter
	 * @return moteur
	 */
	public IMoteurEdition getMoteurEdition() {
		return moteurEdition;
	}

	/**
	 * Setter
	 * @param moteurEdition : moteur
	 */
	public void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}

	/**
	 * Constructeur
	 * @param debutSelection : debutSelection
	 * @param finSelection : finSelection
	 */
	public Selection(int debutSelection, int finSelection) {
		this.debutSelection = debutSelection;
		this.finSelection = finSelection;
	}

	/**
	 * Getter
	 * @return debut selection
	 */
	public int getDebutSelection() {
		return debutSelection;
	}

	/**
	 * Setter
	 * @param debutSelection : debutSelection
	 */
	public void setDebutSelection(int debutSelection) {
		this.debutSelection = debutSelection;
	}

	/**
	 * Getter
	 * @return finSelection
	 */
	public int getFinSelection() {
		return finSelection;
	}

	/**
	 * Setter
	 * @param finSelection : finSelection
	 */
	public void setFinSelection(int finSelection) {
		this.finSelection = finSelection;
	}
	
	/**
	 * Setter
	 * @param deb : debut de la selection
	 * @param fin : fin de la selection
	 */
	public void setSelection(int deb, int fin){
		this.debutSelection = deb;
		this.finSelection = fin;
	}
	
	public String toString() {
		return ""+debutSelection + " "+ finSelection;
	}
}
