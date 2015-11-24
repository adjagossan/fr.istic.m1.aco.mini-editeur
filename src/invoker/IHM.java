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
 *
 */
public class IHM implements IObserver {
	
	private Selection selection;
	private String inputCharacter;
	private HashMap<String, ICommand> cmds = null;
	/**
	 * constructs the invoker IHM with an empty HashMap<String, ICommand>
	 */
	public IHM(){
		selection = new Selection(0,0);
		inputCharacter = "";
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
	public void setSelction(int deb, int fin){
		selection.setSelection(deb, fin);
	}
	
	public String getInputCharacter() {
		return inputCharacter;
	}

	public void setInputCharacter(String inputCharacter) {
		this.inputCharacter = inputCharacter;
	}
	
	public void addCommand(String keyword, ICommand cmd) {
        if ((keyword == null) || (cmd == null)) {
            throw new IllegalArgumentException("null parameter");
        }
        cmds.put(keyword,cmd);
    }
	
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
	}
}
