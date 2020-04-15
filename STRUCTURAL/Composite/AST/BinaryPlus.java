
public class BinaryPlus extends Expr {
    
	Expr _left;
    
	Expr _right;

    
	public BinaryPlus( Expr pleft , Expr pright)
    {
 
	      _left = pleft;
       _right = pright;

	 }

 
         public  double Evaluate() {
       
		 return _left.Evaluate() + _right.Evaluate();
    
	}

}

