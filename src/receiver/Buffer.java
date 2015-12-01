package receiver;
/**
 * Classe Buffer
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class Buffer {
	
	private StringBuffer contenu;

	private IMoteurEdition moteurEdition;

	/**
	 * Getter
	 * @return moteurEdition
	 */
	public IMoteurEdition getMoteurEdition() {
		return moteurEdition;
	}

	@SuppressWarnings("unused")
	/**
	 * Setter
	 * @param moteurEdition
	 */
	private void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}

	/**
	 * Constructeur
	 */
	public Buffer () {
		contenu = new StringBuffer();
	}
	
	/**
	 * Constructeur
	 * @param contenu : contenu du buffer
	 */
	public Buffer (StringBuffer contenu) {
		this.contenu = contenu;
	}

	/**
	 * Getter
	 * @return contenu
	 */
	public StringBuffer getContenu() {
		return contenu;
	}

	/**
	 * Supprime du buffer le texte compris entre [indiceDebut,indiceFin]
	 * @param indiceDebut : indiceDebut
	 * @param indiceFin : indiceFin
	 */
	public void delete(int indiceDebut, int indiceFin){
		contenu.delete(indiceDebut, indiceFin);
	}

	/**
	 * Insertion d'un texte dans le buffer en fonction de la position
	 * @param indiceDebut : indiceDebut
	 * @param indiceFin : indiceFin
	 * @param texte : texte
	 * @return le buffer
	 */
	public Buffer insert(int indiceDebut, int indiceFin, String texte  ){
		contenu.replace(indiceDebut, indiceFin, texte);
		//contenu.insert(indiceDebut, texte);
		return this;
	}
	
	/**
	 * 
	 * @param indiceDebut : indiceDebut
	 * @param indiceFin : indiceFin
	 * @return une sous chaine du buffer
	 */
	public String subString(int indiceDebut, int indiceFin)
	{
		int size = contenu.toString().length();
		
		if(/*size >= (indiceFin-indiceDebut) && */size >=indiceDebut && size >=indiceFin)
			return contenu.substring(indiceDebut, indiceFin);
		else
			return null;
	}
	
	/**
	 * Redéfinition de la méthode toString()
	 */
	public String toString() {
		return contenu.toString();
	}
	
}
