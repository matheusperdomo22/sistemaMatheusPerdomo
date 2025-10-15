package tools;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session; 
import javax.mail.*;
import javax.mail.internet.*;


public class EmailUtil {

    public static boolean enviarEmail(String para, String assunto, String mensagem) {
        final String usuario = "11testeparaprova@gmail.com"; 
        final String senha = "qvanazxxlhkdgpyx";    

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(usuario, senha);
                }
            });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
            message.setSubject(assunto);
            message.setText(mensagem);

            Transport.send(message);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
    boolean enviado = tools.EmailUtil.enviarEmail(
        "sestari.vitorhugo@gmail.com",
        "Teste",
        "Vitor Viado"
    );
    System.out.println("Email enviado? " + enviado);
}
}
