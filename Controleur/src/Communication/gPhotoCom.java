package Communication;

import java.io.*;
import java.lang.Runtime;
import java.util.Hashtable;

public class gPhotoCom {
	public Hashtable<String,String> getDevices() throws IOException{
		
		devices.clear();
		
		Runtime runtime = Runtime.getRuntime();
		final Process process = runtime.exec("gphoto2/gphoto2.exe --auto-detect",envp);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		try {
			int i=0;
			while((line = reader.readLine()) != null) {
				// Traitement du flux de sortie de l'application si besoin est
				i++;
				System.out.println(line);
				if(i>=3){
					devices.put(line.substring(line.indexOf("usb")),"");
				}
			}
		} finally {
			reader.close();
		}
		
		//affichage des modeles d'APN connecté et leur port usb
		 for (String key: devices.keySet()) {
			 devices.put(key, getModel(key));
			 }
		 
		 return devices;
	}
	
	public String getModel(String port) throws IOException{
		String model = "";
		
		Runtime runtime = Runtime.getRuntime();
		final Process process = runtime.exec("gphoto2/gphoto2.exe --summary --port " +port,envp);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		try {
			int i=0;
			while((line = reader.readLine()) != null) {
				// Traitement du flux de sortie de l'application si besoin est
				i++;
				if(i==3){
					model =line.substring(line.indexOf("Model")+6);
					
				}
			}
		} finally {
			reader.close();
		}
		
		return model;
	}
	
	public gPhotoCom() {
		
		devices = new Hashtable<String,String>();
		envp = new String[]{ "CAMLIBS=gphoto2/camlibs", "IOLIBS=gphoto2/iolibs" };
	}
	
	public void getPics(String folderPath, boolean separate) throws IOException{
		for(String port:devices.keySet()){
			getPics(folderPath,port,separate);
			deletePics(port);
		}
		
		
		
	}
	


	public void getPics(String folderPath, String sPort,boolean separate) throws IOException{
		
		Runtime runtime = Runtime.getRuntime();
		Process process;
		String picPath=folderPath+"/"+sPort.substring(sPort.indexOf("libusb"))+(separate?"/":"_");
		process = runtime.exec("D:\\gphoto2\\gphoto2.exe --get-all-files --force-overwrite --port " + sPort + " --filename " + picPath+"%2n.jpg",envp);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		try {
			while((line = reader.readLine()) != null) {
				// Traitement du flux de sortie de l'application si besoin est
				if(line.matches("Saving(.*)")){
					System.out.println(line);
				}
			}
		} finally {
			reader.close();
		}		
	}
	
	public void deletePics(String sPort) throws IOException{
		
		Runtime runtime = Runtime.getRuntime();
		Process process;
		process = runtime.exec("gphoto2/gphoto2.exe -D -R --port " + sPort,envp);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		try {
			while((line = reader.readLine()) != null) {
				// Traitement du flux de sortie de l'application si besoin est
				System.out.println(line);
			}
		} finally {
			reader.close();
		}		
	}
	
	Hashtable<String, String> devices;
	String[] envp;
	
	
}
