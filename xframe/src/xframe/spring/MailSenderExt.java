package xframe.spring;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * MAIL功能类
 *
 * @author ZhangQiang
 * @version 2016-3-1 19:06:52
 */
public class MailSenderExt extends JavaMailSenderImpl
{
    private InternetAddress from;

    public MailSenderExt()
    {
    }

    public void send(String[] to, String subject, String text) throws Exception
    {
        MimeMessage msg = this.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
        helper.setTo(to);
        helper.setFrom(this.from);
        helper.setSubject(subject);
        helper.setText(text, true);

        this.send(msg);
    }

    public InternetAddress getFrom()
    {
        return from;
    }

    public void setFrom(InternetAddress from)
    {
        this.from = from;
    }
}
