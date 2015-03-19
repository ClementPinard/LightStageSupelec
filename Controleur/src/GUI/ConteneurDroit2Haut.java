// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurDroit2Haut.java

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
//            ConteneurDroit2

public class ConteneurDroit2Haut extends JPanel
{
    class minLightListener
        implements DocumentListener, KeyListener
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
			verifyMINL();

		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			verifyMINL();
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			verifyMINL();
		}
    }


    ConteneurDroit2Haut(ConteneurDroit2 conteneurDroit2)
    {
        minLightLabel = new JLabel("Desired mini. Light (%)");
        minLightField = new JTextField("0");
        this.conteneurDroit2 = conteneurDroit2;
        setPreferredSize(new Dimension(300, 600));
        setLayout(new BorderLayout());
        minLightField.setPreferredSize(new Dimension(50, 10));
        add(minLightLabel, "West");
        add(minLightField, "East");
        minLightField.getDocument().addDocumentListener(new minLightListener());
        minLightField.addKeyListener(new minLightListener());
        MINL=0;
    }

    public void activateParameters(boolean bool)
    {
        minLightField.setEditable(bool);
    }

    public void getParameters()
    {
    	if(!minLightField.getText().equals(""))
    		try
    		{
    			if(Integer.parseInt(minLightField.getText()) < 101 && Integer.parseInt(minLightField.getText()) > -1)
    			{
    				conteneurDroit2.setMinLightLevel((new StringBuilder("MINL")).append(Integer.parseInt(minLightField.getText())).append("$").toString());
    			} else
    			{
    				System.out.println("Debug : Warning, wrong Min value!");
    				conteneurDroit2.setMinLightLevel("MINL0$");
    			}
    		}
    		catch(NumberFormatException arg)
    		{
    		System.out.println("Error : wrong number format");
    		}
    }
    
    public void getMinLightLevel(int value)
    {
        MINL=value;
        verifyMINL();
    }
    
    private void verifyMINL(){
    	try
        {
			if(MINL==Integer.parseInt(minLightField.getText())){
				minLightField.setForeground(Color.BLACK);

			}else{
				minLightField.setForeground(Color.GRAY);
			}
		}
        catch(NumberFormatException arg)
        {
            System.out.println("Error : wrong number format");
        }
    }

    ConteneurDroit2 conteneurDroit2;
    private JLabel minLightLabel;
    private JTextField minLightField;
    int MINL;

}
