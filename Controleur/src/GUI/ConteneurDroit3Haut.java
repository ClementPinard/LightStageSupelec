// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurDroit3Haut.java

package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Referenced classes of package GUI:
//            ConteneurDroit3

public class ConteneurDroit3Haut extends JPanel
{
    class comboBeforeListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent arg0)
        {
            int index = comboBefore.getSelectedIndex();
            if(index == 0)
                conteneurDroit3.setBefore("BEFN$");
            else
            if(index == 1)
                conteneurDroit3.setBefore("BEF1$");
            else
            if(index == 2)
                conteneurDroit3.setBefore("BEF3$");
        }

        final ConteneurDroit3Haut this$0;

        comboBeforeListener()
        {
        	super();
        	this$0 = ConteneurDroit3Haut.this;
            
        }
    }


    ConteneurDroit3Haut(ConteneurDroit3 conteneurDroit3)
    {
        labelBefore = new JLabel("Flash before capture?");
        comboBefore = new JComboBox();
        this.conteneurDroit3 = conteneurDroit3;
        setPreferredSize(new Dimension(300, 600));
        setLayout(new BorderLayout());
        add(labelBefore, "West");
        comboBefore.addItem("No");
        comboBefore.addItem("Yes: 1 time");
        comboBefore.addItem("Yes: 3 times");
        comboBefore.setSelectedIndex(2);
        add(comboBefore, "East");
        comboBefore.addActionListener(new comboBeforeListener());
    }

    public void activateParameters(boolean bool)
    {
        comboBefore.setEnabled(bool);
    }

    public void getParameters()
    {
        int index = comboBefore.getSelectedIndex();
        if(index == 0)
            conteneurDroit3.setBefore("BEFN$");
        else
        if(index == 1)
            conteneurDroit3.setBefore("BEF1$");
        else
        if(index == 2)
            conteneurDroit3.setBefore("BEF3$");
    }

    ConteneurDroit3 conteneurDroit3;
    JLabel labelBefore;
    JComboBox comboBefore;
}
