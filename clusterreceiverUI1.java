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
   This class is used to provider
   UI for the Receiver node in the
   network
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.AlgorithmParameterSpec;

import java.util.Calendar;
import javax.swing.*;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class clusterreceiverUI1 extends JFrame implements ActionListener{
    private JTable           table        = null;

  public JTextField jt,jip,jtw;
	public TextArea jta,jta2,jta3;
        public JButton jb1,jb2,jb3,jb4,jb5,jb6,jbw;
        	public JLabel jl,encrypted,j3,j4,jla,jlc1,jlc2,jlc3,jlc4,jlw;
        JPanel jp=new JPanel();
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
        JTabbedPane jtp=new JTabbedPane();
     private Object colHeader[] = {
                                  "SourceIP",
                                  "Protocol Type",
                                  "Packet Data",
                                  "Status",
                                  "Packet Size",

                                 };
    
public String b,str3,str4,str5,str2,key1,time,encrypt,key2,str;
    private String str1;
    /*
       Constructor
    */
    public clusterreceiverUI1(String title) throws Exception {
   jp.setBackground(Color.GRAY);
         jp.setLayout(null);
		jp1.setLayout(null);
		jt=new JTextField(20);
		jip=new JTextField(20);
		jtw=new JTextField(20);
		jta=new TextArea();
              //  jta1=new TextArea();
                jta2=new TextArea();
                jta3=new TextArea();
             //   jta4=new TextArea();
                jl=new JLabel("Secret Key Value:");
		//j4=new JLabel("Choose The File:  ");
                jlw=new JLabel("Choose the destination:");
		//jb1=new JButton("Open");
		jb2=new JButton("Generate Key");
	        jb4=new JButton("Integrity");
		jb5=new JButton("Cancel");
                jbw=new JButton("Request");
		//jl=new JLabel("Browse Server1 packet:");
		//j4=new JLabel("Enter the Destination:  ");
               // jlw=new JLabel("Browse Server2 packet:");
		//jb1=new JButton("Server1");
		jb6=new JButton("Clear");
              //  decrypt=new JButton("decrpt");
               // original=new JLabel("Orginal File");
	      //  jb4=new JButton("Send");
		//jb5=new JButton("Cancel");
                //jbw=new JButton("Server2");
		encrypted=new JLabel("Received File:");
               j3=new JLabel("Source side Encrypted Key:");
               j4=new JLabel("Destination side Encrypted Key:");

		jp.add(jl);
		jp.add(jt);
                jp.add(jlw);
                jp.add(jtw);
                 jp.add(jbw);
                 jp.add(encrypted);
                 jp1.add(j3);
                 jp1.add(j4);
		//jp.add(j4);
		jp.add(jip);
                  //   jp.add(original);
		//jp.add(jb1);
		jp.add(jb2);
                jp.add(jb6);
		//jp.add(j2);
		//jp.add(jradiobutton);
		jp1.add(jta);
               // jp.add(jta1);
                   jp.add(jta3);
                jp1.add(jta2);
	    jp1.add(jb4);
		jp1.add(jb5);
               // jp.add(jta4);
              //  jp.add(decrypt);
	   jtp.addTab("Data",jp);
		jtp.addTab("Receive",jp1);
              add(jtp);
              jta.setForeground(java.awt.Color.red);
             jta.setBackground(java.awt.Color.white);
             //jta1.setForeground(java.awt.Color.red);
            // jta1.setBackground(java.awt.Color.white);
             jta2.setForeground(java.awt.Color.red);
             jta2.setBackground(java.awt.Color.white);

             // jta.setEditable(false);
              //jta1.setEditable(false);
              //jta2.setEditable(false);
              //jta3.setEditable(false);
	  //  j4.setBounds(130,50,150,25);
          //   jip.setBounds(50,80,250,25);
           jl.setBounds(410,150,150,25);
           jt.setBounds(520,150,100,25);
          // original.setBounds(530,70,100,25);
//decrypt.setBounds(500,380,130,25);
//jta4.setBounds(410,100,350,250);
//           jb1.setBounds(140,120,65,25);
           jb2.setBounds(460,200,130,25);
           jb6.setBounds(120,380,130,25);
         //  jta1.setBounds(50,50,300,300);
           jta3.setBounds(50,50,300,300);

            encrypted.setBounds(100,25,100,25);
           j3.setBounds(80,25,190,25);
           j4.setBounds(470,25,190,25);

           jb4.setBounds(250,380,80,25);
           jb5.setBounds(340,380,80,25);
           jta.setBounds(50,50,300,300);
           jta2.setBounds(440,50,300,300);
      jb2.addActionListener(this);
		jb4.addActionListener(this);
                jb5.addActionListener(this);
                jb6.addActionListener(this);
                //decrypt.addActionListener(this);
        setTitle(title);
        setSize(800,500);
        setLocation(100,100);
        setVisible(true);
    }

public void actionPerformed(ActionEvent ae)
	{
try
      {
	if(ae.getSource()==jb5)
		{
System.exit(0);
             }
if(ae.getSource()==jb6)
		{
jta.setText("");
//jta1.setText("");
jta2.setText("");
             }
if(ae.getSource()==jb4)
		{
str4=jta.getText();
str5=jta2.getText();
if(str4.equals(str5)){
    str1=jta3.getText();
System.out.println("kingly0"+str1);
//jta1.append(str1);
 JOptionPane.showMessageDialog(null,"File Received","Status....",JOptionPane.INFORMATION_MESSAGE);
}
 else
 {
 JOptionPane.showMessageDialog(null,"key Value is Changed,You can't take this File","Status....",JOptionPane.INFORMATION_MESSAGE);
 }
             }

             // if(ae.getSource()==decrypt)
       // {
            //String input=jta1.getText();
          //  System.out.println("hello"+input);
        //String input = "sw0SrUIKe0DmS7sRd9+XMgtYg+BUiAfiOsdMw/Lo2RA=";
        //  String strPassword = "password12345678";
       /////   SecretKeySpec key = new SecretKeySpec(strPassword.getBytes(), "AES");
      //   AlgorithmParameterSpec paramSpec = new IvParameterSpec(strPassword.getBytes());
    //Whatever you want to encrypt/decrypt using AES /CBC padding
    //Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

    //You can use ENCRYPT_MODE or DECRYPT_MODE
    // cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

     //decode data using standard decoder
     //byte[] output =  new BASE64Decoder().decodeBuffer(input);

       // Decrypt the data
     //byte[] decrypted = cipher.doFinal(output);

    // System.out.println("Original string: " +
       //      new String(input));

     // decryptedData .;
     //System.out.println("Decrypted string: " +
    // new String(decrypted));
    // jta4.setText(new String(decrypted));
        //}
if(ae.getSource()==jb2)
		{

 str3=jt.getText();

  Calendar calendar2 = Calendar.getInstance();
   // time=calendar2.get(Calendar.HOUR) + ":"+calendar2.get(Calendar.MINUTE);
 encrypt=str3;//+time;
System.out.println("the value is"+str1);


              DESKeySpec keySpec = new DESKeySpec("YourSecr".getBytes("UTF8"));
SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
SecretKey key = keyFactory.generateSecret(keySpec);
sun.misc.BASE64Encoder base64encoder = new BASE64Encoder();
sun.misc.BASE64Decoder base64decoder = new BASE64Decoder();


// ENCODE plainTextPassword String
byte[] cleartext = null;
for(String a:encrypt.split("\n")){
cleartext = a.getBytes("UTF8");

Cipher cipher = Cipher.getInstance("DES"); // cipher is not thread safe
cipher.init(Cipher.ENCRYPT_MODE, key);
 key1 = base64encoder.encode(cipher.doFinal(cleartext));
 jta2.append(key1+"\n");

                    }}

        }
        catch(Exception e)
        {
        System.out.println(e);
        }
}
    
public static void main(String ar[]) throws Exception{

new clusterreceiverUI1("Aggregator1 Receiver1");
}

}
