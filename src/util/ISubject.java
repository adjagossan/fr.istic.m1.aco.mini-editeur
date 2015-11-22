package util;

public interface ISubject {
	public void register();
	public void unregister();
	public boolean isAttach(Object o);
	public void setValue(Object o);
	public Object getValue();
}
