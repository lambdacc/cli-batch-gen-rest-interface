package dev.lambdac.clibatchgenrestinterface;

import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
@Sql({"/data.sql"})
public class BaseTest {
    protected JacksonJsonParser jsonParser = new JacksonJsonParser();

}
