import javax.swing.*;
import java.awt.Color;

public class mKey extends Key {
	
	private JFrame frame;
	
	
	public mKey(JFrame KeyBoard, int i) {
		
		
		super(KeyBoard, i);
		
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		if(i % 7 != 2 && i % 7 != 0) {
			setWIDTH(126);
		} else {
			setWIDTH(177);
		}
		
		setStart(79);
		setBounds(getLeft(i), 57, 116, 212);
		
		
		
	}
}