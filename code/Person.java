package dcst;

/** Abstract base class for people in the sample institution system. */
public abstract class Person implements Reportable {
    private String name;
    private int age;
    protected String department;
    public String institution;

    protected Person(String name, int age, String department, String institution) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.institution = institution;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public abstract String getRole();

    @Override
    public void displayReport() {
        System.out.println(getRole() + ": " + name + " | Age: " + age
                + " | Department: " + department + " | Institution: " + institution);
    }
}
