package com.cooksys.extra;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Client {
	//private Socket s;

	public static void main(String[] args) {

		
		Socket sock = null;
		InputStream os = null;
		byte[] mybytes = new byte[5];
		FileOutputStream fos = null;
		File f = null; 
		try {
			f = new File("hello.txt");
			fos = new FileOutputStream(f);
			sock = new Socket(InetAddress.getLocalHost() , 8060);

			System.out.println("Connecting");

			
			System.out.println("Connection Complete");
			os = sock.getInputStream();
			os.read(mybytes);
			
			System.out.println(new String(mybytes));
			fos.write(mybytes);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//finally {
			//try {
				//sock.close();
			} //catch (IOException e) {
				//e.printStackTrace();
			//}
		//}
	//}
}

