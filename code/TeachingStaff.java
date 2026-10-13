package dcst;

public class TeachingStaff extends Staff {
    private String specialization;

    public TeachingStaff(String name, int age, String department, String institution,
                         String staffId, String designation, String specialization) {
        super(name, age, department, institution, staffId, designation);
        this.specialization = specialization;
    }

    @Override
    public String getRole() { return "Teaching Staff"; }

    @Override
    public void displayReport() {
        super.displayReport();
        System.out.println("  Specialization: " + specialization);
    }
}
