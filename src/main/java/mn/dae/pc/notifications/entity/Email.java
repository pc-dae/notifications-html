package mn.dae.pc.notifications.entity;

import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Email {
    private final String recipient;
    private final Map<String, String> data;
}
