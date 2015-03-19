// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurGauche.java

package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

// Referenced classes of package GUI:
//            ConteneurGaucheHaut, ConteneurGaucheMilieu, ConteneurGaucheBas, Fenetre

public class ConteneurGauche extends JPanel
{
    class testButtonListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            counter++;
            try
            {
                fenetre.sendMessage((new StringBuilder(String.valueOf(counter))).append("#").toString());
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }
        }

        final ConteneurGauche this$0;

        testButtonListener()
        {
        	super();
        	this$0 = ConteneurGauche.this;
            
        }
    }


    ConteneurGauche(Fenetre fenetre)
    {
        monConteneurGaucheHaut = new ConteneurGaucheHaut(this);
        monConteneurGaucheMilieu = new ConteneurGaucheMilieu(this);
        monConteneurGaucheBas = new ConteneurGaucheBas(this);
        this.fenetre = fenetre;
        setBackground(Color.BLUE);
        setLayout(new BorderLayout());
        add(monConteneurGaucheHaut, "North");
        add(monConteneurGaucheMilieu, "Center");
        add(monConteneurGaucheBas, "South");
    }

    public void writeState(String stateConnected)
    {
        monConteneurGaucheHaut.writeState(stateConnected);
    }

    public void writeStateCapture(String stateCapture)
    {
        monConteneurGaucheBas.writeStateCapture(stateCapture);
    }

    public void activateButtonState(boolean bool)
    {
        monConteneurGaucheHaut.activateButtonState(bool);
    }

    public void activateButtonLaunch(boolean bool)
    {
        monConteneurGaucheBas.activateButtonLaunch(bool);
    }

    public void activateButtonDemo1(boolean bool)
    {
        monConteneurGaucheMilieu.activateButtonDemo1(bool);
    }

    public void activateButtonDemo2(boolean bool)
    {
        monConteneurGaucheMilieu.activateButtonDemo2(bool);
    }

    public void activateButtonDemo3(boolean bool)
    {
        monConteneurGaucheMilieu.activateButtonDemo3(bool);
    }

    public void activateButtonSetOneLed(boolean bool)
    {
        monConteneurGaucheMilieu.activateButtonSetOneLed(bool);
    }

    public void activateButtonSetAllLed(boolean bool)
    {
        monConteneurGaucheMilieu.activateButtonSetAllLed(bool);
    }

    public void refresh()
    {
        fenetre.refresh();
    }

    public void launchCapture()
    {
        fenetre.launchCapture();
    }

    public void launchDemo1()
    {
        fenetre.launchDemo1();
    }

    public void launchDemo2()
    {
        fenetre.launchDemo2();
    }

    public void launchDemo3()
    {
        fenetre.launchDemo3();
    }

    public void stopDemo1()
    {
        fenetre.stopDemo1();
    }

    public void stopDemo2()
    {
        fenetre.stopDemo2();
    }

    public void stopDemo3()
    {
        fenetre.stopDemo3();
    }

    public void setAllLed(String value)
    {
        fenetre.setAllLed(value);
    }

    public void setOneLed(String value)
    {
        fenetre.setOneLed(value);
    }

    public void activateButtonLoad(boolean bool)
    {
        monConteneurGaucheMilieu.activateButtonLoad(bool);
    }

    public void activateButtonHelp(boolean bool)
    {
        monConteneurGaucheMilieu.activateButtonHelp(bool);
    }

    public void refreshDrive()
    {
        monConteneurGaucheMilieu.refreshDrive();
    }

    private ConteneurGaucheHaut monConteneurGaucheHaut;
    private ConteneurGaucheMilieu monConteneurGaucheMilieu;
    private ConteneurGaucheBas monConteneurGaucheBas;
    private Fenetre fenetre;
    int counter;

}
