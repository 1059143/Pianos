import javax.swing.*;

public class KeyBoard extends JFrame {
	
	private Key[] listOfKeys = new Key[12];
	private MusicStaff staff = new MusicStaff(this);
	
	public KeyBoard() {
		this.setBounds(100, 100, 1244, 733);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		for(int i = 0; i < 12; i++) {
			if(i == 1 || i == 3 || i == 6 || i == 8 || i == 10) {
				listOfKeys[i] = new Key(this, i, true);
			} else {
				listOfKeys[i] = new Key(this, i, false);
			}
		}
		
		
//		for(int i = 0; i <  listOfMajorKeys.length; i++)  {
//			listOfMajorKeys[i] = new Key(this,i);
//			
//		}
		
		
		
		
	}
		
}
	
	// public void setKey(int i) {
	// 	listOfMajorKeys[i] = new Key(this, i);
	// 	listOfMinorKeys[i] = new mKey(this, i);
	// }
