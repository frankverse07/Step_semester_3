package string.class_problems;

public class MaskedPhoneNumberFormatter {

    /**
     * Validates a 10-digit phone number and returns a masked string in the format "XXXXXX-XXXX".
     *
     * @param phone phone number string
     * @return masked phone number or "Invalid phone number"
     */
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validate all characters are digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append("-");
        sb.append(phone.substring(6)); // last 4 digits

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Masked Phone Number Formatter ===\n");

        String phone1 = "9876543210";
        System.out.printf("Input: \"%s\" -> Output: %s%n", phone1, maskPhoneNumber(phone1));

        String phone2 = "98765";
        System.out.printf("Input: \"%s\" -> Output: %s%n", phone2, maskPhoneNumber(phone2));
    }
}