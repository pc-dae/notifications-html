package mn.dae.pc.notifications.service;

import mn.dae.pc.notifications.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.io.Writer;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.charset.Charset;

@Service
public class NotificationService {

    public void sendEmail(String templateId, Email email) {

        // Invoke email service
        try {
            MustacheFactory mf = new DefaultMustacheFactory();
            Mustache mustache = mf.compile(String.format("src/main/resources/templates/%s.mustache", templateId));
            Writer writer = new StringWriter();
            String rendered = mustache.execute(writer, email.getData()).toString();
            System.out.print(rendered);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
