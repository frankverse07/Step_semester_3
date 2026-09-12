package string.class_problems;

public class VowelAndConsonantCounter {

    /**
     * Counts vowels and consonants in a string (case-insensitive), ignoring spaces.
     *
     * @param text input string containing letters and spaces
     */
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Convert to lowercase for case-insensitive check
            char lower = Character.toLowerCase(ch);

            if (lower >= 'a' && lower <= 'z') {
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.printf("Vowels: %d | Consonants: %d%n", vowels, consonants);
    }

    public static void main(String[] args) {
        System.out.println("=== Vowel & Consonant Counter ===\n");

        String title = "Java Programming";
        System.out.printf("Input: \"%s\"%n", title);
        System.out.print("Output: ");
        countVowelsAndConsonants(title);
    }
}