package dev.lambdac.clibatchgenrestinterface;

import dev.lambdac.clibatchgenrestinterface.model.DataRecordEntity;
import dev.lambdac.clibatchgenrestinterface.repository.DataRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetupTests extends BaseTest {

    @Autowired
    DataRecordRepository repository;

    @Test
    public void onstartup_h2_loaded() throws Exception {
        List<DataRecordEntity> records = repository.findAll();
        assertTrue(records.size() > 0);
    }
}
