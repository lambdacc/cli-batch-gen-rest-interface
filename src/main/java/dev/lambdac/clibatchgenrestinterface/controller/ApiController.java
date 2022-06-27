package dev.lambdac.clibatchgenrestinterface.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(path = "/api/cli-batch-tx",
        produces = "application/json")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ApiController {

    @GetMapping("/ping")
    public ResponseEntity ping() {
        return ok("Live!");
    }

    @GetMapping("/get-data")
    public ResponseEntity<Map<String,String>> checkLogin() {
        return ok(new HashMap<>());
    }
}
