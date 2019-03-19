package es.urjc.etsii.schoolist_email;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class EmailController {

	public static void main(String[] args) {

		try {
			int port = 7777;
			/*
			ServerSocketFactory serverSocketFactory = SSLServerSocketFactory.getDefault();
			SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(port);
			*/
			ServerSocket serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				Thread t = new Thread(new EmailSender(socket));
				t.start();
			}
			
		} catch (IOException e) {
			System.err.println("Error I/O");
		}

	}

}
