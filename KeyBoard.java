import javax.swing.*;
import java.awt.*;
//			listOfMajorKeys[i] = new Key(this,i);
//			

public class KeyBoard extends JFrame {

	private Key[] listOfMajorKeys = new Key[9];
	private mKey[] listOfMinorKeys = new mKey[7];

	private MusicStaff staff = new MusicStaff(this);
	private Instrument change = new Instrument(this);

	public KeyBoard() {
		JLayeredPane pane = getLayeredPane();
		this.setBounds(100, 100, 1244, 733);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);

		for (int i = 0; i < listOfMajorKeys.length; i++) {
			listOfMajorKeys[i] = new Key(this, i, false, this.change);
			pane.add(listOfMajorKeys[i], new Integer(1));
			
		}
		for (int i = 0; i < listOfMinorKeys.length; i++) {
			listOfMinorKeys[i] = new mKey(this, i, true, this.change);
			pane.add(listOfMinorKeys[i], new Integer(2));
		}
		
		

//		for(int i = 0; i <  listOfMajorKeys.length; i++)  {
//		}l

	}

}

// public void setKey(int i) {
// listOfMajorKeys[i] = new Key(this, i);
// listOfMinorKeys[i] = new mKey(this, i);
// }
