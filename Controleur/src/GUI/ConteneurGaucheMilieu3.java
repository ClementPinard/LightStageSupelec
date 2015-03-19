// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConteneurGaucheMilieu3.java

package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

// Referenced classes of package GUI:
//            ConteneurGaucheMilieu

public class ConteneurGaucheMilieu3 extends JPanel
{
    class FiltreExtension extends FileFilter
    {

        public boolean accept(File fichier)
        {
            if(fichier.getName().endsWith(extension1) || fichier.getName().endsWith(extension2))
                return true;
            return fichier.isDirectory();
        }

        public String getDescription()
        {
            return (new StringBuilder(String.valueOf(description))).append("(*").append(extension1).append(")").toString();
        }

        String extension1;
        String extension2;
        String description;
        final ConteneurGaucheMilieu3 this$0;

        public FiltreExtension(String extension1, String extension2, String description)
        {
        	super();
        	this$0 = ConteneurGaucheMilieu3.this;
            this.extension1 = extension1;
            this.extension2 = extension2;
            this.description = description;
        }
    }

    class loadButtonListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent arg0)
        {
            try
            {
                openFile();
            }
            catch(IOException ioexception) { }
        }
    }

    class saveButtonListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent arg0)
        {
            try
            {
                saveFile();
            }
            catch(IOException ioexception) { }
        }
    }


    ConteneurGaucheMilieu3(ConteneurGaucheMilieu conteneurGaucheMilieu)
    {
        loadButton = new JButton("Load Pattern from Mbed...");
        saveButton = new JButton("Save Pattern to Mbed...");
        this.conteneurGaucheMilieu = conteneurGaucheMilieu;
        setBorder(BorderFactory.createTitledBorder("Load or Save new Patterns"));
        setPreferredSize(new Dimension(300, 53));
        setLayout(new GridLayout(1, 2));
        bDriveFound = false;
        java.util.List files = Arrays.asList(File.listRoots());
        for(Iterator iterator = files.iterator(); iterator.hasNext();)
        {
            File f = (File)iterator.next();
            String s1 = FileSystemView.getFileSystemView().getSystemDisplayName(f);
            if(s1.startsWith("MBED"))
            {
                MBED = s1.substring(6, 8);
                bDriveFound = true;
            }
        }

        if(!bDriveFound)
            loader = new JFileChooser(".");
        else
            loader = new JFileChooser((new StringBuilder(String.valueOf(MBED))).append("/").toString());
        System.out.println("");
        saver = new JFileChooser("../Light Stage Supelec/Patterns/");
        loader.setPreferredSize(new Dimension(640, 360));
        loader.setAcceptAllFileFilterUsed(false);
        loader.addChoosableFileFilter(new FiltreExtension(".txt", ".TXT", "Fichier Texte"));
        saver.setPreferredSize(new Dimension(640, 360));
        saver.setAcceptAllFileFilterUsed(false);
        saver.addChoosableFileFilter(new FiltreExtension(".txt", ".TXT", "Fichier Texte"));
        add(loadButton);
        add(saveButton);
        loadButton.addActionListener(new loadButtonListener());
        saveButton.addActionListener(new saveButtonListener());
        if(!bDriveFound)
        {
            loadButton.setEnabled(false);
            saveButton.setEnabled(false);
        }
    }

    public void refreshDrive()
    {
        bDriveFound = false;
        System.out.println("Trying to find drive Letter of MBED...");
        java.util.List files = Arrays.asList(File.listRoots());
        for(Iterator iterator = files.iterator(); iterator.hasNext();)
        {
            File f = (File)iterator.next();
            String s1 = FileSystemView.getFileSystemView().getSystemDisplayName(f);
            if(s1.startsWith("MBED"))
            {
                MBED = s1.substring(6, 8);
                bDriveFound = true;
            }
        }

        if(!bDriveFound)
        {
            System.out.println("MBED Drive not found...");
            loader = new JFileChooser(".");
        } else
        {
            System.out.println((new StringBuilder("MBED successfully found, drive lettre is ")).append(MBED).append("/ :D").toString());
            loader = new JFileChooser((new StringBuilder(String.valueOf(MBED))).append("/").toString());
        }
        System.out.println("");
        saver = new JFileChooser("../Light Stage Supelec/Patterns/");
        if(!bDriveFound)
        {
            loadButton.setEnabled(false);
            saveButton.setEnabled(false);
        }
    }

    public void activateButtonLoad(boolean bool)
    {
        loadButton.setEnabled(bool);
    }

    public void activateButtonHelp(boolean bool)
    {
        saveButton.setEnabled(bool);
    }

    void openFile()
        throws IOException
    {
        int resultat = loader.showOpenDialog(loader);
        if(resultat == 0)
        {
            source = loader.getSelectedFile();
            System.out.println((new StringBuilder("Loading from mbed, to Patterns directory ")).append(source.getName()).append("...").toString());
            dest = new File((new StringBuilder("../Light Stage Supelec/Patterns/")).append(source.getName()).toString());
            if(!dest.exists())
            {
                copyFileUsingJava7Files(source, dest);
                System.out.println((new StringBuilder(String.valueOf(source.getName()))).append(" has been successfuly copied from mbed to Patterns directory").toString());
            } else
            {
                System.out.println("Warning : file already exists, source file hasn't been copied!");
            }
        }
    }

    void saveFile()
        throws IOException
    {
        int resultat = saver.showOpenDialog(loader);
        if(resultat == 0)
        {
            source = saver.getSelectedFile();
            System.out.println((new StringBuilder("Save to mbed, from Patterns directory: ")).append(source.getName()).toString());
            dest = new File((new StringBuilder(String.valueOf(MBED))).append("/").append(source.getName()).toString());
            if(!dest.exists())
            {
                copyFileUsingJava7Files(source, dest);
                System.out.println((new StringBuilder(String.valueOf(source.getName()))).append(" has been successfuly copied from Patterns directory to mbed").toString());
            } else
            {
                System.out.println("Warning : file already exists, source file hasn't been copied!");
            }
        }
    }

    private void copyFileUsingJava7Files(File source, File dest)
        throws IOException
    {
        Files.copy(source.toPath(), dest.toPath(), new CopyOption[0]);
    }

    ConteneurGaucheMilieu conteneurGaucheMilieu;
    private JButton loadButton;
    private JButton saveButton;
    JFileChooser loader;
    JFileChooser saver;
    File source;
    File dest;
    boolean bDriveFound;
    String MBED;
}
