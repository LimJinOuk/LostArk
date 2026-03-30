package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.valkyriedto;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class valkyrie {
    public valkyriedto valkyrie(String title, ArkPassiveDTO dto){
        valkyriedto valkyriedto = new valkyriedto();
        evolutioncalc evolutioncalc = new evolutioncalc();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.getOrDefault("진화" , new HashMap<>());
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음", new HashMap<>());
        Map<String , Integer> leap = nodes.getOrDefault("도약", new HashMap<>());

        double 적주피 = 0.0;
        double 정의_성휘_스킬_피해 = 0.0;
        double 종언의_빛_스킬_피해 = 0.0;
        double 치적 = 0.0;

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

        int 빛의_기사 = enlightment.getOrDefault("빛의 기사" , 0);
        int 검술_훈련 = enlightment.getOrDefault("검술 훈련" , 0);
        int 성검_개방 = enlightment.getOrDefault("성검 개방" , 0);
        int 최후의_빛 = enlightment.getOrDefault("최후의 빛" , 0);
        int 삼위일체 = enlightment.getOrDefault("삼위일체" , 0);

        if(빛의_기사 > 0){
            적주피 += 10 * 빛의_기사;
        }if(검술_훈련 > 0){
            정의_성휘_스킬_피해 += 5 * 검술_훈련;
        }if(성검_개방 > 0){
            if(성검_개방 == 1){
                치적 += evolutioncalc.get치적(치명, 예리한_감각, 혼신의_강타 ,일격, 달인, 뭉툭한_가시);
                double temp적주피 = 0.0;
                double temp종언 = 0.0;
                temp적주피 += 0.15 * 치적;
                if(temp적주피 > 15.0){temp적주피 = 15.0;}

                temp종언 += 0.5 * 치적;
                if(temp종언 > 50){temp종언 = 50.0;}

                적주피 += temp적주피;
                종언의_빛_스킬_피해 += temp종언;
            } else if (성검_개방 == 2) {
                치적 += evolutioncalc.get치적(치명, 예리한_감각, 혼신의_강타 ,일격, 달인, 뭉툭한_가시);
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
                치적 += evolutioncalc.get치적(치명, 예리한_감각, 혼신의_강타 ,일격, 달인, 뭉툭한_가시);
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
            종언의_빛_스킬_피해 += 3 * 최후의_빛;

        }if(삼위일체 > 0){
            적주피 += 35.0 * 삼위일체;
        }

        valkyriedto.set종언의_빛_스킬_피해(종언의_빛_스킬_피해);
        valkyriedto.set적주피(적주피);
        valkyriedto.set정의_성휘_스킬_피해(정의_성휘_스킬_피해);

        return valkyriedto;
    }
}
