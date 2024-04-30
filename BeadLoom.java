//Julia Peng & Maya Peski
//Ms. Krasteva
//11/10/2023
//This program, using primarily for loops, displays a piece of pixel art in the style of Indigenous bead loom art. Following the geometrical characteristic, for loops were used extensively due to its applicability.
//The design was created by both of us, and is an original design, adn the colours are mixtures of our favourite colours!

//importing necessary elements
import java.awt.*;
import hsa.Console;

/* This program will draw a virtual bead loom using for loops

VariableName     Type        Description
sqX              int         The x coordinate of left edge of the 400 by 400 square
sqY              int         The y coordinate of top edge of the 400 by 400 square
c               ConsoleClass    The variable for the program's class.

*/
public class BeadLoom {
	// declaration section
	Console c;
	int sqX;
	int sqY;

	// the constructor of the program, creates and names the console variable, and
	// initializes sqX and sqY
	public BeadLoom() {
		c = new Console("Virtual Bead Loom");
		sqX = c.getWidth() / 2 - 200;
		sqY = c.getHeight() / 2 - 200;
	}

	/*
	 * A private method used for waiting to animate, since we use the Thread.sleep()
	 * command so often.
	 * VariableName Type Description
	 * duration int Passed to the program to tell it how long to wait
	 */
	private void sleeper(int duration) {
		try {
			Thread.sleep(duration);
		} catch (Exception e) {

		}
	}

	/*
	 * In background (), the program colours in the background by filling it up one
	 * strip at a time
	 * VariableName Type Description
	 * i int used in the for loop
	 */
	public void background() {
		c.setColor(new Color(88, 166, 188));
		for (int i = 200; i >= -200; i -= 10) {
			c.fillRect(sqX, c.getHeight() / 2 + i, 400, 10);
			// wait to animate
			sleeper(20);
		}
	}

	// in names () the program displays our names on the screen
	public void names() {

		c.setColor(Color.black);
		c.setFont(new Font("Times New Roman", Font.BOLD, 30));
		c.drawString("Virtual Bead Loom", c.getWidth() / 2 - "Virtual Bead Loom".length() * 7, 35);
		c.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		c.drawString("Created by Maya Peski and Julia Peng", c.getWidth() / 2 - 40, c.getHeight() - 10);

	}

	// in borders() the program colours in the white borders. Since in our corners()
	// method, we outside of the square, we call borders() from corners() to clean
	// up the console
	public void borders() {
		c.setColor(Color.white);
		c.fillRect(0, 0, sqX, c.getHeight());
		c.fillRect(0, 0, c.getWidth(), sqY);
		c.fillRect(0, c.getHeight() - sqY, c.getWidth(), 200);
		c.fillRect(c.getWidth() - sqX, 0, 200, c.getHeight());

	}

	/*
	 * In drawLines(), the prpgram draws the white bars comng out of the centre. It
	 * has one line for each direction
	 * VariableName Type Description
	 * i int used in the for loop
	 */
	public void drawLines() {
		for (int i = 0; i < 9; i++) {
			c.setColor(new Color(19, 136, 8));
			c.fillRect(sqX + 170 - i * 10, sqY + 170 + (int) Math.round((i / 5.0) + 0.4) * 10, 10,
					60 - (int) Math.round((i / 5.0) + 0.4) * 20); // left/right
			c.fillRect(sqX + 220 + i * 10, sqY + 170 + (int) Math.round((i / 5.0) + 0.4) * 10, 10,
					60 - (int) Math.round((i / 5.0) + 0.4) * 20);
			c.fillRect(sqX + 170 + (int) Math.round(i / 5.0 + 0.4) * 10, sqY + 170 - i * 10,
					60 - (int) Math.round(i / 5.0 + 0.4) * 20, 10); // up/down
			c.fillRect(sqX + 170 + (int) Math.round(i / 5.0 + 0.4) * 10, sqY + 220 + i * 10,
					60 - (int) Math.round(i / 5.0 + 0.4) * 20, 10);
			sleeper(50);
		}
	}

