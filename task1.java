import java.util.*;

class Student {
    private String name;
    private ArrayList<Integer> marks;

    public Student(String name) {
        this.name = name;
        marks = new ArrayList<>();
    }

    public void addMark(int mark) {
        marks.add(mark);
    }

    public double getAverage() {
        if (marks.isEmpty()) return 0;
        int sum = 0;
        for (int mark : marks) sum += mark;
        return (double) sum / marks.size();
    }

    public int getHighest() {
        return marks.isEmpty() ? 0 : Collections.max(marks);
    }

    public int getLowest() {
        return marks.isEmpty() ? 0 : Collections.min(marks);
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("\nStudent: " + name);
        System.out.println("Marks: " + marks);
        System.out.printf("Average: %.2f\n", getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
    }
}

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n====== Student Grade Tracker ======");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    Student student = new Student(name);

                    System.out.print("Enter number of subjects: ");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter marks for subject " + (i + 1) + ": ");
                        int mark = sc.nextInt();
                        student.addMark(mark);
                    }
                    students.add(student);
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student data available!");
                    } else {
                        System.out.println("\n===== Student Summary =====");
                        for (Student s : students) {
                            s.displayDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
