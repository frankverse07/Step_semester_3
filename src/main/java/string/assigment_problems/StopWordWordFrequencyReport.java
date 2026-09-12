package string.assigment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StopWordWordFrequencyReport {

    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    private static boolean isStopWord(String word) {
        for (String stop : STOP_WORDS) {
            if (stop.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Normalizes feedback text, filters out stop words, counts frequencies,
     * and prints words sorted by frequency in descending order.
     *
     * @param feedback paragraph of feedback text
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Normalize: convert to lowercase and strip punctuation using replace()
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");

        // Split into words by whitespace
        String[] words = cleaned.trim().split("\\s+");

        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Sort entries by count in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Stop-Word-Filtered Word Frequency Report ===\n");

        String feedback = "The mentor was great, the session was great and clear.";
        System.out.printf("Input: \"%s\"%n%nOutput:%n", feedback);
        printFilteredWordFrequency(feedback);
    }
}