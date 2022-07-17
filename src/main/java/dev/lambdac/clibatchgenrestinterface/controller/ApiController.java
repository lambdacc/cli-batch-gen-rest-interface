package dev.lambdac.clibatchgenrestinterface.controller;

import dev.lambdac.clibatchgenrestinterface.model.DataRecordEntity;
import dev.lambdac.clibatchgenrestinterface.repository.DataRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(path = "/api/cli-batch-tx",
        produces = "application/json")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ApiController {

    DataRecordRepository repository;

    @GetMapping("/ping")
    public ResponseEntity ping() {
        return ok("Live!");
    }

    @GetMapping("/get-data-file")
    public ResponseEntity<Map<String, String>> getDataFile(
            @RequestParam(required = false, defaultValue = "0") Integer pageNo,
            @RequestParam(required = false, defaultValue = "100") Integer pageSize
    ) throws IOException {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        List<DataRecordEntity> records = repository.findAll(paging).getContent();
        Path outFilePath = Paths.get("/tmp/cli-batch-tx-datasource.csv");
        String header = "slno,address,assetId,assetName,amount";
        Files.deleteIfExists(outFilePath);
        Files.write(
                outFilePath,
                header.getBytes(),
                StandardOpenOption.CREATE);

        for (DataRecordEntity record : records) {
            Files.write(
                    outFilePath,
                    (record + "\n").getBytes(),
                    StandardOpenOption.APPEND);
        }

        return ok(Map.of("filePath", outFilePath.toString()));
    }


    @GetMapping("/get-data")
    public ResponseEntity<List<DataRecordEntity>> getData(
            @RequestParam(required = false, defaultValue = "0") Integer pageNo,
            @RequestParam(required = false, defaultValue = "100") Integer pageSize
    ) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        List<DataRecordEntity> records = repository.findAll(paging).getContent();
        return ok(records);
    }


}
