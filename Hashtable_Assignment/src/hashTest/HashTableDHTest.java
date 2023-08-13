package hashTest;

import java.io.IOException;
import java.util.ArrayList;

import hashPD.HashTableDH;
import studentDM.StudentDM;
import studentPD.Student;

public class HashTableDHTest {
	HashTableDH<Student> dh;
	StudentDM students;
	ArrayList<Student> studentList;
	int size;
	
	
	public HashTableDHTest(int size) {
		this.size = size;
		dh = new HashTableDH<Student>(size);
		studentList = new ArrayList<Student>();
		students = new StudentDM();
	}
	
	public void testDH() throws IOException {
		students.readStudentData();
		studentList = students.getStudentData();
		
		dh.fillTable(studentList);
		
		System.out.println("Test HashTableDH with table size " + size);
		
		//Output the number of collisions for inserting all test data for table size 100 and 200.
		System.out.println("Number of Collisions = " + dh.getCollisions());
		
		//Get the object with key 782209 and print out the Student name.
		System.out.println("Name: " + dh.get(782209).getValue().toString());
		
		//Remove the object with key 782209, do a get for the same key, and print out the results
		dh.remove(782209);
		
		if (dh.get(782209).getValue().toString().equals("xxx"))
			System.out.println("782209 not found");
		else
			System.out.println("Name: " + dh.get(782209).getValue().toString());
	}


}
