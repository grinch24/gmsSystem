import java.util.Scanner;

public class GradeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        String[] studentNames = new String[numStudents];
        int[][] studentGrades = new int[numStudents][];
        double[] studentAverages = new double[numStudents];

        //Collect data for each student

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();
            System.out.print("Enter the number of subjects for " + studentNames[i] + ": ");
            int numSubjects = scanner.nextInt();
            studentGrades[i] = new int[numSubjects];
            int sum = 0;

            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter grade for subject " + (j + 1) + ": ");
                studentGrades[i][j] = scanner.nextInt();
                sum += studentGrades[i][j];
            }

            scanner.nextLine();
            studentAverages[i] = (double) sum / numSubjects;
            System.out.println();
        }

        // Calculate and display average grade for each student

        System.out.println("Average grades for each student:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(studentNames[i] + ": " + studentAverages[i]);
        }

        //Find and display the student with the highest average

        double highestAverage = studentAverages[0];
        String topStudent = studentNames[0];
        for (int i = 0; i < numStudents; i++) {
            if (studentAverages[i] > highestAverage) {
                highestAverage = studentAverages[i];
                topStudent = studentNames[i];
            }
        }
        System.out.println("\nStudent with the highest average " + topStudent + " (" + highestAverage + ")");

        //Display all grades for any student (by entering their name)

        System.out.println("\nEnter the name of the student to view all grades: ");
        String nameToFind = scanner.nextLine();
        boolean studentFound = false;

        for (int i = 0; i < numStudents; i++) {
            if (studentNames[i].equalsIgnoreCase(nameToFind)) {
                studentFound = true;
                System.out.println("Grades for " + studentNames[i] + ":");
                for (int grade : studentGrades[i]) {
                    System.out.print(grade + " ");
                }
                System.out.println();
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Student not found.");
        }
        scanner.close();
    }
}