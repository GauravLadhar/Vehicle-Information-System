import javax.swing.JOptionPane;
import com.sun.jdi.CharType;

/**
 * 
 */

/**
 * @author Gaurav
 * Date: 2022-04-26
 * Description: Contains and processes vehicle information
 */
public class VehicleRecord {
	
	/**
	 * Instance variables
	 */
	private String make;
	private String model;
	private int year;
	private char type;

	/**
	 * Default constructor
	 */
	public VehicleRecord() {
		// initialize all data
		this.make = "";
		this.model = "";
		this.year = 0;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * @return the type
	 */
	public char getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(char type) {
		this.type = type;
	}

	/**
	 * Proccess string
	 */
	public void processString(String record) {
		// split record into String array
		String words[] = record.split(",");
		// save the words into instance data
		this.make = words[0];
		this.model = words[1];
		this.year = Integer.parseInt(words[2]);
		this.type = words[3].charAt(type);
	
	}

	@Override
	public String toString() {
		
		// switch-case to check the type of vehicle
		switch(type) {
		// if type is a car
		case 'p': {
			String p = String.valueOf("Passenger");
			return "VehicleRecord [make=" + make + ", model=" + model + ", year=" + year + ", type=" + p + "]";
		}
		// if a type is a van
		case 'v': {
			String v = String.valueOf("Van");
			return "VehicleRecord [make=" + make + ", model=" + model + ", year=" + year + ", type=" + v + "]";
		}
		// if a type is a SUV
		case 's' : {
			String s = String.valueOf("SUV");
			return "VehicleRecord [make=" + make + ", model=" + model + ", year=" + year + ", type=" + s + "]";
		}
		// if type is a truck
		case 't': {
			String t = String.valueOf("Truck");
			return "VehicleRecord [make=" + make + ", model=" + model + ", year=" + year + ", type=" + t + "]";
		}
		}
		
		// if the user enters a invalid vehicle type, display error
		if ((type != 'p') && (type != 'v') && (type != 's') && (type != 't')) {
			System.out.println("Error, please enter a valid vehicle type");
		}

		return "VehicleRecord [make=" + make + ", model=" + model + ", year=" + year + ", type=" + type + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Self testing method for passenger car
		String record = "Toyota,Camry,2020,p";
		
		// create object
		VehicleRecord vInfo = new VehicleRecord();
		
		// test proccessRecord
		vInfo.processString(record);
		
		// display contents
		System.out.println(vInfo);
		
		//<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
		
		// Self testing method for van
		String record2 = "Ford,Transit,2015,v";
				
		// create object
		VehicleRecord vInfo2 = new VehicleRecord();
				
		// test proccessRecord
		vInfo2.processString(record2);
				
		// display contents
		System.out.println(vInfo2);
		
		//<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
		
		// Self testing method for SUV
		String record3 = "Mazda,CX-5,2011,s";
						
		// create object
		VehicleRecord vInfo3 = new VehicleRecord();
						
		// test proccessRecord
		vInfo3.processString(record3);
						
		// display contents
		System.out.println(vInfo3);
		
		//<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
		
		// Self testing method for truck
		String record4 = "Ford,F150,2022,t";
								
		// create object
		VehicleRecord vInfo4 = new VehicleRecord();
								
		// test proccessRecord
		vInfo4.processString(record4);
								
		// display contents
		System.out.println(vInfo4);
		System.out.println();
		
		//<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
		
		// Self testing method for an unknown vehicle type
		String record5 = "Unknown,Vehicle,0,h";
										
		// create object
		VehicleRecord vInfo5 = new VehicleRecord();
										
		// display contents
		System.out.println(vInfo5);
		System.out.println();
		
		//<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
		
		// test the setters for car
		vInfo.setMake("Toyota");
		vInfo.setModel("Camry");
		vInfo.setYear(2020);
		vInfo.setType('p');
		
		// test the getters for car
		System.out.println(vInfo.getMake());
		System.out.println(vInfo.getModel());
		System.out.println(vInfo.getYear());
		System.out.println(vInfo.getType());
		System.out.println();
		
		//<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
		
		// test the setters for van
		vInfo.setMake("Ford");
		vInfo.setModel("Transit");
		vInfo.setYear(2015);
		vInfo.setType('v');
				
		// test the getters
		System.out.println(vInfo.getMake());
		System.out.println(vInfo.getModel());
		System.out.println(vInfo.getYear());
		System.out.println(vInfo.getType());
		System.out.println();
		
		//<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
		
		// test the setters for SUV
		vInfo.setMake("Mazda");
		vInfo.setModel("CX-5");
		vInfo.setYear(2011);
		vInfo.setType('s');
						
		// test the getters
		System.out.println(vInfo.getMake());
		System.out.println(vInfo.getModel());
		System.out.println(vInfo.getYear());
		System.out.println(vInfo.getType());
		System.out.println();
		
		//<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
		
		// test the setters for truck
		vInfo.setMake("Ford");
		vInfo.setModel("F150");
		vInfo.setYear(2022);
		vInfo.setType('t');
								
		// test the getters
		System.out.println(vInfo.getMake());
		System.out.println(vInfo.getModel());
		System.out.println(vInfo.getYear());
		System.out.println(vInfo.getType());
		System.out.println();

	}

}
