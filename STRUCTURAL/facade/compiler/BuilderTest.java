
    public class BuilderTest
    {

        public static void main( String [] args ) {
		ExpressionBuilder b = new ExpressionBuilder("-(2*3)+4");
                Expr e = b.GetExpression();
		double t = e.Evaluate();
		System.out.println(t);
	}
       


    }
