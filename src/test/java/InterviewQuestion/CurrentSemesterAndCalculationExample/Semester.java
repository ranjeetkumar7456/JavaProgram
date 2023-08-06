package InterviewQuestion.CurrentSemesterAndCalculationExample;

import java.util.ArrayList;
import java.util.List;

public class Semester {
    private List<Subject> subjects;

    public Semester() {
        subjects = new ArrayList<>();
    }

    public void addSubject(String name, double marks) {
        Subject subject = new Subject(name, marks);
        subjects.add(subject);
    }

    public double getAverage() {
        double totalMarks = 0.0;
        for (Subject subject : subjects) {
            totalMarks += subject.getMarks();
        }
        return totalMarks / subjects.size();
    }

    public String getGrade(double marks) {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public void printSubjectGrades() {
        for (Subject subject : subjects) {
            double marks = subject.getMarks();
            String grade = getGrade(marks);
            System.out.println(subject.getName() + ": " + marks + " (" + grade + ")");
        }
    }
}
