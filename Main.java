package piano_s;

import java.awt.*;

class Main {
  public static void main(String[]args) {
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