package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import org.springframework.stereotype.Service;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.warLord;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;
import java.util.Map;

@Service
public class warlord {

    public warLord warlord(String title ,ArkPassiveDTO dto ){

        warLord warLorddto;
        warLorddto = new warLord();
        evolutioncalc evolutioncalc;
        evolutioncalc = new evolutioncalc();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.get("진화");
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

        Map<String , Integer> enlightment = nodes.get("깨달음");
        Map<String , Integer> leap = nodes.get("도약");

        int 고독한_기사 = enlightment.get("고독한 기사");
        int 정교함 = enlightment.get("정교함");
        int 건랜스_수련 = enlightment.get("건랜스 수련");
        int 선봉장의_함성 = enlightment.get("선봉장의 함성");

        int 효율_증대 = enlightment.get("효율 증대");
        int 결사대 = enlightment.get("결사대");

        int 철옹성 = enlightment.get("철옹성");
        int 전투_태세 = enlightment.get("전투 태세");
        int 숙련된_전술가 = enlightment.get("숙련된 전술가");
        int 선봉장의_마음가짐 = enlightment.get("선봉장의 마음가짐");

        int 전술_훈련 = enlightment.get("전술 훈련");
        int 전술_이동 = enlightment.get("전술 이동");

        double 치명타_적중률 = 0.0;
        double 랜스_스킬_피해량 = 0.0;
        double 랜스_스킬_치피증 = 0.0;
        double 적주피 = 0.0;
        double 일반_스킬_피해량 = 0.0;
        double 일반_스킬_치명타_적중률 = 0.0;

        if(정교함 > 0){
            치명타_적중률 += 정교함 * 5.0;
        } else if (건랜스_수련 > 0){
            치명타_적중률 += evolutioncalc.CritProbCalc(치명 , 예리한_감각 , 혼신의_강타 , 일격 , 달인 , 뭉툭한_가시)*0.2;
            랜스_스킬_피해량 += 치명타_적중률*건랜스_수련;
        } else if (효율_증대 > 0) {
            랜스_스킬_피해량 += 1 * 효율_증대;
        } else if (결사대 > 0) {
            랜스_스킬_피해량 += 0.8 * 결사대;
        } else if (전술_훈련 > 0) {
            일반_스킬_치명타_적중률 += 0.8 * 전술_훈련;
        } else if (전투_태세 >0) {
            적주피 += 10 * 전투_태세;
        }else if(숙련된_전술가> 0){
            일반_스킬_피해량 += 12 * 숙련된_전술가;
        } else if (선봉장의_마음가짐 > 0) {
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
