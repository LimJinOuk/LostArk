package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import org.springframework.stereotype.Service;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.strikerdto;

import java.util.HashMap;
import java.util.Map;

@Service
public class striker {

    public strikerdto striker(String title , ArkPassiveDTO dto){

        strikerdto strikerdto = new strikerdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

        double 오의스킬피해 = 0.0 ;
        double 구축오의스킬 = 0.0;
        double 오의스킬치피 = 0.0 ;
        double 적주피 = 0.0 ;
        double 치적 = 0.0 ;
        double 일반스킬피해 = 0.0 ;

        int 일격필살1 = enlightment.getOrDefault("일격필살 I" , 0);
        int 일격필살2 = enlightment.getOrDefault("일격필살 II" , 0);
        int 구슬의축복 = enlightment.getOrDefault("구슬의 축복" , 0);
        int 치명적인_오의 = enlightment.getOrDefault("치명적인 오의" , 0);
        int 완전_충전 = enlightment.getOrDefault("완전 충전" , 0);

        if (일격필살1 > 0){
            오의스킬피해 += 12.0 * 일격필살1;
        }
        if (일격필살2 > 0){
            오의스킬피해 += 30.0 * 일격필살2;
        }
        if (치명적인_오의 > 0){
            오의스킬치피 += 4.0 * 치명적인_오의;
        }
        if (구슬의축복 > 0){
            if (구슬의축복 == 1) {
                오의스킬피해 -= 16.0;
                if (오의스킬피해 < 0 ){오의스킬피해 = 0;}
                구축오의스킬 += 30;
            }
            if (구슬의축복 == 2){
                오의스킬피해 -= 13.0;
                if (오의스킬피해 < 0 ){오의스킬피해 = 0;}
                구축오의스킬 += 57.5;
            }
            else {
                오의스킬피해 -= 10.0;
                if (오의스킬피해 < 0 ){오의스킬피해 = 0;}
                구축오의스킬 += 80.0;
            }
        }
        if (완전_충전 > 0){
            오의스킬피해 += 7.0 * 완전_충전;
        }


        int 답보 = enlightment.getOrDefault("답보" , 0);
        int 오의_집중 = enlightment.getOrDefault("오의 집중" , 0);
        int 난무_강화 = enlightment.getOrDefault("난무 강화" , 0);
        int 후방_기습 = enlightment.getOrDefault("후방 기습" , 0);
        int 체술_강화 = enlightment.getOrDefault("체술 강화" , 0);

        if (답보 > 0){
            오의스킬피해 += 4.0 * 답보;
        }
        if(오의_집중 > 0){
            오의스킬피해 += 21.0 * 오의_집중;
        }
        if (난무_강화 > 0){
            일반스킬피해 += 30.0 * 난무_강화;
            오의스킬피해 += 5.0 * 난무_강화;
        }
        if (후방_기습 > 0){
            적주피 += 1.4 * 후방_기습;
        }
        if (체술_강화 > 0){
            치적 += 1.2 * 체술_강화;
            일반스킬피해 += 2.0 * 체술_강화;
        }

        strikerdto.set치적(치적);
        strikerdto.set오의스킬치피(오의스킬치피);
        strikerdto.set구축오의스킬(구축오의스킬);
        strikerdto.set오의스킬피해(오의스킬피해);
        strikerdto.set적주피(적주피);
        strikerdto.set일반스킬피해(일반스킬피해);

        return strikerdto;
    }
}
