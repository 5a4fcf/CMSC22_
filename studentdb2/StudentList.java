package lab13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by iris on 10/15/2016.
 */
public class StudentList extends Student{
    private List<Student> students;
    private File file;

    public StudentList(List<Student> students , File file){
        this.students = students;
        this.file = file;
    }

    public StudentList(){
        students = new ArrayList<>();
        createFile("students.txt");
    }

    public void createFile(String filename) {
        file = new File(filename);
        try{

            if(file.createNewFile()){
                System.out.println("File is created!");
            }else{
                System.out.println("File exists!");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public boolean alreadyExists(String sn){
    	 for (Student s : students) {
      	   if (s.getStudentNumber().equals(sn)) {
      		   return true;
      	   }
         }
         return false;
    }


    public void append(){
        createFile("students.txt");
        Student s = new Student();

        System.out.println("Please enter Student Information:");
        Scanner scan = new Scanner(System.in);
        System.out.println("Student Number:");
        String sn = scan.next();
        if(alreadyExists(sn)){
            System.out.println("Student is already on the list!");
        }
        else{
            int ctr = 1 ;
            while(ctr<=81){
                switch(ctr){
                    case 1:
                        s.setStudentNumber(sn);
                        break;
                    case 2:
                        System.out.print("First name: ");
                        s.setFirstName(scan.next());
                        break;
                    case 3:
                        System.out.print("Middle initial: ");
                        String t = scan.next();
                        s.setMiddleInitial(t.charAt(0));
                        break;
                    case 4:
                        System.out.print("Last name: ");
                        s.setLastName(scan.next());
                        break;
                    case 5:
                        System.out.print("Course: ");
                        s.setCourse(scan.next());
                        break;
                    case 6:
                        System.out.print("Year level: ");
                        s.setYearLevel(scan.nextInt());
                        break;
                    case 7:
                    	System.out.print("Crush Name: ");
                        s.setCrushName(scan.next());
                        break;
                    case 8:
                    	System.out.print("Course Code: ");
                        String ccode = scan.next();
                        System.out.println("Course Description: ");
                        String cdesc = scan.next();
                        Course sub = new Course(ccode,cdesc);
                        s.setFaveSubject(sub);
                        break;
                }
                ctr++;
            }
            students.add(s);
        }
    }

    public void search(){
        System.out.println("Search Student: ");
        Scanner scan = new Scanner(System.in);
        String sn = scan.next();
        if(alreadyExists(sn)){
            System.out.println(students.size());
            for (Student s: students) {
                if (s.getStudentNumber().equals(sn) == true) {
                    System.out.println(s);
                }
            }
        }else{
            System.out.println("Student is not on the list.:(");
        }
    }

    public void delete(){
        System.out.println("Delete Student: ");
        Scanner scan = new Scanner(System.in);
        String sn = scan.next();
        if(alreadyExists(sn)){
            for(Student s: students){
                if(s.getStudentNumber().equals(sn)){
                    students.remove(s);
                    System.out.println("Student has been deleted");
                    break;
                }
            }
        }else{
            System.out.println("No match found for requested student.");
        }
    }

    public void save(){
    	FileOutputStream fos = null;
    	ObjectOutputStream oos = null;
    	try{
             fos = new FileOutputStream(file);
             oos = new ObjectOutputStream(fos);
             oos.writeObject(students);
             System.out.println("SAVED!");
             oos.close();
         }catch(IOException e){
             e.printStackTrace();
         }finally {
             try {
                 fos.close();
             } catch (IOException ex) {
                 ex.printStackTrace();
             }
         }
    	
    }
}
