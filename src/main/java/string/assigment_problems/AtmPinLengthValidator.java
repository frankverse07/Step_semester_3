package string.assigment_problems;

public class AtmPinLengthValidator {

    /**
     * Checks if PIN length is exactly 4 characters using length() and if/else.
     *
     * @param pin PIN string entered by customer
     */
    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ATM PIN Length Validator ===\n");

        System.out.print("Input: \"482\" -> ");
        checkPinLength("482");

        System.out.print("Input: \"4820\" -> ");
        checkPinLength("4820");
    }
}