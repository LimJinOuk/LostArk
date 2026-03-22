package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.demonicdto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class demonic {

    public demonicdto demonic(String title , ArkPassiveDTO dto){
        demonicdto demonicdto = new demonicdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.get("깨달음");

        double 악마화중_치적 = 0.0;
        double 악마_스킬_피해량 = 0.0;
        double 치적 = 0.0;
        double 일반_스킬_피해량 = 0.0;
        double 적주피 = 0.0;

        int 잠식_제어 = enlightment.get("잠식 제어");
        int 무기_단련 = enlightment.get("무기 단련");
        int 스톰_그라인딩 = enlightment.get("스톰 그라인딩");
        int 잠식_흡수 = enlightment.get("잠식 흡수");
        int 잠식_강화 = enlightment.get("잠식 강화");

        if (잠식_제어 > 0){
            치적 += 3.0 * 잠식_제어;
        }
        if (무기_단련 > 0){
            일반_스킬_피해량 += 12.0 * 무기_단련;
        }
        if (스톰_그라인딩 > 0){
            적주피 += 10.0 * 스톰_그라인딩;
        }
        if (잠식_흡수 > 0){
            적주피 += 0.6 * 잠식_흡수;
        }
        if (잠식_강화 > 0){
            적주피 += 1.2 * 잠식_강화;
        }

        int 혼돈_강화 = enlightment.get("혼돈 강화");
        int 혼돈_단련 = enlightment.get("혼돈 단련");
        int 침식 = enlightment.get("침식");

        if (혼돈_강화 > 0){
            악마화중_치적 += 10.0 * 혼돈_강화;
        }
        if (혼돈_단련 > 0){
            악마_스킬_피해량 += 1.2 * 혼돈_단련;
        }
        if (침식 > 0){
            악마_스킬_피해량 += 2.1 * 침식;
        }

        demonicdto.set악마화중_치적(악마화중_치적);
        demonicdto.set악마_스킬_피해량(악마_스킬_피해량);
        demonicdto.set치적(치적);
        demonicdto.set일반_스킬_피해량(일반_스킬_피해량);
        demonicdto.set적주피(적주피);

        return demonicdto;
    }

}
