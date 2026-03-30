package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.sorceressdto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class sorceress {

    public sorceressdto sorceress(String title, ArkPassiveDTO dto){
        sorceressdto sorceressdto = new sorceressdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

        double 마력_해방중_치적 = 0.0;
        double 마력_해방중_치피 = 0.0;
        double 홀딩_스킬_피해량 = 0.0;
        double 캐스팅_스킬_피해 = 0.0;
        double 마력_방출중_적주피 = 0.0;
        double 종날_피해량 = 0.0;
        double 익스플로전_피해량 = 0.0;
        double 천벌_피해량 = 0.0;
        double 공격력 = 0.0;
        double 적주피 = 0.0;
        double 마력_해방중_적주피 = 0.0;

        int 환류강화 = enlightment.getOrDefault("환류 강화" , 0);
        int 마력충전 = enlightment.getOrDefault("마력 충전" , 0);
        int 해방봉인 = enlightment.getOrDefault("해방 봉인" , 0);
        int 응집되는_마력 = enlightment.getOrDefault("응집되는 마력" , 0);

        if (환류강화 > 0){
            적주피 += 22.0 * 환류강화;
        }
        if (마력충전 > 0){
            공격력 += 8.0 * 마력충전;
        }
        if (해방봉인 > 0){
            적주피 += 1.2 * 해방봉인;
            마력_해방중_적주피 -= 1.0 * 해방봉인;
            if (마력_해방중_적주피 < 0){마력_해방중_적주피 = 0;}
        }
        if (응집되는_마력 > 0){
            적주피 += 1.2 * 응집되는_마력;
        }

        int 점화의_불씨 = enlightment.getOrDefault("점화의 불씨" , 0);
        int 발화 = enlightment.getOrDefault("발화" , 0);
        int 마나_순환 = enlightment.getOrDefault("마나 순환" , 0);
        int 화력_충전 = enlightment.getOrDefault("화력 충전" , 0);
        int 점멸폭발 = enlightment.getOrDefault("점멸 폭발" , 0);

        if (점화의_불씨 > 0){
            마력_해방중_치적 += 10.0 * 점화의_불씨;
        }
        if (발화 > 0 ){
            마력_해방중_치피 += 18.0 * 발화;
        }
        if (마나_순환 > 0){
            종날_피해량 += 5.0 * 마나_순환;
            익스플로전_피해량 += 5.0 * 마나_순환;
            천벌_피해량 += 5.0 * 마나_순환;
        }
        if (화력_충전 > 0){
            홀딩_스킬_피해량 += 1.2 * 화력_충전;
            캐스팅_스킬_피해 += 1.2 * 화력_충전;
        }
        if (점멸폭발 > 0){
            마력_방출중_적주피 += 1.0 * 점멸폭발;
        }

        sorceressdto.set마력_해방중_치적(마력_해방중_치적);
        sorceressdto.set마력_해방중_치피(마력_해방중_치피);
        sorceressdto.set홀딩_스킬_피해량(홀딩_스킬_피해량);
        sorceressdto.set캐스팅_스킬_피해(캐스팅_스킬_피해);
        sorceressdto.set마력_방출중_적주피(마력_방출중_적주피);
        sorceressdto.set종날_피해량(종날_피해량);
        sorceressdto.set익스플로전_피해량(익스플로전_피해량);
        sorceressdto.set천벌_피해량(천벌_피해량);
        sorceressdto.set공격력(공격력);
        sorceressdto.set적주피(적주피);
        sorceressdto.set마력_해방중_적주피(마력_해방중_적주피);

        return sorceressdto;
    }

}
