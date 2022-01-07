package email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class SendEamil {

    private  static  String myEmailAccount = "948917676@qq.com";
    private  static  String myEmailPassword = "lcxfoomsdlvbbdea";
    private  static  String myEmialHost = "smtp.qq.com";
    private  static  String receiveMail = "15926681541@163.com";
    private  static  String[] receiveMails = null;
    /**
     *
     * @param receiveMail 传入收件人的邮箱
     */
    public SendEamil(String ... receiveMail){
        this.receiveMails = receiveMail;
    }
    private static  MimeMessage CreateMime(Session session,String sernMail,String recemail){
        MimeMessage m = new MimeMessage(session);
        try {
            m.setFrom(new InternetAddress(sernMail,"SL","utf-8"));
            m.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recemail,"","utf-8"));
//            InternetAddress[] in = {new InternetAddress()};
//            m.setRecipients(MimeMessage.RecipientType.TO,in);
            m.setSubject("SL-Email");

            File f = new File("/Users/brother/Desktop/异常接口.xlsx");
            MimeBodyPart text = new MimeBodyPart();
            text.setContent("<h1>Hello</h1>"," text/html;charset=UTF-8");
            MimeBodyPart attru = new MimeBodyPart();
            DataSource source = new FileDataSource(f);
            attru.setDataHandler(new DataHandler(source));
            attru.setFileName(MimeUtility.encodeText(f.getName()));
            MimeMultipart mm = new MimeMultipart();
            mm.addBodyPart(text);
            mm.addBodyPart(attru);
            mm.setSubType("related");
            m.setContent(mm);
            m.saveChanges();
            return m;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }

    }


    public  Boolean SendEmailY(){
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", myEmialHost);
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(props);
        session.setDebug(true);
        MimeMessage me = this.CreateMime(session,myEmailAccount,receiveMail);
        try {
            Transport tr = session.getTransport();
            tr.connect(myEmailAccount,myEmailPassword);
            tr.sendMessage(me,me.getAllRecipients());
            tr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
