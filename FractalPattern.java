import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.awt.geom.GeneralPath;
import java.awt.Polygon;

public class FractalPattern extends JComponent {
	private int numIterations;
	private int length;

	public FractalPattern(int iters, int aLength) {

		numIterations = iters;
		length = aLength;

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		FractalLine pattern = new FractalLine();
		int x1 = 5;
		int y1 = length / 2;
		int x2 = x1 + length; //+
		int y2 = y1;
		int x3 = x1 - (length / 2);	//change all operators +
		int y3 = (y1 - length); // +
		int x5 = x1 - (length / 2); //+
		int y5 = (y1 + length); // - 


		 pattern.draw(g2, numIterations, x1, y1, x5, y5);
		pattern.draw(g2, numIterations, x5, y5, x2, y2);
		 pattern.draw(g2, numIterations, x2, y2, x3, y3);
		 pattern.draw(g2, numIterations, x3, y3, x1, y1);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 750;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Fractal Pattern");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String input = JOptionPane.showInputDialog(null, "Number of iterations");
		if (input == null)
			System.exit(0);
		int iterations = Integer.parseInt(input);
		FractalPattern component = new FractalPattern(iterations, 700); //300
		component.setBackground(Color.RED);
		frame.setBackground(Color.RED);
		frame.add(component);
		frame.setVisible(true);
	}
}
