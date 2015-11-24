package receiver;

public class Signal {
	
	private String keyword;
	private String text;
	private Selection selection;
	
	public Signal(){
	}
	
	public Signal(String keyword, String text, Selection selection){
		this.keyword = keyword;
		this.text = text;
		this.selection = selection;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Selection getSelection() {
		return selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}
	
	public void update(Signal signal){
		this.keyword = signal.keyword;
		this.text = signal.text;
		this.selection = signal.selection;
	}
}
