// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurDroit1Haut.java

package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintStream;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

// Referenced classes of package GUI:
//            ConteneurDroit1

public class ConteneurDroit1Haut extends JPanel
{
    class timeBetweenTwoPicsListener
        implements KeyListener, DocumentListener
    {
    	public void keyPressed(KeyEvent e) {
			if (e.getKeyCode()==KeyEvent.VK_ENTER){
    	        getParameters();
    	    }
			
		}

		@Override
		public void keyReleased(KeyEvent e) {		
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			verifyTP();
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			verifyTP();
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			verifyTP();
		}
    }


    ConteneurDroit1Haut(ConteneurDroit1 conteneurDroit1)
    {
        timeBetweenTwoPicsLabel = new JLabel("Delay between two pics (ms)");
        timeBetweenTwoPicsField = new JTextField("200");
        this.conteneurDroit1 = conteneurDroit1;
        setPreferredSize(new Dimension(300, 600));
        setLayout(new BorderLayout());
        timeBetweenTwoPicsField.setPreferredSize(new Dimension(50, 10));
        add(timeBetweenTwoPicsLabel, "West");
        add(timeBetweenTwoPicsField, "East");
        timeBetweenTwoPicsField.addKeyListener(new timeBetweenTwoPicsListener());
        timeBetweenTwoPicsField.getDocument().addDocumentListener(new timeBetweenTwoPicsListener());
        sTP=200;
    }

    public void activateParameters(boolean bool)
    {
        timeBetweenTwoPicsField.setEditable(bool);
    }

    public void getParameters()
    {
    	try
        {
            if(!timeBetweenTwoPicsField.getText().equals(""))
                conteneurDroit1.setTimeBetweenTwoPics((new StringBuilder("TP")).append(Integer.parseInt(timeBetweenTwoPicsField.getText())).append("$").toString());
        }
        catch(NumberFormatException arg)
        {
            System.out.println("Error : wrong number format");
        }
    }
    
    public void getTimeBetweenTwoPics(int value)
    {
        sTP=value;
        verifyTP();
    }
    
    private void verifyTP(){
    	try
        {
			if(sTP==Integer.parseInt(timeBetweenTwoPicsField.getText())){
				timeBetweenTwoPicsField.setForeground(Color.BLACK);

			}else{
				timeBetweenTwoPicsField.setForeground(Color.GRAY);
			}
		}
        catch(NumberFormatException arg)
        {
            System.out.println("Error : wrong number format");
        }
    }

    ConteneurDroit1 conteneurDroit1;
    private JLabel timeBetweenTwoPicsLabel;
    private JTextField timeBetweenTwoPicsField;
    private int sTP;

}
