package COAAssignment2;
public class Q1a_Converter {

    public static void main(String[] args) {
        // Values from the image/table
        int[] decimalValues = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15,
            16, 17, 18, 31, 100, 255, 256
        };

        System.out.printf("%-10s %-20s %-10s%n", "Decimal", "Binary", "Hex");
        System.out.println("----------------------------------------------");

        for (int value : decimalValues) {
            String binary = Integer.toBinaryString(value);
            String hex = Integer.toHexString(value).toUpperCase();

            // Apply padding:
            String paddedBinary = padBinary(binary, value);

            System.out.printf("%-10d %-20s %-10s%n", value, paddedBinary, hex);
        }
    }

    // Method to pad binary strings as per table format
    private static String padBinary(String binary, int value) {
        int length = binary.length();

        if (value <= 15) {
            return String.format("%4s", binary).replace(' ', '0'); // 4-bit padding
        } else if (value <= 255) {
            return String.format("%8s", binary).replace(' ', '0'); // 8-bit padding
        } else {
            return String.format("%12s", binary).replace(' ', '0'); // for 256 or larger
        }
    }
}
