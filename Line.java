import java.awt.Color;

public class Line {
	int x;
	int y;
	int x2;
	int y2;
	Color c;
	
	
	
	public Line(int x, int y, int x2, int y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
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

	public int getX2() {
		return x2;
	}
	
	public int getY2() {
		return y2;
	}

}
