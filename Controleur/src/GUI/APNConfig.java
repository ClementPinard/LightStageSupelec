package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;
import java.util.Set;

import javax.swing.*;

import Core.Noyau;

public class APNConfig extends JFrame
{
	
	class refreshButtonListener
	implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			try
			{
				refresh.setText("refreshing...");
				refresh.setEnabled(false);
				conteneurDroit.refreshCams();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	class SeprateListener
	implements ItemListener
	{
		public void itemStateChanged(ItemEvent e) {
			bSeparate = e.getStateChange()==ItemEvent.SELECTED;
			for(String port:deviceList.keySet()){
				deviceList.get(port).setSeparate(bSeparate);
			}
			conteneurDroit.setSeparate(bSeparate);
			

		}
	}
	
	public void getDevices(Hashtable<String,String> devices)
    {
    	this.devices=devices;
    	refresh.setText("Refresh");
		refresh.setEnabled(true);
    	
    	Set<String> set = deviceList.keySet();
    	for(String port:set){
    		APNPanel panel= deviceList.get(port);
    		if (devices.get(port) != panel.model){
    			set.remove(panel);
    			liste.remove(panel);
    		}else
    		{
    			devices.remove(port);
    		}
    		
    	}
    	for(String port:devices.keySet()){
    		String model = devices.get(port);
    		System.out.println(model + " " + port);
    		APNPanel panel = new APNPanel(this,port,model);
    		deviceList.put(port, panel);
    		liste.add(panel);
    	}
    	invalidate();
    	revalidate();
    }

    public APNConfig(ConteneurDroit conteneurDroit)
    {
        super();
        this.conteneurDroit=conteneurDroit;
        deviceList= new Hashtable <String,APNPanel>();
        setTitle("Cameras Configuration");
        setSize(640, 360);
        setLocationRelativeTo(null);
        setResizable(false);
        
        setLayout(new BorderLayout());
        
        menu = new JPanel();
        liste = new JPanel();
        
        area = new JLabel("Config Appareils photos");
    	refresh = new JButton("Refresh");
    	separate = new JCheckBox("Download pictures in separate folders");
    	bSeparate=false;
    	       
        menu.setLayout(new GridLayout(2,0));
        menu.add(area);
        menu.add(refresh);
        menu.add(separate);

        add(menu,"North");
        
        liste.setLayout(new GridLayout(0,1));
        
        add(liste,"South");
        refresh.addActionListener(new refreshButtonListener());
        separate.addItemListener(new SeprateListener());
    }
    
    public void getPics(String port)
    {
    	conteneurDroit.getPics(port);
    }
    
    public void deletePics(String port)
    {
    	conteneurDroit.deletePics(port);
    }

    ConteneurDroit conteneurDroit;
    JLabel area;
    JButton refresh;
    JPanel liste;
    JPanel menu;
    JCheckBox separate;
    boolean bSeparate;
    
    Hashtable <String,String> devices;
    Hashtable <String,APNPanel> deviceList;
    
    
}
