package es.urjc.etsii;

import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.sun.mail.smtp.SMTPTransport;

@RestController
public class EmailController {

	@PostMapping(value = "/emailService")
	@ResponseStatus(HttpStatus.CREATED)
	public void getMail(@RequestBody Map<String, String> mail) {

		Executors.newScheduledThreadPool(1).schedule(() 
				-> sendMail(mail.get("email"), mail.get("tipoMensaje")), 
				10, TimeUnit.SECONDS);

	}

	private void sendMail(String reciever, String emailType) {

		try {
			// Propiedades
			Properties props = System.getProperties();
			props.setProperty("mail.smtps.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.setProperty("mail.smtps.auth", "true");
			props.put("mail.smtps.quitwait", "false");

			Session session = Session.getInstance(props, null);

			final MimeMessage msg = new MimeMessage(session);

			// -- Set the FROM and TO fields --
			msg.setFrom(new InternetAddress("schoolistdistribuidas@gmail.com"));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciever, false));

			// Construir el mensaje
			String subject = "";
			String body = "";

			switch (emailType) {

			case "nuevoMensaje":
				subject = "¡Has recibido un nuevo mensaje";
				body = nuevoMensaje();
				break;
			case "nuevaFalta":
				subject = "Falta de asistencia no justificada.";
				body = nuevaFalta();
				break;
			case "nuevoUsuario":
				subject = "¡Bienvenido a Schoolist!";
				body = nuevoUsuario();
				break;
			}

			msg.setSubject(subject);
			msg.setText(body, "utf-8");

			// fecha
			msg.setSentDate(new Date());

			SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
			t.connect("smtp.gmail.com", "schoolistdistribuido@gmail.com", "papanatas");
			t.sendMessage(msg, msg.getAllRecipients());
			t.close();
		} catch (MessagingException ex) {
			System.out.println(ex);
		}
	}

	private String nuevoMensaje() {
		return "Buenas tardes, \n\n" + "Le informamos de que ha recibido un nuevo mensaje en su cuenta del colegio.\n\n"
				+ "Posiblemente sea un mensaje importante, por lo que le rogamos que intente leerlo lo más rápido posible.\n\n"
				+ "Un cordial saludo, \n" + "Colegio.";
	}

	private String nuevaFalta() {
		return "Buenas tardes, \n\n" + "Le informamos de que su hijo ha faltado al menos a una clase el día de hoy.\n\n"
				+ "Podrá justificar la falta accediendo a la plataforma del colegio.\n\n" + "Un cordial saludo, \n"
				+ "Colegio.";
	}

	private String nuevoUsuario() {
		return "Buenas tardes, \n\n" + "Le Le damos la bienvenida a nuestra plataforma online Schoolist.\n\n"
				+ "Esta plataforma le permitirá acceder a información privilegiada "
				+ "de sus hijos matriculados en nuestra escuela y comunicarse con los profesores" + "vía online.\n"
				+ "Esperemos que le resulte útil nuestro nuevo servicio.\n\n" + "Un cordial saludo, \n" + "Colegio.";
	}

}
