package util;

/**
 * Interface IObserver
 * @author Gossan Adja, Florent Le Boulch, Ammar Barry
 */
public interface IObserver {
	/**
	 * Update
	 * @param subject : subject
	 */
	public void update(ISubject subject);
}
