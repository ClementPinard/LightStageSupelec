// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurGaucheMilieu2.java

package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

// Referenced classes of package GUI:
//            ConteneurGaucheMilieu2Gauche, ConteneurGaucheMilieu2Droit, ConteneurGaucheMilieu

public class ConteneurGaucheMilieu2 extends JPanel
{

    ConteneurGaucheMilieu2(ConteneurGaucheMilieu conteneurGaucheMilieu)
    {
        conteneurGaucheMilieu2Gauche = new ConteneurGaucheMilieu2Gauche(this);
        conteneurGaucheMilieu2Droit = new ConteneurGaucheMilieu2Droit(this);
        this.conteneurGaucheMilieu = conteneurGaucheMilieu;
        setBorder(BorderFactory.createTitledBorder("Manual control"));
        setPreferredSize(new Dimension(300, 10));
        setLayout(new GridLayout(1, 2));
        add(conteneurGaucheMilieu2Gauche);
        add(conteneurGaucheMilieu2Droit);
    }

    public void setAllLed(String value)
    {
        conteneurGaucheMilieu.setAllLed(value);
    }

    public void setOneLed(String value)
    {
        conteneurGaucheMilieu.setOneLed(value);
    }

    public void activateButtonSetOneLed(boolean bool)
    {
        conteneurGaucheMilieu2Gauche.activateButtonSetOneLed(bool);
    }

    public void activateButtonSetAllLed(boolean bool)
    {
        conteneurGaucheMilieu2Droit.activateButtonSetAllLed(bool);
    }

    ConteneurGaucheMilieu conteneurGaucheMilieu;
    private ConteneurGaucheMilieu2Gauche conteneurGaucheMilieu2Gauche;
    private ConteneurGaucheMilieu2Droit conteneurGaucheMilieu2Droit;
}
