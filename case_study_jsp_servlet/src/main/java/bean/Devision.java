package bean;

public class Devision {

    private int devisionId;
    private String devisionName;

    public Devision() {
    }

    public Devision(int devisionId) {
        this.devisionId = devisionId;
    }

    public Devision(int devisionId, String devisionName) {
        this.devisionId = devisionId;
        this.devisionName = devisionName;
    }

    public int getDevisionId() {
        return devisionId;
    }

    public void setDevisionId(int devisionId) {
        this.devisionId = devisionId;
    }

    public String getDevisionName() {
        return devisionName;
    }

    public void setDevisionName(String devisionName) {
        this.devisionName = devisionName;
    }

    @Override
    public String toString() {
        return "devision{" +
                "devisionId=" + devisionId +
                ", devisionName='" + devisionName + '\'' +
                '}';
    }
}
