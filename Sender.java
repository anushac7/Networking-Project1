package Basestation;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
public class Sender implements ConfigIF, SourceConfigIF {

    // socket reference
    Socket         socket     = null;
    
    //OutputStream Reference
    OutputStream   os,os5,os6;
    DataOutputStream dos1,dos5,dos6;
    PrintStream    ps         = null;
    Vector         packets    = null;
public String str1="",str2="",str3;

 
    public Sender() throws Exception {
        intializeSetup();
        intializeStream();
        packetforward();
       
    } 
    public void intializeSetup()throws Exception
    {
       
        socket = new Socket(routerIP,routerPort);
    }

   
    public void intializeStream() throws Exception{
         os = socket.getOutputStream();
         dos1=new DataOutputStream(os);
          os5 = socket.getOutputStream();
         dos5=new DataOutputStream(os5);
          os6 = socket.getOutputStream();
         dos6=new DataOutputStream(os6);
      
    }
public void sendPackets(String packets,String remove,String receiver) throws Exception{
    System.out.println("hai hello");

      //calculate the start time of transfer  
      long startTime = System.currentTimeMillis();
     
      str3=packets;//+"good"+remove;
      String key=remove;
      String receive=receiver;
    dos1.writeUTF(str3);
    dos5.writeUTF(key);
    dos6.writeUTF(receive);
    //System.out.println("mirsha11");
    System.out.println(receive);
         
      long endTime = System.currentTimeMillis();
      //calculate the total time
      long totalTime = endTime - startTime;

      System.out.println("Start Time :"+ startTime);
      System.out.println("End   Time :"+ endTime);
      System.out.println("Total Time :"+ totalTime);
        
    }
public void packetforward() throws Exception
{

}
    public void closeConnection() throws Exception {
        ps.close();
        socket.close();
        System.out.println("Client Connection Closed");
    }
    
    public static void main(String[] args) throws Exception {
       Sender sender = new Sender(); 
    }
   
}
