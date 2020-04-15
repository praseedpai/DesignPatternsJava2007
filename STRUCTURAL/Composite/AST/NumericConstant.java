import java.lang.*;


public class NumericConstant extends Expr {
    
	private double _value;
    
	///

	///
  
	public NumericConstant(double value) {
        _value = value;
    }
 
	///
    
	///
    
	public  double Evaluate() {
        return _value;
    }

}

