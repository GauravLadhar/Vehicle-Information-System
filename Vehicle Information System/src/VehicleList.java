import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Gaurav
 * Date: 2022-05-13
 * Description: Class to insert, delete and change VehicleRecord objects in list
 */
public class VehicleList {
	
	/**
	 * Instance variables
	 */
	private VehicleRecord list[];
	private int maxSize;
	private int size;

	/**
	 * Default constructor
	 */
	public VehicleList() {
		// initalize data
		this.maxSize = 10;
		this.list = new VehicleRecord[maxSize];
		this.size = 0;
	}

	/**
	 * Method to insert records into my list
	 * Checks if there is space - size <= maxSize
	 * if so, increase the size by 1
	 * adds the record to the location just below the size
	 * returns true if successful
	 */
	public boolean insert(VehicleRecord record) {
		// if size is below maxSize
		if (size < maxSize) {
			size++; // increase by 1
			list [size-1] = record;
			return true;
		}
		return false;
	}

	public boolean delete(VehicleRecord record) {
		// loop through the valid list
		for (int i = 0; i < size; i++) {
			// check if the record is found
			binarySearch(record.getMake());
			list[i] = list[size-1];	// places the last record in the i location
			size--;	// decreases usable size
			insertSort();
			return true;
		}
		// record not found
		return false;
	}

