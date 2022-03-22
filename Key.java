import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.sound.midi.*;
import javax.swing.*;


public class Key extends JButton  {

  private Color backGround, foreGround;
  private boolean isMinor;
  private JFrame frame;
  private int WIDTH = 107;
  private int startPos = 37;
  
  private Note note;
  

  private String[] noteName = { "C", "D", "E", "F", "G", "A", "B" };
  private int noteNumber = 60;
  

  public Key(JFrame KeyBoard, int i) {
	
    this.frame = KeyBoard;
    int noteRemainder = i % this.noteName.length;
    // frame.setBounds(100, 100, 1244, 733);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.getContentPane().setLayout(null);
    this.backGround = Color.white;
    this.setBackground(backGround);
    setTheFont(26);
    this.setBounds(getLeft(i, false), 280, 97, 287);
    this.frame.getContentPane().add(this);
    this.addActionListener(e -> selectionButtonPressed(e,i,KeyBoard));
    this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "C");
    this.frame.setVisible(true);

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
  }
  public void selectionButtonPressed(ActionEvent e,int i, JFrame KeyBoard){
    
    // Setting up the instrument..
    // TODO: this should be moved back to the piano at some point...
    try {
    Synthesizer synth = MidiSystem.getSynthesizer();
    Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
    MidiChannel[] mc = synth.getChannels();
		
    synth.open();
    
    
    synth.loadInstrument(instr[90]);
    
    System.out.println(e.paramString());
    
    
    this.note = new Note(KeyBoard);
    this.note.setVisible(true);
    
    int tmp = i + this.noteNumber;
    if(i % 7 != 0 ) {
    	mc[5].noteOn(tmp + 2, 600);
    	System.out.println(tmp + 2);
    } else {
    	mc[5].noteOn(tmp, 600);
    	System.out.println(tmp);
    }
    
  
  }
    catch(Exception ex){
      
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
