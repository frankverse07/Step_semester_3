package string.class_problems;

public class CsvStudentRecordParser {

    /**
     * Parses a CSV line in the form "Name,RollNumber,Department".
     * Validates exactly 3 fields and prints the formatted record.
     *
     * @param csvLine CSV string representing student registration record
     */
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        if (name.isEmpty() || rollNo.isEmpty() || dept.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", name, rollNo, dept);
    }

    public static void main(String[] args) {
        System.out.println("=== CSV Student Record Parser ===\n");

        System.out.println("Test Case 1:");
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");

        System.out.println("\nTest Case 2:");
        parseStudentRecord("Ananya Verma,CSE");
    }
}