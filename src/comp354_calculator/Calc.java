/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp354_calculator;


/** SUBJECT TO CHANGE */
public class Calc {
    private static final double PI = 3.14159265359;
    private static final int DECIMAL_PLACE_NUMBER = 6;
    private static final double SINH_ACCURACY = 0.0000000001;
    
    public static double exp (double arg1, double arg2) {
        return 0.0;
    } 
    
    // Input must be in Radians (rad)
    public static double sin (double numInRad) {
    	
    	// convert x to the period from 0 to 360 degrees (0 to 2 * PI rad)
    	numInRad = numInRad % (2 * PI);
    	double sum = numInRad;
    	double step = numInRad;
    	
    	// Compute until the value of step is smaller than 9 decimal places
    	int k = 2;
    	double accuracy = 0.0000000001;
    	while(Double.compare(step >= 0 ? step : step * (-1), accuracy) > 0) {
    		step = (-1) * step * numInRad * numInRad/(k * (k + 1));
    		sum += step;
    		k += 2;
    	}
    	
    	// Round result to 6 decimal places
        return CalcHelper.roundDouble(sum, 6);
    }

    public static double sinh (double num, boolean isNumDegree) {

        // Convert to Radian if inout is in Degrees
        if(isNumDegree) {
            num = num * PI / 180;
        }

        double sum = num;
        double step = num;

        int k = 2;

        while (Double.compare(step >= 0 ? step : step * (-1), SINH_ACCURACY) > 0){
            step = step * num * num/(k * (k + 1));
            sum += step;
            k += 2;
        }

        return CalcHelper.roundDouble(sum, DECIMAL_PLACE_NUMBER);
    }
    
    public static double naturalExp () {
        return 0.0;
    }
    
    public static double decimalExp (double power) {
        return exp(10, power);
    }
    
    public static double sqrt(double arg) {
        /* Calculates the square root of a number using the Babylonian method */
        if(arg < 0) {
            throw new IllegalArgumentException("Cannot calculate negative square roots.");
        } else if (arg == 0) {
            return 0;
        }
        double guess = 0.0;
        double res = 1.0;
        /* res and arg/res are overestimates and underestimates (or vice versa) for the root of arg
        The closer the estimates are, the better the next guess will be.
        We loop this algorithm until we converge to the true root
        (or when the difference between the guess and result is lower than a certain amount) */
        while(res != guess) {
            guess = res;
            res = (res + arg / res) / 2;
        }
        
        return res;
    }
}


