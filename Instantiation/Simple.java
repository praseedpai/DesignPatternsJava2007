import java.lang.*;
import java.beans.*;
import java.io.*;

public class Simple
{
	///////////////////////
	//
	// An Instance variable...
	private String message;
	/////////////////////////////////
	//
	//  CTOR
	//
	public Simple(){
	
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
