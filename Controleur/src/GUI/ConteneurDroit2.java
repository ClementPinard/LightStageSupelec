// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurDroit2.java

package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

// Referenced classes of package GUI:
//            ConteneurDroit2Haut, ConteneurDroit2Bas, ConteneurDroit

public class ConteneurDroit2 extends JPanel
{

    ConteneurDroit2(ConteneurDroit conteneurDroit)
    {
        conteneurDroit2Haut = new ConteneurDroit2Haut(this);
        conteneurDroit2Bas = new ConteneurDroit2Bas(this);
        this.conteneurDroit = conteneurDroit;
        setBorder(BorderFactory.createTitledBorder("Light Levels"));
        setPreferredSize(new Dimension(300, 600));
        setLayout(new GridLayout(2, 1));
        add(conteneurDroit2Haut);
        add(conteneurDroit2Bas);
    }

    public void setMinLightLevel(String value)
    {
        conteneurDroit.setMinLightLevel(value);
    }

    public void getMinLightLevel(int value)
    {
        conteneurDroit2Haut.getMinLightLevel(value);
    }
    
    public void setMaxLightLevel(String value)
    {
        conteneurDroit.setMaxLightLevel(value);
    }
    
    public void getMaxLightLevel(int value)
    {
        conteneurDroit2Bas.getMaxLightLevel(value);
    }

    public void activateParameters(boolean bool)
    {
        conteneurDroit2Haut.activateParameters(bool);
        conteneurDroit2Bas.activateParameters(bool);
    }

    public void getParameters()
    {
        conteneurDroit2Haut.getParameters();
        conteneurDroit2Bas.getParameters();
    }

    ConteneurDroit conteneurDroit;
    ConteneurDroit2Haut conteneurDroit2Haut;
    ConteneurDroit2Bas conteneurDroit2Bas;
}
