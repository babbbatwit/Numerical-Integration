package NumeralIntegration;
import java.util.Scanner;

public class NumeralIntegration {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("Please input the lower limit of the integral(a): ");
		double lowerLimit = myScanner.nextInt();
		
		System.out.print("Please input the upper limit of the integral(b): ");
		double upperLimit = myScanner.nextInt();
		
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
		
		double deltaX = (upperLimit - lowerLimit) / subintervals;
		
		double actualUpper = (A * Math.pow(upperLimit, 6))/ 6 + (B * Math.pow(upperLimit, 5))/ 5
				+ (C * Math.pow(upperLimit, 4))/ 4 + (D * Math.pow(upperLimit, 3))/ 3 
				+ (E * Math.pow(upperLimit, 2))/ 2 + F * upperLimit;
		
		double actualLower = (A * Math.pow(lowerLimit, 6))/ 6 + (B * Math.pow(lowerLimit, 5))/ 5
				+ (C * Math.pow(lowerLimit, 4))/ 4 + (D * Math.pow(lowerLimit, 3))/ 3 
				+ (E * Math.pow(lowerLimit, 2))/ 2 + F * lowerLimit;
		
		double actualFinal = actualUpper - actualLower;
		
		double midpointSum = 0;
		double currentX = deltaX/2 + lowerLimit;
		
		//midpoint for loop
		for(int i = 0; i < subintervals; i++) {
			
			midpointSum += A * Math.pow(currentX, 5) * deltaX + B * Math.pow(currentX, 4) * deltaX 
					+ C * Math.pow(currentX, 3)  * deltaX +  D * Math.pow(currentX, 2) * deltaX 
					+ E * currentX * deltaX + F * deltaX;
			
			currentX += deltaX;
			
		}
		
		double previousValue = 0;
		double currentValue = 0;
		double trapizoidSum = 0;
		currentX = lowerLimit;
		for(int i = 0; i <= subintervals; i++) {
			//System.out.println(currentX);
			if(i == 0) {
				previousValue = A * Math.pow(currentX, 5) + B * Math.pow(currentX, 4)
						+ C * Math.pow(currentX, 3) +  D * Math.pow(currentX, 2)  
						+ E * currentX + F;
				currentX += deltaX;
			}
			else {
				currentValue = A * Math.pow(currentX, 5) + B * Math.pow(currentX, 4)
						+ C * Math.pow(currentX, 3) +  D * Math.pow(currentX, 2) 
						+ E * currentX + F;
				trapizoidSum += ((currentValue + previousValue) / 2) * deltaX;
				previousValue = currentValue;
				currentX += deltaX;
			}
		}
		
		double simpsons = (2 * midpointSum + trapizoidSum)/3;
		
		double midpointAbsError = Math.abs(actualFinal - midpointSum);
		double midpointPercentError = Math.abs((midpointAbsError / actualFinal) * 100);
		
		double trapizoidAbsError = Math.abs(actualFinal - trapizoidSum);
		double trapizoidPercentError = (trapizoidAbsError / actualFinal) * 100;
		
		double simpsonAbsError = Math.abs(actualFinal - simpsons);
		double simpsonPercentError = (simpsonAbsError / actualFinal) * 100;
		

		
		System.out.println("Exact value of the integral: " + actualFinal);
		
		System.out.println("Midpoint rule approximation: " + midpointSum);
		System.out.println("Midpoint rule percent error: " + midpointPercentError + "%");
		
		System.out.println("Trapezoidal rule approximation: " + trapizoidSum);
		System.out.println("Trapezoidal rule percent error: " + trapizoidPercentError + "%");
		
		System.out.println("Simpson's rule approximation: " + simpsons);
		System.out.println("Simpson's rule percent error: " + simpsonPercentError + "%");
	}
}
