package com.jinouk.lostark.simulator.controller;


import com.jinouk.lostark.simulator.dto.simulateRun.child.*;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.dto.simulateRun.run.RunRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.skill.identitySkillsDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.skill.skillsDto;
import com.jinouk.lostark.simulator.postProcess.skillPostProcess;
import com.jinouk.lostark.simulator.service.arkCoreCalc.ArkGridService;
import com.jinouk.lostark.simulator.service.simulatorRun.destroyersr;
import com.jinouk.lostark.simulator.service.simulatorService;
import com.jinouk.lostark.simulator.service.simulatorSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class simulatorController {

    private final simulatorService service;
    private final simulatorSkillService skillService;
    private final ArkGridService arkGridService;

    @GetMapping("/do")
    public Mono<List<skillPostProcess>> doProcess(@RequestParam String characterName) {
        return service.doProcess(characterName);
    }

    @PostMapping("/simulatorSkills")
    public Mono<List<skillPostProcess>> skills(@RequestParam String characterName, @RequestBody skillsDto skillsDto) {
        return skillService.parsingSkillPostProcess(characterName, skillsDto);
    }

    @PostMapping("/identitySkills")
    public String identitySkills(@RequestBody identitySkillsDto identitySkillsDto) {
        System.out.println("수신된 아덴 스킬 정보: " + identitySkillsDto.toString());
        return "아덴 스킬 데이터 수신 성공!";
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

    private final destroyersr destroyer;

    @PostMapping("/simulatorRun")
    public ResponseEntity<?> run(@RequestBody RunRequestDto runDto) {
        if (runDto.getCharacterClass() == "디스트로이어"){
            destroyer.srdestroyer( runDto.getAccessories() , runDto.getArkGrid() , runDto.getArkPassive() ,
                    runDto.getEngraving() , runDto.getEquipments() , runDto.getGemEffect() , runDto.getJewel());

        }
        return destroyer.srdestroyer( runDto.getAccessories() , runDto.getArkGrid() , runDto.getArkPassive() ,
                runDto.getEngraving() , runDto.getEquipments() , runDto.getGemEffect() , runDto.getJewel());
    }


}
