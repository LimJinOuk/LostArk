package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.battlemasterdto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class battelmaster {

    public battlemasterdto battlemaster(String title , ArkPassiveDTO dto){

        battlemasterdto battlemasterdto = new battlemasterdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.get("깨달음");

        double 적주피 = 0.0;
        double 일반스킬치피 = 0.0;
        double 치적 = 0.0;
        double 오의스킬피해 = 0.0;


        return battlemasterdto;

    }
}
