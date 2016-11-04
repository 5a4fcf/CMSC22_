package lab13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by iris on 10/15/2016.
 */
public class TestStudentList extends StudentList{
    public static void main(String[] args){
        List<Student> stude = new ArrayList<>();
        File file = new File("D://iris/mps/cmsc22/lab13/students.txt");
        FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			if (file.length() == 0) {
				System.out.println(0);
			} else {

				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				
				stude = (List<Student>) ois.readObject();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();
		StudentList sl = new StudentList(stude, file);
		System.out.println("Menu:\n\t1. Add\n\t2. Search\n\t3. Delete\n\t4. Save\n\t5. Exit");
		Scanner sc = new Scanner(System.in);
		int n = 0;

		while (n != 5) {
			n = sc.nextInt();
			switch (n) {
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
