package mn.dae.pc.notifications.entity;

import lombok.RequiredArgsConstructor;
import lombok.Data;
import mn.dae.pc.notifications.enums.TemplateStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

@Data
@RequiredArgsConstructor
@Document
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TemplateEntity {
    @Id private UUID templateId;
    @Field private final String tenantId;
    private final String template;
    private final TemplateStatus status;
    private final Optional<String> re = Optional.empty();
}
