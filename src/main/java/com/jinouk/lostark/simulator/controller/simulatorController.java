package com.jinouk.lostark.simulator.controller;


import com.jinouk.lostark.simulator.dto.*;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.postProcess.skillPostProcess;
import com.jinouk.lostark.simulator.service.arkCoreCalc.ArkGridService;
import com.jinouk.lostark.simulator.service.simulatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class simulatorController {

    private final simulatorService service;
    private final ArkGridService arkGridService;

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

    @PostMapping("/simulatorGemEffect")
    public ResponseEntity<Map<String, gemEffectDto>> gemEffect (@RequestBody gemEffectDto gemEffectDto) {
        Map<String, gemEffectDto> res = new HashMap<>();
        res.put("gemEffectDto", gemEffectDto);
        return ResponseEntity.status(200).body(res);
    }
    @PostMapping("/simulatorEquipments")
    public String equipments (@RequestBody equipmentsDto weaponDto) {
        System.out.println("수신된 무기 정보: " + weaponDto.toString());
        return "무기 데이터 수신 성공!";
    }
    @PostMapping("/simulatorAccessories")
    public String accessories (@RequestBody accessoriesDto accDto) {
        System.out.println("수신된 무기 정보: " + accDto.toString());
        return "악세사리 데이터 수신 성공!";
    }
    @PostMapping("/simulatorArkGrid")
    public ArkGridResponseDto arkGrids (@RequestBody ArkGridRequestDto arkGridDto ) {
        System.out.println("수신된 아크 그리드 정보: " + arkGridDto.toString());
        return arkGridService.getArkGrid(arkGridDto);
    }
    @PostMapping("/simulatorEngravings")
    public String engravings (@RequestBody engravingDto engravingDto ) {
        System.out.println("수신된 각인 정보: " + engravingDto.toString());
        return "각인 데이터 수신 성공!";
    }
}
