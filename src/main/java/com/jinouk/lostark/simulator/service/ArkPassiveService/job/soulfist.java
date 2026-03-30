package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.soulfistdto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class soulfist {

    public soulfistdto soulfist(String title , ArkPassiveDTO dto) {
        soulfistdto soulfistdto = new soulfistdto();

        double 적주피 = 0.0;
        double 치적 = 0.0;
        double 치피 = 0.0;

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());


        int 세맥타통2 = enlightment.getOrDefault("세맥타통 II" , 0);
        int 내공폭발 = enlightment.getOrDefault("내공 폭발" , 0);
        int 운기행공 = enlightment.getOrDefault("운기행공" , 0);
        int 자연체 = enlightment.getOrDefault("자연체" , 0);

        if(세맥타통2 > 0){
            적주피 += 17.0 * 세맥타통2;
        }
        if(내공폭발 > 0){
            치피 += 25.0 * 내공폭발;
        }
        if(운기행공 > 0){
            적주피 += 0.7 * 운기행공;
        }
        if (자연체 > 0){
            치적 += 3.0 * 자연체;
            적주피 += 1.0 * 자연체;
        }

        int 금강선공_강화 = enlightment.getOrDefault("금강선공 강화" , 0);
        int 한계돌파 = enlightment.getOrDefault("한계 돌파" , 0);
        int 반동제어 = enlightment.getOrDefault("반동 제어" , 0);
        int 날카로운_기공 = enlightment.getOrDefault("날카로운 기공" , 0);

        if(금강선공_강화 > 0){
            적주피 += 8.0 * 금강선공_강화;
        }
        if(한계돌파 > 0 ){
            적주피 += 11.0 * 한계돌파;
        }
        if (날카로운_기공 >0){
            치피 += 4.0 * 날카로운_기공;
        }
        if(반동제어 >0){
            적주피 += 0.6 * 반동제어;
        }

        soulfistdto.set치피(치피);
        soulfistdto.set치적(치적);
        soulfistdto.set적주피(적주피);

        return soulfistdto;
    }
}
