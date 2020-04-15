import java.lang.*;

public class RDParser extends Lexer
    {
        int Current_Token;


        public RDParser(String str)
            
        {
               super(str);

        }

        /// <summary>
        ///      
        /// </summary>
        /// <returns></returns>
        public Expr CallExpr() throws Exception
        {
            Current_Token = GetToken();
            return Expr();
        }

        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public Expr Expr() throws Exception
        {
            int l_token;
            Expr RetValue = Term();
            while (Current_Token == TOKEN.TOK_PLUS || Current_Token == TOKEN.TOK_SUB)
            {
                l_token = Current_Token;
                Current_Token = GetToken();
                Expr e1 = Expr();

                if ( l_token == TOKEN.TOK_PLUS ) 
                	RetValue = new BinaryPlus(RetValue, e1);
                else   
                    RetValue = new BinaryMinus(RetValue, e1);

            }

            return RetValue;

        }
        /// <summary>
        /// 
        /// </summary>
        public Expr Term() throws Exception
        {
            int l_token;
            Expr RetValue = Factor();

            while (Current_Token == TOKEN.TOK_MUL || Current_Token == TOKEN.TOK_DIV)
            {
                l_token = Current_Token;
                Current_Token = GetToken();


                Expr e1 = Term();
                if ( l_token == TOKEN.TOK_MUL ) 
                	RetValue = new BinaryMul(RetValue, e1);
                else   
                    RetValue = new BinaryDiv(RetValue, e1);


            }

            return RetValue;
        }

        /// <summary>
        ///    
        /// </summary>
        public Expr Factor() throws Exception
        {
            int l_token;
            Expr RetValue = null;
            if (Current_Token == TOKEN.TOK_DOUBLE)
            {

                RetValue = new NumericConstant(GetNumber());
                Current_Token = GetToken();

            }
            else if (Current_Token == TOKEN.TOK_OPAREN)
            {

                Current_Token = GetToken();

                RetValue = Expr();  // Recurse

                if (Current_Token != TOKEN.TOK_CPAREN)
                {
                    System.out.println("Missing Closing Parenthesis\n");
                    throw new Exception();

                }
                Current_Token = GetToken();
            }

            else if (Current_Token == TOKEN.TOK_PLUS || Current_Token == TOKEN.TOK_SUB)
            {
                l_token = Current_Token;
                Current_Token = GetToken();
                RetValue = Factor();

                 if ( l_token == TOKEN.TOK_PLUS ) 
                	RetValue = new UnaryPlus(RetValue);
                else   
                    RetValue = new UnaryMinus(RetValue);


               
            }
            else
            {

                System.out.println("Illegal Token");
                throw new Exception();
            }


            return RetValue;

        }





    }
