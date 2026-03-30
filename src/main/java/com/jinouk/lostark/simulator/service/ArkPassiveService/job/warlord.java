package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.warlorddto;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class warlord {

    public warlorddto warlord(String title , ArkPassiveDTO dto ){

        warlorddto warLorddto;
        warLorddto = new warlorddto();
        evolutioncalc evolutioncalc;
        evolutioncalc = new evolutioncalc();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.getOrDefault("진화" , new HashMap<>());
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음", new HashMap<>());
        Map<String , Integer> leap = nodes.getOrDefault("도약", new HashMap<>());

        double 치명타_적중률 = 0.0;
        double 랜스_스킬_피해량 = 0.0;
        double 랜스_스킬_치피증 = 0.0;
        double 적주피 = 0.0;
        double 일반_스킬_피해량 = 0.0;
        double 일반_스킬_치명타_적중률 = 0.0;

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


        int 고독한_기사 = enlightment.getOrDefault("고독한 기사" , 0);
        int 정교함 = enlightment.getOrDefault("정교함" , 0);
        int 건랜스_수련 = enlightment.getOrDefault("건랜스 수련" , 0);
        int 선봉장의_함성 = enlightment.getOrDefault("선봉장의 함성" , 0);

        int 효율_증대 = enlightment.getOrDefault("효율 증대" , 0);
        int 결사대 = enlightment.getOrDefault("결사대" , 0);

        int 철옹성 = enlightment.getOrDefault("철옹성" , 0);
        int 전투_태세 = enlightment.getOrDefault("전투 태세" , 0);
        int 숙련된_전술가 = enlightment.getOrDefault("숙련된 전술가" , 0);
        int 선봉장의_마음가짐 = enlightment.getOrDefault("선봉장의 마음가짐" , 0);

        int 전술_훈련 = enlightment.getOrDefault("전술 훈련" , 0);
        int 전술_이동 = enlightment.getOrDefault("전술 이동" , 0);

        if(정교함 > 0){
            치명타_적중률 += 정교함 * 5.0;
        } if (건랜스_수련 > 0){
            치명타_적중률 += evolutioncalc.get치적(치명 , 예리한_감각 , 혼신의_강타 , 일격 , 달인 , 뭉툭한_가시)*0.2;
            랜스_스킬_피해량 += 치명타_적중률*건랜스_수련;
        } if (효율_증대 > 0) {
            랜스_스킬_피해량 += 1 * 효율_증대;
        } if (결사대 > 0) {
            랜스_스킬_피해량 += 0.8 * 결사대;
        } if (전술_훈련 > 0) {
            일반_스킬_치명타_적중률 += 0.8 * 전술_훈련;
        } if (전투_태세 >0) {
            적주피 += 10 * 전투_태세;
        }if(숙련된_전술가> 0){
            일반_스킬_피해량 += 12 * 숙련된_전술가;
        } if (선봉장의_마음가짐 > 0) {
            적주피 += 6 * 선봉장의_마음가짐;
        }
        warLorddto.set랜스_스킬_피해량(랜스_스킬_피해량);
        warLorddto.set치명타_적중률(치명타_적중률);
        warLorddto.set적주피(적주피);
        warLorddto.set일반_스킬_치명타_적중률(일반_스킬_치명타_적중률);
        warLorddto.set일반_스킬_피해량(일반_스킬_피해량);

        return warLorddto;
    }
}
