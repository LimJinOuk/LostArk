package com.jinouk.lostark.simulator.controller;

import com.jinouk.lostark.simulator.dto.ariGridDto;
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
    public String equipments (@RequestBody equipmentsDto weaponDto) {
        // 성공적으로 매핑되면 DTO에 값이 들어옵니다.
        System.out.println("수신된 무기 정보: " + weaponDto.toString());
        return "무기 데이터 수신 성공!";
    }
    @PostMapping("/simulatorAccessories")
    public String accessories (@RequestBody Map<String, equipmentsDto> accessoriesMap) {
        accessoriesMap.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
        return "데이터 수신 성공!";
    }
    @PostMapping("/simulatorArkGrid")
    public String arkGrids (@RequestBody ariGridDto arkGridDto ) {
        System.out.println("수신된 아크 그리드 정보: " + arkGridDto.toString());
        return "무기 데이터 수신 성공!";
    }
}
