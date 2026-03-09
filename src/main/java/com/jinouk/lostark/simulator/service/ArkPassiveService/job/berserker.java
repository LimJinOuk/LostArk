package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class berserker {

    public String berserker(String title , ArkPassiveDTO dto) {

        berserker berserkerdto;
        berserkerdto = new berserker();
        evolutioncalc evolutioncalcdto;
        evolutioncalcdto = new evolutioncalc();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.get("진화");
        Map<String , Integer> enlightment = nodes.get("깨달음");
        Map<String , Integer> leap = nodes.get("도약");

        double 적주피 = 0.0;
        double 공격력 = 0.0;
        double 치명타_피해량 = 0.0;
        double 치명타_적중률 = 0.0;

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

        int 폭주_강화 = enlightment.get("폭주 강화");
        int 광전사의_비기 = enlightment.get("광전사의 비기");
        int 신체_각성 = enlightment.get("신체 각성");
        int 분노_소모 = enlightment.get("분노 소모");
        int 차가운_분노 = enlightment.get("차가운 분노");
        int 어둠_강화 = enlightment.get("어둠 강화");
        int 분노_자극 = enlightment.get("분노 자극");


        return "";
    }
}
