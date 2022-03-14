import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Key extends JButton {
	
	private Color backGround, foreGround;
	private boolean isMinor;
	private JFrame frame;
	private  int WIDTH = 107;
	private int startPos = 37;
	
	
	
	private String[] noteName =  {"C","D","E","F","G","A","B"};
	
	public Key(JFrame KeyBoard, int i) {
		this.frame = KeyBoard;
		int noteRemainder = i % this.noteName.length;
//		frame.setBounds(100, 100, 1244, 733);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		this.backGround = Color.white;
		this.setBackground(backGround);
		setTheFont(26);
		this.setBounds(getLeft(i, false), 280, 97, 287);
		this.frame.getContentPane().add(this);
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "C");
		this.frame.setVisible(true);
		
		switch(noteRemainder) {
			case 0:
				this.setText(noteName[noteRemainder]);
				break;
			case 1:
				this.setText(noteName[noteRemainder]);
				break;
			case 2:
				this.setText(noteName[noteRemainder]);
				break;
			case 3:
				this.setText(noteName[noteRemainder]);
				break;
			case 4:
				this.setText(noteName[noteRemainder]);
				break;
			case 5:
				this.setText(noteName[noteRemainder]);
				break;
			case 6:
				this.setText(noteName[noteRemainder]);
				break;
		}
	}
//		Action aa = new AbstractAction()
//		   {
//				@Override
//			  public void actionPerformed(ActionEvent e)
//			   {
//				  mc[5].noteOn(60, 600);                      
//			   }
//		   };			
//		this.getActionMap().put("C", aa);
//		this.addActionListener(aa);
	
	public int getLeft(int i, boolean isMinor) {
		if(!isMinor) {
			return this.startPos + i * this.WIDTH;
			
			
			
		} else if(isMinor) {
			this.startPos = 79;
			if(i % 5 > 1) {
				return this.startPos + (i-1) * this.WIDTH + 177;
			} else { 
				return this.startPos + i * this.WIDTH;
			}
			
		}
		return 0;
		
	}

	
	
	public void setWIDTH(int x) {
		this.WIDTH = x;
	}

	public void setTheFont(int x) {
		this.setFont(new Font("Tahoma", Font.PLAIN, x));
	}
}