	/**
	 * Method to change the record
	 */
	public boolean change(VehicleRecord oldR, VehicleRecord newR) {
		// check if you can delete the old record
		if(delete(oldR)) {
			insert(newR);
			insertSort();
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * Method to increase the record size to 20
	 */
	public void increaseSize(int newMax) {
		// make the newMax from old maxSize
		this.maxSize = newMax;
		// create a new list and set new size to 20
		VehicleRecord newList[] = new VehicleRecord[list.length + 20];
		// create new list with elements of old list added in
		for (int i = 0; i < list.length; i++) {
			newList[i] = this.list[i];
		}
		this.list = newList;
	}
	
	/**
	 * toString method
	 */
	public String toString() {
		String theList = "";
		for (int i = 0; i < this.size; i++) {
			theList = theList + "Record " + i + ": " + this.list[i].toString() + "\n";
		}
		return theList;
	}
	
	/**
	 * Linear search method - finds vehicle model
	 */
	public int linearSearch (String searchKey) {
		// look through our valid list 
		for (int i = 0; i < size; i++) {
			if (searchKey.equalsIgnoreCase(list[i].getModel())) {
				// found it at index i
				return i;
			}
		}
		// model not found
		return -1;
	}
	
	/**
	 * Binary search method - finds vehicle make
	 */
	public int binarySearch (String searchKey) {
		int low = 0;
		int high = size-1;
		int middle;
		
		// while the low end of the array is below the high end of the array
		while (low <= high) {
			middle = (high + low)/2;
			if (searchKey.compareToIgnoreCase(list[middle].getMake()) == 0) {
				// found middle location
				return middle;
			}
			// lower then middle
			else if (searchKey.compareToIgnoreCase(list[middle].getMake()) < 0) {
				high = middle - 1;
			}
			// higher then middle
			else {
				low = middle + 1;
			}
		}
		// make not found
		return -1;
	}
	
	/**
	 * Insertion sort method - sorts vehicle makes into alphabetical order
	 * @return 
	 */
	public void insertSort () {
		for (int top = 1; top < size; top++) {
			VehicleRecord newList = new VehicleRecord();
			newList = list[top];
			int i = top;
			while (i > 0 && newList.toString().compareTo(list[i-1].toString()) < 1) {
				list[i] = list[i-1];
				i--;
			}
			list[i] = newList;
		}
	}
	
	/**
	 * Selection sort method in order to sort the vehicles by model year
	 */
	public void selectSort () {
		for (int top = size - 1; top > 0; top--) {
			int newDoc = 0;
			for (int i = 1; i <= top; i++) {
				if (list[i].getYear() > list[newDoc].getYear()) 
					newDoc = i;
				VehicleRecord temp = list[top];
				list[top] = list[newDoc];
				list[newDoc] = temp;
			}
		}
	}
	
	/**
	 * Method to save a file
	 * @throws IOException 
	 */
	public String saveToFile (String filename, VehicleRecord record) throws IOException {
		// create a file
		FileWriter fileW = new FileWriter("Vehicle list");
		PrintWriter output = new PrintWriter(fileW);
		
		// write contents to file
		output.println(record.getMake() + record.getModel() + record.getYear() + record.getType());
		fileW.close();

		// return file
		return filename;
	}
	
	/**
	 * Method to read a file
	 */
	public static String loadFile(String filename) throws IOException {
		// open file to read
		String line;
		int lineCount = 0;
		System.out.println("Enter filename");
		BufferedReader kbio = new BufferedReader(new InputStreamReader(System.in));
		filename = kbio.readLine();
		BufferedReader fr = new BufferedReader(new FileReader(filename));
		line = fr.readLine();
		while (line != null) {
			lineCount++;
			line = fr.readLine();
		}
		fr.close();

		String list [] = new String[lineCount];

		for (int i = 0; i < lineCount; i++) {
			list[i] = fr.readLine();
			System.out.println(list[i]);
		}
		return filename;
	}
	
	/**
	 * @return the list
	 */
	public VehicleRecord[] getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(VehicleRecord[] list) {
		this.list = list;
	}

	/**
	 * @return the maxSize
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * @param maxSize the maxSize to set
	 */
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	public static void main(String[] args) {
		// create a VehicleList object
		VehicleList vehicles = new VehicleList();
		
		// infinite loop to test
		while(true) {
			char command = JOptionPane.showInputDialog(null, "i - insert\n" + "d - delete\n" + "c - change\n" +
					"a - increase record size\n" + "s - linear search\n" + "b - binary search\n" +
					 "k - insertion sort\n" + "y - selection sort\n" + "p - display\n" + "q - quit", "i").charAt(0);
			
			if (command == 'q') {
				break;
			}
			switch (command) {
			case 'i': {
				String record = JOptionPane.showInputDialog(null, "Enter <make, model, year, type>", 
						"Toyota,Camry,2020,p");
				// create and process a record object
				VehicleRecord sInfo = new VehicleRecord();
				sInfo.processString(record);
				if (vehicles.insert(sInfo)) {
					JOptionPane.showMessageDialog(null, "Record inserted");
				}
				else {
					JOptionPane.showMessageDialog(null, "Insert failed");
				}
				break;
			}
			case 'd': {
				String record = JOptionPane.showInputDialog(null, "Enter <make, model, year, type>", 
						"Toyota,Camry,2020,Car");
				// create and process a record object
				VehicleRecord sInfo = new VehicleRecord();
				sInfo.processString(record);
				if (vehicles.delete(sInfo)) {
					JOptionPane.showMessageDialog(null, "Record deleted");
				}
				else {
					JOptionPane.showMessageDialog(null, "delete failed");
				}
				break;
			}
			case 'c': {
				String oldRecord = JOptionPane.showInputDialog(null, "Enter <make, model, year, type>", 
						"Toyota,Camry,2020,Car");
				// create and process a record object
				VehicleRecord oldInfo = new VehicleRecord();
				oldInfo.processString(oldRecord);
				
				String newRecord = JOptionPane.showInputDialog(null, "Enter <make, model, year, type>", 
						"Toyota,Camry,2020,Car");
				// create and process a record object
				VehicleRecord newInfo = new VehicleRecord();
				newInfo.processString(newRecord);
				
				if (vehicles.change(oldInfo, newInfo)) {
					JOptionPane.showMessageDialog(null, "Record changed");
				}
				else {
					JOptionPane.showMessageDialog(null, "Change failed");
				}
				break;
			}
			case 's': {
				String model = JOptionPane.showInputDialog(null, "Enter vehicle model to find");
				int location = vehicles.linearSearch(model);
				// found it at location
				if (location >= 0) {
					JOptionPane.showMessageDialog(null, vehicles.getList()[location].getModel() + " found");
				}
				else {
					JOptionPane.showMessageDialog(null, model + " not found");
				}
				break;
			}
			case 'b': {
				String make = JOptionPane.showInputDialog(null, "Enter vehicle make to find");
				int location = vehicles.binarySearch(make);
				// found it at location
				if (location >= 0) {
					JOptionPane.showMessageDialog(null, vehicles.getList()[location].getMake() + " found");
				}
				else {
					JOptionPane.showMessageDialog(null, make + " not found");
				}
				break;
			}
			case 'k': {
				vehicles.insertSort();
				break;
			}
			case 'y': {
				vehicles.selectSort();
				break;
			}
			case 'u': {
				try {
					VehicleRecord sInfo = new VehicleRecord();
					vehicles.saveToFile("Vehicle list", sInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 'a': {
				VehicleRecord sInfo = new VehicleRecord();
				// set new record maxSize to 20
				vehicles.increaseSize(20);
				JOptionPane.showMessageDialog(null, "Record size increased to: " + vehicles.getMaxSize());
				break;
			}
			case 'p': {
				JOptionPane.showMessageDialog(null, vehicles.toString());
				break;
			}
		}
	}

}

}
