// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AboutHaut.java

package GUI;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutHaut extends JPanel
{

    AboutHaut()
    {
        label1 = new JTextArea("");
        label2 = new JTextArea("");
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(640, 100));
        setLayout(new GridLayout(2, 1));
        font = new Font("Cambria", 0, 22);
        label1.setFont(font);
        label1.setForeground(Color.BLACK);
        label1.setText("               Light Stage Supelec - Control Software - Version 1.01");
        add(label1);
        label1.setEditable(false);
        font = new Font("Cambria", 2, 16);
        label2.setFont(font);
        label2.setForeground(Color.BLACK);
        label2.setText("                     Written by Vincent Gouldieff for CEI Light Stage Supelec - March 2014\n                     updated by Clement Pinard - March 2015");
        add(label2);
        label2.setEditable(false);
    }

    JTextArea label1;
    JTextArea label2;
    Font font;
}
