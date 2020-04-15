/////////////////////////
//
//
//
//

import java.lang.*;
import java.beans.*;
import java.io.*;


/////////////////////////////////////////
//
//  Entry Point...class
//
//
public class Second
{
	public static void main( String [] args ) throws IOException,ClassNotFoundException {
		Simple sm = (Simple)Beans.instantiate(Second.class.getClass().getClassLoader(),"Simple");

		if ( sm == null ) {
			System.out.println("Failed to load the class....");
			return;
		}
		sm.setmessage("Hello world...");
		System.out.println(sm.getmessage());
	}	

}
