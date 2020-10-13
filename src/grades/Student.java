package grades;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private ArrayList<Integer> grades;
    private HashMap<String, String> attendance = new HashMap<>();


    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addGrade(int grade) {
        (this.grades).add(grade);
    }

    public double getGradeAverage() {
        double total = 0;
        for (Integer grade : this.grades) {
            total += grade;
        }
        return total / this.grades.size();
    }

    public ArrayList<Integer> getGrades() {
        return this.grades;
//        for (Integer grade : this.grade) {
//            System.out.println(grade);
//        }
    }

    public void recordAttendance(String date, String value) {
        if (value.equalsIgnoreCase("P") || value.equalsIgnoreCase("A")) {
            this.attendance.put(date, value);
        } else {
            System.out.println("Invalid Input");
        }
    }

    public float attendancePercentage() {
        float total = 0;
        float absent = 0;
        for (String date : this.attendance.keySet()) {
            total += 1;
            if (this.attendance.get(date).equalsIgnoreCase("A")) {
                absent += 1;
            }
        }
        return (total-absent)/total;
    }

    public ArrayList<String> absentDates() {
        ArrayList<String> dates = new ArrayList<>();
        for (String date : this.attendance.keySet()) {
            if (this.attendance.get(date).equalsIgnoreCase("A")) {
                dates.add(date);
            }
        }
        return dates;
    }

    public static void main(String[] args) {
        Student Sam = new Student("Sam");
        Sam.addGrade(70);
        Sam.addGrade(90);
        System.out.println(Sam.getGradeAverage());
    }
}
