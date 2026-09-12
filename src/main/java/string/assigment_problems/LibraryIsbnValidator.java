package string.assigment_problems;

public class LibraryIsbnValidator {

    /**
     * Normalizes the raw ISBN code: trims leading/trailing spaces,
     * uppercases the first 3 characters (publisher code), and leaves the rest untouched.
     *
     * @param raw raw ISBN code string
     * @return normalized code string
     */
    public static String normalizeCode(String raw) {
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
     * Validates normalized 13-character code (3 letters + 10 digits) using Character methods,
     * and formats into "[PUBCODE] YEAR: 20XX | CATALOG: 123456".
     *
     * @param code normalized ISBN code string
     * @return formatted line or error reason
     */
    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length (must be exactly 13 characters)";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: year and catalog body must be 10 digits";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ");
        sb.append("YEAR: ").append(year);
        sb.append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void processAndDisplay(String raw) {
        String normalized = normalizeCode(raw);
        String result = validateAndFormat(normalized);
        System.out.printf("Input: \"%s\"%nOutput: %s%n%n", raw, result);
    }

    public static void main(String[] args) {
        System.out.println("=== Library ISBN Normalizer & Validator ===\n");

        processAndDisplay(" pen2026004251 ");
        processAndDisplay("12N2026004251");
    }
}