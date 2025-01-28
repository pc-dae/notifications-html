package mn.dae.pc.notifications.utils;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.io.StringWriter;

@Slf4j
@Component
public class Render {

    public String generateHTML(String templateName, Map<String, String> data) {
        try {
            MustacheFactory mf = new DefaultMustacheFactory();
            String templateFile = String.format("application/templates/%s.mustache", templateName);
            Mustache mustache = mf.compile(templateFile);
            StringWriter writer = new StringWriter();
            mustache.execute(writer, data).flush();
            return writer.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
