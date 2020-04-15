
public class UnaryMinus extends Expr {
    
	
	private Expr _right;
    
	
	public UnaryMinus( Expr right) {
        _right = right;
    }
	
	public double Evaluate() {
        
		return -_right.Evaluate();
    
	}
  
}
