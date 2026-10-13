package dcst;

public abstract class Activity implements Reportable {
    protected String name;
    protected int year;
    protected String description;

    public Activity(String name, int year, String description) {
        this.name = name;
        this.year = year;
        this.description = description;
    }

    public int getYear() { return year; }
    public abstract String getCategory();

    @Override
    public void displayReport() {
        System.out.println("[" + getCategory() + "] " + name + " | Year: " + year
                + " | " + description);
    }
}
