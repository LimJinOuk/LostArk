package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.souleaterdto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class souleater {

    public souleaterdto souleater(String title , ArkPassiveDTO dto){
        souleaterdto souleaterdto = new souleaterdto();
        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

        double 사신화_상태에서_사신_스킬_피해량 = 0.0;
        double 사신화_상태에서_살귀_스킬_피해량 = 0.0;
        double 사신화_상태에서_망자_스킬_피해량 = 0.0;
        double 강화된_사신_스킬_피해량 = 0.0;
        double 사신_스킬_피해량 = 0.0;
        double 살귀_스킬_피해량 = 0.0;
        double 망자_스킬_피해량 = 0.0;
        double 치적 = 0.0;

        int 그믐의_경계 = enlightment.getOrDefault("그믐의 경계" , 0);
        int 죽음_연마 = enlightment.getOrDefault("죽음 연마" , 0);
        int 허물어진_경계 = enlightment.getOrDefault("허물어진 경계" , 0);
        int 영혼_강화 = enlightment.getOrDefault("영혼 강화" , 0);
        int 영혼_제어 = enlightment.getOrDefault("영혼 제어" , 0);

        if (그믐의_경계 > 0){
            살귀_스킬_피해량 += 40.0 * 그믐의_경계;
        }
        if (죽음_연마 > 0) {
            살귀_스킬_피해량 += 24 * 죽음_연마;
            사신_스킬_피해량 += 24 * 죽음_연마;
        }
        if (허물어진_경계 > 0){
            강화된_사신_스킬_피해량 += 20.0 * 허물어진_경계;
        }
        if (영혼_강화 > 0) {
            사신_스킬_피해량 += 0.6 * 영혼_강화;
            살귀_스킬_피해량 += 0.6 * 영혼_강화;
        }
        if (영혼_제어 > 0) {
            살귀_스킬_피해량 += 1.0 * 영혼_제어;
            망자_스킬_피해량 += 1.0 * 영혼_제어;
        }

        int 영혼_친화력 = enlightment.getOrDefault("영혼 친화력" , 0);
        int 만월의_집행자 = enlightment.getOrDefault("만월의 집행자" , 0);
        int 영혼_증폭 = enlightment.getOrDefault("영혼 증폭" , 0);
        int 영혼_길잡이 = enlightment.getOrDefault("영혼 길잡이" , 0);

        if (영혼_친화력 > 0){
            치적 += 3.0 * 영혼_친화력;
        }
        if (만월의_집행자 > 0){
            사신화_상태에서_사신_스킬_피해량 += 3.0 * 만월의_집행자;
        }
        if (영혼_증폭 > 0) {
            사신화_상태에서_사신_스킬_피해량 += 1.6 * 영혼_증폭;
            사신화_상태에서_망자_스킬_피해량 += 1.6 * 영혼_증폭;
            사신화_상태에서_살귀_스킬_피해량 += 1.6 * 영혼_증폭;
        }
        if (영혼_길잡이 > 0) {
            사신_스킬_피해량 += 1.2 * 영혼_길잡이;
        }

        souleaterdto.set사신화_상태에서_사신_스킬_피해량(사신화_상태에서_사신_스킬_피해량);
        souleaterdto.set사신화_상태에서_살귀_스킬_피해량(사신화_상태에서_살귀_스킬_피해량);
        souleaterdto.set사신화_상태에서_망자_스킬_피해량(사신화_상태에서_망자_스킬_피해량);
        souleaterdto.set강화된_사신_스킬_피해량(강화된_사신_스킬_피해량);
        souleaterdto.set사신_스킬_피해량(사신_스킬_피해량);
        souleaterdto.set살귀_스킬_피해량(살귀_스킬_피해량);
        souleaterdto.set망자_스킬_피해량(망자_스킬_피해량);
        souleaterdto.set치적(치적);

        return souleaterdto;
    }
}
