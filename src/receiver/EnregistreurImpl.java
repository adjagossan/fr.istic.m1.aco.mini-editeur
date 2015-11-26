package receiver;

import java.util.ArrayList;
import java.util.List;

import util.IMemento;

import command.ICommand;

public class EnregistreurImpl implements IEnregistreur {
	private List<ICommand> cmds = null;
	private boolean start = false;
	private List<IMemento> mementos = null; // todo : changer IMemento par une new class prenant un couple (cmd, mememto)

	public EnregistreurImpl(){
		cmds = new ArrayList<ICommand>();
		mementos = new ArrayList<IMemento>();
	}

	public void enregistrer(ICommand cmd) {
		if (isStart()) cmds.add(cmd);
	}

	public void enregistrer(IMemento memento) {
		if (isStart()) mementos.add(memento);
	}

	public void demarrer() {
		this.start = true;
		cmds.clear();
		mementos.clear();

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
	
	public void setMementos(List<IMemento> mementos) {
		this.mementos = mementos;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

}
