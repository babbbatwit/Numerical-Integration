package NumeralIntegration;
import java.util.Scanner;

public class NumeralIntegration {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("Please input the lower limit of the integral(a): ");
		int lowerLimit = myScanner.nextInt();
		
		System.out.print("Please input the upper limit of the integral(b): ");
		int upperLimit = myScanner.nextInt();
		
		System.out.print("Enter the number of subintervals (n): ");
		int subintervals = myScanner.nextInt();
		
		System.out.println("Enter the coeficients of Ax⁵ + Bx⁴ + Cx³ + Dx² + Ex + F");
		
		System.out.print("A: ");
		double A = myScanner.nextDouble();
		
		System.out.print("B: ");
		double B = myScanner.nextDouble();
		
		System.out.print("C: ");
		double C = myScanner.nextDouble();
		
		System.out.print("D: ");
		double D = myScanner.nextDouble();
		
		System.out.print("E: ");
		double E = myScanner.nextDouble();
		
		System.out.print("F: ");
		double F = myScanner.nextDouble();
	}
}
