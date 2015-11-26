package receiver;

public class Signal {
	
	private String keyword;
	private Object o;
	
	public Signal(){
	}
	
	public Signal(String keyword, Object o){
		this.keyword = keyword;
		this.o = o;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	public Object getObject() {
		return o;
	}

	public void setObject(Object o) {
		this.o = o;
	}

	public void update(Signal signal){
		this.keyword = signal.keyword;
		this.o = signal.o;
	}
}