	/*
	 * In drawMiddleCircle(), the red square in the centre is drawn
	 * VariableName Type Description
	 * i int used in the for loop
	 */
	public void drawMiddleCircle() {
		c.setColor(new Color(221, 0, 0));
		for (int i = 3; i > -3; i--) {
			c.fillRect(sqX + 160 + (int) Math.round(Math.abs(i - 0.5)) * 10, sqY + 200 - i * 10,
					70 - (int) Math.abs(Math.round((i - 0.5) * 20)), 10);
			sleeper(50);
		}
	}

	/*
	 * In drawRing(), the program draws the "ring" by drawing an outside circle and
	 * then an inside circle. It makes a fake grid, then uses the equation y^2 =
	 * r^2-x^2 to draw this circle, then rounds the number it gets to the nearest
	 * 10.
	 * VariableName Type Description
	 * x0 int the x coordinate of the (0,0) of the ring
	 * y0 int the y coordinate of the (0,0) of the ring
	 * y int used in the for loop: the descending y coordinate on the axis
	 * outr int the radius of the outer circle
	 * inr int the radius of the inner circle
	 * outx int the x coordinate of the outer circle relative to the y coordinate
	 * and the radius
	 * inx int the x coordinate of the inner circle relative to the y coordinate and
	 * the radius
	 */
	public void drawRing() {
		int x0 = sqX + 200;
		int y0 = sqY + 195;
		int outx = 0;
		int inx = 0;
		int outr = 165;
		int inr = 120;
		for (int y = outr; y >= -outr; y -= 10) {
			outx = (int) Math.sqrt(outr * outr - y * y);

			if (Math.abs(y) <= inr) {
				inx = (int) Math.sqrt(inr * inr - y * y);
			} else {
				inx = 0;
			}
			// rounding
			outx = Math.round(outx / 10) * 10;
			inx = Math.round(inx / 10) * 10;
			// outer circle
			c.setColor(new Color(148, 226, 248));
			c.fillRect(x0 - outx, y0 + y, outx * 2, 10);
			// inner circle
			c.setColor(new Color(255, 204, 0));
			c.fillRect(x0 - inx, y0 + y, inx * 2, 10);
			sleeper(20);
		}
	}

	/*
	 * In drawCorners(), the corners are drawn by drawing three "lines" of beads,
	 * offset by one bead, and everything that goes outside the 400x400 square is
	 * covered up by the borders method.
	 * VariableName Type Description
	 * i int used in the for loop
	 * j int used in the nested for loop
	 */
	public void drawCorners() // method to draw corners
	{
		for (int i = 0; i <= 40; i += 20) {
			for (int j = 0; j <= 40; j += 20) {
				// setting incrementing colour
				c.setColor(new Color(148 - i, 226 - i, 248 - i));
				c.fillRect(sqX + j, sqY + i - j, 20, 20);
				c.fillRect(sqX + j * -1 + 380, sqY + i - j, 20, 20);
				c.fillRect(sqX + j + 340, sqY + 420 - i - j, 20, 20);
				c.fillRect(sqX + j * -1 + 40, sqY + 420 - i - j, 20, 20);
				borders();
				sleeper(30);
			}
		}
	}

