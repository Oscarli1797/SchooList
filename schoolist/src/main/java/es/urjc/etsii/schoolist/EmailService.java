package es.urjc.etsii.schoolist;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import es.urjc.etsii.schoolist.Entities.Usuario;

public class EmailService {

	private static EmailService instance = null;

	public static EmailService getInstance() {
		if (instance == null)
			instance = new EmailService();

		return instance;
	}

	/**
	 * Los tipos de mensajes disponibles son "NuevoUsuario", "NuevoMensaje",
	 * "NuevaFalta".
	 * 
	 * @param u
	 * @param TipoMensaje
	 */
	public void send(Usuario u, String TipoMensaje) {
		String url = "http://127.0.0.1:7777/emailService";
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("email", u.getMail());
		values.put("tipoMensaje", TipoMensaje);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity(url, values, String.class);

	}

}
