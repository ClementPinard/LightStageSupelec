// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Fenetre.java

package GUI;

import Communication.Comm;
import Core.Noyau;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;

import javax.swing.JFrame;

// Referenced classes of package GUI:
//            ConteneurDroit, ConteneurGauche

public class Fenetre extends JFrame
{

    public Fenetre(Comm monMbed)
    {
    	super();
    	monConteneurDroit = new ConteneurDroit(this);
        monConteneurGauche = new ConteneurGauche(this);
        this.monMbed = monMbed;
        setTitle("Light Stage Sup\351lec - Control Software - v1.01");
        setSize(640, 360);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setResizable(false);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e)
            {
                noyau.onNewConnectionState("APP");
            }
        }
);
    }

    public void init()
    {
        add(monConteneurDroit, "East");
        add(monConteneurGauche, "Center");
        setVisible(true);
        monMbed.setFenetre(this);
    }

    public void writeState(String stateConnected)
    {
        monConteneurGauche.writeState(stateConnected);
    }

    public void writeStateCapture(String stateCapture)
    {
        monConteneurGauche.writeStateCapture(stateCapture);
    }

    public void refresh()
    {
        noyau.refreshConnection();
    }

    public void sendMessage(String monMessage)
    {
        monMbed.sendCommand(monMessage);
    }

    public void activateButtonState(boolean bool)
    {
        monConteneurGauche.activateButtonState(bool);
    }

    public void activateButtonLaunch(boolean bool)
    {
        monConteneurGauche.activateButtonLaunch(bool);
    }

    public void activateButtonDemo1(boolean bool)
    {
        monConteneurGauche.activateButtonDemo1(bool);
    }

    public void activateButtonDemo2(boolean bool)
    {
        monConteneurGauche.activateButtonDemo2(bool);
    }

    public void activateButtonDemo3(boolean bool)
    {
        monConteneurGauche.activateButtonDemo3(bool);
    }

    public void activateButtonSetOneLed(boolean bool)
    {
        monConteneurGauche.activateButtonSetOneLed(bool);
    }

    public void activateButtonSetAllLed(boolean bool)
    {
        monConteneurGauche.activateButtonSetAllLed(bool);
    }

    public void setKernel(Noyau noyau)
    {
        this.noyau = noyau;
    }

    public void launchCapture()
    {
        noyau.launchCapture();
    }

    public void launchDemo1()
    {
        noyau.launchDemo1();
    }

    public void launchDemo2()
    {
        noyau.launchDemo2();
    }

    public void launchDemo3()
    {
        noyau.launchDemo3();
    }

    public void stopDemo1()
    {
        noyau.stopDemo1();
    }

    public void stopDemo2()
    {
        noyau.stopDemo2();
    }

    public void stopDemo3()
    {
        noyau.stopDemo3();
    }

    public void setAllLed(String value)
    {
        noyau.setAllLed(value);
    }

    public void setOneLed(String value)
    {
        noyau.setOneLed(value);
    }

    public void setTimeBetweenTwoPics(String value)
    {
        noyau.setTimeBetweenTwoPics(value);
    }

    public void setTimeBetweenTwoTypes(String value)
    {
        noyau.setTimeBetweenTwoTypes(value);
    }
    
    public void getTimeBetweenTwoPics(int value)
    {
    	monConteneurDroit.getTimeBetweenTwoPics(value);
    }
    
    public void getTimeBetweenTwoTypes(int value)
    {
    	monConteneurDroit.getTimeBetweenTwoTypes(value);
    }

    public void setMinLightLevel(String value)
    {
        noyau.setMinLightLevel(value);
    }
    
    public void getMinLightLevel(int value)
    {
    	monConteneurDroit.getMinLightLevel(value);
    }

    public void setMaxLightLevel(String value)
    {
        noyau.setMaxLightLevel(value);
    }
    
    public void getMaxLightLevel(int value)
    {
    	monConteneurDroit.getMaxLightLevel(value);
    }

    public void activateButtonLoad(boolean bool)
    {
        monConteneurGauche.activateButtonLoad(bool);
    }

    public void activateButtonHelp(boolean bool)
    {
        monConteneurGauche.activateButtonHelp(bool);
    }

    public void setBefore(String value)
    {
        noyau.setBefore(value);
    }

    public void setAfter(String value)
    {
        noyau.setAfter(value);
    }
    
    public void getAfter(int value)
    {
    	monConteneurDroit.getAfter(value);
    }

    public void activateParameters(boolean bool)
    {
        monConteneurDroit.activateParameters(bool);
    }

    public void getParameters()
    {
        monConteneurDroit.getParameters();
    }

    public void refreshDrive()
    {
        monConteneurGauche.refreshDrive();
    }
    
    public void refreshCams()
    {
    	noyau.refreshCams();
    }
    
    public void getDevices(Hashtable<String,String> devices){
    	monConteneurDroit.getDevices(devices);
    }
    
    public void getPics(String port)
    {
    	noyau.getPics(port);
    }
    
    public void setSeparate(boolean separate)
    {
    	noyau.setSeparate(separate);
    }
    
    public void deletePics(String port)
    {
    	noyau.deletePics(port);
    }
    
    

    ConteneurDroit monConteneurDroit;
    ConteneurGauche monConteneurGauche;
    Comm monMbed;
    Noyau noyau;
}
