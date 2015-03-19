// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LightStageSupelec.java

package Main;

import Communication.Comm;
import Communication.gPhotoCom;
import Core.Noyau;
import GUI.Fenetre;

public class LightStageSupelec
{

    public static void main(String args[])
    {
        System.out.println("\n\n");
        System.out.println("###############################################################");
        System.out.println("#   Light Stage Supelec - Control Software v1.01 is loading   #");
        System.out.println("###############################################################\n");
        Comm monMbed = new Comm();
        Fenetre maFenetre = new Fenetre(monMbed);
        gPhotoCom gphoto = new gPhotoCom();
        Noyau monNoyau = new Noyau(maFenetre, monMbed, gphoto);
        Thread monThreadKernel = new Thread(monNoyau);
        monThreadKernel.start();
        monMbed.setKernel(monNoyau);
        maFenetre.setKernel(monNoyau);
        monNoyau.init();
        monMbed.init();
        maFenetre.init();
        try
        {
            Thread.sleep(500L);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("\nLaunch successfull");
        System.out.println("-----------------------------------------\n");
    }
}
