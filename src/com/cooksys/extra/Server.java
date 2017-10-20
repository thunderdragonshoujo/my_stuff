package com.cooksys.extra;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		ServerSocket ss = null;
		Socket sock = null;
		FileOutputStream fo = null;
		OutputStream os = null;
		FileReader fr = null;
		
		try {
			ss = new ServerSocket(8060,10 ,InetAddress.getLocalHost());
			fr = new FileReader("C:\\Users\\ftd-11\\eclipse-workspace\\file transfer\\resources\\Test.txt");
			
			System.out.println("Connecting");
			//while(true) {
			
			sock = ss.accept();
			System.out.println("Connection Accepted");
			os = sock.getOutputStream();
			//char c = '\0';
			int c;
			while( (c=(char) fr.read()) != -1 ) {
				os.write(c);
			}
			
			os.flush();
			System.out.println("after flush");
			//}
		} 
			catch (Exception e) {
			e.printStackTrace();
		} 
		//finally {
			//try {
				//System.out.println("all done");
				//ss.close();
				//sock.close();
				//fo.close();
			//} catch (IOException e) {
				//e.printStackTrace();
			//}
		//}
	}
}
