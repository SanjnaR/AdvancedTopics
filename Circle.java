import java.awt.Color;

public class Circle {
	int x;
	int y;
	int w;
	Color c;
	
	
	
	public Circle(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w = w;
		c = randomColor();
	}
	
	public Color randomColor() {
		int r = (int) (Math.random() * 255);
		int g = (int) (Math.random() * 255);
		int b = (int) (Math.random() * 255);
		
		return new Color(r, g, b);
	}
	
	public Color getColor() {
		return c;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public int getW() {
		return w;
	}
	

}
