package mn.dae.pc.notifications.feign.email;

import feign.Client;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/** Interceptor class for adding authorization to F5 requests. */
@RequiredArgsConstructor
@Slf4j
public class EmailFeignClientConfig implements RequestInterceptor {
  private RestTemplate restTemplate = restTemplate();

  @Value("${email.tester.svc.cluster.local}")
  private String emailUrl;

  /**
   * @param requestTemplate
   */
  @Override
  public void apply(RequestTemplate requestTemplate) {
    String region = String.valueOf(((List<?>) requestTemplate.headers().get("region")).getFirst());
    String token = currentToken.get();
    if (token != null) {
      requestTemplate.header("X-F5-Auth-Token", token);

      // replace with token for logout url
      if (requestTemplate.url().contains("/shared/authz/tokens")) {
        String url = requestTemplate.url();

        url += token;
        requestTemplate.uri(url);
        currentToken.remove();
      }
    }
    requestTemplate.target(getRegionUrl(region));
  }


  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
