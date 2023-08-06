package InterviewQuestion.CurrentSemesterAndCalculationExample;

public class SemesterGrades {
    public static void main(String[] args) {
        Semester semester = new Semester();
        semester.addSubject("Mathematics", 85);
        semester.addSubject("Physics", 92);
        semester.addSubject("English", 78);
        semester.addSubject("Computer Science", 91);

        double average = semester.getAverage();
        String overallGrade = semester.getGrade(average);

        System.out.println("Overall Average: " + average + " (" + overallGrade + ")");
        System.out.println("Subject Grades:");
        semester.printSubjectGrades();
    }
}
