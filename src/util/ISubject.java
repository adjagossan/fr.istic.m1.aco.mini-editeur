package util;

/**
 * Interface ISubject
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public interface ISubject {
	
	/**
	 * Enregistre l'observer dans la liste des observers
	 * @param o : un observer
	 */
	public void register(IObserver o);
	
	/**
	 * Supprime l'oberser de la liste des observers
	 * @param o : un observer
	 */
	public void unregister(IObserver o);
	
	/**
	 * @param o : un objet
	 * @return true si l'objet est dans la liste des observers, sinon false
	 */
	public boolean isAttach(Object o);
	
	/**
	 * Notifie les observers et mise à jour
	 * @param o : objet
	 */
	public void setValue(Object o);
	
	/**
	 * @return un signal (comportant le mot clé de la commande
	 * ainsi qu'un texte ou le contenu du presse papier en fonction de la commande executée)
	 */
	public Object getValue();
}
