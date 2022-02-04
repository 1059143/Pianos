// package piano_s;

import java.awt.*;
import javax.sound.midi.*;

class Main {
  public static void main(String[]args) throws MidiUnavailableException {
    // pianos piano = new pianos();
    EventQueue.invokeLater(new Runnable(){
      public void run() {
        try {
          pianos window = new pianos();
        //   window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}