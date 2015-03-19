// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurDroit.java

package GUI;

import java.awt.*;
import java.util.Hashtable;

import javax.swing.*;

// Referenced classes of package GUI:
//            ConteneurDroit1, ConteneurDroit2, ConteneurDroit3, ConteneurDroit4, 
//            Fenetre

public class ConteneurDroit extends JPanel
{

    /**
	 * 
	 */
	ConteneurDroit(Fenetre fenetre)
    {
        monConteneurDroit1 = new ConteneurDroit1(this);
        monConteneurDroit2 = new ConteneurDroit2(this);
        monConteneurDroit3 = new ConteneurDroit3(this);
        monConteneurDroit4 = new ConteneurDroit4(this);
        apnConfig= new ConteneurAPNConfig(this);
        this.fenetre = fenetre;
        setBorder(BorderFactory.createTitledBorder("Parameters"));
        setPreferredSize(new Dimension(250, 650));
        setLayout(new GridLayout(4,1));
        add(monConteneurDroit1);
        add(monConteneurDroit2);
        add(monConteneurDroit3);
        JPanel Panel = new JPanel();
        add(Panel);
        Panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx=0.5;
        c.gridheight = 2;
        Panel.add(apnConfig,c);
        c.gridy = 2;
        c.gridheight = 1;
        Panel.add(monConteneurDroit4,c);
    }

    public void setTimeBetweenTwoPics(String value)
    {
        fenetre.setTimeBetweenTwoPics(value);
    }
    public void getTimeBetweenTwoPics(int value)
    {
        monConteneurDroit1.getTimeBetweenTwoPics(value);
    }

    public void setTimeBetweenTwoTypes(String value)
    {
        fenetre.setTimeBetweenTwoTypes(value);
    }
    
    public void getTimeBetweenTwoTypes(int value)
    {
        monConteneurDroit1.getTimeBetweenTwoTypes(value);
    }

    public void setMinLightLevel(String value)
    {
        fenetre.setMinLightLevel(value);
    }
    
    public void getMinLightLevel(int value)
    {
        monConteneurDroit2.getMinLightLevel(value);
    }

    public void setMaxLightLevel(String value)
    {
        fenetre.setMaxLightLevel(value);
    }
    
    public void getMaxLightLevel(int value)
    {
        monConteneurDroit2.getMaxLightLevel(value);
    }

    public void setBefore(String value)
    {
        fenetre.setBefore(value);
    }

    public void setAfter(String value)
    {
        fenetre.setAfter(value);
    }
    
    public void getAfter(int value)
    {
        monConteneurDroit3.getAfter(value);
    }

    public void activateParameters(boolean bool)
    {
        monConteneurDroit1.activateParameters(bool);
        monConteneurDroit2.activateParameters(bool);
        monConteneurDroit3.activateParameters(bool);
    }

    public void getParameters()
    {
        monConteneurDroit1.getParameters();
        monConteneurDroit2.getParameters();
        monConteneurDroit3.getParameters();
    }
    
    public void refreshCams()
    {
    	fenetre.refreshCams();
    }
    
    public void getPics(String port)
    {
    	fenetre.getPics(port);
    }
    
    public void setSeparate(boolean separate)
    {
    	fenetre.setSeparate(separate);
    }
    
    public void deletePics(String port)
    {
    	fenetre.deletePics(port);
    }
    
    public void getDevices(Hashtable<String,String> devices)
    {
    	apnConfig.getDevices(devices);
    }

    Fenetre fenetre;
    ConteneurDroit1 monConteneurDroit1;
    ConteneurDroit2 monConteneurDroit2;
    ConteneurDroit3 monConteneurDroit3;
    ConteneurAPNConfig apnConfig;
    ConteneurDroit4 monConteneurDroit4;
}
