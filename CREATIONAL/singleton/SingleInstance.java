import java.lang.*;

public class SingleInstance
{
	private int i = 0;

	private SingleInstance() { i=0;}

	private static SingleInstance _st = null;

	public int Bump() {
		return ++i;
	}

	public int GetCount() { return i; }

	public static SingleInstance GetInstance() {
		if ( _st == null )
		{
			_st = new SingleInstance();
		}
		return _st;
	}

}