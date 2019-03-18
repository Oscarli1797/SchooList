package es.urjc.etsii.schoolist;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import es.urjc.etsii.schoolist.Entities.Usuario;

public class EmailService {

	private static EmailService instance = null;

	public static EmailService getInstance() {
		if (instance == null)
			instance = new EmailService();

		return instance;
	}

	/**
	 * Los tipos de mensajes disponibles son "NuevoUsuario", "NuevoMensaje", "NuevaFalta".
	 * @param u
	 * @param TipoMensaje
	 */
	public void send(Usuario u, String TipoMensaje) {
		//EmailService.getInstance().send(usuario, "");
		try {
			Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 7777);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			String msg = u.getMail() + "\n" + TipoMensaje;
            out.println(msg);
            socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

