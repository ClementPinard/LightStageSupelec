// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurDroit3Bas.java

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
//            ConteneurDroit3

public class ConteneurDroit3Bas extends JPanel
{
    class afterListener
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
			verifyAft();

		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			verifyAft();
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			verifyAft();
		}
    }


    ConteneurDroit3Bas(ConteneurDroit3 conteneurDroit3)
    {
        labelAfter = new JLabel("Keep lights after capture (%)");
        fieldAfter = new JTextField("20");
        this.conteneurDroit3 = conteneurDroit3;
        setPreferredSize(new Dimension(300, 600));
        fieldAfter.setPreferredSize(new Dimension(50, 10));
        setLayout(new BorderLayout());
        add(labelAfter, "West");
        add(fieldAfter, "East");
        fieldAfter.getDocument().addDocumentListener(new afterListener());
        fieldAfter.addKeyListener(new afterListener());
        Aft=100;
    }

    public void activateParameters(boolean bool)
    {
        fieldAfter.setEditable(bool);
    }

    public void getParameters()
    {
    	if(!fieldAfter.getText().equals(""))
            try
            {
                if(Integer.parseInt(fieldAfter.getText()) < 101 && Integer.parseInt(fieldAfter.getText()) > -1)
                {
                    conteneurDroit3.setAfter((new StringBuilder("AFT")).append(Integer.parseInt(fieldAfter.getText())).append("$").toString());
                } else
                {
                    System.out.println("Debug : Warning, wrong Max value!");
                    conteneurDroit3.setAfter("AFT100$");
                }
            }
            catch(NumberFormatException arg)
            {
                System.out.println("Error : wrong number format");
            }
    }
    
    public void getAfter(int value)
    {
        Aft=value;
        verifyAft();
    }
    
    private void verifyAft(){
    	try
        {
			if(Aft==Integer.parseInt(fieldAfter.getText())){
				fieldAfter.setForeground(Color.BLACK);

			}else{
				fieldAfter.setForeground(Color.GRAY);
			}
		}
        catch(NumberFormatException arg)
        {
            System.out.println("Error : wrong number format");
        }
    }

    ConteneurDroit3 conteneurDroit3;
    JLabel labelAfter;
    JTextField fieldAfter;
    int Aft;
}
