

package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.*;

// Referenced classes of package GUI:
//            About, Help, ConteneurDroit

public class ConteneurAPNConfig extends JPanel
{
    class aboutButtonListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            try
            {
                apnConfig.setVisible(true);
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }
        }
    }


    ConteneurAPNConfig(ConteneurDroit conteneurDroit)
    {
    	APNButton = new JButton("Manage...");
        APNLabel = new JLabel("no device connected");
        APNLabel.setHorizontalAlignment(0);
        apnConfig = new APNConfig(conteneurDroit);
        this.conteneurDroit = conteneurDroit;
        setBorder(BorderFactory.createTitledBorder("Cameras"));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx=0.5;
        c.gridwidth = 1;
        add(APNButton,c);
        c.gridx = 1;
        c.gridwidth = 2;
        add(APNLabel,c);
        APNButton.addActionListener(new aboutButtonListener());
    }

    ConteneurDroit conteneurDroit;
    private JButton APNButton;
    private JLabel APNLabel;
    APNConfig apnConfig;
    
    public void refreshCams()
    {
    	conteneurDroit.refreshCams();
    }
    
    
    
    
    public void getDevices(Hashtable<String,String> devices)
    {
    	apnConfig.getDevices(devices);
    	
    	int APNs = devices.size();
    	if(APNs == 1){
    		APNLabel.setText("1 device connected");
    	}else if(APNs > 1){
    		APNLabel.setText(APNs+ " devices connected");
    	}
    }
}
