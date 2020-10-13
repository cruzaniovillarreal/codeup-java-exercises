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
        student1.addGrade(85);
        student1.addGrade(89);
        student1.addGrade(92);
        Student student2 = new Student("Eddy");
        student2.addGrade(93);
        student2.addGrade(97);
        student2.addGrade(100);
        Student student3 = new Student("James");
        student3.addGrade(85);
        student3.addGrade(74);
        student3.addGrade(80);
        Student student4 = new Student("Max");
        student4.addGrade(67);
        student4.addGrade(73);
        student4.addGrade(77);
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
            String userInput = new Input().getString("\n\nEnter username to expand: ");
            if (!students.containsKey(userInput)) {
                System.out.println("No users exist with the entered username.");
            } else {
                System.out.println("Name: "+students.get(userInput).getName());
                System.out.println("Grades: "+students.get(userInput).getGrades());
                System.out.println("Grade Average: "+students.get(userInput).getGradeAverage());
            }
            String userContinue = new Input().getString("Would you like to continue?");
            if (userContinue.equalsIgnoreCase("y")) {
                toContinue = true;
            }
        } while (toContinue);


    }
}
