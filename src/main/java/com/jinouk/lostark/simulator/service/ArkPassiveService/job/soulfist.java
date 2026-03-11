package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import org.springframework.stereotype.Service;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.soulfistdto;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;

import java.util.Map;

@Service
public class soulfist {

    public soulfistdto soulfist(String title , ArkPassiveDTO dto) {
        soulfistdto soulfistdto = new soulfistdto();
        evolutioncalc evolutioncalc = new evolutioncalc();

        double 적주피 = 0.0;
        double 치적 = 0.0;
        double 치피 = 0.0;

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

        치적 = evolutioncalc.get치적(치명, 예리한_감각, 혼신의_강타, 일격, 달인, 뭉툭한_가시);


        int 세맥타통2 = enlightment.get("세맥타통 II");
        int 내공폭발 = enlightment.get("내공 폭발");
        int 운기행공 = enlightment.get("운기행공");
        int 자연체 = enlightment.get("자연체");

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

        int 금강선공_강화 = enlightment.get("금강선공 강화");
        int 한계돌파 = enlightment.get("한계 돌파");
        int 반동제어 = enlightment.get("반동 제어");
        int 날카로운_기공 = enlightment.get("날카로운 기공");

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
