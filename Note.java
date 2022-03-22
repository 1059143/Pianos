import javax.swing.*;
import java.awt.*;


public class Note extends MusicStaff {
	
	
	public Note(JFrame KeyBoard) {
		
		
		super(KeyBoard);
		
		
		this.setBounds(850, 420, 200, 80);
		this.setText("q");
		this.setVisible(false);

		KeyBoard.getContentPane().add(this);
	
		
		
	}
	
	
	
	
	
}