package core_java.class_problems;

public class PalindromeChecker {

    /**
     * Checks palindrome using iterative two-pointer approach from both ends.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Checks palindrome using recursion by shrinking substring.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        if (text.length() <= 1) return true;

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Checks palindrome by reversing character array and comparing with original.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    private static String formatResult(boolean isPal) {
        return isPal ? "Palindrome" : "Not Palindrome";
    }

    public static void testAndDisplay(String input) {
        boolean iter = isPalindromeIterative(input);
        boolean recur = isPalindromeRecursive(input);
        boolean arrRev = isPalindromeArrayReversal(input);

        System.out.printf("Input: \"%s\"%n", input);
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n%n",
                formatResult(iter), formatResult(recur), formatResult(arrRev));
    }

    public static void main(String[] args) {
        System.out.println("=== Palindrome Checker (3 Approaches) ===\n");
        testAndDisplay("madam");
        testAndDisplay("hello");
    }
}
