package mn.dae.pc.notifications.dto.request;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/** request DTO to save user load balancer requests in DB document */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Template request payload")
@JsonIgnoreProperties
public class TemplateRequestDTO {
  @Schema(description = "Template text", example = "mustache template")
  @NotBlank(message = "Template is required")
  private String template;
}
