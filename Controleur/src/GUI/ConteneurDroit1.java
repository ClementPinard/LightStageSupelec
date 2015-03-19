// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurDroit1.java

package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

// Referenced classes of package GUI:
//            ConteneurDroit1Haut, ConteneurDroit1Bas, ConteneurDroit

public class ConteneurDroit1 extends JPanel
{

    ConteneurDroit1(ConteneurDroit conteneurDroit)
    {
        conteneurDroit1Haut = new ConteneurDroit1Haut(this);
        conteneurDroit1Bas = new ConteneurDroit1Bas(this);
        this.conteneurDroit = conteneurDroit;
        setBorder(BorderFactory.createTitledBorder("Delays"));
        setPreferredSize(new Dimension(300, 600));
        setLayout(new GridLayout(2, 1));
        add(conteneurDroit1Haut);
        add(conteneurDroit1Bas);
    }

    public void setTimeBetweenTwoPics(String value)
    {
        conteneurDroit.setTimeBetweenTwoPics(value);
    }
    
    public void getTimeBetweenTwoPics(int value)
    {
        conteneurDroit1Haut.getTimeBetweenTwoPics(value);
    }

    public void setTimeBetweenTwoTypes(String value)
    {
        conteneurDroit.setTimeBetweenTwoTypes(value);
    }
    
    public void getTimeBetweenTwoTypes(int value)
    {
        conteneurDroit1Bas.getTimeBetweenTwoTypes(value);
    }

    public void activateParameters(boolean bool)
    {
        conteneurDroit1Haut.activateParameters(bool);
        conteneurDroit1Bas.activateParameters(bool);
    }

    public void getParameters()
    {
        conteneurDroit1Haut.getParameters();
        conteneurDroit1Bas.getParameters();
    }

    ConteneurDroit conteneurDroit;
    ConteneurDroit1Haut conteneurDroit1Haut;
    ConteneurDroit1Bas conteneurDroit1Bas;
}
