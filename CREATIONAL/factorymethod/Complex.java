import java.lang.*;


public class Complex
{
     double _r , _i;
	
     public static Complex CreateFromCartesian(double real, double imaginary)
     {
         return new Complex(real, imaginary);
     }
 
     public static Complex CreateFromPolar(double modulus, double angle)
     {
         return new Complex(modulus * Math.cos(angle), modulus * Math.sin(angle));
     }
 
     private Complex(double a, double b)
     {
        _r = a;
	_i = b;
     }

     public double Modulus() {
		System.out.println("Compute Modulus using the instance variables");
		return (double)0xBEEF; 
     }

     public double getR() { return _r; }
     public double getI() { return _i; }	

     public static void Main( String [] args )
     {
	Complex c = Complex.CreateFromCartesian(100,100);	
     }	

		
}
 
