package studentDM;
import studentPD.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class StudentDM {
	ArrayList<Student> students;
	Student temp;
	public StudentDM() {
		students = new ArrayList<Student>();
	}
	
	public void readStudentData() throws IOException {
		String fileName = "src\\hashdata.csv";
		String line = null;
		String token = ",";
		String data[];
		
		
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while ((line = bufferedReader.readLine()) != null) {
				data = line.split(token);
				temp = new Student(data[1], Integer.parseInt(data[0]));
				students.add(temp);
			}
			bufferedReader.close();
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();	
		}

//		for (int i = 0; i < students.size(); i++)
//			System.out.println(students.get(i));
	}
	
	public ArrayList<Student> getStudentData() {
		return students;
	}
}
