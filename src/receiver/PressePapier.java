package receiver;

/**
 * Classe PressePapier
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class PressePapier {
	
	private String contenu;

	private IMoteurEdition moteurEdition;
	
	/**
	 * Constructeur
	 */
	public PressePapier(){
		this.contenu = "";
	}
	
	public PressePapier (String contenu) {
		this.contenu = contenu;
	}

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
	 * Getter
	 * @return contenu
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * Setter
	 * @param contenu : contenu
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	public PressePapier clone()  {
		PressePapier o = null;
		o = new PressePapier(contenu);
		
		// on renvoie le clone
		return o;
	}
	
	public String toString() {
		return contenu;
	}
}
