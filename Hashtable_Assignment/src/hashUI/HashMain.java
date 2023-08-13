package hashUI;

import java.io.IOException;

import hashTest.HashTableDHTest;
import hashTest.HashTableLPTest;
import studentDM.StudentDM;

public class HashMain {

	public static void main(String[] args) throws IOException {
		//StudentDM dm = new StudentDM();
		//dm.readStudentData();
		HashTableLPTest lpTest = new HashTableLPTest(100);
		lpTest.testLP();
		
		System.out.println();
		
		lpTest = new HashTableLPTest(200);
		lpTest.testLP();
		
		System.out.println();
		
		HashTableDHTest dhTest = new HashTableDHTest(100);
		dhTest.testDH();
		
		System.out.println();
		
		dhTest = new HashTableDHTest(200);
		dhTest.testDH();
	}

}
