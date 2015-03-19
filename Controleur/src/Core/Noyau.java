// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Noyau.java

package Core;

import Communication.Comm;
import Communication.gPhotoCom;
import GUI.Fenetre;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;

public class Noyau
    implements Runnable
{

    public Noyau(Fenetre fenetre, Comm mbed, gPhotoCom gphoto)
    {
        this.fenetre = fenetre;
        this.mbed = mbed;
        this.gphoto = gphoto;
        sCaptureDirectory = "Dump";
    }

    public void init()
    {
        bNewConnectionState = false;
        bRefreshConnection = false;
        bRefreshCam = false;
        bGetPics = false;
        bDeletePics = false;
        nCaptures = 0;
        bCapture = false;
        bLaunchCapture = false;
        bDemo1 = false;
        bDemo2 = false;
        bDemo3 = false;
        bLaunchDemo1 = false;
        bLaunchDemo2 = false;
        bLaunchDemo3 = false;
        bOneLed = false;
        bAllLed = false;
        bBefore = false;
        bAfter = false;
        
        try {
			devices = gphoto.getDevices();
		} catch (IOException e) {
			System.out.println("Error getting Usb Camera devices via gPhoto2");
		}
		
		fenetre.getDevices(devices);
        
    }

    public void run()
    {
        do
        {
            if(reseted)
            {
                fenetre.writeState("Mbed reset, connection lost!");
                fenetre.writeStateCapture("First, connect the Light Stage!");
                fenetre.activateButtonState(true);
                reseted = false;
                fenetre.activateButtonLaunch(false);
                fenetre.activateButtonDemo1(false);
                fenetre.activateButtonDemo2(false);
                fenetre.activateButtonDemo3(false);
                fenetre.activateButtonSetOneLed(false);
                fenetre.activateButtonSetAllLed(false);
                fenetre.activateButtonLoad(false);
                fenetre.activateButtonHelp(false);
                fenetre.activateParameters(false);
            }
            if(bRefreshConnection)
            {
                mbed.refresh();
                bRefreshConnection = false;
                bParameters = true;
            }
            if(bNewConnectionState)
            {
                if(connectionState.startsWith("COM"))
                {
                    fenetre.activateButtonLoad(true);
                    fenetre.activateButtonHelp(true);
                    fenetre.writeState((new StringBuilder("Connection successful on ")).append(connectionState.substring(3, 7)).toString());
                    fenetre.writeStateCapture("Ready");
                    fenetre.refreshDrive();
                    fenetre.activateButtonState(false);
                    fenetre.activateButtonLaunch(true);
                    fenetre.activateButtonDemo1(true);
                    fenetre.activateButtonDemo2(true);
                    fenetre.activateButtonDemo3(true);
                    fenetre.activateButtonSetOneLed(true);
                    fenetre.activateButtonSetAllLed(true);
                    fenetre.activateParameters(true);
                    mbed.sendCommand((new StringBuilder("Connected : ")).append(connectionState.substring(3, 7)).toString());
                    bParameters = true;
                }
                if(connectionState.startsWith("NO"))
                {
                    fenetre.writeState("No mbed, please checked USB cable");
                    fenetre.writeStateCapture("First, connect the Light Stage!");
                    fenetre.activateButtonLaunch(false);
                    fenetre.activateButtonDemo1(false);
                    fenetre.activateButtonDemo2(false);
                    fenetre.activateButtonDemo3(false);
                    fenetre.activateButtonSetOneLed(false);
                    fenetre.activateButtonSetAllLed(false);
                    fenetre.activateButtonLoad(false);
                    fenetre.activateButtonHelp(false);
                    fenetre.activateParameters(false);
                    bParameters = false;
                }
                if(connectionState.startsWith("APP"))
                    System.out.println("Appli. closed by user. Bye");
                bNewConnectionState = false;
            }
            
            if(bRefreshCam){
            	try {
					devices = gphoto.getDevices();
				} catch (IOException e) {
					System.out.println("Error getting Usb Camera devices via gPhoto2");
				}
				
				fenetre.getDevices(devices);
				bRefreshCam = false;
            	
            }
            
            if(bGetPics){
            	if(sPort.equals(""))
            	{
            		try {
    					gphoto.getPics(sCaptureDirectory,bSeparate);
    					fenetre.writeStateCapture("Light Stage ready to acquire");
    				} catch (IOException e) {
    					System.out.println("Error getting Pictures via gPhoto2");
    				}
            	}else{
            		try {
    					gphoto.getPics(sCaptureDirectory,sPort,bSeparate);
    				} catch (IOException e) {
    					System.out.println("Error getting Pictures via gPhoto2");
    				}
            	}
            	
            	bGetPics = false;
            	
            }
            
            if(bDeletePics){
            	try {
					gphoto.deletePics(sPort);
				} catch (IOException e) {
					System.out.println("Error getting Pictures via gPhoto2");
				}
				
				bDeletePics = false;
            }
            
            if(bCapture)
            {
            	if(bLaunchCapture)
            	{
            		nCaptures++;
            		this.sCaptureDirectory="Capture"+String.format("%03d", nCaptures);
            		mbed.sendCommand("CAP");
                    fenetre.activateButtonLaunch(false);
                    fenetre.activateButtonDemo1(false);
                    fenetre.activateButtonDemo2(false);
                    fenetre.activateButtonDemo3(false);
                    fenetre.activateButtonSetOneLed(false);
                    fenetre.activateButtonSetAllLed(false);
                    fenetre.activateButtonLoad(false);
                    fenetre.activateButtonHelp(false);
                    fenetre.writeStateCapture("Light Stage Supelec is acquiring...");
            	}else
            	{
            		
                    fenetre.activateButtonLaunch(true);
                    fenetre.activateButtonDemo1(true);
                    fenetre.activateButtonDemo2(true);
                    fenetre.activateButtonDemo3(true);
                    fenetre.activateButtonSetOneLed(true);
                    fenetre.activateButtonSetAllLed(true);
                    fenetre.activateButtonLoad(true);
                    fenetre.activateButtonHelp(true);
                    fenetre.writeStateCapture("Acquiring Pictures via USB ...");
                    this.getAllPics();
            	}
            	bCapture = false;
            }
            if(bDemo1)
            {
                if(bLaunchDemo1)
                {
                    mbed.sendCommand("DEMO1");
                    fenetre.activateButtonDemo2(false);
                    fenetre.activateButtonDemo3(false);
                    fenetre.activateButtonLaunch(false);
                    fenetre.activateButtonSetOneLed(false);
                    fenetre.activateButtonSetAllLed(false);
                    fenetre.activateButtonLoad(false);
                    fenetre.activateButtonHelp(false);
                    fenetre.writeStateCapture("Light Stage is in Demo Mode");
                } else
                {
                    mbed.sendCommand("STOPDEMO1");
                    fenetre.activateButtonDemo2(true);
                    fenetre.activateButtonDemo3(true);
                    fenetre.activateButtonLaunch(true);
                    fenetre.activateButtonSetOneLed(true);
                    fenetre.activateButtonSetAllLed(true);
                    fenetre.activateButtonLoad(true);
                    fenetre.activateButtonHelp(true);
                    fenetre.writeStateCapture("Light Stage ready to acquire");
                }
                bDemo1 = false;
            }
            if(bDemo2)
            {
                if(bLaunchDemo2)
                {
                    mbed.sendCommand("DEMO2");
                    fenetre.activateButtonDemo1(false);
                    fenetre.activateButtonDemo3(false);
                    fenetre.activateButtonLaunch(false);
                    fenetre.activateButtonSetOneLed(false);
                    fenetre.activateButtonSetAllLed(false);
                    fenetre.activateButtonLoad(false);
                    fenetre.activateButtonHelp(false);
                    fenetre.writeStateCapture("Light Stage in Demo Mode");
                } else
                {
                    mbed.sendCommand("STOPDEMO2");
                    fenetre.activateButtonDemo1(true);
                    fenetre.activateButtonDemo3(true);
                    fenetre.activateButtonLaunch(true);
                    fenetre.activateButtonSetOneLed(true);
                    fenetre.activateButtonSetAllLed(true);
                    fenetre.activateButtonLoad(true);
                    fenetre.activateButtonHelp(true);
                    fenetre.writeStateCapture("Light Stage ready to acquire");
                }
                bDemo2 = false;
            }
            if(bDemo3)
            {
                if(bLaunchDemo3)
                {
                    mbed.sendCommand("DEMO3");
                    fenetre.activateButtonDemo1(false);
                    fenetre.activateButtonDemo2(false);
                    fenetre.activateButtonLaunch(false);
                    fenetre.activateButtonSetOneLed(false);
                    fenetre.activateButtonSetAllLed(false);
                    fenetre.activateButtonLoad(false);
                    fenetre.activateButtonHelp(false);
                    fenetre.writeStateCapture("Light Stage is in Demo Mode");
                } else
                {
                    mbed.sendCommand("STOPDEMO3");
                    fenetre.activateButtonDemo1(true);
                    fenetre.activateButtonDemo2(true);
                    fenetre.activateButtonLaunch(true);
                    fenetre.activateButtonSetOneLed(true);
                    fenetre.activateButtonSetAllLed(true);
                    fenetre.activateButtonLoad(true);
                    fenetre.activateButtonHelp(true);
                    fenetre.writeStateCapture("Light Stage is ready to acquire :)");
                }
                bDemo3 = false;
            }
            if(bOneLed)
            {
                mbed.sendCommand(sValueOneLed);
                bOneLed = false;
            }
            if(bAllLed)
            {
                mbed.sendCommand(sValueAllLed);
                bAllLed = false;
            }
            if(bTimeBetweenTwoPics)
            {
                if(bSend){
            	mbed.sendCommand(sTimeBetweenTwoPics);
                }else{
                	fenetre.getTimeBetweenTwoPics(mbedTP);
                }
                bTimeBetweenTwoPics = false;
            }
            if(bTimeBetweenTwoTypes)
            {
                if(bSend){
                	mbed.sendCommand(sTimeBetweenTwoTypes);
                }else{
                	fenetre.getTimeBetweenTwoTypes(mbedTT);
                }
                bTimeBetweenTwoTypes = false;
            }
            if(bMinLightLevel)
            {
                if(bSend){
                	mbed.sendCommand(sMinLightLevel);
                }else{
                	fenetre.getMinLightLevel(mbedMINL);
                }
                bMinLightLevel = false;
            }
            if(bMaxLightLevel)
            {
                if(bSend){
                	mbed.sendCommand(sMaxLightLevel);
                }else{
                	fenetre.getMaxLightLevel(mbedMAXL);
                }
                bMaxLightLevel = false;
            }
            if(bAfter)
            {
                if(bSend){
                	mbed.sendCommand(sAfter);
                }else{
                	fenetre.getAfter(mbedAft);
                }
                bAfter = false;
            }
            if(bBefore)
            {
                mbed.sendCommand(sBefore);
                bBefore = false;
            }
            if(bParameters)
            {
                System.out.println("Debug : Sending Parameters to the Mbed");
                fenetre.getParameters();
                bParameters = false;
            }
            
            try
            {
                Thread.sleep(100L);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        } while(true);
    }

    public void refreshConnection()
    {
        bRefreshConnection = true;
    }

    public void reset()
    {
        reseted = true;
    }

    public void onNewConnectionState(String newConnectionState)
    {
        bNewConnectionState = true;
        connectionState = newConnectionState;
    }
    
    public void refreshCams()
    {
    	bRefreshCam = true;
    }
    
    public void getPics(String port)
    {
    	this.sPort = port;
    	bGetPics = true;
    }
    
    public void setSeparate(boolean separate)
    {
    	bSeparate = separate;
    }
    
    public void deletePics(String port)
    {
    	this.sPort = port;
    	
    	bDeletePics = true;
    }
    
    public void getAllPics()
    {
    	bGetPics = true;
    	this.sPort="";
    }

    public void launchCapture()
    {
        bCapture = true;
        bLaunchCapture = true;
    }
    
    public void endCapture()
    {
    	bCapture = true;
    	bLaunchCapture = false;
    }

    public void launchDemo1()
    {
        bDemo1 = true;
        bLaunchDemo1 = true;
    }

    public void launchDemo2()
    {
        bDemo2 = true;
        bLaunchDemo2 = true;
    }

    public void launchDemo3()
    {
        bDemo3 = true;
        bLaunchDemo3 = true;
    }

    public void stopDemo1()
    {
        bDemo1 = true;
        bLaunchDemo1 = false;
    }

    public void stopDemo2()
    {
        bDemo2 = true;
        bLaunchDemo2 = false;
    }

    public void stopDemo3()
    {
        bDemo3 = true;
        bLaunchDemo3 = false;
    }

    public void setAllLed(String value)
    {
        bAllLed = true;
        sValueAllLed = value;
    }

    public void setOneLed(String value)
    {
        bOneLed = true;
        sValueOneLed = value;
    }

    public void setTimeBetweenTwoPics(String value)
    {
        bTimeBetweenTwoPics = true;
        sTimeBetweenTwoPics = value;
        bSend=true;
    }
    public void getTimeBetweenTwoPics(String value){
    	int value_=Integer.parseInt(value.substring(2, value.length()-1));
    	mbedTP=value_;
    	bSend=false;
    	bTimeBetweenTwoPics = true;
    	
    	
    }

    public void setTimeBetweenTwoTypes(String value)
    {
    	bTimeBetweenTwoTypes = true;
        sTimeBetweenTwoTypes = value;
        bSend=true;
    }
    
    public void getTimeBetweenTwoTypes(String value){
    	int value_= Integer.parseInt(value.substring(2, value.length()-1));
    	mbedTT = value_;
    	bSend = false;
    	bTimeBetweenTwoTypes = true;    	
    }

    public void setMinLightLevel(String value)
    {
        bMinLightLevel = true;
        sMinLightLevel = value;
    	bSend = true;
    }
    
    public void getMinLightLevel(String value){
    	int value_= Integer.parseInt(value.substring(4, value.length()-1));
    	mbedMINL = value_;
    	bSend = false;
    	bMinLightLevel = true; 	
    }

    public void setMaxLightLevel(String value)
    {
        bMaxLightLevel = true;
        sMaxLightLevel = value;
    	bSend = true;
    }
    
    public void getMaxLightLevel(String value){
    	int value_= Integer.parseInt(value.substring(4, value.length()-1));
    	mbedMAXL = value_;
    	bSend = false;
    	bMaxLightLevel = true; 	
    }

    public void setBefore(String value)
    {
        bBefore = true;
        sBefore = value;
        bSend = true;
    }

    public void setAfter(String value)
    {
        bAfter = true;
        sAfter = value;
        bSend = true;
    }
    public void getAfter(String value){
    	int value_= Integer.parseInt(value.substring(3, value.length()-1));
    	mbedAft = value_;
    	bSend = false;
    	bAfter = true; 	
    }

    public void sendParameters()
    {
        bParameters = true;
    }

    private Fenetre fenetre;
    private Comm mbed;
    private gPhotoCom gphoto;
    private Hashtable<String,String> devices;
    boolean clicked;
    boolean reseted;
    private String connectionState;
    private boolean bNewConnectionState;
    private boolean bRefreshConnection;
    private boolean bRefreshCam;
    private boolean bGetPics;
    private boolean bDeletePics;
    private String sCaptureDirectory;
    private String sPort;
    private int nCaptures;
    private boolean bSeparate;
    private boolean bCapture;
    private boolean bLaunchCapture;
    private boolean bDemo1;
    private boolean bDemo2;
    private boolean bDemo3;
    private boolean bLaunchDemo1;
    private boolean bLaunchDemo2;
    private boolean bLaunchDemo3;
    private boolean bAllLed;
    private boolean bOneLed;
    private boolean bTimeBetweenTwoPics;
    private boolean bTimeBetweenTwoTypes;
    private boolean bMinLightLevel;
    private boolean bMaxLightLevel;
    private boolean bBefore;
    private boolean bAfter;
    private boolean bParameters;
    private boolean bSend;
    private String sValueAllLed;
    private String sValueOneLed;
    private String sTimeBetweenTwoPics;
    private int mbedTP;
    private String sTimeBetweenTwoTypes;
    private int mbedTT;
    private String sMinLightLevel;
    private int mbedMINL;
    private String sMaxLightLevel;
    private int mbedMAXL;
    private String sBefore;
    private String sAfter;
    private int mbedAft;
}
