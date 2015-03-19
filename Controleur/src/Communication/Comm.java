// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Comm.java

package Communication;

import Core.Noyau;
import GUI.Fenetre;
import gnu.io.CommPortIdentifier;
import java.io.*;
import java.util.Enumeration;

// Referenced classes of package Communication:
//            SerialHandler

public class Comm
{

    public Comm()
    {
    }

    public void init()
    {
        listSerial = null;
        bMbedIsConnected = false;
        serialHandler = new SerialHandler(this);
        System.out.println("Processing Serial Auto Configuration");
        System.out.println("------------------------------------");
        for(listSerial = serialHandler.list(); listSerial.hasMoreElements();)
        {
            currentlyTestedSerial = (CommPortIdentifier)listSerial.nextElement();
            if((currentlyTestedSerial.getPortType() == 1) & (!bMbedIsConnected))
            {
                System.out.println((new StringBuilder("Trying to connect to : ")).append(currentlyTestedSerial.getName()).toString());
                try
                {
                    if(serialHandler.connect(currentlyTestedSerial))
                    {
                        inMbed = serialHandler.inMbed;
                        outMbed = serialHandler.outMbed;
                        bMbedIsConnected = true;
                        mbedSerial = currentlyTestedSerial;
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            if(bMbedIsConnected)
                noyau.onNewConnectionState((new StringBuilder("COM")).append(mbedSerial.getName()).toString());
            else
                noyau.onNewConnectionState("NO");
        }

    }

    public void refresh()
    {
        serialHandler = new SerialHandler(this);
        for(listSerial = serialHandler.list(); listSerial.hasMoreElements();)
        {
            currentlyTestedSerial = (CommPortIdentifier)listSerial.nextElement();
            if((currentlyTestedSerial.getPortType() == 1) & (!bMbedIsConnected))
            {
                System.out.println((new StringBuilder("Trying to connect to : ")).append(currentlyTestedSerial.getName()).toString());
                try
                {
                    if(serialHandler.connect(currentlyTestedSerial))
                    {
                        inMbed = serialHandler.inMbed;
                        outMbed = serialHandler.outMbed;
                        bMbedIsConnected = true;
                        mbedSerial = currentlyTestedSerial;
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            if(bMbedIsConnected)
                noyau.onNewConnectionState((new StringBuilder("COM")).append(mbedSerial.getName()).toString());
            else
                noyau.onNewConnectionState("NO");
        }

    }

    public void sendCommand(String maCommande)
    {
        byte msg[] = (new StringBuilder(String.valueOf(maCommande))).append("#").toString().getBytes();
        System.out.println((new StringBuilder("PC->CLIENT : ")).append(maCommande).toString());
        try
        {
            if(bMbedIsConnected)
                outMbed.write(msg, 0, msg.length);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void setFenetre(Fenetre fenetre)
    {
        this.fenetre = fenetre;
    }

    public void handleNewCommandeFromMbed(String maCommande)
    {
        System.out.println((new StringBuilder("New commande : ")).append(maCommande).toString());
        if(maCommande.equals("Reset"))
        {
            fenetre.writeState("Reset : connection aborted");
            noyau.reset();
        }
        if(maCommande.equals("ENDCAP")){
        	noyau.endCapture();
        }
        
        if(maCommande.contains("TP")){
        	noyau.getTimeBetweenTwoPics(maCommande);        	
        }
        
        if(maCommande.contains("TT")){
        	noyau.getTimeBetweenTwoTypes(maCommande);        	
        }
        
        if(maCommande.contains("MINL")){
        	noyau.getMinLightLevel(maCommande);        	
        }
        
        if(maCommande.contains("MAXL")){
        	noyau.getMaxLightLevel(maCommande);        	
        }
        
        if(maCommande.contains("AFT")){
        	noyau.getAfter(maCommande);        	
        }
    }

    public void setKernel(Noyau noyau)
    {
        this.noyau = noyau;
    }

    Fenetre fenetre;
    Noyau noyau;
    Enumeration listSerial;
    SerialHandler serialHandler;
    CommPortIdentifier currentlyTestedSerial;
    CommPortIdentifier mbedSerial;
    InputStream inMbed;
    OutputStream outMbed;
    private boolean bMbedIsConnected;
}
