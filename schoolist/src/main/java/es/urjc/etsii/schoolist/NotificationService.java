package es.urjc.etsii.schoolist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NotificationService {

	String host = "192.0.0.1";
	int port = 9999;
	
	public void sendNotification() {
		try {
			Socket socket = new Socket(host, port);

        	BufferedReader brSocketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        	PrintWriter pwSocketOut = new PrintWriter(socket.getOutputStream());
        	
        	/*String line;
        	while(!(line = brStdIn.readLine()).equals("x")) {
        		pwSocketOut.println(line);
        		String response = brSocketIn.readLine();
        		System.out.println(response);
        	}*/
        	
        	String line = "MENSAJE RANDOM";
        	pwSocketOut.println(line);
    		String response = brSocketIn.readLine();
    		System.out.println(response);
        	
        	brSocketIn.close();
        	pwSocketOut.close();
        	socket.close();
        	
		}
		catch(Exception e) {
			
		}
	}
	
}
