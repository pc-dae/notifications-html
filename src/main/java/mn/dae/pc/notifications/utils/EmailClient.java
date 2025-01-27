package mn.dae.pc.notifications.utils;

public class EmailClient {
}

@FeignClient(name = "email", configuration = EmailFeignClientConfig.class)
public interface As3FeignClient {

    /** Login to F5 */
    @PostMapping(
            path = "/shared/authn/login",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    String login(
            @RequestHeader("region") String region, @RequestBody F5LoginCredentials loginCredentials);
