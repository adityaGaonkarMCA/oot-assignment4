package dcst;

public class Course {
    private String code;
    private String name;
    private int credits;

    public Course(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return code + " - " + name + " (" + credits + " credits)";
    }
}
