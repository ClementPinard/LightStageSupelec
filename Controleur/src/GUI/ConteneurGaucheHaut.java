// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurGaucheHaut.java

package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Referenced classes of package GUI:
//            ConteneurGauche

public class ConteneurGaucheHaut extends JPanel
{
    class refreshButtonListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            try
            {
                conteneurGauche.refresh();
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }
        }

        final ConteneurGaucheHaut this$0;

        refreshButtonListener()
        {
        	super();
        	this$0 = ConteneurGaucheHaut.this;
            
        }
    }


    ConteneurGaucheHaut(ConteneurGauche conteneurGauche)
    {
        monLabelPortCom = new JLabel("State  : Not connected");
        refreshButton = new JButton("Refresh & connect");
        this.conteneurGauche = conteneurGauche;
        setBorder(BorderFactory.createTitledBorder("PC <=> Light Stage Connection"));
        setLayout(new BorderLayout());
        add(monLabelPortCom, "West");
        add(refreshButton, "East");
        refreshButton.addActionListener(new refreshButtonListener());
    }

    public void writeState(String stateConnected)
    {
        monLabelPortCom.setText(stateConnected);
    }

    public void activateButtonState(boolean bool)
    {
        refreshButton.setEnabled(bool);
    }

    private JLabel monLabelPortCom;
    private JButton refreshButton;
    private ConteneurGauche conteneurGauche;

}
