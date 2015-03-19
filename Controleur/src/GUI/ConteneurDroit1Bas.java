// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurDroit1Bas.java

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

public class ConteneurDroit1Bas extends JPanel
{
	class timeBetweenTwoTypesListener
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
			verifyTT();

		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			verifyTT();
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			verifyTT();
		}
	}


    ConteneurDroit1Bas(ConteneurDroit1 conteneurDroit1)
    {
        timeBetweenTwoTypesLabel = new JLabel("Delay between two series (ms)");
        timeBetweenTwoTypesField = new JTextField("200");
        this.conteneurDroit1 = conteneurDroit1;
        setPreferredSize(new Dimension(300, 600));
        setLayout(new BorderLayout());
        timeBetweenTwoTypesField.setPreferredSize(new Dimension(50, 10));
        add(timeBetweenTwoTypesLabel, "West");
        add(timeBetweenTwoTypesField, "East");
        timeBetweenTwoTypesField.getDocument().addDocumentListener(new timeBetweenTwoTypesListener());
        timeBetweenTwoTypesField.addKeyListener(new timeBetweenTwoTypesListener());
        sTT=200;
    }

    public void activateParameters(boolean bool)
    {
        timeBetweenTwoTypesField.setEditable(bool);
    }

    public void getParameters()
    {
    	try
        {
            if(!timeBetweenTwoTypesField.getText().equals(""))
                conteneurDroit1.setTimeBetweenTwoPics((new StringBuilder("TT")).append(Integer.parseInt(timeBetweenTwoTypesField.getText())).append("$").toString());
        }
        catch(NumberFormatException arg)
        {
            System.out.println("Error : wrong number format");
        }
    }
    
    public void getTimeBetweenTwoTypes(int value)
    {
        sTT=value;
        verifyTT();
    }
    
    private void verifyTT(){
    	try
        {
			if(sTT==Integer.parseInt(timeBetweenTwoTypesField.getText())){
				timeBetweenTwoTypesField.setForeground(Color.BLACK);

			}else{
				timeBetweenTwoTypesField.setForeground(Color.GRAY);
			}
		}
        catch(NumberFormatException arg)
        {
            System.out.println("Error : wrong number format");
        }
    }

    ConteneurDroit1 conteneurDroit1;
    private JLabel timeBetweenTwoTypesLabel;
    private JTextField timeBetweenTwoTypesField;
    int sTT;

}
