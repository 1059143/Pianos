import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Note extends JLabel {
	
	private Font Musical;
	
	public Note(JFrame KeyBoard, int i) {
		
		
	
	     try {
	            this.Musical = Font.createFont(Font.TRUETYPE_FONT, new File("MusiSync.ttf")).deriveFont(70f);
	            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("MusiSync.ttf")));
	        } catch (IOException | FontFormatException e) {

	        }
	

	    this.setFont(this.Musical);
	    this.setBackground(Color.WHITE);
	    this.setText("q");
		
		this.setVisible(false);
		

		KeyBoard.getContentPane().add(this);
	
		
		
	}
	

	
	
	
}