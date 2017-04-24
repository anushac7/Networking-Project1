/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clusternode1;

/**
 *
 * @author AVANCER
 */


/*
   This class is used to receive the incoming packets

*/

import java.io.*;
import java.net.*;
import java.util.*;
import Basestation.ConfigIF;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class clusterPacketReceiver1 implements ConfigIF {
    ServerSocket    serverSocket   = null;
    Socket          socket         = null;
  public String str1,str2;
 public static String time;
 InputStream        is1,is1a           = null;
    DataInputStream dis2,dis2a=null;
    clusterreceiverUI1         receiverUI   = null;
   Toolkit toolkit;

  Timer timer;


  public clusterPacketReceiver1(clusterreceiverUI1 receiverUI) throws Exception {

          this.receiverUI = receiverUI;

          intializeSetup();
          intializeStream();
          receivePackets();
          closeConnection();
    }

    public void intializeSetup() throws Exception {
      serverSocket = new ServerSocket(destPort3);
      socket = serverSocket.accept();

    }

    public void intializeStream() throws Exception {
      is1 = socket.getInputStream();
     dis2=new DataInputStream(is1);
     is1a = socket.getInputStream();
     dis2a=new DataInputStream(is1a);
    }

    public void receivePackets() throws Exception
    {
System.out.println("the value is very is");

          str1 = dis2.readUTF(dis2);
    str2 = dis2a.readUTF(dis2a);
    // Calendar calendar = Calendar.getInstance();
    //time=calendar.get(Calendar.HOUR) + ":"+calendar.get(Calendar.MINUTE);
      System.out.println("Received packet:"+time);

    System.out.println("Enter1");
   /*   Vector vector = new Vector();
      StringTokenizer tokenizer = new StringTokenizer(str,"seperation");

   while ( tokenizer.hasMoreElements() ) {
          str1+=tokenizer.nextToken();

      }
*/
    receiverUI.jta.append(str2);
   receiverUI.jta3.append(str1);
 receiverUI.jta3.setVisible(false);

   toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
    timer.schedule(new RemindTask(), 120 * 1000);

      }


 class RemindTask extends TimerTask {
    public void run() {
      System.out.println("Time's up!");
      receiverUI.jta.setText("Time's up!");
      toolkit.beep();
      //timer.cancel(); //Not necessary because we call System.exit
     // System.exit(0); //Stops the AWT thread (and everything else)
    }
  }






    public void closeConnection() throws Exception {

       socket.close();
       serverSocket.close();
    }

}