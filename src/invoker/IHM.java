package invoker;

import receiver.Selection;

public class IHM {
	
	private Selection selection;
	private String inputCharacter;

	public IHM(){
		selection = new Selection(0,0);
		inputCharacter = "";
	}
	
	public Selection getSelction(){
		return selection;
	}
	
	public void setSelction(int deb, int fin){
		selection.setSelection(deb, fin);
	}
	
	public String getInputCharacter() {
		return inputCharacter;
	}

	public void setInputCharacter(String inputCharacter) {
		this.inputCharacter = inputCharacter;
	}
}
