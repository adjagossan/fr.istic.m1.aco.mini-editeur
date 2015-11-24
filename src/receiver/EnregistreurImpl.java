package receiver;

import java.util.ArrayList;
import java.util.List;

import command.ICommand;

public class EnregistreurImpl implements IEnregistreur {
	private List<ICommand> cmds = null;
	private boolean start = false;
	
	public EnregistreurImpl(){
		cmds = new ArrayList<ICommand>();
	}
	
	public void enregistrer(ICommand cmd) {
		if (isStart()) cmds.add(cmd);
	}

	public void demarrer() {
		this.start = true;
		cmds.clear();
		
	}

	public void arreter() {
		this.start = false;

	}

	public void rejouer() {
		for(ICommand cmd : cmds){
			cmd.execute();
		}
			
	}

	public List<ICommand> getCmds() {
		return cmds;
	}

	public void setCmds(List<ICommand> cmds) {
		this.cmds = cmds;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

}