	/*
	 * In drawRays(), the red rays coming out from the sun are drawn. The first for
	 * loop draws the straight rays, and the second for loop draws the diagonal
	 * rays.
	 * VariableName Type Description
	 * i int used in the for loop
	 */
	public void drawRays() {
		c.setColor(new Color(221, 0, 0));
		for (int i = 3; i > 0; i--) // straight rays
		{
			// vertical rays
			c.fillRect(sqX + 200 - i * 10, sqY + 40 + Math.abs((i - 1)) * 20, 10,
					20 + (int) Math.abs(Math.round((i - 3) * 1.4)) * 10);
			c.fillRect(sqX + 190 + i * 10, sqY + 40 + Math.abs((i - 1)) * 20, 10,
					20 + (int) Math.abs(Math.round((i - 3) * 1.4)) * 10);
			// horizontal rays
			c.fillRect(sqX + 200 - i * 10, sqY + 300 + (int) Math.round(((i * -1) + 4) / 3.0) * 10, 10,
					20 + (int) Math.abs(Math.round((i - 3) * 1.4)) * 10);
			c.fillRect(sqX + 190 + i * 10, sqY + 300 + (int) Math.round(((i * -1) + 4) / 3.0) * 10, 10,
					20 + (int) Math.abs(Math.round((i - 3) * 1.4)) * 10);

			c.fillRect(sqX + 40 + Math.abs((i - 1)) * 20, sqY + 200 - i * 10,
					20 + (int) Math.abs(Math.round((i - 3) * 1.4)) * 10, 10);
			c.fillRect(sqX + 40 + Math.abs((i - 1)) * 20, sqY + 190 + i * 10,
					20 + (int) Math.abs(Math.round((i - 3) * 1.4)) * 10, 10);

			c.fillRect(sqY + 370 + (int) Math.round(((i * -1) + 4) / 3.0) * 10, sqX + 130 - i * 10,
					20 + (int) Math.abs(Math.round((i - 3) * 1.4)) * 10, 10);
			c.fillRect(sqY + 370 + (int) Math.round(((i * -1) + 4) / 3.0) * 10, sqX + 120 + i * 10,
					20 + (int) Math.abs(Math.round((i - 3) * 1.4)) * 10, 10);
			sleeper(150);
		}

		for (int i = 1; i > -2; i--) // diagonal rays
		{
			// left side
			c.fillRect(sqX + 90 + (i + 1) * 10, sqY + 90 - (int) Math.round(Math.abs((i - 1) / 3.0)) * 10, 10,
					(-2 * Math.abs(i) + 6) * 10);
			c.fillRect(sqY + 160 - (int) Math.round(Math.abs((i - 1) / 3.0)) * 10, sqX + 20 + (i + 1) * 10,
					(-2 * Math.abs(i) + 6) * 10, 10);

			c.fillRect(sqY + 160 - (int) Math.round(Math.abs((i + 1) / 3.0)) * 10, sqX + 210 + (i + 1) * 10,
					(-2 * Math.abs(i) + 6) * 10, 10);
			c.fillRect(sqX + 90 + (i + 1) * 10,
					sqY + 310 - (-2 * Math.abs(i) + 6) * 10 + (int) Math.round(Math.abs(i - 1) / 3.0) * 10, 10,
					(-2 * Math.abs(i) + 6) * 10);
			// right side
			c.fillRect(sqX + 310 - (-2 * Math.abs(i) + 6) * 10 + (int) Math.round(Math.abs((i + 1) / 3.0)) * 10,
					sqY + 280 + (i + 1) * 10, (-2 * Math.abs(i) + 6) * 10, 10);
			c.fillRect(sqX + 300 - (i + 1) * 10,
					sqY + 310 - (-2 * Math.abs(i) + 6) * 10 + (int) Math.round(Math.abs(i - 1) / 3.0) * 10, 10,
					(-2 * Math.abs(i) + 6) * 10);

			c.fillRect(sqX + 300 - (i + 1) * 10, sqY + 90 - (int) Math.round(Math.abs((i - 1) / 3.0)) * 10, 10,
					(-2 * Math.abs(i) + 6) * 10);
			c.fillRect(sqX + 310 - (-2 * Math.abs(i) + 6) * 10 + (int) Math.round(Math.abs((i + 1) / 3.0)) * 10,
					sqY + 110 - (i + 1) * 10, (-2 * Math.abs(i) + 6) * 10, 10);
			sleeper(150);
		}
	}

