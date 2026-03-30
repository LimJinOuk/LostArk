package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class berserker {

    public String berserker(String title , ArkPassiveDTO dto) {

        berserker berserkerdto;
        berserkerdto = new berserker();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

        double 적주피 = 0.0;
        double 공격력 = 0.0;
        double 치명타_피해량 = 0.0;
        double 치명타_적중률 = 0.0;

        int 폭주_강화 = enlightment.getOrDefault("폭주 강화" , 0);
        int 광전사의_비기 = enlightment.getOrDefault("광전사의 비기" , 0);
        int 신체_각성 = enlightment.getOrDefault("신체 각성" , 0);
        int 분노_소모 = enlightment.getOrDefault("분노 소모" , 0);
        int 차가운_분노 = enlightment.getOrDefault("차가운 분노" , 0);
        int 어둠_강화 = enlightment.getOrDefault("어둠 강화" , 0);
        int 분노_자극 = enlightment.getOrDefault("분노 자극" , 0);


        return "";
    }
}
