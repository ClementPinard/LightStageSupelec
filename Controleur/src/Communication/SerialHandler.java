// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SerialHandler.java

package Communication;

import gnu.io.*;
import java.io.*;
import java.util.Enumeration;

// Referenced classes of package Communication:
//            Comm

public class SerialHandler
{
    public class SerialReader
        implements SerialPortEventListener
    {

        public void serialEvent(SerialPortEvent arg0)
        {
            if(!connectionLost)
                try
                {
                    int len = 0;
                    int data;
                    while((data = in.read()) > -1) 
                    {
                        if(data == 10)
                            break;
                        buffer[len++] = (byte)data;
                    }
                    if((char)buffer[len - 1] == '#')
                        comm.handleNewCommandeFromMbed((new String(buffer, 0, len)).substring(0, len - 2));
                    else
                        System.out.println((new StringBuilder("CLIENT->PC : ")).append(new String(buffer, 0, len)).toString());
                }
                catch(IOException e)
                {
                    System.out.println("Warning : connection lost");
                    connectionLost = true;
                    try
                    {
                        Runtime.getRuntime().exec("java -jar LSSCS.jar");
                        System.exit(0);
                    }
                    catch(IOException e1)
                    {
                        e1.printStackTrace();
                    }
                }
        }

        private boolean connectionLost;
        private InputStream in;
        final SerialHandler this$0;

        public SerialReader(InputStream in)
        {
        	super();
        	this$0 = SerialHandler.this;
            connectionLost = false;
            this.in = in;
        }
    }

    public class SerialWriter
        implements Runnable
    {

        public void run()
        {
            try
            {
                for(int c = 0; (c = System.in.read()) > -1;)
                    out.write(c);

            }
            catch(IOException e)
            {
                e.printStackTrace();
                System.exit(-1);
            }
        }

        OutputStream out;
        final SerialHandler this$0;

        public SerialWriter(OutputStream out)
        {
        	super();
        	this$0 = SerialHandler.this;
            this.out = out;
        }
    }


    public SerialHandler(Comm comm)
    {
        buffer = new byte[1024];
        this.comm = comm;
    }

    public Enumeration list()
    {
        Enumeration ports = CommPortIdentifier.getPortIdentifiers();
        return ports;
    }

    boolean connect(CommPortIdentifier portIdentifier)
        throws Exception
    {
        boolean isMbed = false;
        if(portIdentifier.isCurrentlyOwned())
        {
            System.out.println("Error: Port is currently in use");
        } else
        {
            CommPort commPort = portIdentifier.open(getClass().getName(), 2000);
            if(commPort instanceof SerialPort)
            {
                SerialPort serialPort = (SerialPort)commPort;
                serialPort.setSerialPortParams(9600, 8, 1, 0);
                InputStream in = serialPort.getInputStream();
                OutputStream out = serialPort.getOutputStream();
                serialPort.addEventListener(new SerialReader(in));
                serialPort.notifyOnDataAvailable(true);
                out.write(whois);
                System.out.println("PC->CLIENT : WHOIS#");
                Thread.sleep(400L);
                if(buffer[0] == 77 && buffer[1] == 66 && buffer[2] == 69 && buffer[3] == 68)
                {
                    System.out.println((new StringBuilder("Debug : ")).append(portIdentifier.getName()).append(" is the mbed").toString());
                    isMbed = true;
                    inMbed = in;
                    outMbed = out;
                    portIdentifierMbed = portIdentifier;
                    serialPortMbed = serialPort;
                    (new Thread(new SerialWriter(outMbed))).start();
                } else
                {
                    System.out.println((new StringBuilder("Debug : wrong answer, ")).append(portIdentifier.getName()).append(" isn't an mbed!").toString());
                    isMbed = false;
                    serialPort.close();
                }
            } else
            {
                System.out.println("Error: Only serial ports are handled by this example.");
                isMbed = false;
            }
        }
        return isMbed;
    }

    byte whois[] = {
        87, 72, 79, 73, 83, 35
    };
    InputStream inMbed;
    OutputStream outMbed;
    CommPortIdentifier portIdentifierMbed;
    public SerialPort serialPortMbed;
    Comm comm;
    byte buffer[];
}
