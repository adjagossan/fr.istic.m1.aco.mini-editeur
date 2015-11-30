package receiver;
/**
 * Classe Signal
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public class Signal {
	
	private String keyword;
	private Object o;
	
	/**
	 * Constructeur
	 */
	public Signal(){
	}
	
	/**
	 * Constructeur
	 * @param keyword
	 * @param o
	 */
	public Signal(String keyword, Object o){
		this.keyword = keyword;
		this.o = o;
	}
	
	/**
	 * Getter
	 * @return keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * Setter
	 * @param keyword
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * Getter
	 * @return object
	 */
	public Object getObject() {
		return o;
	}

	/**
	 * Setter
	 * @param o
	 */
	public void setObject(Object o) {
		this.o = o;
	}

	/**
	 * Update
	 * @param signal
	 */
	public void update(Signal signal){
		this.keyword = signal.keyword;
		this.o = signal.o;
	}
}
