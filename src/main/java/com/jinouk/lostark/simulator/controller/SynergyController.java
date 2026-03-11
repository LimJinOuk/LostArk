package com.jinouk.lostark.simulator.controller;

import com.jinouk.lostark.simulator.dto.SynergyRequest;
import com.jinouk.lostark.simulator.service.SynergyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor

public class SynergyController {

    private final SynergyService synergyService;

    @PostMapping("/bulk")
    public ResponseEntity<Map<String, List<String>>> checkBulkSynergy(@RequestBody List<SynergyRequest> requests) {
        return ResponseEntity.ok(synergyService.getBulkSynergies(requests));
    }
}