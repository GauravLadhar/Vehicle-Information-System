import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Gaurav
 * Date: 2022-03-23
 * Description: Using picture class, program draws image
 */
public class Picture extends JComponent {

	// private data for picture
	private Color color;
	private int xPos, yPos, myWidth, myHeight;

	/**
	 * Default constructor
	 */
	public Picture() {
		// initialize my data
		this.color = Color.RED;
		this.xPos = 0;
		this.yPos = 0;
		this.myWidth = 50;
		this.myHeight = 25;
	}

	/**
	 * overloaded constructor
	 */
	public Picture(int x, int y, int w, int h) {
		this.color = Color.RED;
		this.xPos = x;
		this.yPos = y;
		this.myWidth = w;
		this.myHeight = h;
	}

	// overide the JComponent paint
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.drawRect(this.xPos, this.yPos, this.myWidth, this.myHeight);
		g.drawOval(this.xPos, this.yPos, this.myWidth, this.myHeight);
		g.fillOval(this.xPos + myWidth / 4, this.yPos, (myWidth / 2), myHeight);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// self testing

		// create a JFrame
		JFrame f = new JFrame("Testing only");
		f.setSize(400, 350);

		// instantiates a picture object
		Picture p = new Picture();

		// add the object to f
		f.add(p);

		// set JFrame visible
		f.setVisible(true);

		// wait command
		JOptionPane.showMessageDialog(null, "Wait to change color");

		// change color
		p.setColor(Color.BLUE);

		// repaint the frame
		f.repaint();

		// wait command
		JOptionPane.showMessageDialog(null, "Wait to change color");

		// change color using RGB
		p.setColor(204, 0, 204);

		// repaint the frame
		f.repaint();

		// wait command
		JOptionPane.showMessageDialog(null, "Wait to change position and size");

		// set position and size
		p.setxPos(50);
		p.setyPos(100);
		p.setMyWidth(30);
		p.setMyHeight(80);

		// repaint the frame
		f.repaint();

		// wait command
		JOptionPane.showMessageDialog(null, "Wait to create new object");

		// instantiates a picture object
		Picture p1 = new Picture(200, 100, 120, 50);

		// add the object to f
		f.add(p1);

		// set the JFrame visible
		f.setVisible(true);

	}

	// set getters and setters method

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * overloading the setColor method
	 * set color using RGB
	 */
	public void setColor(int r, int g, int b) {
		this.color = new Color(r, g, b);
	}

	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * @return the myWidth
	 */
	public int getMyWidth() {
		return myWidth;
	}

	/**
	 * @param myWidth the myWidth to set
	 */
	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
	}

	/**
	 * @return the myHeight
	 */
	public int getMyHeight() {
		return myHeight;
	}

	/**
	 * @param myHeight the myHeight to set
	 */
	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
	}


}
