package string.assigment_problems;

public class WordReversalEncoder {

    /**
     * Reverses each word in a sentence while preserving word order.
     *
     * @param sentence string containing words separated by single spaces
     * @return encoded sentence with each word reversed
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reversedWord = new StringBuilder();

            // Reverse using loop
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            result.append(reversedWord);

            // Add space between words
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Word Reversal Encoder ===\n");

        String input = "hello club";
        String output = reverseEachWord(input);

        System.out.printf("Input: \"%s\"%n", input);
        System.out.printf("Output: %s%n", output);
    }
}