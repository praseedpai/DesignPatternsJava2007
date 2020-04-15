import java.lang.*;
import java.util.*;

interface Command
{
	public boolean Execute();

}

abstract class BaseCommand implements Command
{
        public boolean Execute() {
		return false;
	}

}


class MoveCommand extends BaseCommand
{
	public MoveCommand( int dx , int dy ) {} 
	public boolean Execute() {
		System.out.println("MOVE ... ");
		return true;
	}

}

class RotateCommand extends BaseCommand
{

	public RotateCommand( double angle ) {} 
	public boolean Execute() {
		System.out.println("Rotate ");
		return true;
	}

}

class ScaleCommand extends BaseCommand
{

	public ScaleCommand( double sx , double sy ) {} 
	public boolean Execute() {
		System.out.println("Scale ");
		return true;
	}

}

class GraphicsDB
{
     	public ArrayList<Command> cmds = new ArrayList<Command>();
        public GraphicsDB() { SavePoint(); }
	public boolean SavePoint() { 
		//Save the State of DB 
		cmds.clear();
		return true;
	}

	public boolean RestorePoint() { 
		//Restore to  the last SavePoint DB
		return true; 
	}

	public boolean SendCommand( Command cmd ) {
		cmds.add(cmd);
		cmd.Execute();
		return true;
	} 

	public boolean UndoLastChange() {
		int size = cmds.size();
		RestorePoint();
		for(Command c : cmds )
		{
			c.Execute();
		}
		return true;
	} 
}


public class CommandTest 
{
	public static void main( String [] args ) {
		System.out.println("Command Test...");
	}

}