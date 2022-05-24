import java.awt.*;

import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.sound.midi.*;
import javax.swing.*;

public class Key extends JButton {

	private Color backGround, foreGround;
	private boolean isMinor;
	private JFrame frame;
	private int WIDTH = 85;
	private int startPos = 37;

	private Note note;
	private Instrument change;
	private Note middleN;

	private static final String[] noteName = { "C", "D", "E", "F", "G", "A", "B" };
	private int noteNumber = 60;

	public Key(JFrame KeyBoard, int i, boolean minorKey, Instrument changeInstr) {

		this.frame = KeyBoard;
		this.change = changeInstr;
		int noteRemainder = i % noteName.length;
		// frame.setBounds(100, 100, 1244, 733);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.getContentPane().setLayout(null);

		this.backGround = Color.white;
		this.setBackground(backGround);
		setTheFont(26);
		this.setBounds(getLeft(i, minorKey), 65, 86, 480);
		switch (noteRemainder) {
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

		this.note = new Note(KeyBoard, i);
		this.middleN = new Note(KeyBoard, i);

		this.frame.getContentPane().add(this);
		this.addActionListener(e -> selectionButtonPressed(e, i, KeyBoard, minorKey));

		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "C");

		this.frame.setVisible(true);

	}

	public void timerForNote(ActionEvent a) {
		this.note.setVisible(false);
	}

	public void selectionButtonPressed(ActionEvent e, int i, JFrame KeyBoard, boolean minorKey) {

		// Setting up the instrument..
		// TODO: this should be moved back to the piano at some point...
		try {
			Synthesizer synth = MidiSystem.getSynthesizer();
			javax.sound.midi.Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
			MidiChannel[] mc = synth.getChannels();

			ShortMessage msg = new ShortMessage();

			synth.open();

			synth.loadInstrument(instr[90]);
			msg.setMessage(ShortMessage.PROGRAM_CHANGE, 5, this.change.getInstr(), 0);

			synth.getReceiver().send(msg, -1);

			System.out.println(e.paramString());

			if (!minorKey) {
				if (i % 7 > 3) {
					mc[5].noteOn(2 * (i - 1) + this.noteNumber + 1, 600);
					System.out.println(2 * (i - 1) + this.noteNumber + 1);
				} else if (i % 7 == 3) {
					mc[5].noteOn(2 * (i - 1) + this.noteNumber + 1, 600);
					System.out.println(2 * (i - 1) + this.noteNumber + 1);
				} else {
					mc[5].noteOn(2 * i + this.noteNumber, 600);
					System.out.println(2 * i + this.noteNumber);
				}
				this.middleN.setBounds(910, 429, 300, 80);
				this.middleN.setText("--");
				this.note.setBounds(915, 426 - i * 8, 300, 80);

			} else if (minorKey) {
				this.note.setText("B q");

				if (i % 5 == 2) {
					this.note.setBounds(880, 418 - i * 8, 300, 80);
					mc[5].noteOn(2 * (i - 1) + 61 + 3, 600);
					System.out.println(2 * (i - 1) + 61 + 3);

				} else if (i % 5 > 2) {
					this.note.setBounds(880, 418 - i * 8, 300, 80);
					mc[5].noteOn(2 * (i - 1) + 61 + 3, 600);
					System.out.println(2 * (i - 1) + 61 + 3);

				} else {
					this.note.setBounds(880, 426 - i * 8, 300, 80);

					mc[5].noteOn(2 * i + 61, 600);
					System.out.println(2 * i + 61);
					this.middleN.setBounds(910, 429, 300, 80);
					this.middleN.setText("--");

				}

			}
			if (i == 0) {
				this.middleN.setVisible(true);
			}
			this.note.setVisible(true);

		} catch (Exception ex) {

		}

	}

	// Action aa = new AbstractAction()
	// {
	// @Override
	// public void actionPerformed(ActionEvent e)
	// {
	// mc[5].noteOn(60, 600);
	// }
	// };
	// this.getActionMap().put("C", aa);
	// this.addActionListener(aa);

	public int getLeft(int i, boolean isMinor) {
		if (!isMinor) {
			return this.startPos + i * 85;

		} else if (isMinor) {

			this.startPos = 90;
			if (i % 5 > 1) {
				return this.startPos + (i - 1) * 85 + 170;

			} else if (i % 5 == 0 && i > 0) {
				return this.startPos + (i - 1) * 85 + 255;
			} else {
				return this.startPos + i * 85;
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
