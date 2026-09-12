package core_java.assigment_problems;

public class TrafficSignalStreakAnalyzer {

    /**
     * Scans through the signal log string and finds the longest continuous streak
     * of consecutive identical signal characters.
     *
     * @param signalLog string representing sequence of signal readings (e.g., "RRGGGYRR")
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Empty signal log.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestColor = currentColor;
                }
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }
        }

        // Final check for trailing streak
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, maxStreak);
    }

    public static void main(String[] args) {
        System.out.println("=== Traffic Signal Streak Analyzer ===\n");

        String log1 = "RRGGGYRR";
        System.out.printf("Input: \"%s\" -> ", log1);
        findLongestStreak(log1);

        String log2 = "RRRRYYGG";
        System.out.printf("Input: \"%s\" -> ", log2);
        findLongestStreak(log2);
    }
}
