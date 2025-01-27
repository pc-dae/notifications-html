package mn.dae.pc.notifications.dto.response;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tesco.ise.lbaas.orchestrator.dto.request.LoadBalancerRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** DTO response class for template creation or upate response. */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Template response payload")
@JsonIgnoreProperties
public class TemplateResponseDTO {

  private String validationMsg;
}
