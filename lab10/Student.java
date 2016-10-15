import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Arsolon,Cugal,Desabille on 10/15/2016.
 */
public class Student {
    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;

    public Student() {
    }

    public Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.yearLevel = yearLevel;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }


    @Override
    public String toString() {
        return "Student Information\n" +
                "\tStudent Number: " + studentNumber  +
                "\n\tFirst Name: " + firstName  +
                "\n\tMiddle Initial: " + middleInitial +
                "\n\tlastName: " + lastName  +
                "\n\tcourse: " + course  +
                "\n\tyearLevel: " + yearLevel +
                "\n";
    }
}
