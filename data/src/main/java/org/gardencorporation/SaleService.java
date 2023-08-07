package org.gardencorporation;

/**
 *
 * @author feliperego
 */
public class SaleService {

    private static double valueToDiscount = 0.25;
    private static double maxValueDiscounted = 4;

    public static double getDiscountedValue(double amount, int points) {
        for (int i = 1; i <= points; i++) {
            if (amount == maxValueDiscounted) {
                break;
            }
            amount = amount - valueToDiscount;
        }

        return amount;
    }

    public static int pointsCalculation(double value) {
        int pts = 0;
        boolean b = true;
        if (value > 10) {
            while (b) {
                value = value - 10;
                if (value > 0 || value == 0) {
                    ++pts;
                } else {
                    b = false;
                }
            }
        }
        return pts;
    }

}
