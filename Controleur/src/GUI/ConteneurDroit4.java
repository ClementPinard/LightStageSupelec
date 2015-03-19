// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurDroit4.java

package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Referenced classes of package GUI:
//            About, Help, ConteneurDroit

public class ConteneurDroit4 extends JPanel
{
    class aboutButtonListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            try
            {
                about.setVisible(true);
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }
        }
    }

    class helpButtonListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            try
            {
                help.setVisible(true);
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }
        }
    }


    ConteneurDroit4(ConteneurDroit conteneurDroit)
    {
        helpButton = new JButton("Help");
        aboutButton = new JButton("About");
        about = new About();
        help = new Help();
        this.conteneurDroit = conteneurDroit;
        setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(30, 150));
        setLayout(new GridLayout(1,2));
        add(helpButton);
        add(aboutButton);
        aboutButton.addActionListener(new aboutButtonListener());
        helpButton.addActionListener(new helpButtonListener());
    }

    ConteneurDroit conteneurDroit;
    private JButton helpButton;
    private JButton aboutButton;
    About about;
    Help help;
}
