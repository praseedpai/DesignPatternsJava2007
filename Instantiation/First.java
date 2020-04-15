/////////////////////////
//
//
//
//
import java.lang.*;

class Simple
{
	///////////////////////
	//
	// An Instance variable...
	private String message;

	/////////////////////////////////
	//
	//  CTOR
	//
	
	public Simple(   ){
	
		message = null;
	}

	/////////////////////////
	// Java uses patterns to simulate properties...!
	//
	public String getmessage() { return message; }
	public void   setmessage(String pmessage) {
		message = pmessage;
	}

}

/////////////////////////////////////////
//
//  Entry Point...class
//
//
public class First
{
	public static void main( String [] args ){
		Simple sm = new Simple();
		sm.setmessage("Hello world...");
		System.out.println(sm.getmessage());
	}	

}
