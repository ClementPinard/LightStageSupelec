// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Help.java

package GUI;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Help extends JFrame
{

    public Help()
    {
        area = new JTextArea();
        setTitle("Help : Light Stage Sup\351lec - Control Software");
        setSize(640, 360);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        font = new Font("Cambria", 0, 24);
        area.setFont(font);
        area.setForeground(Color.BLACK);
        area.setText("For any enquiry you can  contact the authors here :\n v1.0 vincent.gouldieff@supelec.fr \n v1.01 clement.pinard@supelec.fr");
        add(area, "Center");
        area.setEditable(false);
    }

    JTextArea area;
    Font font;
}
