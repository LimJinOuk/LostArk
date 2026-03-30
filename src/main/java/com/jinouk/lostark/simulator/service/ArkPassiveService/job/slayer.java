package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.slayerdto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class slayer {

    public slayerdto slayer (String title , ArkPassiveDTO dto){
        slayerdto slayerdto = new slayerdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

        double 블러드러스트_피해 = 0.0;
        double 적주피 = 0.0;
        double 치명타_피해 = 0.0;

        int 강화된_기술 = enlightment.getOrDefault("강화된 기술" , 0);
        int 처단자 = enlightment.getOrDefault("처단자" , 0);
        int 갈증_해소 = enlightment.getOrDefault("갈증 해소" , 0);
        int 사무치는_공포 = enlightment.getOrDefault("사무치는 공포" , 0);
        
        if(강화된_기술 >0){
            블러드러스트_피해 += 5.0 * 강화된_기술;
        }
        if (처단자 >0) {
            적주피 += 15 * 처단자;
        }
        if(갈증_해소 > 0){
            블러드러스트_피해 += 2.0 * 갈증_해소;
        }
        if(사무치는_공포 > 0){
            적주피 += 1.2 * 사무치는_공포;
        }

        int 격분 = enlightment.getOrDefault("격분" , 0);
        int 전투_본능 = enlightment.getOrDefault("전투 본능" , 0);
        int 깊어지는_분노 = enlightment.getOrDefault("깊어지는 분노" , 0);
        int 무모한_공격 = enlightment.getOrDefault("무모한 공격" , 0);

        if(격분 > 0){
            치명타_피해 += 17 * 격분;
        }if ( 전투_본능 > 0){
            적주피 += 1.0 * 전투_본능;
        }if(깊어지는_분노 > 0){
            적주피 += 10 * 깊어지는_분노;
        }if(무모한_공격 > 0){
            적주피 += 1.4 * 무모한_공격;
        }

        slayerdto.set블러드러스트_피해(블러드러스트_피해);
        slayerdto.set치명타_피해(치명타_피해);
        slayerdto.set적주피(적주피);

        return slayerdto;
    }
}
