// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurGaucheMilieu2Droit.java

package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.PrintStream;
import javax.swing.*;

// Referenced classes of package GUI:
//            ConteneurGaucheMilieu2

public class ConteneurGaucheMilieu2Droit extends JPanel
{
    class puissanceAllLedListener
        implements KeyListener
    {

    	public void keyPressed(KeyEvent e) {
        	if (e.getKeyCode()==KeyEvent.VK_ENTER){
    	        sendAllLeds();
    	        
    	    }
        }
        
        public void keyTyped(KeyEvent e)
        {
        }
        
        public void keyReleased(KeyEvent e)
        {
        }
    }
    
    public void sendAllLeds(){
    	int value = 0;
        try
        {
            value = Integer.parseInt(puissanceAllLed.getText());
            if(value > -1 && value < 4096)
                conteneurGaucheMilieu2.setAllLed((new StringBuilder("ALL")).append(value).append("$").toString());
            else
                System.out.println("Debut : Error, wrong value!!!");
        }
        catch(NumberFormatException arg)
        {
            System.out.println("Error : wrong number format");
        }
    }

    class sendAllLedButtonListenener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            sendAllLeds();
        }

        final ConteneurGaucheMilieu2Droit this$0;

        sendAllLedButtonListenener()
        {
        	super();
        	this$0 = ConteneurGaucheMilieu2Droit.this;
            
        }
    }


    ConteneurGaucheMilieu2Droit(ConteneurGaucheMilieu2 conteneurGaucheMilieu2)
    {
        sendAllLedButton = new JButton("Send PWM for all LEDs");
        puissanceAllLed = new HintTextField("Power(0-4095)");
        this.conteneurGaucheMilieu2 = conteneurGaucheMilieu2;
        setBorder(BorderFactory.createTitledBorder("DIM all LEDs"));
        puissanceAllLed.setPreferredSize(new Dimension(300, 25));
        setLayout(new BorderLayout());
        add(puissanceAllLed, "North");
        add(sendAllLedButton, "Center");
        puissanceAllLed.addKeyListener(new puissanceAllLedListener());
        sendAllLedButton.addActionListener(new sendAllLedButtonListenener());
    }

    public void activateButtonSetAllLed(boolean bool)
    {
        sendAllLedButton.setEnabled(bool);
    }

    ConteneurGaucheMilieu2 conteneurGaucheMilieu2;
    private JButton sendAllLedButton;
    private JTextField puissanceAllLed;

}
