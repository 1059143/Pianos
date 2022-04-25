import java.awt.event.*;
import javax.swing.*;


import javax.sound.midi.*;


public abstract class actionEvent implements ActionListener {
	
	private int noteNumber = 60;
	private Note note;
	private Instrument change;

	public actionEvent( ActionEvent e,int i, JFrame Keyboard, boolean minorKey, Instrument change) {
		this.change = change;
		actionPerformed(e, i, Keyboard, minorKey, change);
		
		
	}
	
	public void actionPerformed(ActionEvent e, int i, JFrame KeyBoard, boolean minorKey, Instrument change) {
		
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
		        
		        

		        this.note.setBounds(880, 426 - i * 8, 300, 80);
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

		        this.note.setBounds(810, 427 - i * 9, 300, 80);
		        this.note.setText("B q");


		      }

		      this.note.setVisible(true);
		      
//		      this.note.setVisible(isItVisible(false));
		      
		  
		      

		    } catch (Exception ex) {

		    }
	}
	
}