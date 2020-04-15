//////////////////////
//
// TemplateMethod.cs
//  
// Written by Praseed Pai K.t.
//            http://praseedp.blogspot.com
//
//
// gmcs TemplateMethod.cs -r:System.dll
// mono TemplateMethod.exe
//

import java.lang.*;

////////////////////////////////
//
// Declare a Logger class ...with one abstract method
// DoLog
// 
// DoLog is our template method...
//
abstract class Logger {

      /////////////////////////////
      //
      // Concrete classes will override this 
      protected abstract boolean DoLog( String logitem );

      ///////////////////////////////////////////
      //
      // public API  
      public boolean Log( String app , String key , String cause ) {
             return DoLog( app + " " + key + " " + cause );
      }

}

//////////////////////////////////////
//
// DbLogger will log to the Database...!
//
// This will override the template method !

class DbLogger extends Logger
{
    protected boolean DoLog( String logitem ) {
           // Log into the DB
           System.out.println( "DB Log " + logitem );  
           return true;
    }


}
//////////////////////////////////////////////
// FileLogger will log into the Disk File...
//
//  
//
class FileLogger extends Logger
{
    protected boolean DoLog( String logitem ) {
           // Log into the File
           System.out.println( "File Log " + logitem );
           return true;   
    }


}
/////////////////////////////
//
// NullLogger is a NOP logger....
//
class NullLogger extends Logger
{
    protected boolean DoLog( String logitem ) {
           // Log into the File
           System.out.println( "Ignoring the log...!" );
           return true;   
    }


}

//////////////////////////////////////////
//
// Create a Factory method to instantiate the Logger....!
//
// LoggerFactory can be singleton...
//
class LoggerFactory {
     public static Logger CreateLogger( String loggertype ) {

               if ( loggertype == "DB" )
                      return new DbLogger();
               else if ( loggertype == "FILE" )
                      return new FileLogger();
               else
                      return new NullLogger();
                
     }

}

//////////////////////////////////////////////
//
// EntryPoint ...!
//
//
public class TemplateMethod
{
   public static void main( String[] s ) {
     Logger l = LoggerFactory.CreateLogger("FILE");
     l.Log("MyApp" , "SEVERITY" ,"NOTHIN SERIOUS");
     l = LoggerFactory.CreateLogger("DB");
     l.Log("MyApp" , "SEVERITY TO DB " ,"NOTHIN SERIOUS");

          
   }


}

