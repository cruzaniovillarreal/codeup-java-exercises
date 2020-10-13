package grades;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> grade;


    public Student(String name) {
        this.name = name;
        this.grade = new ArrayList<>();
    }

    // returns the student's name
    public String getName() {
        return this.name;
    }

    // adds the given grade to the grades property
    public void addGrade(int grade) {
        (this.grade).add(grade);
    }

    // returns the average of the students grades
    public double getGradeAverage() {
        double total = 0;
        for (Integer grade : this.grade) {
            total += grade;
        }
        return total / this.grade.size();
    }

    public ArrayList<Integer> getGrades() {
        return this.grade;
//        for (Integer grade : this.grade) {
//            System.out.println(grade);
//        }
    }

    public static void main(String[] args) {
        Student Sam = new Student("Sam");
        Sam.addGrade(70);
        Sam.addGrade(90);
        System.out.println(Sam.getGradeAverage());
    }
}
