package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import org.springframework.stereotype.Service;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.valkyriedto;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;

import java.util.Map;

@Service
public class valkyrie {
    public valkyriedto valkyrie(String title, ArkPassiveDTO dto){
        valkyriedto valkyriedto = new valkyriedto();
        evolutioncalc evolutioncalc = new evolutioncalc();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.get("진화");
        Map<String , Integer> enlightment = nodes.get("깨달음");
        Map<String , Integer> leap = nodes.get("도약");

        double 적주피 = 0.0;
        double 정의_성휘_스킬_피해 = 0.0;
        double 종언의_빛_스킬_피해 = 0.0;
        double 치적 = 0.0;

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

        int 빛의_기사 = enlightment.get("빛의 기사");
        int 검술_훈련 = enlightment.get("검술 훈련");
        int 성검_개방 = enlightment.get("성검 개방");
        int 최후의_빛 = enlightment.get("최후의 빛");
        int 삼위일체 = enlightment.get("삼위일체");

        if(빛의_기사 > 0){
            적주피 += 10 * 빛의_기사;
        }if(검술_훈련 > 0){
            정의_성휘_스킬_피해 += 5 * 검술_훈련;
        }if(성검_개방 > 0){
            if(성검_개방 == 1){
                치적 += evolutioncalc.CritProbCalc(치명, 예리한_감각, 혼신의_강타 ,일격, 달인, 뭉툭한_가시);
                double temp적주피 = 0.0;
                double temp종언 = 0.0;
                temp적주피 += 0.15 * 치적;
                if(temp적주피 > 15.0){temp적주피 = 15.0;}

                temp종언 += 0.5 * 치적;
                if(temp종언 > 50){temp종언 = 50.0;}

                적주피 += temp적주피;
                종언의_빛_스킬_피해 += temp종언;
            } else if (성검_개방 == 2) {
                치적 += evolutioncalc.CritProbCalc(치명, 예리한_감각, 혼신의_강타 ,일격, 달인, 뭉툭한_가시);
                double temp적주피 = 0.0;
                double temp종언 = 0.0;
                temp적주피 += 0.35 * 치적;
                if(temp적주피 > 35.0){temp적주피 = 35.0;}

                temp종언 += 1.0 * 치적;
                if(temp종언 > 100){temp종언 = 100.0;}

                적주피 += temp적주피;
                종언의_빛_스킬_피해 += temp종언;
            }
            else if(성검_개방 == 3){
                치적 += evolutioncalc.CritProbCalc(치명, 예리한_감각, 혼신의_강타 ,일격, 달인, 뭉툭한_가시);
                double temp적주피 = 0.0;
                double temp종언 = 0.0;
                temp적주피 += 0.55 * 치적;
                if(temp적주피 > 55.0){temp적주피 = 55.0;}

                temp종언 += 1.5 * 치적;
                if(temp종언 > 150){temp종언 = 150.0;}

                적주피 += temp적주피;
                종언의_빛_스킬_피해 += temp종언;
            }
        }if (최후의_빛 > 0){
            종언의_빛_스킬_피해 += 3 * 최후의_빛
        }if(삼위일체 > 0){
            적주피 += 35.0 * 삼위일체;
        }

        valkyriedto.set종언의_빛_스킬_피해(종언의_빛_스킬_피해);
        valkyriedto.set적주피(적주피);
        valkyriedto.set정의_성휘_스킬_피해(정의_성휘_스킬_피해);

        return valkyriedto;
    }
}
