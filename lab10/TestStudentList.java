import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Arsolon,Cugal,Desabille on 10/15/2016.
 */
public class TestStudentList extends StudentList{
    public static void main(String[] args){
        List<Student> stude = new ArrayList<>();
        File file = new File("student.txt");
        StudentList sl = new StudentList(stude,file);
        System.out.println("Menu:\n\t1. Add\n\t2. Search\n\t3. Delete\n\t4. Save\n\t5. Exit");
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(n!=5){
            n = sc.nextInt();
            switch(n) {
                case 1:
                    sl.append();
                    break;
                case 2:
                    sl.search();
                    break;
                case 3:
                    sl.delete();
                    break;
                case 4:
                    sl.save();
                    break;
                default:
                    break;
            }
        }
    }
}
