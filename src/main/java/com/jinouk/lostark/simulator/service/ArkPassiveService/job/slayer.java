package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import org.springframework.stereotype.Service;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.slayerdto;

import java.util.Map;

@Service
public class slayer {

    public slayerdto slayer (String title , ArkPassiveDTO dto){
        slayerdto slayerdto = new slayerdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.get("진화");
        Map<String , Integer> enlightment = nodes.get("깨달음");
        Map<String , Integer> leap = nodes.get("도약");

        double 블러드러스트_피해 = 0.0;
        double 적주피 = 0.0;
        double 치명타_피해 = 0.0;

        int 강화된_기술 = enlightment.get("강화된 기술");
        int 처단자 = enlightment.get("처단자");
        int 갈증_해소 = enlightment.get("갈증 해소");
        int 사무치는_공포 = enlightment.get("사무치는 공포");
        
        if(강화된_기술 >0){
            블러드러스트_피해 += 5.0;
        }
        if (처단자 >0) {
            
        }
        if(갈증_해소 > 0){

        }
        if(사무치는_공포 > 0){

        }

        int 격분 = enlightment.get("격분");
        int 전투_본능 = enlightment.get("전투 본능");
        int 깊어지는_분노 = enlightment.get("깊어지는 분노");
        int 무모한_공격 = enlightment.get("무모한 공격");

        slayerdto.set블러드러스트_피해(블러드러스트_피해);
        slayerdto.set치명타_피해(치명타_피해);
        slayerdto.set적주피(적주피);

        return slayerdto;
    }
}
