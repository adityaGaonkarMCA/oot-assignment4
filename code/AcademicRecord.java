package dcst;

/** Mutable object used to demonstrate shallow and deep cloning. */
public class AcademicRecord implements Cloneable {
    private double percentage;
    private String remark;

    public AcademicRecord(double percentage, String remark) {
        this.percentage = percentage;
        this.remark = remark;
    }

    public double getPercentage() { return percentage; }
    public void setPercentage(double percentage) { this.percentage = percentage; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public String getSummary() {
        return String.format("%.1f%% (%s)", percentage, remark);
    }

    @Override
    public AcademicRecord clone() throws CloneNotSupportedException {
        return (AcademicRecord) super.clone();
    }
}
