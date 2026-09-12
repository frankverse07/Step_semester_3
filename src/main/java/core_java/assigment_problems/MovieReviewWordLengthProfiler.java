package core_java.assigment_problems;

public class MovieReviewWordLengthProfiler {

    /**
     * Splits a review into words and classifies each word by its length:
     * - Short: 1-4 letters
     * - Medium: 5-8 letters
     * - Long: 9+ letters
     *
     * @param review single string input representing a movie review
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split by whitespace
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            // Remove punctuation attached to words for accurate letter counting if any
            String cleanedWord = word.replaceAll("[^a-zA-Z]", "");
            int len = cleanedWord.isEmpty() ? word.length() : cleanedWord.length();

            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n",
                shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        System.out.println("=== Movie Review Word Length Profiler ===\n");

        String review = "This movie was absolutely fantastic and thrilling";
        System.out.printf("Input: \"%s\"%n", review);
        System.out.print("Output: ");
        classifyWordLengths(review);
    }
}
