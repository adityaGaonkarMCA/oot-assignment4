package dcst;

public class NonTeachingStaff extends Staff {
    private String office;

    public NonTeachingStaff(String name, int age, String department, String institution,
                            String staffId, String designation, String office) {
        super(name, age, department, institution, staffId, designation);
        this.office = office;
    }

    @Override
    public String getRole() { return "Non-Teaching Staff"; }

    @Override
    public void displayReport() {
        super.displayReport();
        System.out.println("  Office/Section: " + office);
    }
}
