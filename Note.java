import javax.swing.*;
import java.awt.*;


public class Note extends MusicStaff {
	
	
	public Note(JFrame KeyBoard, int i) {
		
		
		super(KeyBoard);
		
		
//		this.setBounds(850, 375 - i * 10, 300, 80);
	
		
		this.setVisible(false);
		

		KeyBoard.getContentPane().add(this);
	
		
		
	}
	

	
	
	
}