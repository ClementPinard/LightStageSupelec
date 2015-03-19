// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurGaucheMilieu1.java

package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

// Referenced classes of package GUI:
//            ConteneurGaucheMilieu

public class ConteneurGaucheMilieu1 extends JPanel
{
    class demo1ButtonListener
        implements ItemListener
    {

        public void itemStateChanged(ItemEvent e)
        {
            if(e.getStateChange() == 1)
                try
                {
                    conteneurGaucheMilieu.launchDemo1();
                    demo1Button.setText("Demo1 runs");
                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
            else
                try
                {
                    conteneurGaucheMilieu.stopDemo1();
                    demo1Button.setText("Demo1");
                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
        }

        final ConteneurGaucheMilieu1 this$0;

        demo1ButtonListener()
        {
        	super();
        	this$0 = ConteneurGaucheMilieu1.this;
            
        }
    }

    class demo2ButtonListener
        implements ItemListener
    {

        public void itemStateChanged(ItemEvent e)
        {
            if(e.getStateChange() == 1)
                try
                {
                    conteneurGaucheMilieu.launchDemo2();
                    demo2Button.setText("Demo2 runs");
                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
            else
                try
                {
                    conteneurGaucheMilieu.stopDemo2();
                    demo2Button.setText("Demo2");
                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
        }

        final ConteneurGaucheMilieu1 this$0;

        demo2ButtonListener()
        {
        	super();
        	this$0 = ConteneurGaucheMilieu1.this;
            
        }
    }

    class demo3ButtonListener
        implements ItemListener
    {

        public void itemStateChanged(ItemEvent e)
        {
            if(e.getStateChange() == 1)
                try
                {
                    conteneurGaucheMilieu.launchDemo3();
                    demo3Button.setText("Demo3 runs");
                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
            else
                try
                {
                    conteneurGaucheMilieu.stopDemo3();
                    demo3Button.setText("Demo3");
                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
        }

        final ConteneurGaucheMilieu1 this$0;

        demo3ButtonListener()
        {
        	super();
        	this$0 = ConteneurGaucheMilieu1.this;
            
        }
    }


    ConteneurGaucheMilieu1(ConteneurGaucheMilieu conteneurGaucheMilieu)
    {
        demo1Button = new JToggleButton("Demo 1");
        demo2Button = new JToggleButton("Demo 2");
        demo3Button = new JToggleButton("Demo 3");
        this.conteneurGaucheMilieu = conteneurGaucheMilieu;
        setBorder(BorderFactory.createTitledBorder("Demo Patterns (Amazing light effects inside)"));
        setPreferredSize(new Dimension(300, 53));
        setLayout(new GridLayout(1, 3));
        add(demo1Button);
        add(demo2Button);
        add(demo3Button);
        demo1Button.addItemListener(new demo1ButtonListener());
        demo2Button.addItemListener(new demo2ButtonListener());
        demo3Button.addItemListener(new demo3ButtonListener());
    }

    public void activateButtonDemo1(boolean bool)
    {
        demo1Button.setEnabled(bool);
    }

    public void activateButtonDemo2(boolean bool)
    {
        demo2Button.setEnabled(bool);
    }

    public void activateButtonDemo3(boolean bool)
    {
        demo3Button.setEnabled(bool);
    }

    ConteneurGaucheMilieu conteneurGaucheMilieu;
    private JToggleButton demo1Button;
    private JToggleButton demo2Button;
    private JToggleButton demo3Button;



}
