package command;

import client.Editeur;
import memento.Memento;
import receiver.IMoteurEdition;

public class CollerV3 extends Coller {
	private IMoteurEdition article;

	/**
	 * Constructeur
	 * @param moteurEdition : moteur
	 */
	public CollerV3(IMoteurEdition moteurEdition){
		super(moteurEdition);
	}

	@Override
	public void execute() {
		super.execute();
		enregistrer();

	}
	
	public void enregistrer() {
		// System.out.println(">>"+super.getIhm().getInputCharacter());
		// Editeur.getSaisir().set(super.getIhm().getInputCharacter());

		// Buffer buffTmp = (Buffer)
		// super.getmMoteurEdition().getBuffer().clone();
		IMoteurEdition moteur = super.getMoteurEdition().cloner();

		Editeur.getSaisir().set(moteur);

		super.getMoteurEdition().addMemento(Editeur.getSaisir().storeInMemento());

		Editeur.setSaveFiles(Editeur.getSaveFiles() + 1);
		Editeur.setCurrentArticle(Editeur.getCurrentArticle() + 1);

		// System.out.println("current art : "+Editeur.getCurrentArticle());
		// System.out.println("Save Files " + Editeur.getSaveFiles());

	}


	/**
	 * Getter
	 * @return moteurEdition
	 */
	public IMoteurEdition getMoteurEdition() {
		return article;
	}

	/**
	 * Setter
	 * @param moteurEdition : moteurEdition
	 */
	public void setMoteurEdition(IMoteurEdition moteurEdition) {
		this.article = moteurEdition;
	}

	public void set(IMoteurEdition newArticle) {
		// System.out.println("From Originator: Current Version of
		// Article\n"+newArticle+ "\n");
		this.article = newArticle;
		System.out.println(">buffer : " + newArticle.getBuffer().toString());
		System.out.println(">selection : " + newArticle.getSelection());
		System.out.println(">pp : " + newArticle.getPressePapier());
		System.out.println("------------------------");
	}

	public Memento storeInMemento() {
		// System.out.println("From Originator: Saving to Memento");
		return new Memento(article);
	}

	public IMoteurEdition restoreFromMemento(Memento memento) {
		article = memento.getState();
		// System.out.println("From Originator: Previous Article Saved in
		// Memento\n"+article + "\n");
		return article;
	}

}
