package dcst;

import java.io.IOException;
import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();
    private static final List<Staff> staff = new ArrayList<>();
    private static final Set<String> subjects = new TreeSet<>();
    private static final Queue<String> pendingTasks = new LinkedList<>();
    private static final Map<Integer, List<Activity>> activitiesByYear = new TreeMap<>();
    private static final List<Program> programs = new ArrayList<>();

    public static void main(String[] args) {
        seedSampleData();
        System.out.println("DCST / GBS Academic Information Management System");
        System.out.println("NOTE: The built-in records are illustrative sample data, not official NIRF data.");

        boolean running = true;
        while (running) {
            showMenu();
            try {
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch (choice) {
                    case 1 -> showStudents();
                    case 2 -> showStaff();
                    case 3 -> showProgramsAndSubjects();
                    case 4 -> showActivities(true);
                    case 5 -> showActivities(false);
                    case 6 -> showYearWiseReport();
                    case 7 -> addStudent();
                    case 8 -> demonstrateReferenceAndCloning();
                    case 9 -> demonstrateOOP();
                    case 10 -> saveReport();
                    case 11 -> loadReport();
                    case 12 -> showCollections();
                    case 13 -> MemberCounter.displayCount();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice. Enter a number from 0 to 13.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input error: please enter a whole number.");
            } catch (CustomException e) {
                System.out.println("Application error: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("File error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error handled: " + e.getMessage());
            } finally {
                System.out.println();
            }
        }
        sc.close();
        System.out.println("Program closed.");
    }

    private static void showMenu() {
        System.out.println("""

                ========== MAIN MENU ==========
                1. Student information
                2. Teaching and non-teaching staff
                3. Programs and sample subjects
                4. Academic activities
                5. Non-academic activities
                6. Three-year report
                7. Add student
                8. Object referencing and cloning
                9. OOP concepts (reflection, generics, overloading, access)
                10. Save report to file
                11. Load report from file
                12. Collection framework demonstration
                13. Display static member count
                0. Exit
                ===============================
                """);
    }

    private static void seedSampleData() {
        students.add(new Student("Aditya Gaonkar", 21, "CST", "Goa University",
                2603, "MCA", new AcademicRecord(78.5, "Sample record")));
        students.add(new Student("Sample Student", 22, "CST", "Goa University",
                2604, "MCA", new AcademicRecord(81.0, "Sample record")));

        staff.add(new TeachingStaff("Sample Faculty", 40, "CST", "Goa University",
                "T001", "Assistant Professor", "Computer Science"));
        staff.add(new NonTeachingStaff("Sample Office Staff", 35, "CST", "Goa University",
                "N001", "Office Assistant", "Department Office"));

        Program mca = new Program("MCA (sample program entry)", "Postgraduate");
        mca.addCourse(new Course("SUB101", "Object-Oriented Concepts (sample)", 4));
        mca.addCourse(new Course("SUB102", "Programming and Problem Solving (sample)", 4));
        programs.add(mca);
        subjects.add("Object-Oriented Concepts (sample)");
        subjects.add("Programming and Problem Solving (sample)");
        subjects.add("Operating Systems (sample)");

        addActivity(new AcademicActivity("ISA", 2024, "Internal assessment (sample entry)"));
        addActivity(new AcademicActivity("Midpoint Examination", 2024, "Assessment (sample entry)"));
        addActivity(new AcademicActivity("SEA", 2025, "Semester-end assessment (sample entry)"));
        addActivity(new AcademicActivity("Study Tour / Industrial Visit", 2025, "Sample entry; verify actual event"));
        addActivity(new AcademicActivity("Placement Drive / Internship", 2026, "Sample entry; verify actual event"));
        addActivity(new AcademicActivity("Guest Lecture / Technical Workshop", 2026, "Sample entry; verify actual event"));
        addActivity(new NonAcademicActivity("InfoFest", 2024, "Sample entry; verify date and details"));
        addActivity(new NonAcademicActivity("Plateaunia", 2025, "Sample entry; verify date and details"));
        addActivity(new NonAcademicActivity("Play-on", 2026, "Sample entry; verify date and details"));
        addActivity(new NonAcademicActivity("Sports / Cultural Programme", 2026, "Additional illustrative entry"));
        pendingTasks.offer("Verify official course list");
        pendingTasks.offer("Verify event dates and participation figures");
    }

    private static void addActivity(Activity activity) {
        activitiesByYear.computeIfAbsent(activity.getYear(), k -> new ArrayList<>()).add(activity);
    }

    private static void showStudents() {
        System.out.println("\\n--- Students (sample records) ---");
        for (Student student : students) ReportService.printReport(student);
    }

    private static void showStaff() {
        System.out.println("\\n--- Staff (sample records) ---");
        for (Staff member : staff) ReportService.printReport(member);
    }

    private static void showProgramsAndSubjects() {
        System.out.println("\\n--- Programs and courses (sample entries; verify officially) ---");
        for (Program program : programs) ReportService.printReport(program);
        System.out.println("Subject Set (unique values): " + subjects);
    }

    private static void showActivities(boolean academic) {
        System.out.println(academic ? "\\n--- Academic activities ---" : "\\n--- Non-academic activities ---");
        for (List<Activity> yearActivities : activitiesByYear.values()) {
            for (Activity activity : yearActivities) {
                if (academic == (activity instanceof AcademicActivity)) activity.displayReport();
            }
        }
    }

    private static void showYearWiseReport() {
        System.out.println("\\n--- Year-wise summary (illustrative sample records) ---");
        for (Map.Entry<Integer, List<Activity>> entry : activitiesByYear.entrySet()) {
            long academic = entry.getValue().stream().filter(a -> a instanceof AcademicActivity).count();
            long nonAcademic = entry.getValue().stream().filter(a -> a instanceof NonAcademicActivity).count();
            System.out.println(entry.getKey() + ": academic activities = " + academic
                    + ", non-academic activities = " + nonAcademic);
            for (Activity activity : entry.getValue()) activity.displayReport();
        }
        System.out.println("Students in sample dataset: " + students.size());
        System.out.println("Staff in sample dataset: " + staff.size());
        System.out.println("These are demonstration figures, not official NIRF statistics.");
    }

    private static void addStudent() throws CustomException {
        System.out.print("Student name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) throw new CustomException("Student name cannot be empty.");
        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Roll number: ");
        int roll = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Program: ");
        String program = sc.nextLine().trim();
        if (age <= 0 || roll <= 0 || program.isEmpty())
            throw new CustomException("Age, roll number and program must be valid.");
        for (Student student : students) {
            if (student.getRollNumber() == roll) throw new CustomException("Roll number already exists.");
        }
        students.add(new Student(name, age, "CST", "Goa University", roll, program,
                new AcademicRecord(0.0, "New sample record")));
        System.out.println("Student added.");
    }

    private static void demonstrateReferenceAndCloning() throws CloneNotSupportedException {
        if (students.isEmpty()) return;
        Student original = students.get(0);
        Student secondReference = original;
        System.out.println("Original name: " + original.getName());
        secondReference.setName("Name changed through second reference");
        System.out.println("Name through original reference: " + original.getName());
        original.setName("Aditya Gaonkar");

        Student shallow = original.clone();
        Student deep = original.deepClone();
        original.getAcademicRecord().setRemark("Changed after cloning");
        System.out.println("Original record: " + original.getAcademicRecord().getSummary());
        System.out.println("Shallow clone record: " + shallow.getAcademicRecord().getSummary());
        System.out.println("Deep clone record: " + deep.getAcademicRecord().getSummary());
        System.out.println("Shallow clone shares nested record; deep clone has a separate record.");
    }

    private static void demonstrateOOP() {
        if (!students.isEmpty()) OOPDemo.run(students.get(0));
        System.out.println("\\n--- Interface / message passing ---");
        for (Student student : students) student.attendActivity("Technical Workshop");
        System.out.println("\\n--- Overriding / runtime polymorphism ---");
        List<Reportable> reportables = new ArrayList<>();
        reportables.addAll(students);
        reportables.addAll(staff);
        for (Reportable item : reportables) item.displayReport();
        System.out.println("\\n--- Multiple interface inheritance ---");
        System.out.println("Student implements Reportable (through Person) and Attendable.");
        System.out.println("Java classes cannot extend two classes, but a class can implement multiple interfaces.");
    }

    private static void saveReport() throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("DCST / GBS report - illustrative sample data");
        lines.add("Students: " + students.size());
        lines.add("Staff: " + staff.size());
        lines.add("Subjects: " + subjects);
        for (Map.Entry<Integer, List<Activity>> entry : activitiesByYear.entrySet()) {
            lines.add("Year " + entry.getKey());
            for (Activity activity : entry.getValue()) {
                lines.add(activity.getCategory() + " | " + activity.name + " | " + activity.description);
            }
        }
        DataManager.saveLines("dcst_report.txt", lines);
        System.out.println("Saved report to dcst_report.txt in the current working directory.");
    }

    private static void loadReport() throws IOException {
        System.out.println("--- Contents of dcst_report.txt ---");
        DataManager.displayFile("dcst_report.txt");
    }

    private static void showCollections() {
        System.out.println("List<Student>: stores student records; count = " + students.size());
        System.out.println("Set<String>: unique subjects = " + subjects);
        System.out.println("Queue<String>: pending tasks = " + pendingTasks);
        System.out.println("Map<Integer, List<Activity>>: year keys = " + activitiesByYear.keySet());
        GenericBox<Integer> box = new GenericBox<>(students.size());
        System.out.println("Generic function result: " + describe(box.getValue()));
    }

    public static <T> String describe(T value) {
        return "Value = " + value + " | Type = " + (value == null ? "null" : value.getClass().getSimpleName());
    }
}
