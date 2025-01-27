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


  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
