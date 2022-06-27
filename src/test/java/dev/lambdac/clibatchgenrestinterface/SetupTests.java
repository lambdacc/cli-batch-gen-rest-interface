package dev.lambdac.clibatchgenrestinterface;

import dev.lambdac.clibatchgenrestinterface.model.DataRecordEntity;
import dev.lambdac.clibatchgenrestinterface.repository.DataRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
@Sql({"/data.sql"})
public class SetupTests {

    @Autowired
    DataRecordRepository repository;

    @Test
    public void onstartup_h2_loaded() throws Exception {
        List<DataRecordEntity> records = repository.findAll();
        assertTrue(records.size() > 0);
    }
}
