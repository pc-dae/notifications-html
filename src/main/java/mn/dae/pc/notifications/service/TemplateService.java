package mn.dae.pc.notifications.service;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import mn.dae.pc.notifications.entity.Email;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.io.Writer;

@Service
public class TemplateService {

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
