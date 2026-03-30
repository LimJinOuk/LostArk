package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.guardiannightsdto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class guardiannights {

    public guardiannightsdto guardiannights(String title , ArkPassiveDTO dto){
        guardiannightsdto g = new guardiannightsdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

        double 인페르노_버스트_피해량 = 0.0;
        double 기운_소모당_피해량 = 0.0;
        double 일반_스킬_피해량 = 0.0;
        double 일반_스킬_치피 = 0.0;
        double 길로틴_스핀_피해량 = 0.0;
        double 퀘이크_스매시_피해량 = 0.0;
        double 임페일_쇼크_피해량 = 0.0;
        double 프렌지_스윕_피해량 = 0.0;
        double 소울_디바이드_피해량 = 0.0;
        double 적주피 = 0.0;
        double 이속 = 0.0;
        double 치적 = 0.0;

        int 드레드_로어 = enlightment.getOrDefault("드레드 로어" , 0);
        int 완전_연소 = enlightment.getOrDefault("완전 연소" , 0);
        int 돌파의_외침 = enlightment.getOrDefault("돌파의 외침" , 0);
        int 한계_초월 = enlightment.getOrDefault("한계 초월" , 0);
        int 날카로운_비늘 = enlightment.getOrDefault("날카로운 비늘" , 0);
        int 할버드의_대가 = enlightment.getOrDefault("할버드의 대가" , 0);

        if (드레드_로어 > 0) {
            적주피 += 6.0 * 드레드_로어;
        }
        if (완전_연소 > 0) {
            치적 += 5.0 * 완전_연소;
        }
        if (돌파의_외침 > 0) {
            일반_스킬_피해량 += 6.0 * 돌파의_외침;
        }
        if (한계_초월 > 0) {
            길로틴_스핀_피해량 += 5.0 * 한계_초월;
            퀘이크_스매시_피해량 += 5.0 * 한계_초월;
            임페일_쇼크_피해량 += 5.0 * 한계_초월;
            프렌지_스윕_피해량 += 5.0 * 한계_초월;
            소울_디바이드_피해량 += 5.0 * 한계_초월;
        }
        if (날카로운_비늘 > 0) {
            적주피 += 1.0 * 날카로운_비늘;
        }
        if (할버드의_대가 > 0) {
            일반_스킬_치피 += 4.0 * 할버드의_대가;
        }



        int 업화의_계승자 = enlightment.getOrDefault("업화의 계승자" , 0);
        int 깨어나는_힘 = enlightment.getOrDefault("깨어나는 힘" , 0);
        int 힘의_제어 = enlightment.getOrDefault("힘의 제어" , 0);
        int 완전_융화 = enlightment.getOrDefault("완전 융화" , 0);
        int 초비행 = enlightment.getOrDefault("초비행" , 0);
        int 잔불 = enlightment.getOrDefault("잔불" , 0);

        if (업화의_계승자>0){
            이속 += 11.0 * 업화의_계승자;
        }
        if (깨어나는_힘 > 0) {
            치적 += 6.0 * 깨어나는_힘;
        }
        if (힘의_제어 > 0) {
            기운_소모당_피해량 += 6.0 * 힘의_제어;
        }
        if (완전_융화 > 0) {
            인페르노_버스트_피해량 += 50.0 * 완전_융화;
        }
        if (초비행 > 0) {
            이속 += 10.0 * 초비행;
            적주피 += 1.0 * 초비행;
        }
        if (잔불 > 0) {
            적주피 += 1.0 * 잔불;
            이속 += 5.0 * 잔불;
        }


        g.set인페르노_버스트_피해량(인페르노_버스트_피해량);
        g.set기운_소모당_피해량(기운_소모당_피해량);
        g.set일반_스킬_피해량(일반_스킬_피해량);
        g.set일반_스킬_치피(일반_스킬_치피);
        g.set길로틴_스핀_피해량(길로틴_스핀_피해량);
        g.set퀘이크_스매시_피해량(퀘이크_스매시_피해량);
        g.set임페일_쇼크_피해량(임페일_쇼크_피해량);
        g.set프렌지_스윕_피해량(프렌지_스윕_피해량);
        g.set소울_디바이드_피해량(소울_디바이드_피해량);
        g.set적주피(적주피);
        g.set이속(이속);
        g.set치적(치적);

        return g;
    }
}
