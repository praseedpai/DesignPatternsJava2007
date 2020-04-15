
    public class ExpressionBuilder
    {
        public String _expr_string;
        public ExpressionBuilder(String expr)
        {
            _expr_string = expr;


        }
        /// <summary>
        ///    
        /// </summary>
        /// <returns></returns>
        public Expr GetExpression()
        {
            try
            {
                RDParser p = new RDParser(_expr_string);
                return p.CallExpr();
            }
            catch (Exception e)
            {

                return null;
            }
        }



    }
