import javax.swing.*;

public class KeyBoard extends JFrame {
	
	private Key[] listOfMajorKeys = new Key[10];
	private mKey[] listOfMinorKeys = new mKey[5];
	
	public KeyBoard() {
		this.setBounds(100, 100, 1244, 733);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		for(int i = 0; i <  listOfMajorKeys.length; i++)  setKey(i);
	}
	
	public void setKey(int i) {
		listOfMajorKeys[i] = new Key(this, i);
	}
}