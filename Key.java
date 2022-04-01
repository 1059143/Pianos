import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.sound.midi.*;
import javax.swing.*;

public class Key extends JButton {

  private Color backGround, foreGround;
  private boolean isMinor;
  private JFrame frame;
  private int WIDTH = 107;
  private int startPos = 37;

  private Note note;

  private static final String[] noteName = { "C", "D", "E", "F", "G", "A", "B" };
  private int noteNumber = 60;

  public Key(JFrame KeyBoard, int i, boolean minorKey) {

    this.frame = KeyBoard;
    int noteRemainder = i % noteName.length;
    // frame.setBounds(100, 100, 1244, 733);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.getContentPane().setLayout(null);

    this.backGround = Color.white;
    this.setBackground(backGround);
    setTheFont(26);
    this.setBounds(getLeft(i, minorKey), 280, 97, 287);
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

    this.frame.getContentPane().add(this);
    this.addActionListener(e -> selectionButtonPressed(e, i, KeyBoard, minorKey));
    this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "C");
    this.frame.setVisible(true);

  }

  public void selectionButtonPressed(ActionEvent e, int i, JFrame KeyBoard, boolean minorKey) {

    // Setting up the instrument..
    // TODO: this should be moved back to the piano at some point...
    try {
      Synthesizer synth = MidiSystem.getSynthesizer();
      Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
      MidiChannel[] mc = synth.getChannels();
      
      
      ShortMessage msg = new ShortMessage();
      

      synth.open();

      synth.loadInstrument(instr[90]);
      msg.setMessage(ShortMessage.PROGRAM_CHANGE, 5, 115, 0);
      synth.getReceiver().send(msg, -1);
      

      System.out.println(e.paramString());

      

      int tmp = i + this.noteNumber;

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
        
        

        this.note.setBounds(850, 425 - i * 10, 300, 80);
        this.note.setText("q");



      } else if (minorKey) {

        if (i % 5 == 2) {
          mc[5].noteOn(2 * (i - 1) + 61 + 3, 600);

          System.out.println(2 * (i - 1) + 61 + 3);
        } else if (i % 5 > 2) {
          mc[5].noteOn(2 * (i - 1) + 61 + 3, 600);
          System.out.println(2 * (i - 1) + 61 + 3);

        } else {
          mc[5].noteOn(2 * i + 61, 600);
          System.out.println(2 * i + 61);
        }

        this.note.setBounds(810, 425 - i * 10, 300, 80);
        this.note.setText("B q");



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
      return this.startPos + i * this.WIDTH;

    } else if (isMinor) {
      this.startPos = 79;
      if (i % 5 > 1) {
        return this.startPos + (i - 1) * this.WIDTH + 177;
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
