package com.jinouk.lostark.simulator.controller;

import com.jinouk.lostark.simulator.dto.ArkCoreCalcDto;
import com.jinouk.lostark.simulator.service.ArkCoreCalc.Chaos.ChaosMoonArkCoreCalcService;
import com.jinouk.lostark.simulator.service.ArkCoreCalc.Chaos.ChaosStarArkCoreCalc;
import com.jinouk.lostark.simulator.service.ArkCoreCalc.Chaos.ChaosSunArkCoreCalcService;
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
public class ArkCoreCalcController {
    private final ChaosSunArkCoreCalcService sunservice;
    private final ChaosMoonArkCoreCalcService moonservice;
    private final ChaosStarArkCoreCalc starservice;

    @PostMapping("/ChaosSunCoreCalc")
    public ResponseEntity<Map<String , ?>> suncorecalc(@RequestBody ArkCoreCalcDto dto){
        Map<String , Double> res = new HashMap<>();
        res = sunservice.calcSunArkCoreDamage(dto);
        return ResponseEntity.status(200).body(res);
    }

    @PostMapping("/ChaosMoonCoreCalc")
    public ResponseEntity<Map<String , ?>> moomcorecalc(@RequestBody ArkCoreCalcDto dto){
        Map<String , Double> res = new HashMap<>();
        res = moonservice.calcMoonArkCoreDamage(dto);
        return ResponseEntity.status(200).body(res);
    }

    @PostMapping("/ChaosStarCoreCalc")
    public ResponseEntity<Map<String , ?>> starcorecalc(@RequestBody ArkCoreCalcDto dto){
        Map<String , Double> res = new HashMap<>();
        res = starservice.calcStarArkCoreDamage(dto);
        return ResponseEntity.status(200).body(res);
    }
}
