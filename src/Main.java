import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();

        File file = new File("D:/assignment1Project/src/Student");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            if (parts.length < 5) continue;

            String name = parts[0];
            String surname = parts[1];
            int age = Integer.parseInt(parts[2]);
            boolean gender = parts[3].equalsIgnoreCase("Male");
            List<Integer> grades = new ArrayList<>();
            for (int i = 4; i < parts.length; i++) {
                grades.add(Integer.parseInt(parts[i]));
            }

            Student student = new Student(name, surname, age, gender, grades);
            school.addMember(student);
        }

        file = new File("D:/assignment1Project/src/Teacher");
        Scanner tscanner = new Scanner(file);
        while (tscanner.hasNextLine()) {
            String line = tscanner.nextLine();
            String[] parts = line.split("\\s+");
            if (parts.length < 7) continue;

            String name = parts[0];
            String surname = parts[1];
            int age = Integer.parseInt(parts[2]);
            boolean gender = parts[3].equalsIgnoreCase("Male");
            String subject = parts[4];
            int yearsOfExperience = Integer.parseInt(parts[5]);
            int salary = Integer.parseInt(parts[6]);

            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
            if (yearsOfExperience > 10) {
                teacher.giveRaise(10);
            }
            school.addMember(teacher);
        }

        Collections.sort(school.getMembers(), Comparator.comparing(Person::getSurname));
        System.out.println(school);
    }
}