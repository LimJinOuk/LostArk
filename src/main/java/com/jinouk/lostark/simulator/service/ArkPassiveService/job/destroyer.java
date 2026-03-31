package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.destroyerdto;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
@Service
public class destroyer {

    public destroyerdto destroyer( ArkPassiveDTO dto) {

        destroyerdto destroyerdto = new destroyerdto();
        evolutioncalc evolutioncalc = new evolutioncalc();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.getOrDefault("진화" , new HashMap<>());
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음", new HashMap<>());
        Map<String , Integer> leap = nodes.getOrDefault("도약", new HashMap<>());

        double 치명타_적중률 = 0.0;
        double 치명타_피해 = 0.0;
        double 적주피= 0.0;
        double 해방_스킬_피해= 0.0;
        double 중수_치적= 0.0;
        double 중수_피해= 0.0;
        double 중수_치피= 0.0;

        //TODO : 치명 값을 진화 기준(ex : 10 , 20 , 30)이 아니라 스탯 기준(ex : 1183 / 1333 )으로 바꾸기
        int 치명 = evolution.getOrDefault("치명", 0) * 50;
        int 특화 = evolution.getOrDefault("특화", 0);
        int 신속 = evolution.getOrDefault("신속", 0);
        int 금단의_주문 = evolution.getOrDefault("금단의 주문", 0);
        int 예리한_감각 = evolution.getOrDefault("예리한 감각", 0);
        int 한계_돌파 = evolution.getOrDefault("한계 돌파", 0);
        int 최적화_훈련 = evolution.getOrDefault("최적화 훈련", 0);
        int 무한한_마력 = evolution.getOrDefault("무한한 마력", 0);
        int 혼신의_강타 = evolution.getOrDefault("혼신의 강타", 0);
        int 일격 = evolution.getOrDefault("일격", 0);
        int 파괴_전차 = evolution.getOrDefault("파괴 전차", 0);
        int 타이밍_지배 = evolution.getOrDefault("타이밍 지배", 0);
        int 회심 = evolution.getOrDefault("회심", 0);
        int 달인 = evolution.getOrDefault("달인", 0);
        int 분쇄 = evolution.getOrDefault("분쇄", 0);
        int 뭉툭한_가시 = evolution.getOrDefault("뭉툭한 가시", 0);
        int 음속_돌파 = evolution.getOrDefault("음속 돌파", 0);
        int 인파이팅 = evolution.getOrDefault("인파이팅", 0);
        int 입식_타격가 = evolution.getOrDefault("입식타격가", 0);
        int 마나_용광로 = evolution.getOrDefault("마나 용광로", 0);

        int 날카로운_해머 = enlightment.getOrDefault("날카로운 해머", 0);
        int 분노의_망치 = enlightment.getOrDefault("분노의 망치", 0);
        int 해방_강화 = enlightment.getOrDefault("해방 강화", 0);
        int 중력_해방 = enlightment.getOrDefault("중력 해방", 0);
        int 중력_변환 = enlightment.getOrDefault("중력 변환", 0);

        int 중력_수련 = enlightment.getOrDefault("중력 수련", 0);
        int 영역_강화 = enlightment.getOrDefault("영역 강화", 0);
        int 새로운_코어 = enlightment.getOrDefault("새로운 코어", 0);

        치명타_적중률 += evolutioncalc.get치적(치명 , 예리한_감각 ,혼신의_강타,일격, 달인, 뭉툭한_가시);
        if (날카로운_해머 > 0){치명타_적중률 += 날카로운_해머 * 6;}
        if (분노의_망치 > 0 ) { 치명타_피해 += 분노의_망치 * 15; }
        if( 해방_강화 > 0 ){
            적주피 += 해방_강화 * 1.6;
        } if (중력_해방 > 0) {
            적주피 += 10 * 중력_해방;
            해방_스킬_피해 += 20 * 중력_해방;
        }
        if(중력_변환 > 0){
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
