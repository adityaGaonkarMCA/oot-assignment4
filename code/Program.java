package dcst;

import java.util.ArrayList;
import java.util.List;

public class Program implements Reportable {
    private String programName;
    private String level;
    private final List<Course> courses;

    public Program(String programName, String level) {
        this.programName = programName;
        this.level = level;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) { courses.add(course); }
    public String getProgramName() { return programName; }

    @Override
    public void displayReport() {
        System.out.println(level + " Program: " + programName);
        if (courses.isEmpty()) System.out.println("  No sample courses added.");
        for (Course c : courses) System.out.println("  - " + c.getName());
    }
}
