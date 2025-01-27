package mn.dae.pc.notifications.entity;

import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Email {
    private final String recipient; // Single recipient for PofC
    private Map<String, String> data;
}
