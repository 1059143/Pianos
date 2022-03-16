import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.*;

public class MusicStaff extends JLabel {
    
    private Font Musical;
    private JFrame frame;
    

    public MusicStaff(JFrame KeyBoard) {
        this.frame = KeyBoard;
        try {
            Musical = Font.createFont(Font.TRUETYPE_FONT, new File("MusiSync.ttf")).deriveFont(60f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("MusiSync.ttf")));
        } catch (IOException | FontFormatException e) {

        }

        this.setFont(Musical);
        this.setBackground(Color.WHITE);
        // x,y,width,height
        this.setBounds(200,567,150,60);





    }
}
