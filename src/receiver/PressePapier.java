package receiver;

public class PressePapier {
	
	private String contenu;

	private IMoteurEdition moteurEdition;
	
	public PressePapier(){
		//this.contenu = "";
	}

	public IMoteurEdition getMoteurEdition() {
		return moteurEdition;
	}

	public void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}
	
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}
