package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.arcanadto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class arcana {

    public arcanadto arcana(String title , ArkPassiveDTO dto){
        arcanadto arcanadto = new arcanadto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

        double 스택이_4개_이상_루인_피해량 = 0.0;
        double 루인_스킬_피해량 = 0.0;
        double 일반_스킬_피해량 = 0.0;
        double 스택트_스킬_피해량 = 0.0;
        double 적주피 = 0.0;

        int 황제의_만찬 = enlightment.getOrDefault("황제의 만찬" , 0);
        int 또_다른_황제 = enlightment.getOrDefault("또 다른 황제" , 0);
        int 황제의_자비 = enlightment.getOrDefault("황제의 자비" , 0);
        int 황제의_심판 = enlightment.getOrDefault("황제의 심판" , 0);

        if (황제의_만찬 > 0){
            일반_스킬_피해량 += 27.0 * 황제의_만찬;
        }
        if (또_다른_황제 > 0){
            적주피 += 2.0 * 또_다른_황제;
        }
        if (황제의_자비 > 0){
            적주피 += 1.2 * 황제의_자비;
        }
        if (황제의_심판 > 0){
            루인_스킬_피해량 -= 2.0 * 황제의_심판;
            if (루인_스킬_피해량 < 0){루인_스킬_피해량 = 0;}
            일반_스킬_피해량 += 2.0 * 황제의_심판;
            스택트_스킬_피해량 += 2.0 * 황제의_심판;
        }

        int 황후의_연회 = enlightment.getOrDefault("황후의 연회" , 0);
        int 황후의_탐욕 = enlightment.getOrDefault("황후의 탐욕" , 0);
        int 황후의_속삭임 = enlightment.getOrDefault("황후의 속삭임" , 0);

        if (황후의_연회 > 0){
            스택이_4개_이상_루인_피해량 += 7.0 * 황후의_연회;
        }
        if (황후의_탐욕 > 0){
            루인_스킬_피해량 += 0.9 * 황후의_탐욕;
        }
        if (황후의_속삭임 > 0){
            루인_스킬_피해량 += 6.0 * 황후의_속삭임;
        }

        arcanadto.set스택이_4개_이상_루인_피해량(스택이_4개_이상_루인_피해량);
        arcanadto.set루인_스킬_피해량(루인_스킬_피해량);
        arcanadto.set일반_스킬_피해량(일반_스킬_피해량);
        arcanadto.set스택트_스킬_피해량(스택트_스킬_피해량);
        arcanadto.set적주피(적주피);

        return arcanadto;
    }

}
