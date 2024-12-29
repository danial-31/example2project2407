package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        readStudentsFromFile("students.txt", school);
        readTeachersFromFile("teachers.txt", school);

        System.out.println("School Members:");
        System.out.println(school);

        school.saveToFile("school_members.txt");
    }

    private static void readStudentsFromFile(String fileName, School school) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String surname = data[1];

                int age = 0;
                try {
                    age = Integer.parseInt(data[2]);
                } catch (NumberFormatException e) {
                    continue;
                }

                boolean gender = data[3].equalsIgnoreCase("male");

                Student student = new Student(name, surname, age, gender);

                for (int i = 4; i < data.length; i++) {
                    try {
                        student.addGrade(Integer.parseInt(data[i]));
                    } catch (NumberFormatException e) {
                    }
                }
                school.addMember(student);
            }
        } catch (IOException e) {
        }
    }

    private static void readTeachersFromFile(String fileName, School school) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String surname = data[1];

                int age = 0;
                try {
                    age = Integer.parseInt(data[2]);
                } catch (NumberFormatException e) {
                    continue;
                }

                boolean gender = data[3].equalsIgnoreCase("male");
                String subject = data[4];
                int experience = 0;
                int salary = 0;

                try {
                    experience = Integer.parseInt(data[5]);
                    salary = Integer.parseInt(data[6]);
                } catch (NumberFormatException e) {
                    continue;
                }

                Teacher teacher = new Teacher(name, surname, age, gender, subject, experience, salary);
                if (experience > 10) {
                    teacher.giveRaise(10);
                }
                school.addMember(teacher);
            }
        } catch (IOException e) {
        }
    }
}
