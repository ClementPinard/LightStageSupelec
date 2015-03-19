// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AboutMilieu.java

package GUI;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutMilieu extends JPanel
{

    AboutMilieu()
    {
        label5 = new JTextArea("");
        label6 = new JTextArea("");
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(640, 150));
        setLayout(new BorderLayout());
        font = new Font("Cambria", 0, 16);
        label5.setFont(font);
        label5.setForeground(Color.BLACK);
        label5.setText("      ---The CEI Light Stage Supelec Team--- \nv1.00\n                     Corentin Guezenoc\n                       Geoffrey Thierry\n                       Florent Fournier\n                      Vincent Gouldieff\nv1.01\n                      Arthur Derennes\n                      Clément Pinard");
        add(label5, "West");
        label5.setEditable(false);
        font = new Font("Cambria", 0, 16);
        label6.setPreferredSize(new Dimension(300, 200));
        label6.setFont(font);
        label6.setForeground(Color.BLACK);
        label6.setText("This application has been tested under \nWindows 7, 8 & 8.1 64-bits/32-bits\n\nIt needs RXTXcomm.jar (LGPL License) \nand RXTXSerial.dll (LGPL License) \nto run mbed communications\nIt needs gphoto2 (GPL License) \nand libusb (GPL License) \nto run Camera control");
        add(label6, "East");
        label6.setEditable(false);
    }

    JTextArea label5;
    JTextArea label6;
    Font font;
}
