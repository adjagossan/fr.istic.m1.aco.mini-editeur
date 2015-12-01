package command;

import client.Editeur;
import invoker.IHM;
import memento.Memento;
import receiver.Buffer;
import receiver.IMoteurEdition;
import receiver.MoteurV3;
/**
 * Originator
 * @author Florent
 *
 */
public class SaisirV3 extends Saisir {

	private IMoteurEdition article;

	public SaisirV3(IMoteurEdition mMoteurEdition, IHM ihm) {
		super(mMoteurEdition, ihm);
	}


	@Override
	public void execute() {
		super.execute();
		enregistrer();
		
	}
	
	public void enregistrer() {
		//System.out.println(">>"+super.getIhm().getInputCharacter());
		//Editeur.getSaisir().set(super.getIhm().getInputCharacter());
		
		//Buffer buffTmp = (Buffer) super.getmMoteurEdition().getBuffer().clone();
		IMoteurEdition moteur = super.getmMoteurEdition().cloner();
		
		Editeur.getSaisir().set(moteur);
		
		
		super.getmMoteurEdition().addMemento(Editeur.getSaisir().storeInMemento());
		
		Editeur.setSaveFiles(Editeur.getSaveFiles()+1);
		Editeur.setCurrentArticle(Editeur.getCurrentArticle()+1);
		
		//System.out.println("current art : "+Editeur.getCurrentArticle());
		//System.out.println("Save Files " + Editeur.getSaveFiles());
		
	}
	
	public void set(IMoteurEdition newArticle) {
		//System.out.println("From Originator: Current Version of Article\n"+newArticle+ "\n");
		this.article = newArticle;
		System.out.println(">buffer : "+newArticle.getBuffer().toString());
		//System.out.println(">selection : "+newArticle.getSelection());
		//System.out.println(">pp : "+newArticle.getPressePapier());
		System.out.println("------------------------");
	}
	
	public Memento storeInMemento() {
		//System.out.println("From Originator: Saving to Memento");
		return new Memento(article);
	}
	
	public IMoteurEdition restoreFromMemento(Memento memento) {
		article = memento.getState();
		//System.out.println("From Originator: Previous Article Saved in Memento\n"+article + "\n");
		return article;
	}
}
