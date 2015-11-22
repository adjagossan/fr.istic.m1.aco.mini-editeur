package util;

public interface ISubject {
	public void register(IObserver o);
	public void unregister(IObserver o);
	public boolean isAttach(Object o);
	public void setValue(Object o);
	public Object getValue();
}
