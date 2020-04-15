
/////////////////////////
//
//
//
//

import java.lang.*;
import java.beans.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static java.lang.System.out;



/////////////////////////////////////////
//
//  Entry Point...class
//
//
public class Third
{
	public static void main( String [] args ) throws IOException,ClassNotFoundException,
						InstantiationException,Exception {
		Class c = (Class)Class.forName("Simple");

		if ( c == null ) {
			System.out.println("Failed to load the class....");
			return;
		}
		Constructor[] ctors = c.getDeclaredConstructors();
		Constructor ctor = null;
		for (int i = 0; i < ctors.length; i++) {
	   		 ctor = ctors[i];
	    		if (ctor.getParameterTypes().length == 0)
					break;
		}
		Simple s = (Simple)ctor.newInstance();

		
		s.setmessage("Hello world...");
		System.out.println(s.getmessage());
	}	

}
