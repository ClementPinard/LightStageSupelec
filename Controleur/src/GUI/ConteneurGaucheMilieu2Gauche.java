// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurGaucheMilieu2Gauche.java

package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintStream;
import javax.swing.*;

// Referenced classes of package GUI:
//            ConteneurGaucheMilieu2GaucheHaut, ConteneurGaucheMilieu2

public class ConteneurGaucheMilieu2Gauche extends JPanel
{
	
    class sendOneLedButtonListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            conteneurGaucheMilieu2GaucheHaut.sendOneLed();
        }
    }


    ConteneurGaucheMilieu2Gauche(ConteneurGaucheMilieu2 conteneurGaucheMilieu2)
    {
        conteneurGaucheMilieu2GaucheHaut = new ConteneurGaucheMilieu2GaucheHaut(this);
        sendOneLedButton = new JButton("Send PWM for one LED");
        this.conteneurGaucheMilieu2 = conteneurGaucheMilieu2;
        setBorder(BorderFactory.createTitledBorder("DIM one LED"));
        setPreferredSize(new Dimension(300, 600));
        setLayout(new BorderLayout());
        add(conteneurGaucheMilieu2GaucheHaut, "North");
        add(sendOneLedButton, "Center");
        sendOneLedButton.addActionListener(new sendOneLedButtonListener());
    }

    public void activateButtonSetOneLed(boolean bool)
    {
        sendOneLedButton.setEnabled(bool);
    }

    ConteneurGaucheMilieu2 conteneurGaucheMilieu2;
    ConteneurGaucheMilieu2GaucheHaut conteneurGaucheMilieu2GaucheHaut;
    private JButton sendOneLedButton;
}
