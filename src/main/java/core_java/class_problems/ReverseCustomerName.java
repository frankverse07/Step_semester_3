package core_java.class_problems;

public class ReverseCustomerName {

    /**
     * Reverses the given customer name and returns it as a new string,
     * ensuring the original customer name remains unmodified.
     *
     * @param customerName original customer name
     * @return reversed customer name
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] chars = customerName.toCharArray();
        char[] reversed = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }

        return new String(reversed);
    }

    public static void main(String[] args) {
        System.out.println("=== Customer Identity Verification System ===\n");

        String customerName = "Sunil";
        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }
}
