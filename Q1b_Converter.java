package COAAssignment2;

import java.util.Random;

public class Q1b_Converter {
    public static void main(String[] args) {
        Random rand = new Random();
        int numTests = 30;

        System.out.println("S/No.\tDecimal Number\tBinary Number\tRemarks");
        System.out.println("------------------------------------------------");

        for (int i = 1; i <= numTests; i++) {
            // Generate random float between 0 and 100 with up to 3 decimal places
            double decimal = Math.round(rand.nextDouble() * 1000.0) / 10.0;
            String binary = convertToBinary(decimal);
            String remark = isExact(decimal) ? "Exactly" : "Approximate";

            System.out.printf("%d.\t%.2f\t\t%s\t\t%s%n", i, decimal, binary, remark);
        }
    }

    public static String convertToBinary(double decimal) {
        // Separate integer and fractional parts
        long integerPart = (long) decimal;
        double fractionalPart = decimal - integerPart;

        // Convert integer part to binary
        StringBuilder binary = new StringBuilder();
        if (integerPart == 0) {
            binary.append("0");
        } else {
            while (integerPart > 0) {
                binary.insert(0, integerPart % 2);
                integerPart /= 2;
            }
        }

        // Convert fractional part to binary (up to 6 bits for 3 decimal precision)
        if (fractionalPart > 0) {
            binary.append(".");
            double frac = fractionalPart;
            for (int i = 0; i < 6 && frac > 0; i++) {
                frac *= 2;
                int bit = (int) frac;
                binary.append(bit);
                frac -= bit;
            }
        }

        return binary.toString();
    }

    public static boolean isExact(double decimal) {
        // Check if decimal has more than 3 decimal places or is a simple fraction
        double rounded = Math.round(decimal * 1000.0) / 1000.0;
        return decimal == rounded;
    }
}
