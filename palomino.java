import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String id;
    private double[] grades = new double[3];
    private double average;
    private String remark;

    public Student(String name, String id, double[] grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
        computeAverage();
        computeRemark();
    }

    private void computeAverage() {
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        average = sum / 3;
    }

    private void computeRemark() {
        if (average >= 90) {
            remark = "Excellent";
        } else if (average >= 80) {
            remark = "Very Good";
        } else if (average >= 70) {
            remark = "Good";
        } else if (average >= 60) {
            remark = "Needs Improvement";
        } else {
            remark = "Fail";
        }
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getAverage() {
        return average;
    }

    public String getRemark() {
        return remark;
    }
}

public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("STUDENT GRADE MANAGEMENT SYSTEM");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        double[] grades = new double[3];
        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Enter grade for subject " + (i + 1) + " (0-100): ");
                double g = sc.nextDouble();
                if (g >= 0 && g <= 100) {
                    grades[i] = g;
                    break;
                } else {
                    System.out.println("Invalid grade. Must be between 0 and 100.");
                }
            }
        }
        sc.nextLine(); // Consume newline
        students.add(new Student(name, id, grades));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-8s %-15s %-10s %-15s%n", "ID", "Name", "Average", "Remark");
        System.out.println("-----------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-8s %-15s %-10.2f %-15s%n", s.getId(), s.getName(), s.getAverage(), s.getRemark());
        }
        System.out.println("-----------------------------------------------------");
    	
	}
}