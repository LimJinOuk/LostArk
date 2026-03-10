package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.destroyerdto;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class destroyer {

    public destroyerdto destroyer(String title , ArkPassiveDTO dto) {

        destroyerdto destroyerdto = new destroyerdto();
        evolutioncalc evolutioncalc = new evolutioncalc();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.get("진화");
        Map<String , Integer> enlightment = nodes.get("깨달음");
        Map<String , Integer> leap = nodes.get("도약");

        double 치명타_적중률 = 0.0;
        double 치명타_피해 = 0.0;
        double 적주피= 0.0;
        double 해방_스킬_피해= 0.0;
        double 중수_치적= 0.0;
        double 중수_피해= 0.0;
        double 중수_치피= 0.0;

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

        int 날카로운_해머 = enlightment.get("날카로운 해머");
        int 분노의_망치 = enlightment.get("분노의 망치");
        int 해방_강화 = enlightment.get("해방 강화");
        int 중력_해방 = enlightment.get("중력 해방");
        int 중력_변환 = enlightment.get("중력 변환");

        int 중력_수련 = enlightment.get("중력 수련");
        int 영역_강화 = enlightment.get("영역 강화");
        int 새로운_코어 = enlightment.get("새로운 코어");

        if (날카로운_해머 > 0){치명타_적중률 += 날카로운_해머 * 2;}
        if (분노의_망치 > 0 ) { 치명타_피해 += 분노의_망치 * 15; }
        if( 해방_강화 > 0 ){
            적주피 += 해방_강화 * 1.6;
        } if (중력_해방 > 0) {
            적주피 += 10 * 중력_해방;
            해방_스킬_피해 += 20 * 중력_해방;
        }
        if(중력_변환 > 0){
            치명타_적중률 += evolutioncalc.get치적(치명 , 예리한_감각 ,혼신의_강타,일격, 달인, 뭉툭한_가시);
            적주피 += 치명타_적중률 * 0.036 * 중력_변환;
        } if (중력_수련 >0) {
            중수_치적 += 10 * 중력_수련;
            적주피 += 7 * 중력_수련;
        } if (영역_강화 > 0){
            중수_치적 += 2 * 영역_강화;
        } if (새로운_코어 > 0) {
            중수_피해 += 24 * 새로운_코어;
        }

        destroyerdto.set치명타_적중률(치명타_적중률);
        destroyerdto.set중수_치적(중수_치적);
        destroyerdto.set치명타_피해(치명타_피해);
        destroyerdto.set중수_치피(중수_치피);
        destroyerdto.set해방_스킬_피해(해방_스킬_피해);
        destroyerdto.set적주피(적주피);
        destroyerdto.set중수_피해(중수_피해);

        return destroyerdto;
    }
}
