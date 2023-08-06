package kaplan1;

public class ClassRoomNew {

    private String name;
    private String teacher;
    private int students;
    private double latitude;
    private double longitude;


    ClassRoomNew(String Name, String Teacher, int Students, double Latitude, double Longitude)
    {
        this.name = Name;
        this.teacher = Teacher;
        this.students = Students;
        this.latitude = Latitude;
        this.longitude = Longitude;
    }
    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getStudents() {
        return students;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }




}
