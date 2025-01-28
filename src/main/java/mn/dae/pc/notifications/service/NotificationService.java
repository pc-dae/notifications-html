package mn.dae.pc.notifications.service;

import mn.dae.pc.notifications.entity.Email;
import mn.dae.pc.notifications.feign.email.EmailFeignClient;
import mn.dae.pc.notifications.utils.Render;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import com.fasterxml.jackson.datatype.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);
    private final Render render = new Render();
    @Autowired
    private final EmailFeignClient emailFeignClient;

    public void sendEmail(String templateName, Email email) {
        String html = render.generateHTML(templateName, email.getData());
        Map<String, String> htmlData = HashMap.newHashMap(1);
        System.out.print(html);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);

            // Print JSON to the console
            System.out.println("Generated JSON:");
            System.out.println(jsonOutput);

        } catch (Exception e) {
            System.out.println("Error creating JSON document: " + e.getMessage());
        }
        htmlData.put("body", html );
        email.setData(htmlData);
        try {
            emailFeignClient.email(email);
        } catch (Exception e) {
            log.error("Unexpected error occurred while submitting request: {}", e.getMessage(), e);
            throw new RuntimeException(
                    "Unexpected error occurred while submitting request: " + e.getMessage());
        }
    }

}
