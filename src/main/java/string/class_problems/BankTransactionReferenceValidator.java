package string.class_problems;

public class BankTransactionReferenceValidator {

    /**
     * Normalizes raw reference string: trims spaces, uppercases the first 3 characters (bank code),
     * and keeps the rest untouched.
     *
     * @param raw raw reference string
     * @return normalized reference string
     */
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates normalized 14-char code (3 letters + 11 digits) using Character methods in a loop,
     * and formats into "[BANKCODE] DATE: dd/MM/yy | SEQ: 12345".
     *
     * @param reference normalized reference string
     * @return formatted string or error message
     */
    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ");
        sb.append("DATE: ").append(day).append("/").append(month).append("/").append(year);
        sb.append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void processAndDisplay(String raw) {
        String normalized = normalizeReference(raw);
        String result = validateAndFormat(normalized);
        System.out.printf("Input: \"%s\"%nOutput: %s%n%n", raw, result);
    }

    public static void main(String[] args) {
        System.out.println("=== Bank Transaction Reference Generator & Validator ===\n");

        processAndDisplay(" hdf03022600042 ");
        processAndDisplay("12F03022600042");
    }
}