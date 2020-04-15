
public class MainTest{

    
    public static void main(String[] args) {
    
	  Expr e = new UnaryMinus(
new BinaryPlus(
 
	                    new NumericConstant(10),
   
		            new NumericConstant(10))

                     );
     
	  double val =  e.Evaluate();
       
	  System.out.println("value is "+val);
 
   }


}
