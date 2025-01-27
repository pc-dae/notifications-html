package mn.dae.pc.notifications.feign.email;

import org.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import mn.dae.pc.notifications.entity.Email;

/**
 * Feign client to connect to F5 AS3 REST APIs. Feign client configured to use base URL defined
 * during runtime based on region
 */
@FeignClient(name = "email", url = "email.email.svc.cluster.local")
public interface EmailFeignClient {

  /** Login to F5 */
  @PostMapping(
      path = "/email",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  String email(@RequestBody Email email);
}
