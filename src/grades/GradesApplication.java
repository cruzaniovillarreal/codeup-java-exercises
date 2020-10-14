package grades;

import util.Input;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GradesApplication {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();
        Student student1 = new Student("Jack");
        student1.recordAttendance("2017-10-17", "P");
        student1.recordAttendance("2017-10-18", "A");
        student1.recordAttendance("2017-10-19", "P");
        student1.addGrade(90);
        student1.addGrade(90);
        student1.addGrade(90);
        Student student2 = new Student("Eddy");
        student2.recordAttendance("2017-10-17", "A");
        student2.recordAttendance("2017-10-18", "P");
        student2.recordAttendance("2017-10-19", "A");
        student2.addGrade(60);
        student2.addGrade(90);
        student2.addGrade(100);
        Student student3 = new Student("James");
        student3.recordAttendance("2017-10-17", "P");
        student3.recordAttendance("2017-10-18", "P");
        student3.recordAttendance("2017-10-19", "P");
        student3.addGrade(70);
        student3.addGrade(80);
        student3.addGrade(90);
        Student student4 = new Student("Max");
        student4.recordAttendance("2017-10-17", "A");
        student4.recordAttendance("2017-10-18", "A");
        student4.recordAttendance("2017-10-19", "A");
        student4.addGrade(80);
        student4.addGrade(50);
        student4.addGrade(60);
        students.put("JackyBoy", student1);
        students.put("EddyBoy", student2);
        students.put("JamesyBoy", student3);
        students.put("MaxyBoy", student4);
        System.out.println(students);

        boolean toContinue;
        do {
            toContinue = false;
            System.out.println("\nWelcome to our User Database!");
            System.out.println("\nHere are the GitHub usernames of our students: \n");
            for (String student : students.keySet()) {
                System.out.print("|"+student+"|"+" ");
            }
            String userInput = new Input().getString("\n\nEnter username to view specific student information or type 'class' for summary: ");
            if (userInput.equalsIgnoreCase("class")) {
                ArrayList<Integer> allGrades = new ArrayList<>();
                int classSize = 0;
                int classTotal = 0;
                for (String student : students.keySet()) {
                    classSize += 1;
//                    classTotal += students.get(student).getGradeAverage();
                    allGrades.addAll(students.get(student).getGrades());
                    System.out.println(students.get(student).getName()+", "+student+", "+students.get(student).getGrades()+", "+students.get(student).getGradeAverage());
                }
                for (Integer grade : allGrades) {
                    classTotal += grade;
                }
                System.out.println("Class Size: "+classSize);
                System.out.println("Class Average: "+classTotal/allGrades.size());
            } else if (!students.containsKey(userInput)) {
                System.out.println("No users exist with the entered username.");
            } else {
                System.out.println("Name: "+students.get(userInput).getName());
                System.out.println("Grades: "+students.get(userInput).getGrades());
                System.out.println("Grade Average: "+students.get(userInput).getGradeAverage());
                System.out.printf("Attendance Percentage: %.2f", students.get(userInput).attendancePercentage());
                System.out.println("\nAbsent Dates: "+students.get(userInput).absentDates());
            }
            String userContinue = new Input().getString("\nWould you like to continue? [y/N]");
            if (userContinue.equalsIgnoreCase("y")) {
                toContinue = true;
            }
        } while (toContinue);
    }
}
