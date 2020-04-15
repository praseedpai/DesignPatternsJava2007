import java.lang.*;

public class Caller
{
     	private static SingleInstance CreateSingleInstance() 
	{
		return SingleInstance.GetInstance();
	}

	public static void main( String [] args ) 
	{
		SingleInstance st = Caller.CreateSingleInstance();
		st.Bump();
		SingleInstance mt = Caller.CreateSingleInstance();
		mt.Bump();

		if ( st.GetCount() == mt.GetCount() )
			System.out.println("SingleTon object...");
		else
			System.out.println("Not a Singleton Object..");
	} 


}