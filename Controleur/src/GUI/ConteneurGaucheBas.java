// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurGaucheBas.java

package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Referenced classes of package GUI:
//            ConteneurGauche

public class ConteneurGaucheBas extends JPanel
{
    class launchButtonListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            try
            {
                conteneurGauche.launchCapture();
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }
        }

        final ConteneurGaucheBas this$0;

        launchButtonListener()
        {
        	super();
        	this$0 = ConteneurGaucheBas.this;
            
        }
    }


    ConteneurGaucheBas(ConteneurGauche conteneurGauche)
    {
        monLabelCapture = new JLabel("");
        launchButton = new JButton("Launch Capture!");
        this.conteneurGauche = conteneurGauche;
        setBorder(BorderFactory.createTitledBorder("Capture"));
        launchButton.setPreferredSize(new Dimension(180, 30));
        setLayout(new BorderLayout());
        add(monLabelCapture, "West");
        add(launchButton, "East");
        launchButton.addActionListener(new launchButtonListener());
    }

    public void writeStateCapture(String stateCapture)
    {
        monLabelCapture.setText(stateCapture);
    }

    public void activateButtonLaunch(boolean bool)
    {
        launchButton.setEnabled(bool);
    }

    private JLabel monLabelCapture;
    private JButton launchButton;
    private ConteneurGauche conteneurGauche;

}
