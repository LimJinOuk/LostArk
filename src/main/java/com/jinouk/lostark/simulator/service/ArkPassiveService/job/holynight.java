package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.holynightdto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class holynight {

    public holynightdto holynight(String title, ArkPassiveDTO dto){
        
        holynightdto holynightdto = new holynightdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.get("진화");
        Map<String , Integer> enlightment = nodes.get("깨달음");
        Map<String , Integer> leap = nodes.get("도약");

        double 적주피 = 0.0;
        double 심판의_칼날_피해량 = 0.0;

        int 신의_기사 = enlightment.get("신의 기사");
        int 신앙_수련 =  enlightment.get("신앙 수련");
        int 심판자 = enlightment.get("심판자");

        if(신의_기사 > 0){
            적주피 += 20 * 신의_기사;
        } if (신앙_수련 > 0) {
            심판의_칼날_피해량 += 10 * 신앙_수련;
        } if (심판자 > 0){
            적주피 += 6 * 심판자;
        }

        holynightdto.set적주피(적주피);
        holynightdto.set심판의_칼날_피해량(심판의_칼날_피해량);
        
        return holynightdto;
    }

}
