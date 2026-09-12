package core_java.class_problems;

public class FirstNonRepeatingCharacter {

    /**
     * Finds the first non-repeating character in a string.
     * Returns '\0' if no non-repeating character exists.
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Frequency array for ASCII characters
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 256) {
                freq[c]++;
            }
        }

        // Scan left to right for first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 256 && freq[c] == 1) {
                return c;
            }
        }

        return '\0';
    }

    public static void testAndDisplay(String text) {
        char result = findFirstNonRepeatingChar(text);
        System.out.printf("Input: \"%s\"%n", text);
        if (result != '\0') {
            System.out.printf("First Non-Repeating Character: '%c'%n%n", result);
        } else {
            System.out.println("No Non-Repeating Character Found\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Unique Letter Hunt Mini-Game ===\n");
        testAndDisplay("swiss");
        testAndDisplay("aabbcc");
    }
}
