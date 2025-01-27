package mn.dae.pc.notifications.service;

import mn.dae.pc.notifications.MainApplication;
import mn.dae.pc.notifications.entity.Email;
import mn.dae.pc.notifications.feign.email.EmailFeignClient;
import mn.dae.pc.notifications.utils.Render;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(MainApplication.class);
    private final Render render = new Render();
    private final EmailFeignClient emailFeignClient;

    public void sendEmail(String templateName, Email email) {
        String html = render.generateHTML(templateName, email.getData());
        Map<String, String> htmlData = HashMap.newHashMap(1);
        System.out.print(html);
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
