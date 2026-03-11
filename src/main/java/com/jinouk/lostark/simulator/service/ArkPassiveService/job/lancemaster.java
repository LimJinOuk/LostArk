package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.lancemasterdto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class lancemaster {

    public lancemasterdto lancemaster(String title , ArkPassiveDTO dto){

        lancemasterdto lancemasterdto = new lancemasterdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.get("깨달음");

        double 난무스킬피해;
        double 치적;
        double 적주피;
        double 난무스킬치피;
        double 이속;
        double 치피;
        double 집중스킬피해;

        return lancemasterdto;
    }
}
