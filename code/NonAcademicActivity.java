package dcst;

public class NonAcademicActivity extends Activity {
    public NonAcademicActivity(String name, int year, String description) {
        super(name, year, description);
    }

    @Override
    public String getCategory() { return "Non-Academic"; }
}
