package invoker;

import java.util.HashMap;

import receiver.IMoteurEdition;
import receiver.MoteurEditionImpl;
import receiver.Selection;
import receiver.Signal;
import util.IObserver;
import util.ISubject;

import command.ICommand;
/**
 *  invoker for the Command design pattern
 * 
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */

public class IHM implements IObserver {
	
	private Selection selection;
	private String inputCharacter;
	private String pressePapier;
	private HashMap<String, ICommand> cmds = null;
	/**
	 * constructs the invoker IHM with an empty HashMap<String, ICommand>
	 */
	public IHM(){
		selection = new Selection(0,0);
		inputCharacter = "";
		pressePapier = "";
		cmds = new HashMap<>();
		
	}
	/**
	 * returns the property selection of this object
	 * @return non-null Selection reference
	 */
	public Selection getSelection(){
		return selection;
	}
	/**
	 * set the property selection of this object 
	 * @param deb the begining index
	 * @param fin the ending index
	 */
	public void setSelection(int deb, int fin){
		selection.setSelection(deb, fin);
	}
	
	/**
	 * Getter
	 * @return le caractère entré
	 */
	public String getInputCharacter() {
		return inputCharacter;
	}

	/**
	 * Setter
	 * @param inputCharacter
	 */
	public void setInputCharacter(String inputCharacter) {
		this.inputCharacter = inputCharacter;
	}
	
	/**
	 * Ajoute une commande à la hashmap
	 * @param keyword
	 * @param cmd
	 */
	public void addCommand(String keyword, ICommand cmd) {
        if ((keyword == null) || (cmd == null)) {
            throw new IllegalArgumentException("null parameter");
        }
        cmds.put(keyword,cmd);
    }
	
	/**
	 * Execute une commande
	 * @param cmd
	 */
	public void invoke(String cmd){
		if (cmds.containsKey(cmd))
			cmds.get(cmd).execute();
		else
			throw new IllegalArgumentException(cmd+" isn't a valid command");
	}
	
	@Override
	public void update(ISubject subject) {
		
		IMoteurEdition moteurEdition = (MoteurEditionImpl)subject;
		Signal signal = (Signal) moteurEdition.getValue();
		String keyWord = signal.getKeyword();
		
		if(keyWord.equalsIgnoreCase("copier"))
				this.pressePapier = (String) signal.getObject();		
		//if(keyWord.equalsIgnoreCase("coller"))
		//		this.pressePapier = (String) signal.getObject();
	}
	
	/**
	 * Getter
	 * @return presse papier
	 */
	public String getPressePapier() {
		return pressePapier;
	}
	
	/**
	 * Setter
	 * @param pressePapier
	 */
	public void setPressePapier(String pressePapier) {
		this.pressePapier = pressePapier;
	}
}
