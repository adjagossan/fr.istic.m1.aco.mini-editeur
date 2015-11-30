package receiver;

public class Buffer {
	
	private StringBuffer contenu;

	private IMoteurEdition moteurEdition;

	public IMoteurEdition getMoteurEdition() {
		return moteurEdition;
	}

	@SuppressWarnings("unused")
	private void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}

	public Buffer () {
		contenu = new StringBuffer();
	}
	
	public Buffer (StringBuffer contenu) {
		this.contenu = contenu;
	}

	public StringBuffer getContenu() {
		return contenu;
	}

	public void delete(int indiceDebut, int indiceFin){
		contenu.delete(indiceDebut, indiceFin);
	}

	public Buffer insert(int indiceDebut, int indiceFin, String texte  ){
		contenu.replace(indiceDebut, indiceFin, texte);
		//contenu.insert(indiceDebut, texte);
		return this;
	}
	
	public String subString(int indiceDebut, int indiceFin){
		return contenu.substring(indiceDebut, indiceFin);
	}
	
	public String toString() {
		return contenu.toString();
	}
	
}
