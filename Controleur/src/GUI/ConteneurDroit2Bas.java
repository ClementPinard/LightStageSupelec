// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurDroit2Bas.java

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

public class ConteneurDroit2Bas extends JPanel
{
    class maxLightListener
        implements KeyListener,DocumentListener
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
			verifyMAXL();

		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			verifyMAXL();
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			verifyMAXL();
		}
    }


    ConteneurDroit2Bas(ConteneurDroit2 conteneurDroit2)
    {
        maxLightLabel = new JLabel("Desired maxi. Light (%)");
        maxLightField = new JTextField("100");
        this.conteneurDroit2 = conteneurDroit2;
        setPreferredSize(new Dimension(300, 600));
        setLayout(new BorderLayout());
        maxLightField.setPreferredSize(new Dimension(50, 10));
        add(maxLightLabel, "West");
        add(maxLightField, "East");
        maxLightField.getDocument().addDocumentListener(new maxLightListener());
        maxLightField.addKeyListener(new maxLightListener());
        MAXL=100;
    }

    public void activateParameters(boolean bool)
    {
        maxLightField.setEditable(bool);
    }

    public void getParameters()
    {
    	if(!maxLightField.getText().equals(""))
            try
            {
                if(Integer.parseInt(maxLightField.getText()) < 101 && Integer.parseInt(maxLightField.getText()) > -1)
                {
                    conteneurDroit2.setMaxLightLevel((new StringBuilder("MAXL")).append(Integer.parseInt(maxLightField.getText())).append("$").toString());
                } else
                {
                    System.out.println("Debug : Warning, wrong Max value!");
                    conteneurDroit2.setMaxLightLevel("MAXL100$");
                }
            }
            catch(NumberFormatException arg)
            {
                System.out.println("Error : wrong number format");
            }
    }
    
    public void getMaxLightLevel(int value)
    {
        MAXL=value;
        verifyMAXL();
    }
    
    private void verifyMAXL(){
    	try
        {
			if(MAXL==Integer.parseInt(maxLightField.getText())){
				maxLightField.setForeground(Color.BLACK);

			}else{
				maxLightField.setForeground(Color.GRAY);
			}
		}
        catch(NumberFormatException arg)
        {
            System.out.println("Error : wrong number format");
        }
    }

    ConteneurDroit2 conteneurDroit2;
    private JLabel maxLightLabel;
    private JTextField maxLightField;
    int MAXL;

}
