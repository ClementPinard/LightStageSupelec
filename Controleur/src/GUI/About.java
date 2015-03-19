// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   About.java

package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;

// Referenced classes of package GUI:
//            AboutHaut, AboutMilieu, AboutBas

public class About extends JFrame
{

    public About()
    {
        aboutHaut = new AboutHaut();
        aboutMilieu = new AboutMilieu();
        aboutBas = new AboutBas();
        setTitle("About : Light Stage Sup\351lec - Control Software");
        setSize(640, 430);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        add(aboutHaut, "North");
        add(aboutMilieu, "Center");
        add(aboutBas, "South");
    }

    AboutHaut aboutHaut;
    AboutMilieu aboutMilieu;
    AboutBas aboutBas;
}
