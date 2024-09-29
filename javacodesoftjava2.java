
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int numberOfSubjects = scanner.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.println("Enter marks for subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();
            
            // Validating input
            while (marks < 0 || marks > 100) {
                System.out.println("Invalid input! Please enter marks between 0 and 100.");
                marks = scanner.nextInt();
            }
            
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numberOfSubjects;
        String grade = calculateGrade(averagePercentage);

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}