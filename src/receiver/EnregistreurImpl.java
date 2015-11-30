package receiver;

import java.util.ArrayList;
import java.util.List;
import util.IMemento;

import command.ICommand;
import command.ICommandEnreg;

public class EnregistreurImpl implements IEnregistreur {
	
	private boolean start = false;
	private List<ICommandEnreg> cmds;
	private List<IMemento> mementos;
	
	public EnregistreurImpl()
	{
		cmds = new ArrayList<ICommandEnreg>();
		mementos = new ArrayList<IMemento>();
	}
	
	@Override
	public void enregistrer(ICommandEnreg cmdEnreg)
	{
		if (isStart())
		{
			cmds.add(cmdEnreg);
			mementos.add(cmdEnreg.getMemento());
		}
	}

	public void demarrer()
	{
		this.start = true;
		cmds.clear();
		mementos.clear();
	}

	public void arreter() {
		this.start = false;
	}

	public void rejouer()
	{
		this.arreter();
		if(cmds.size() == mementos.size())
		{
			for(int i=0; i<cmds.size(); i++)
			{
				if(mementos.get(i) != null && cmds.get(i)!= null)
				{
					cmds.get(i).setMemento(mementos.get(i));
					cmds.get(i).execute();
				}
			}
		}

	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}
}
