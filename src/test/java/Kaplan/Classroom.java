package Kaplan;

public class Classroom {


    private String name;
    private String teacher;
    private int students;
    private double latitude;
    private double longitude;

    public Classroom(String name, String teacher, int students, double latitude, double longitude) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
        this.latitude = latitude;
        this.longitude = longitude;
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
