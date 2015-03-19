// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurGaucheMilieu2GaucheHaut.java

package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Referenced classes of package GUI:
//            ConteneurGaucheMilieu2Gauche

public class ConteneurGaucheMilieu2GaucheHaut extends JPanel
{
	public void sendOneLed(){
		int value1 = 0;
        int value2 = 0;
        try
        {
            value1 = Integer.parseInt(numeroOneLed.getText());
            value2 = Integer.parseInt(puissanceOneLed.getText());
            if(value1 < 157 && value1 > 0 && value2 > -1 && value2 < 4096)
                conteneurGaucheMilieu2Gauche.conteneurGaucheMilieu2.setOneLed((new StringBuilder("ONE")).append(value1).append("$").append(value2).append("$").toString());
            else
                System.out.println("Debut : Error, wrong value(s)");
        }
        catch(NumberFormatException arg)
        {
            System.out.println("Error : wrong number format");
        }
	}

    class puissanceOneLedListener
        implements KeyListener
    {

        public void keyPressed(KeyEvent e) {
        	if (e.getKeyCode()==KeyEvent.VK_ENTER){
    	        sendOneLed();
    	    }
        }
        
        public void keyTyped(KeyEvent e)
        {
        }
        
        public void keyReleased(KeyEvent e)
        {
        }
    }
    
    class numeroOneLedListener
    implements KeyListener
    {

    public void keyPressed(KeyEvent e) {
    	if (e.getKeyCode()==KeyEvent.VK_ENTER){
	        puissanceOneLed.requestFocus();
	    }
    }
    
    public void keyTyped(KeyEvent e)
    {
    }
    
    public void keyReleased(KeyEvent e)
    {
    }
}
    
    
    
    


    ConteneurGaucheMilieu2GaucheHaut(ConteneurGaucheMilieu2Gauche conteneurGaucheMilieu2Gauche)
    {
        numeroOneLed = new HintTextField("Num.(1-156)");
        puissanceOneLed = new HintTextField("Power(0-4095)");
        this.conteneurGaucheMilieu2Gauche = conteneurGaucheMilieu2Gauche;
        setPreferredSize(new Dimension(300, 25));
        setLayout(new GridLayout(1, 2));
        add(numeroOneLed);
        add(puissanceOneLed);
        puissanceOneLed.addKeyListener(new puissanceOneLedListener());
        numeroOneLed.addKeyListener(new numeroOneLedListener());
    }

    ConteneurGaucheMilieu2Gauche conteneurGaucheMilieu2Gauche;
    HintTextField numeroOneLed;
    HintTextField puissanceOneLed;
}
