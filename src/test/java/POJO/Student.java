package POJO;

public class Student {

    String name;

    // public field
    public String id;

    // private field
    private double score;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", score=" + score +
                '}';
    }

    //arg-constructor to initialize fields
    public Student(String name, String id, double score)
    {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    // getter method for name
    public String getName()
    {
        return name;
    }

    // getter method for id
    public String getId()
    {
        return id;
    }

    // getter method for score
    public double getScore()
    {
        return score;
    }

}
