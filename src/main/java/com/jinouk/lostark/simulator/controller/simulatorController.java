package com.jinouk.lostark.simulator.controller;


import com.jinouk.lostark.simulator.dto.JewelDto;
import com.jinouk.lostark.simulator.postProcess.skillPostProcess;
import com.jinouk.lostark.simulator.service.simulatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequiredArgsConstructor
@CrossOrigin(
        origins = {"http://localhost:3000", "http://localhost:5173" , "http://localhost:8080"},
        allowCredentials = "true"
)
public class simulatorController {

    private final simulatorService service;

    @GetMapping("/do")
    public Mono<List<skillPostProcess>> doProcess(@RequestParam String characterName) {
        return service.doProcess(characterName);
    }

    @PostMapping("/simulatorJewels")
    public ResponseEntity<Map<String, JewelDto>> jewels (@RequestBody JewelDto jewelDto) {
        Map<String, JewelDto> res = new HashMap<>();
        res.put("jewelDto", jewelDto);
        return ResponseEntity.status(200).body(res);
    }
}
