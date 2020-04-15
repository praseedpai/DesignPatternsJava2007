
public class UnaryPlus extends Expr {
    
	private Expr _right;
    
	public UnaryPlus( Expr right) {
        _right = right;
    }


	public double Evaluate() {
        return _right.Evaluate();
    }

}


