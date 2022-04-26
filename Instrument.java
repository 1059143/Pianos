
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instrument extends JButton {

	private int instru = 0;

	private JFrame frame;

	public Instrument(JFrame KeyBoard) {

		this.frame = KeyBoard;

		this.setBounds(900, 200, 150, 60);
		this.setFont(new Font("Tahoma", Font.PLAIN, 12));

		this.setText("Change Instrument?");

		this.addActionListener(e -> selectionButtonPressed(e));
		this.frame.getContentPane().add(this);
		this.setVisible(true);

	}

	public void selectionButtonPressed(ActionEvent e) {
		String x = JOptionPane.showInputDialog("Pick a number from 0 to 128");
		this.instru = Integer.parseInt(x);
	}

	public int getInstr() {
		return this.instru;
	}
}
