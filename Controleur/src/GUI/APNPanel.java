package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class APNPanel extends JPanel {
	
	class getPicsButtonListener
	implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			apnConfig.getPics(port);
		}
	}

	class deletePicsButtonListener
	implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			apnConfig.deletePics(port);
		}
	}
	
	public APNPanel(APNConfig apnConfig, String port, String model)
    {
        super();
        this.apnConfig=apnConfig;
        this.port = port;
        this.model = model;
        setBorder(BorderFactory.createTitledBorder("Port "+ port));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        
        getPictures = new JButton("Get pictures");
        getPictures.addActionListener(new getPicsButtonListener());
        deletePictures = new JButton("Delete pictures");
        deletePictures.addActionListener(new deletePicsButtonListener());
        modelLabel = new JLabel(model);
        directoryLabel = new JLabel();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx=0.5;
        c.weighty=0.5;
        c.gridheight=1;
        add(modelLabel,c);
        c.gridy = 1;
        add(directoryLabel,c);
        c.gridx = 1;
        c.weightx=0.1;
        add(getPictures,c);
        c.gridx = 2;
        add(deletePictures,c);
        directory = "Dump/";
        directoryLabel.setText("Saved in "+directory);
    }
	
	public void setSeparate(boolean separated){
		String append = separated?port.substring(port.indexOf("libusb"))+"/":"";
		directoryLabel.setText("Saved in "+ directory + append);
	}

    APNConfig apnConfig;
    String port;
    String model;
    String directory;
    JLabel modelLabel;
    JLabel directoryLabel;
    JButton getPictures;
    JButton deletePictures;
}
