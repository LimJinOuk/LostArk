package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.aerodto;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class aero {

    public aerodto aero(String title , ArkPassiveDTO dto){
        aerodto aero = new aerodto();
        evolutioncalc evolutioncalc = new evolutioncalc();
        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.getOrDefault("진화" , new HashMap<>());
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());
        Map<String , Integer> leap = nodes.getOrDefault("도약" , new HashMap<>());

        int 치명 = evolution.getOrDefault("치명" , 0);
        int 특화 = evolution.getOrDefault("특화" , 0);
        int 신속 = evolution.getOrDefault("신속" , 0);
        int 금단의_주문 = evolution.getOrDefault("금단의 주문" , 0);
        int 예리한_감각 = evolution.getOrDefault("예리한 감각" , 0);
        int 한계_돌파 = evolution.getOrDefault("한계 돌파" , 0);
        int 최적화_훈련 = evolution.getOrDefault("최적화 훈련" , 0);
        int 무한한_마력 = evolution.getOrDefault("무한한 마력" , 0);
        int 혼신의_강타 = evolution.getOrDefault("혼신의 강타" , 0);
        int 일격 = evolution.getOrDefault("일격" , 0);
        int 파괴_전차 = evolution.getOrDefault("파괴 전차" , 0);
        int 타이밍_지배 = evolution.getOrDefault("타이밍 지배" , 0);
        int 회심 = evolution.getOrDefault("회심" , 0);
        int 달인 = evolution.getOrDefault("달인" , 0);
        int 분쇄 = evolution.getOrDefault("분쇄" , 0);
        int 뭉툭한_가시 = evolution.getOrDefault("뭉툭한 가시" , 0);
        int 음속_돌파 = evolution.getOrDefault("음속 돌파" , 0);
        int 인파이팅 = evolution.getOrDefault("인파이팅" , 0);
        int 입식_타격가 = evolution.getOrDefault("입식타격가" , 0);
        int 마나_용광로 = evolution.getOrDefault("마나 용광로" , 0);

        double 눈부신_나날들_피해량 = 0.0;
        double 우산_스킬_피해량 = 0.0;
        double 기상_스킬_피해량 = 0.0;
        double 여우비_피해량 = 0.0;
        double 이속 = 0.0;
        double 공속 = 0.0;
        double 치피 = 0.0;
        double 치적 = 0.0;
        double 적주피 = 0.0;

        int 맑은날 = enlightment.getOrDefault("맑은 날" , 0);
        int 눈부신_나날들 = enlightment.getOrDefault("눈부신 나날들" , 0);
        int 단련 = enlightment.getOrDefault("단련" , 0);
        int 수증기_충전 = enlightment.getOrDefault("수증기_충전" , 0);

        if (맑은날 > 0) {
            기상_스킬_피해량 += 11.0 * 맑은날;
        }
        if (눈부신_나날들 > 0){
            눈부신_나날들_피해량 += 40.0 * 눈부신_나날들;
        }
        if (단련 > 0){
            치적 += 1.0 * 단련;
            치피 += 4.0 * 단련;
        }
        if (수증기_충전 > 0) {
            여우비_피해량 += 12.0 * 수증기_충전;
        }

        공속 = evolutioncalc.get공이속(신속);

        int 질풍노도 = enlightment.getOrDefault("질풍노도" , 0);
        int 기민함 = enlightment.getOrDefault("기민함" , 0);
        int 자연의_흐름 = enlightment.getOrDefault("자연의 흐름" , 0);
        int 바람의_길 = enlightment.getOrDefault("바람의 길" , 0);

        if (질풍노도 > 0){
            공속 += 12.0 * 질풍노도;
            이속 += 12.0 * 질풍노도;
        }
        if (기민함 > 0){
            치피 += (공속 - 100) * 0.4;
            치적 += (이속 - 100) * 0.1;
        }
        if (자연의_흐름 > 0){
            적주피 += 1.2 * 자연의_흐름;
        }
        if (바람의_길 > 0) {
            우산_스킬_피해량 += 1.2 * 바람의_길;
        }

        aero.set공속(공속);
        aero.set이속(이속);
        aero.set치적(치적);
        aero.set치피(치피);
        aero.set여우비_피해량(여우비_피해량);
        aero.set우산_스킬_피해량(우산_스킬_피해량);
        aero.set기상_스킬_피해량(기상_스킬_피해량);
        aero.set눈부신_나날들_피해량(눈부신_나날들_피해량);
        aero.set적주피(적주피);

        return aero;
    }
}
