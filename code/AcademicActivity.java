package dcst;

public class AcademicActivity extends Activity {
    public AcademicActivity(String name, int year, String description) {
        super(name, year, description);
    }

    @Override
    public String getCategory() { return "Academic"; }
}
