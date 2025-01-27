package mn.dae.pc.notifications.utils;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

@Component
public class Render {

    public String generateHTML(String templateName, Map<String, String> data) {
        try {
            MustacheFactory mf = new DefaultMustacheFactory();
            Mustache mustache = mf.compile(String.format("src/main/resources/templates/%s.mustache", templateName));
            Writer writer = new StringWriter();
            String rendered = mustache.execute(writer, data).toString();
            return rendered;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
