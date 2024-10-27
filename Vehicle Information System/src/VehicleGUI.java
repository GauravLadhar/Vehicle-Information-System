import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author Gaurav
 * Date: 2022-05-16
 * Description: GUI class that uses VehicleRecord and VehicleList
 */
public class VehicleGUI extends JFrame implements ActionListener {

	// private data
	private JPanel inputPanel, outputPanel, controlPanel;
	private JTextField textInput;
	private JTextArea textOutput;
	private JLabel lblInstruction, lblInstruction2;
	private JButton btnInsert, btnDelete, btnChange, btnAlphabetically, btnClear, btnMake, btnYear, btnModel, btnSave, btnRead;
	private JScrollPane scroller;
	private Picture p;
	private VehicleRecord list[];

	/**
	 * Creates an instance of VehicleGUI
	 */
	public VehicleGUI() {
		// create title for GUI
		super("Vehicle Information System");

		// set layout for frame
		setLayout(new GridLayout(5,1));

		// add areas to panel
		inputPanel = new JPanel();
		outputPanel = new JPanel();
		controlPanel = new JPanel();

		// create text component by calling TextPicture and setting its color
		p = new TextPicture("Vehicle Information System");
		p.setColor(Color.RED);
		p.setMyWidth(5);
		p.setMyHeight(8);
		p.setxPos(45);
		p.setyPos(60);

		// create text components, scroller, and buttons
		textInput = new JTextField("Toyota,Camry,2020,p", 20);
		lblInstruction = new JLabel("Enter the make, model, year, and type");
		textOutput = new JTextArea(4,30);
		lblInstruction2 = new JLabel("Vehicle information displays below");
		scroller = new JScrollPane(textOutput);
		btnInsert = new JButton("Insert");
		btnDelete = new JButton("Delete");
		btnChange = new JButton("Change");
		btnAlphabetically = new JButton("Alphabetical Sort");
		btnMake = new JButton("Make search");
		btnModel = new JButton("Model sort");
		btnYear = new JButton("Year sort");
		btnSave = new JButton("Save");
		btnRead = new JButton("Read");
		btnClear = new JButton("Clear");

		// add components to the panel
		inputPanel.add(lblInstruction);
		outputPanel.add(lblInstruction2);
		inputPanel.add(textInput);
		outputPanel.add(scroller);
		controlPanel.add(btnInsert);
		controlPanel.add(btnDelete);
		controlPanel.add(btnChange);
		controlPanel.add(btnAlphabetically);
		controlPanel.add(btnMake);
		controlPanel.add(btnModel);
		controlPanel.add(btnYear);
		controlPanel.add(btnSave);
		controlPanel.add(btnRead);
		controlPanel.add(btnClear);

		// add components to the frame
		add(p);
		add(inputPanel);
		add(outputPanel);
		add(controlPanel);

		// add button as a listener in this frame
		btnInsert.addActionListener(this);
		btnDelete.addActionListener(this);
		btnChange.addActionListener(this);
		btnAlphabetically.addActionListener(this);
		btnMake.addActionListener(this);
		btnModel.addActionListener(this);
		btnYear.addActionListener(this);
		btnSave.addActionListener(this);
		btnRead.addActionListener(this);
		btnClear.addActionListener(this);

		// set the size of the frame
		setSize(435, 520);
		setVisible(true);
		setResizable(false);
		setLocation(500, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Method for button action
	 */
	public void actionPerformed(ActionEvent e) {
		// declare variables for input and output
		String record = "Toyota,Camry,2020,Car";
		String input;
		String output;

		// create a VehicleList object
		VehicleList vehicles = new VehicleList();

		// if the insert button is pressed
		if (e.getSource() == btnInsert) {
			input = textInput.getText();
			output = textOutput.getText() + record + "\n";
			// create and process a record object
			VehicleRecord sInfo = new VehicleRecord();
			sInfo.processString(record);
			vehicles.insert(sInfo);

			// display outputText
			textOutput.setText(output);
		}

		// if the delete button is pressed
		if (e.getSource() == btnDelete) {
			// create a record object
			VehicleList obj1 = new VehicleList();
			VehicleRecord sInfo = new VehicleRecord();
			input = textInput.getText();
			output = textOutput.getText() + input + "\n";
			obj1.delete(sInfo);
			textOutput.setText(obj1.toString());
		}

		// if the change button is pressed
		if (e.getSource() == btnChange) {
			VehicleList obj1 = new VehicleList();
			VehicleRecord sInfo = new VehicleRecord();
			input = textInput.getText();
			output = textOutput.getText() + input + "\n";
			obj1.change(sInfo, sInfo);
			textOutput.setText(obj1.toString());
		}

		if (e.getSource() == btnAlphabetically) {
			VehicleList obj1 = new VehicleList();
			VehicleRecord sInfo = new VehicleRecord();
			input = textInput.getText();
			output = textOutput.getText() + input + "\n";
			obj1.insertSort();
			textOutput.setText(obj1.toString());
		}

		if (e.getSource() == btnMake) {
			VehicleList obj1 = new VehicleList();
			VehicleRecord sInfo = new VehicleRecord();
			input = textInput.getText();
			output = textOutput.getText() + input + "\n";
			obj1.binarySearch(output);
			textOutput.setText(obj1.toString());
		}

		if (e.getSource() == btnModel) {
			VehicleList obj1 = new VehicleList();
			VehicleRecord sInfo = new VehicleRecord();
			input = textInput.getText();
			output = textOutput.getText() + input + "\n";
			obj1.linearSearch(output);;
			textOutput.setText(obj1.toString());
		}

		if (e.getSource() == btnYear) {
			VehicleList obj1 = new VehicleList();
			VehicleRecord sInfo = new VehicleRecord();
			input = textInput.getText();
			output = textOutput.getText() + input + "\n";
			obj1.selectSort();
			textOutput.setText(obj1.toString());
		}

		// if save file button pressed
		if (e.getSource() == btnSave) {
			VehicleList obj1 = new VehicleList();
			VehicleRecord sInfo = new VehicleRecord();
			input = textInput.getText();
			output = textOutput.getText() + input + "\n";
			try {
				obj1.saveToFile("Vehicle List", sInfo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			textOutput.setText(obj1.toString());
		}
/**
		// if read file button pressed
		if (e.getSource() == btnRead) {
			VehicleList obj1 = new VehicleList();
			VehicleRecord sInfo = new VehicleRecord();
			input = textInput.getText();
			output = textOutput.getText() + input + "\n";
			try {
				obj1.loadFile("Vehicle List");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			textOutput.setText(obj1.toString());
		}
**/
		// if clear button pressed
		if (e.getSource() == btnClear) {
			textOutput.setText("");
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// run the GUI
		VehicleGUI vGUI = new VehicleGUI();

	}

}
