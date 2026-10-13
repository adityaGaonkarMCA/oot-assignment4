package dcst;

/** Shared parent for teaching and non-teaching staff. */
public abstract class Staff extends Person {
    private String staffId;
    private String designation;

    protected Staff(String name, int age, String department, String institution,
                    String staffId, String designation) {
        super(name, age, department, institution);
        this.staffId = staffId;
        this.designation = designation;
        MemberCounter.increment();
    }

    public String getStaffId() { return staffId; }
    public String getDesignation() { return designation; }

    @Override
    public void displayReport() {
        super.displayReport();
        System.out.println("  Staff ID: " + staffId + " | Designation: " + designation);
    }
}
