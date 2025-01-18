import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private static int idCounter = 1;
    private final int studentID;
    private List<Integer> grades;

    public Student(String name, String surname, int age, boolean gender, List<Integer> grades) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
        this.grades = grades;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public void addGrade(int grade) {
        if (grades == null) {
            grades = new ArrayList<>();
        }
        grades.add(grade);
    }

    public double calculateGPA() {
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return grades.isEmpty() ? 0 : (double) total / grades.size();
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ". GPA: " + calculateGPA();
    }
}