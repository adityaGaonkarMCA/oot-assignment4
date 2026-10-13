package dcst;

/** Represents a student. The sample records are illustrative, not official statistics. */
public class Student extends Person implements Attendable, Cloneable {
    private int rollNumber;
    private String program;
    private AcademicRecord academicRecord;

    public Student(String name, int age, String department, String institution,
                   int rollNumber, String program, AcademicRecord academicRecord) {
        super(name, age, department, institution);
        this.rollNumber = rollNumber;
        this.program = program;
        this.academicRecord = academicRecord;
        MemberCounter.increment();
    }

    public int getRollNumber() { return rollNumber; }
    public String getProgram() { return program; }
    public AcademicRecord getAcademicRecord() { return academicRecord; }
    public void setAcademicRecord(AcademicRecord record) { this.academicRecord = record; }

    @Override
    public String getRole() { return "Student"; }

    @Override
    public void displayReport() {
        super.displayReport();
        System.out.println("  Roll No: " + rollNumber + " | Program: " + program);
        if (academicRecord != null) {
            System.out.println("  Academic record: " + academicRecord.getSummary());
        }
    }

    @Override
    public void attendActivity(String activityName) {
        System.out.println(getName() + " is attending " + activityName + ".");
    }

    /** Shallow clone: the cloned student shares the same AcademicRecord object. */
    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    /** Deep clone: the AcademicRecord is cloned as well. */
    public Student deepClone() throws CloneNotSupportedException {
        Student copy = (Student) super.clone();
        if (academicRecord != null) copy.academicRecord = academicRecord.clone();
        return copy;
    }
}
