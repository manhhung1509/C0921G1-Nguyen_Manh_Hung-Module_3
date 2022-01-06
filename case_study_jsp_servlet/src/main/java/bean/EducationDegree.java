package bean;

public class EducationDegree {
  private int EducationDegreeId;
  private String EducationDegreeName;

    public EducationDegree() {
    }

    public EducationDegree(int educationDegreeId) {
        EducationDegreeId = educationDegreeId;
    }

    public EducationDegree(int educationDegreeId, String educationDegreeName) {
        EducationDegreeId = educationDegreeId;
        EducationDegreeName = educationDegreeName;
    }

    public int getEducationDegreeId() {
        return EducationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        EducationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return EducationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        EducationDegreeName = educationDegreeName;
    }

    @Override
    public String toString() {
        return "EducationDegree{" +
                "EducationDegreeId=" + EducationDegreeId +
                ", EducationDegreeName='" + EducationDegreeName + '\'' +
                '}';
    }
}
