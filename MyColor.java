import java.awt.Color;

public class MyColor {


	public static void main(String[]args) {
Float redVal = (float) 0.0;
Float blueVal =(float) 0.0;
Float greenVal = (float) 0.0;
	Color c1 = new Color(redVal, blueVal, greenVal);
	Color c2 = new Color(redVal, blueVal, greenVal);	
c2 = c1.brighter().brighter() ;
System.out.println(c2.getRed() + c2.getBlue() + c2.getGreen() );
}	


}
