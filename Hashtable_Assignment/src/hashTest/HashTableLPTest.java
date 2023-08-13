package hashTest;

import java.io.IOException;
import java.util.ArrayList;

import hashPD.HashTableLP;
import studentDM.StudentDM;
import studentPD.Student;

public class HashTableLPTest {
	HashTableLP<Student> lp;
	StudentDM students;
	ArrayList<Student> studentList;
	int size;
	
	
	public HashTableLPTest(int size) {
		this.size = size;
		lp = new HashTableLP<Student>(size);
		studentList = new ArrayList<Student>();
		students = new StudentDM();
	}
	
	public void testLP() throws IOException {
		students.readStudentData();
		studentList = students.getStudentData();
		
		lp.fillTable(studentList);
		
		System.out.println("Test HashTableLP with table size " + size);
		
		//Output the number of collisions for inserting all test data for table size 100 and 200.
		System.out.println("Number of Collisions = " + lp.getCollisions());
		
		//Get the object with key 782209 and print out the Student name.
		System.out.println("Name: " + lp.get(782209).getValue().toString());
		
		//Remove the object with key 782209, do a get for the same key, and print out the results
		lp.remove(782209);
		
		if (lp.get(782209) == null)
			System.out.println("782209 not found");
		else
			System.out.println("Name: " + lp.get(782209).getValue().toString());
	}


}
