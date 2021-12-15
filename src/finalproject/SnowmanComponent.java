package finalproject;

/** @author sak5680 */ 

import java.awt.*;
import javax.swing.*;

public class SnowmanComponent extends JComponent{
    
    private Color bgColor;
    private Color hatColor;
    
    public void setHatColor(String c){
        if(c.equals("black")){
            hatColor = Color.BLACK;
        }
        else if (c.equals("blue")){
            hatColor = Color.BLUE;
        } 
        else if (c.equals("green")){
            hatColor = Color.GREEN;
        } 
    }
    
    public void setTime(String t){
        if(t.equals("day")){
            Color skyBlue = new Color(123,311,247);
            bgColor = skyBlue;
        }
        else if (t.equals("night")){
            bgColor = Color.BLACK;
        }  
    }
    
    public void createSnowman(Graphics g){
        Color brown = new Color(165,42,42);
        Color snow = new Color(211,211,211);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,425,400);
        g.setColor(snow);
        g.fillRect(0,310,425,90);
        g.setColor(Color.WHITE);
        g.fillOval(112,65,75,75);
        g.fillOval(103,135,90,90);
        g.fillOval(100,215,100,100);
        g.setColor(Color.BLACK);
        g.fillOval(143,150,15,15);
        g.fillOval(143,170,15,15);
        g.fillOval(143,190,15,15);
        g.fillOval(120,110,7,7);
        g.fillOval(130,117,7,7);
        g.fillOval(140,120,7,7);
        g.fillOval(150,120,7,7);
        g.fillOval(160,117,7,7);
        g.fillOval(170,110,7,7);
        g.fillOval(135,85,10,10);
        g.fillOval(155,85,10,10);
        g.fillOval(145,100,8,8);
        g.setColor(brown);
        g.drawLine(103, 180, 53, 160);
        g.drawLine(193, 180, 243, 160);
    }
    
}