import javax.swing.*;
import java.awt.*;


public class Note extends MusicStaff {
	
	
	public Note(JFrame KeyBoard, int i, boolean isMinor) {
		
		
		super(KeyBoard);
		
		
		this.setBounds(850, 425 - i * 10, 300, 80);
		if(!isMinor ) {
			this.setText("q");
		} else {
			this.setText("B");
		}
		
		this.setVisible(false);
		

		KeyBoard.getContentPane().add(this);
	
		
		
	}
	

	
	
	
}