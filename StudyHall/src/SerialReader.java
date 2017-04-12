import java.io.IOException;
import java.io.InputStream;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialReader implements SerialPortEventListener // required to connect to scanner, I know its not great to have nested classes but this was the best implementation i could find
    {
        private InputStream in;
        private byte[] buffer = new byte[1024];
        
        public SerialReader ( InputStream in )
        {
            this.in = in;
        }
        
        public void serialEvent(SerialPortEvent arg0) 
        {
            int data;
          
            try
            {
                int len = 0;
                while ((data = in.read()) > -1 )
                {
                    if (data == '\n' ) 
                    {
                        break;
                    }
                    buffer[len++] = (byte) data;
                }
                String id = new String(buffer,0,len);
                SHCheckin.scanned(id);
            }
            catch ( IOException e )
            {
                e.printStackTrace();
                System.exit(-1);
            }             
        }

    }
