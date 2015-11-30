package receiver;

public class Buffer {
	
	private StringBuffer contenu;

	private IMoteurEdition moteurEdition;

	public IMoteurEdition getMoteurEdition() {
		return moteurEdition;
	}

	private void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}

	public Buffer () {
		contenu = new StringBuffer();
	}

	public StringBuffer getContenu() {
		return contenu;
	}

	public void delete(int indiceDebut, int indiceFin){
		contenu.delete(indiceDebut, indiceFin);
	}

	public void insert(int indiceDebut, int indiceFin, String texte  ){
		contenu.replace(indiceDebut, indiceFin, texte);
		//contenu.insert(indiceDebut, texte);
	}
	
	public String subString(int indiceDebut, int indiceFin)
	{
		int size = contenu.toString().length();
		
		if(/*size >= (indiceFin-indiceDebut) && */size >=indiceDebut && size >=indiceFin)
			return contenu.substring(indiceDebut, indiceFin);
		else
			return null;
	}
}
