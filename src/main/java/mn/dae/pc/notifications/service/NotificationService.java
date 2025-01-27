package mn.dae.pc.notifications.service;

import mn.dae.pc.notifications.entity.Email;
import mn.dae.pc.notifications.utils.Render;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {

    private Render render = new Render();

    public void sendEmail(String templateName, Email email) {
            String html = render.generateHTML(templateName, email.getData());
            System.out.print(html);
    }
}
