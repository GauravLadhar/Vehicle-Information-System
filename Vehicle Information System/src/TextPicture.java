import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Gaurav
 * Date: 2022-03-24
 * Description: Displays a string that inherits from Picture class
 */
public class TextPicture extends Picture {
	
	// private data for string and font
	private String title;
	private Font f;

	/**
	 * 
	 */
	public TextPicture(String title) {
		// calls the Picture constructor
		super();

		// set title
		this.title = title;
		
		// set Font type to f
		this.f = new Font("Serif", Font.ITALIC, 30);
		
	}
	
	// override Picture method
	public void paint (Graphics g) {
		g.setFont(f);
		g.setColor(this.getColor());
		g.drawString(this.title, this.getxPos(), this.getyPos());
	}
	
	/**
	 * set setters and getters for font
	 */
	public Font getF() {
		return f;
	}

	/**
	 * @param f the f to set
	 */
	public void setF(Font f) {
		this.f = f;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// self testing
		// delcare a JFrame
		JFrame f = new JFrame("Testing");
		
		// set frame size
		f.setSize(500, 400);
		
		// call TextPicture class to put in a string
		TextPicture p = new TextPicture("My title");
		
		// set color
		p.setColor(Color.BLACK);
		
		// add text to frame
		f.add(p);
		
		// set x and y positions of string
		p.setxPos(170);
		p.setyPos(150);
		
		// set frame visible
		f.setVisible(true);
		
		// wait to change color
		JOptionPane.showMessageDialog(null, "Wait to change color of title");
		
		// change color
		p.setColor(Color.BLUE);
		
		// repaint the frame
		f.repaint();
		
		// wait to change color
		JOptionPane.showMessageDialog(null, "Wait to change color of title again");
				
		// change color
		p.setColor(Color.RED);
				
		// repaint the frame
		f.repaint();

	}

}
