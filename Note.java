import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class Note extends JLabel {

	private Font Musical;
	private float alpha;

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

		Timer noteTime = new Timer(3250, a -> timerForNote(a));
		noteTime.start();
		this.setVisible(false);

		KeyBoard.getContentPane().add(this);

	}

	public void timerForNote(ActionEvent a) {
		this.setVisible(false);
	}

	public void setAlpha(float value) {
		if (this.alpha != value) {
			float old = this.alpha;
			this.alpha = value;
			firePropertyChange("alpha", old, alpha);
			repaint();

		}
	}

	public float getAlpha() {
		return alpha;
	}

}