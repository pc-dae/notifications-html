package mn.dae.pc.notifications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import mn.dae.pc.notifications.entity.Email;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Map;
import static java.util.Map.entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// activate automatic startup and stop of containers
@Testcontainers
public class EmailControllerTest {

    private static final Logger log = LoggerFactory.getLogger(MainApplication.class);

    public String hmtlText() {
        return """
        <!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <title>{{title}}/title>
</head>
<body>
 <h1>{{body}}</h1>
</body>
</html>""";
    }

    private String objToJson(Object o) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(o);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        log.debug("Starting, loading templates, cwd: {}", System.getProperty("user.dir"));
    }
/*
    @Test
    public void testSend() {
        Map<String, String> data1 = Map.ofEntries(
                entry("title", "This is a message title"),
                entry("body", "This is the message body")
        );
        Email e1 = new Email("paul.carlton@dae.mn", data1);

        given()
                .contentType(ContentType.JSON)
                .body(objToJson(e1))
                .when()
                .post("/email")
                .then()
                .statusCode(201); // expecting HTTP 201 Created
    }*/
}