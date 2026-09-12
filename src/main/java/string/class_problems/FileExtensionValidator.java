package string.class_problems;

public class FileExtensionValidator {

    private static final String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};

    /**
     * Validates if a filename has an accepted extension (pdf, docx, zip) regardless of case.
     *
     * @param filename string containing the filename
     * @return "Accepted" or "Rejected — invalid file type"
     */
    public static String validateFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "Rejected - invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == filename.length() - 1) {
            return "Rejected - invalid file type";
        }

        String extension = filename.substring(lastDotIndex + 1);

        for (String accepted : ACCEPTED_EXTENSIONS) {
            if (accepted.equalsIgnoreCase(extension)) {
                return "Accepted";
            }
        }

        return "Rejected - invalid file type";
    }

    public static void main(String[] args) {
        System.out.println("=== File Extension Validator ===\n");

        String file1 = "Assignment1.PDF";
        System.out.printf("Input: \"%s\" -> Output: %s%n", file1, validateFileExtension(file1));

        String file2 = "notes.txt";
        System.out.printf("Input: \"%s\" -> Output: %s%n", file2, validateFileExtension(file2));
    }
}