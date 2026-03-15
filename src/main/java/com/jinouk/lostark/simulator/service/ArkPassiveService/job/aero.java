package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.aerodto;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class aero {

    public aerodto aero(String title , ArkPassiveDTO dto){
        aerodto aero = new aerodto();
        evolutioncalc evolutioncalc = new evolutioncalc();
        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.get("진화");
        Map<String , Integer> enlightment = nodes.get("깨달음");
        Map<String , Integer> leap = nodes.get("도약");

        int 치명 = evolution.get("치명");
        int 특화 = evolution.get("특화");
        int 신속 = evolution.get("신속");
        int 금단의_주문 = evolution.get("금단의 주문");
        int 예리한_감각 = evolution.get("예리한 감각");
        int 한계_돌파 = evolution.get("한계 돌파");
        int 최적화_훈련 = evolution.get("최적화 훈련");
        int 무한한_마력 = evolution.get("무한한 마력");
        int 혼신의_강타 = evolution.get("혼신의 강타");
        int 일격 = evolution.get("일격");
        int 파괴_전차 = evolution.get("파괴 전차");
        int 타이밍_지배 = evolution.get("타이밍 지배");
        int 회심 = evolution.get("회심");
        int 달인 = evolution.get("달인");
        int 분쇄 = evolution.get("분쇄");
        int 뭉툭한_가시 = evolution.get("뭉툭한 가시");
        int 음속_돌파 = evolution.get("음속 돌파");
        int 인파이팅 = evolution.get("인파이팅");
        int 입식_타격가 = evolution.get("입식타격가");
        int 마나_용광로 = evolution.get("마나 용광로");

        double 눈부신_나날들_피해량 = 0.0;
        double 우산_스킬_피해량 = 0.0;
        double 기상_스킬_피해량 = 0.0;
        double 여우비_피해량 = 0.0;
        double 이속 = 0.0;
        double 공속 = 0.0;
        double 치피 = 0.0;
        double 치적 = 0.0;
        double 적주피 = 0.0;

        int 맑은날 = enlightment.get("맑은 날");
        int 눈부신_나날들 = enlightment.get("눈부신 나날들");
        int 단련 = enlightment.get("단련");
        int 수증기_충전 = enlightment.get("수증기_충전");

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

        int 질풍노도 = enlightment.get("질풍노도");
        int 기민함 = enlightment.get("기민함");
        int 자연의_흐름 = enlightment.get("자연의 흐름");
        int 바람의_길 = enlightment.get("바람의 길");

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
