// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurDroit3.java

package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

// Referenced classes of package GUI:
//            ConteneurDroit3Haut, ConteneurDroit3Bas, ConteneurDroit

public class ConteneurDroit3 extends JPanel
{

    ConteneurDroit3(ConteneurDroit conteneurDroit)
    {
        conteneurDroit3Haut = new ConteneurDroit3Haut(this);
        conteneurDroit3Bas = new ConteneurDroit3Bas(this);
        this.conteneurDroit = conteneurDroit;
        setBorder(BorderFactory.createTitledBorder("Before and After the Capture"));
        setPreferredSize(new Dimension(300, 600));
        setLayout(new GridLayout(2, 1));
        add(conteneurDroit3Haut);
        add(conteneurDroit3Bas);
    }

    public void setBefore(String value)
    {
        conteneurDroit.setBefore(value);
    }

    public void setAfter(String value)
    {
        conteneurDroit.setAfter(value);
    }
    
    public void getAfter(int value)
    {
    	conteneurDroit3Bas.getAfter(value);
    }

    public void activateParameters(boolean bool)
    {
        conteneurDroit3Haut.activateParameters(bool);
        conteneurDroit3Bas.activateParameters(bool);
    }

    public void getParameters()
    {
        conteneurDroit3Haut.getParameters();
        conteneurDroit3Bas.getParameters();
    }

    ConteneurDroit conteneurDroit;
    ConteneurDroit3Haut conteneurDroit3Haut;
    ConteneurDroit3Bas conteneurDroit3Bas;
}
