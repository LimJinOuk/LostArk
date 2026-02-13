package com.jinouk.lostark.simulator.controller;

import com.jinouk.lostark.simulator.dto.equipmentsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(
        origins = {"http://localhost:3000", "http://localhost:5173" , "http://localhost:8080"},
        allowCredentials = "true"
)
public class equipmentsController {

    @PostMapping("/simulatorEquipments")
    public String equipments (@RequestBody Map<String, equipmentsDto> equipmentMap) {
        equipmentMap.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });

        return "데이터 수신 성공!";
    }
}
