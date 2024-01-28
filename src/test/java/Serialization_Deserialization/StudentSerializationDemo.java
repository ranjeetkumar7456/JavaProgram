package Serialization_Deserialization;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentSerializationDemo
{
    public static void main(String[] args)
    {
        // Serialize student data to a file
        serializeStudentData("studentData.txt");

        // Deserialize student data from the file
        Map<String, Student> studentMap = deserializeStudentData("studentData.txt");

        // Display the deserialized student data
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            System.out.println("Roll Number: " + entry.getKey() + ", Student: " + entry.getValue());
        }

        // Modify and serialize the student data again
        Student modifiedStudent = studentMap.get("S123");
        if (modifiedStudent != null) {
            modifiedStudent.setAge(22); // Example: modify the age
            serializeStudentData("studentData.txt");
        }
    }

    private static void serializeStudentData(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            Map<String, Student> studentMap = new HashMap<>();
            BufferedReader reader = new BufferedReader(new FileReader("studentData.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] studentInfo = line.split(",");
                String rollNumber = studentInfo[3].trim(); // Assuming roll number is at index 3

                Student student = new Student(
                        studentInfo[0].trim(), // name
                        Integer.parseInt(studentInfo[1].trim()), // age
                        studentInfo[2].trim(), // class
                        rollNumber,
                        studentInfo[4].trim(), // contact number
                        studentInfo[5].trim()  // address
                );

                studentMap.put(rollNumber, student);
            }

            oos.writeObject(studentMap);
            System.out.println("Serialization complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Student> deserializeStudentData(String filename) {
        Map<String, Student> studentMap = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            studentMap = (HashMap<String, Student>) ois.readObject();
            System.out.println("Deserialization complete.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentMap;
    }

    static class Student implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private int age;
        private String studentClass;
        private String rollNumber;
        private String contactNumber;
        private String address;

        public Student(String name, int age, String studentClass, String rollNumber, String contactNumber, String address) {
            this.name = name;
            this.age = age;
            this.studentClass = studentClass;
            this.rollNumber = rollNumber;
            this.contactNumber = contactNumber;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getStudentClass() {
            return studentClass;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Name: " + name +
                    ", Age: " + age +
                    ", Class: " + studentClass +
                    ", Roll Number: " + rollNumber +
                    ", Contact Number: " + contactNumber +
                    ", Address: " + address;
        }
    }
}
