package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.infighterdto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class infighter {

    public infighterdto infighter(String title , ArkPassiveDTO dto){
        infighterdto infighterdto = new infighterdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

        double 기력_스킬_피해 = 0.0;
        double 치명타_적중률 = 0.0;
        double 기력_스킬_치명타_피해 = 0.0;
        double 충격_스킬_치적 = 0.0;
        double 충격_스킬_피해 = 0.0;
        double 적주피 = 0.0;

        int 극의체술 = enlightment.getOrDefault("극의 : 체술" , 0);
        int 날카로운타격 = enlightment.getOrDefault("날카로운 타격" , 0);
        int 치명적인투지 = enlightment.getOrDefault("치명적인 투지" , 0);

        if (극의체술 > 0){
            기력_스킬_피해 += 40.0 * 극의체술;
            충격_스킬_피해 -= 30.0 * 극의체술;
            if (충격_스킬_피해 < 0){충격_스킬_피해 = 0;}
        }
        if (날카로운타격 > 0){
            기력_스킬_치명타_피해 += 4.0 * 날카로운타격;
            충격_스킬_치적 += 1.0 * 날카로운타격;
        }
        if (치명적인투지 >0){
            치명타_적중률 += 2.0 * 치명적인투지;
        }

        int 충격단련 = enlightment.getOrDefault("충격 단련" , 0);
        int 충격발산 = enlightment.getOrDefault("충격 발산" , 0);
        int 더킹2 = enlightment.getOrDefault("더킹 II" , 0);

        if (충격단련 > 0){
            충격_스킬_피해 += 10.0 * 충격단련;
        }
        if(충격발산 > 0){
            적주피 += 34.0 * 충격발산;
        }
        if(더킹2 > 0){
            적주피 += 2.0 * 더킹2;
        }

        infighterdto.set기력_스킬_치명타_피해(기력_스킬_치명타_피해);
        infighterdto.set기력_스킬_피해(기력_스킬_피해);
        infighterdto.set치명타_적중률(치명타_적중률);
        infighterdto.set충격_스킬_치적(충격_스킬_치적);
        infighterdto.set충격_스킬_피해(충격_스킬_피해);
        infighterdto.set적주피(적주피);

        return infighterdto;
    }
}
