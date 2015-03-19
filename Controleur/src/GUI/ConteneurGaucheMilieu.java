// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurGaucheMilieu.java

package GUI;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

// Referenced classes of package GUI:
//            ConteneurGaucheMilieu1, ConteneurGaucheMilieu2, ConteneurGaucheMilieu3, ConteneurGauche

public class ConteneurGaucheMilieu extends JPanel
{

    ConteneurGaucheMilieu(ConteneurGauche conteneurGauche)
    {
        monConteneurGaucheMilieu1 = new ConteneurGaucheMilieu1(this);
        monConteneurGaucheMilieu2 = new ConteneurGaucheMilieu2(this);
        monConteneurGaucheMilieu3 = new ConteneurGaucheMilieu3(this);
        this.conteneurGauche = conteneurGauche;
        setBorder(BorderFactory.createTitledBorder("Test Patterns"));
        setLayout(new BorderLayout());
        add(monConteneurGaucheMilieu1, "North");
        add(monConteneurGaucheMilieu2, "Center");
        add(monConteneurGaucheMilieu3, "South");
    }

    public void launchDemo1()
    {
        conteneurGauche.launchDemo1();
    }

    public void launchDemo2()
    {
        conteneurGauche.launchDemo2();
    }

    public void launchDemo3()
    {
        conteneurGauche.launchDemo3();
    }

    public void stopDemo1()
    {
        conteneurGauche.stopDemo1();
    }

    public void stopDemo2()
    {
        conteneurGauche.stopDemo2();
    }

    public void stopDemo3()
    {
        conteneurGauche.stopDemo3();
    }

    public void activateButtonDemo1(boolean bool)
    {
        monConteneurGaucheMilieu1.activateButtonDemo1(bool);
    }

    public void activateButtonDemo2(boolean bool)
    {
        monConteneurGaucheMilieu1.activateButtonDemo2(bool);
    }

    public void activateButtonDemo3(boolean bool)
    {
        monConteneurGaucheMilieu1.activateButtonDemo3(bool);
    }

    public void activateButtonSetOneLed(boolean bool)
    {
        monConteneurGaucheMilieu2.activateButtonSetOneLed(bool);
    }

    public void activateButtonSetAllLed(boolean bool)
    {
        monConteneurGaucheMilieu2.activateButtonSetAllLed(bool);
    }

    public void setAllLed(String value)
    {
        conteneurGauche.setAllLed(value);
    }

    public void setOneLed(String value)
    {
        conteneurGauche.setOneLed(value);
    }

    public void activateButtonLoad(boolean bool)
    {
        monConteneurGaucheMilieu3.activateButtonLoad(bool);
    }

    public void activateButtonHelp(boolean bool)
    {
        monConteneurGaucheMilieu3.activateButtonHelp(bool);
    }

    public void refreshDrive()
    {
        monConteneurGaucheMilieu3.refreshDrive();
    }

    ConteneurGauche conteneurGauche;
    ConteneurGaucheMilieu1 monConteneurGaucheMilieu1;
    ConteneurGaucheMilieu2 monConteneurGaucheMilieu2;
    ConteneurGaucheMilieu3 monConteneurGaucheMilieu3;
}
