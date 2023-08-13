package hashPD;

import java.util.ArrayList;
import studentPD.Student;

public class HashTableDH<E> {
	private Entry[] table;
	int size;
	int collisions;

	public class Entry<T> {
		int key;
		T value;
		
		public Entry() {
			key = 0;
			value = null;
		}
		
		public Entry(int key, T value) {
			this.key = key;
			this.value = value;
		}
		
		public int getKey() {
			return key;
		}
		
		public T getValue() {
			return value;
		}
		
		public String toString() {
			return "Key: " + key + ", Value: " + value.toString();
		}
	}

	public HashTableDH(int size) {
		this.size = size;
		table = new Entry[size];
		collisions = 0;
	}
	
	public <T> int put(Entry<T> entry) {
		int i = 0;
		int h = (3* entry.getKey() +5) % size;
		int hC = 7 - (entry.getKey() % 7);
		int dh = (h + i * hC) % size;
		
		while (!isAvaliable(dh)) {
			collisions++;
			i++;
			dh = (h + i * hC) % size;		
		}
		
		table[dh] = entry;
		return collisions;
	}
	
	public <T> Entry get(int key) {
		//System.out.println(key);
		int i = 0;
		int h = (3 * key + 5) % size;
		int hC = 7 - (key % 7);
		int dh = (h + i * hC) % size;
		
		if(table[dh] != null)
			while (table[dh].getKey() != key) {
				i++;
				dh = (h + i * hC) % size;	
			}
		
		
		return table[dh];
	}
	
	
	public void remove(int key) {
		int i = 0;
		int h = (3*key +5) % size;
		int hC = 7 - (key % 7);
		int dh = (h + i * hC) % size;
		
		while (table[dh].getKey() != key) {
			i++;
			dh = (h + i * hC) % size;	
		}
		
		table[dh].value = "xxx";
	
	}
	
	public boolean isAvaliable(int location) {
		if (table[location] != null)
			return false;
		return true;
	}

	public <T> void fillTable(ArrayList<Student> data) {
		for (int i = 0; i < data.size(); i++) {
			Entry temp = new Entry(data.get(i).getId(), data.get(i).getName());
			this.put(temp);
		}
	}

	public int getCollisions() {
		return collisions;
	}
}


