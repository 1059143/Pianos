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
            this.Musical = Font.createFont(Font.TRUETYPE_FONT, new File("MusiSync.ttf")).deriveFont(80f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("MusiSync.ttf")));
        } catch (IOException | FontFormatException e) {

        }

        this.setFont(this.Musical);
        this.setBackground(Color.WHITE);
        // x,y,width,height
        this.setBounds(800,400,300,80);
        this.setText("›››"); // ����
        this.frame.getContentPane().add(this);
        this.setVisible(true);





    }
}