	/*
	 * In drawEmbellishments(),the yellow embellishments are drawn. In the first for
	 * loop the "straight" embellishments (the crosses at the end of the lines) are
	 * drawn, and in the second for loop the "diagonal" embellishments (the two
	 * squares at the end of the rays) are drawn
	 * VariableName Type Description
	 * i int used in the for loop
	 */
	public void drawEmbellishments() {
		c.setColor(new Color(255, 204, 0));
		for (int i = 2; i > -2; i--) // straight embellishments
		{
			// vertical embellishments
			c.fillRect(sqX + 180 + (int) Math.round((Math.abs(i * 2 - 1) * 0.25)) * 10, sqY + 20 - i * 10,
					40 - (int) Math.round(Math.abs((i) * 0.5 - 0.25)) * 20, 10);
			c.fillRect(sqX + 180 + (int) Math.round((Math.abs(i * 2 - 1) * 0.25)) * 10, sqY + 380 - i * 10,
					40 - (int) Math.round(Math.abs((i) * 0.5 - 0.25)) * 20, 10);
			// horizontal embellishments
			c.fillRect(sqX + (int) Math.round((Math.abs(i * 2 - 1) * 0.25)) * 10, sqY + 200 - i * 10,
					40 - (int) Math.round(Math.abs((i) * 0.5 - 0.25)) * 20, 10);
			c.fillRect(sqX + 360 + (int) Math.round((Math.abs(i * 2 - 1) * 0.25)) * 10, sqY + 180 + 20 - i * 10,
					40 - (int) Math.round(Math.abs((i) * 0.5 - 0.25)) * 20, 10);
			// wait to animate
			sleeper(100);
		}

		for (int i = 1; i > -2; i--) // diagonal embellishments
		{
			// left side of the diagonal embellishments
			c.fillRect(sqX + 60 + (int) Math.round(Math.abs((i - 1) / 3.0)) * 10, sqY + 60 - (i - 1) * 10,
					30 - Math.abs(i * 10), 10);
			c.fillRect(sqX + 60 + (int) Math.round(Math.abs((i - 1) / 3.0)) * 10, sqY + 330 + (i - 1) * 10,
					30 - Math.abs(i * 10), 10);
			// right side of the diagonal embellishments
			c.fillRect(sqX + 310 + (int) Math.round(Math.abs((i - 1) / 3.0)) * 10, sqY + 310 - (i - 1) * 10,
					30 - Math.abs(i * 10), 10);
			c.fillRect(sqX + 310 + (int) Math.round(Math.abs((i - 1) / 3.0)) * 10, sqY + 80 + (i - 1) * 10,
					30 - Math.abs(i * 10), 10);
			// wait to animate
			sleeper(100);
		}
	}

	/*
	 * In drawMotif(), the green motifs near the centre are drawn. The two for loops
	 * draw the diagonal lines, and the next lines draw the two squares
	 * VariableName Type Description
	 * i int used in the for loop
	 */
	public void drawMotif() {
		for (int i = 1; i <= 5; i++) {
			c.setColor(new Color(19, 136, 8));
			c.fillRect(sqX + 190 - (i + 2) * 10, sqY + 270 - (i - 1) * 10, 10, 10);
			c.fillRect(sqX + 210 + (i + 1) * 10, sqY + 270 - (i - 1) * 10, 10, 10);
			c.fillRect(sqX + 190 - (i + 2) * 10, sqY + 130 + (i - 2) * 10, 10, 10);
			c.fillRect(sqX + 200 + (i + 1) * 10 + 10, sqY + 190 - 60 + (i - 2) * 10, 10, 10);
			// wait to animate
			sleeper(100);
		}

		for (int i = 0; i < 6; i++) {
			c.fillRect(sqX + 180 - (i + 2) * 10, sqY + 270 - (i - 1) * 10, 10, 10);
			c.fillRect(sqX + 220 + (i + 1) * 10, sqY + 270 - (i - 1) * 10, 10, 10);
			c.fillRect(sqX + 180 - (i + 2) * 10, sqY + 130 + (i - 2) * 10, 10, 10);
			c.fillRect(sqX + 210 + (i + 1) * 10 + 10, sqY + 190 - 60 + (i - 2) * 10, 10, 10);
			sleeper(100);
		}
		// top square
		c.fillRect(sqX + 140, sqY + 140, 20, 20);
		c.fillRect(sqX + 240, sqY + 140, 20, 20);
		c.fillRect(sqX + 140, sqY + 240, 20, 20);
		c.fillRect(sqX + 240, sqY + 240, 20, 20);
		// wait to animate
		sleeper(100);
		// bottom square
		c.fillRect(sqX + 150, sqY + 150, 20, 20);
		c.fillRect(sqX + 230, sqY + 150, 20, 20);
		c.fillRect(sqX + 150, sqY + 230, 20, 20);
		c.fillRect(sqX + 230, sqY + 230, 20, 20);
	}

	// the main method. Calls every single method except for sleeper() and borders()
	// in the order that we would like them to be animated in
	public static void main(String[] args) {
		// creating a new BeadLoom object
		BeadLoom a = new BeadLoom();

		a.background();
		a.drawRing();
		a.drawLines();
		a.drawMiddleCircle();
		a.drawRays();
		a.drawEmbellishments();
		a.drawMotif();
		a.drawCorners();
		a.names();
	}
}
