/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clusternode1; 

/**
 *
 * @author AVANCER
 */




public class Receiver1 {

   public Receiver1() throws Exception {



      clusterreceiverUI1 receiverUI = new clusterreceiverUI1("Aggregator1 Receiver1");

      while(true) {
        clusterPacketReceiver1 receiver = new clusterPacketReceiver1(receiverUI);
      }
   }


   public static void main(String[] args) throws Exception {
      Receiver1 obj = new Receiver1();
   }
}