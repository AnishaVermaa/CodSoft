import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Define the number of subjects and initialize variables
            int numSubjects;
            int totalMarks = 0;
            double averagePercentage;

            System.out.print("Enter the number of subjects: ");
            numSubjects = sc.nextInt();

            if (numSubjects <= 0) {
                System.out.println("Please enter a valid number of subjects.");
                return;
            }

            // Input marks for each subject and calculate total marks
            for (int i = 1; i <= numSubjects; i++) {
                System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
                int marks = sc.nextInt();

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks. Marks should be between 0 and 100.");
                    return;
                }

                totalMarks += marks;
            }

            // Calculate average percentage
            averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

            // Assign grades based on the average percentage
            String grade;
            if (averagePercentage >= 90) {
                grade = "A+";
            } else if (averagePercentage >= 80) {
                grade = "A";
            } else if (averagePercentage >= 70) {
                grade = "B";
            } else if (averagePercentage >= 60) {
                grade = "C";
            } else if (averagePercentage >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            // Display results
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage + "%");
            System.out.println("Grade: " + grade);

            sc.close();
        }
    }
}
