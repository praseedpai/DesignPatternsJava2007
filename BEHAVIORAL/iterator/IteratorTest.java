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

class CommandIterator implements Iterator
{
   int position = 0;
   private Command[] arr;

   public CommandIterator( Command [] parr ) {
	this.arr = parr;	
   }

   public boolean hasNext() {
	return position < arr.length ;	
   }

   public Object next() { 
	if ( position >= arr.length ) 
		return null;
 	return arr[position++];
   }

   public void remove() { }

}


public class IteratorTest 
{

   public static void main( String [] args )
   {
	Command [] as = new Command[5];
        as[0] = new ScaleCommand(1.3,1.3 );
        as[1] = new RotateCommand(45);
        as[2] = new MoveCommand(10,10);
        as[3] = new MoveCommand(-10,10);
        as[4] = new ScaleCommand(1,1);

        CommandIterator it = new CommandIterator(as);
        for( ; it.hasNext() ;  ) {
	      Command cmd = (Command)it.next();
              cmd.Execute();
        }

   }

}