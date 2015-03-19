// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AboutBas.java

package GUI;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutBas extends JPanel
{

    AboutBas()
    {
        label3 = new JTextArea("");
        label4 = new JTextArea("");
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(640, 120));
        font = new Font("Cambria", 0, 12);
        label3.setFont(font);
        label3.setForeground(Color.BLACK);
        label3.setText("Copyright \2512015, CentraleSupelec");
        add(label3);
        label3.setEditable(false);
        font = new Font("Cambria", 0, 12);
        label4.setFont(font);
        label4.setForeground(Color.BLACK);
        label4.setText("   This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public \n   License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later\n   version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even \n   the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public \n   License for more details. You should have received a copy of the GNU General Public Licensealong with this program. \n   If not, see <http://www.gnu.org/licenses/>.");
        add(label4);
        label4.setEditable(false);
    }

    JTextArea label3;
    JTextArea label4;
    Font font;
}
