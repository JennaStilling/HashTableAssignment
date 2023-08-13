package hashPD;

import java.util.ArrayList;

import studentPD.Student;

public class HashTableLP<E> {
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
	
	public HashTableLP(int size) {
		this.size = size;
		table = new Entry[size];
		collisions = 0;
	}
	
	public <T> int put(Entry<T> entry) {
		int hash = (3 * entry.getKey() + 5) % size;
		while (!isAvaliable(hash)) {
			hash++;
			collisions++;
		}
		
		table[hash] = entry;
		return collisions;
	}
	
	public <T> Entry<T> get(int key) {
		int hash = (3 * key + 5) % size;
		
		if (table[hash] != null)
			while (table[hash].getKey() != key) {
				hash++;
			}
		
		return table[hash];
	}
	
	public void remove(int key) {
		int hash = (3 * key + 5) % size;
		while (table[hash].getKey() != key) {
			hash++;
		}
		
		table[hash] = null;
		
	}
	
	public boolean isAvaliable(int location) {
		if (table[location] != null)
			return false;
		return true;
	}
	
	public <T> void fillTable(ArrayList<Student> data) {
		for (int i = 0; i < data.size(); i++) {
			Entry<String> temp = new Entry<String>(data.get(i).getId(), data.get(i).getName());
			this.put(temp);
		}
	}
	
	public int getCollisions() {
		return collisions;
	}
}
