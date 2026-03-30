package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.breakerdto;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class breaker {

    private final evolutioncalc evolutioncalc;

    public breaker(evolutioncalc evolutioncalc) {
        this.evolutioncalc = evolutioncalc;
    }

    public breakerdto breaker(String title , ArkPassiveDTO dto){
        breakerdto breakerdto = new breakerdto();
        evolutioncalc evolutioncalc = new evolutioncalc();
        
        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.getOrDefault("진화" , new HashMap<>());
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

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

        double 적주피 = 0.0;
        double 충격스킬피해 = 0.0;
        double 수라피해 = 0.0;
        double 수라상태시피해 = 0.0;
        double 공이속 = 0.0;
        double 낙화피해량 = 0.0;
        double 낙화치적 = 0.0;
        double 풍랑피해량 = 0.0;
        double 풍랑치적 = 0.0;
        double 치적 = 0.0;
        double temp적주피 = 0.0;

        int 치명적인_주먹 = enlightment.getOrDefault("치명적인 주먹" , 0);
        int 수라강체 = enlightment.getOrDefault("수라강체" , 0);
        int 전면전 = enlightment.getOrDefault("전면전" , 0);
        int 무아지경 = enlightment.getOrDefault("무아지경" , 0);
        
        if (치명적인_주먹 > 0){
           치적 = evolutioncalc.get치적(치명, 예리한_감각, 혼신의_강타, 일격, 달인, 뭉툭한_가시);
           temp적주피 = 치적 * 0.6;
           if(temp적주피 > 60){적주피 += 60;}
           else {적주피 += temp적주피;}
        }
        if (수라강체 > 0){
            수라상태시피해 += 8.0 * 수라강체;
        }
        if(전면전 > 0){
            적주피 += 1.6 * 전면전;
        }
        if (무아지경 > 0){
            수라피해 += 5.0 * 무아지경;
            공이속 += 15.0 * 무아지경;
        }

        int 권왕파천무 = enlightment.getOrDefault("권왕파천무" , 0);
        int 단전_호흡 = enlightment.getOrDefault("단전 호흡" , 0);
        int 낙화강화 = enlightment.getOrDefault("권왕십이식 : 낙화 강화" , 0);
        int 풍랑 = enlightment.getOrDefault("권왕십이식 : 풍랑" , 0);
        int 권왕심법 = enlightment.getOrDefault("권왕심법" , 0);
        int 호신강기 = enlightment.getOrDefault("호신강기" , 0);

        if (권왕파천무 > 0){
            낙화치적 += 15.0 * 권왕파천무;
            적주피 += 12.0 * 권왕파천무;
        }
        if (단전_호흡 >0){
            적주피 += 6.0 * 단전_호흡;
        }
        if (낙화강화 > 0){
            낙화피해량 += 25.0 * 낙화강화;
        }
        if (풍랑 > 0){
            풍랑치적 += 15.0 * 풍랑;
            풍랑피해량 += 12.0 * 풍랑;
        }
        if (권왕심법 > 0){
            충격스킬피해 += 1.0 * 권왕심법;
        }
        if (호신강기 > 0){
            적주피 += 0.6 * 호신강기;
        }

        breakerdto.set적주피(적주피);
        breakerdto.set공이속(공이속);
        breakerdto.set충격스킬피해(충격스킬피해);
        breakerdto.set낙화치적(낙화치적);
        breakerdto.set수라피해(수라피해);
        breakerdto.set수라상태시피해(수라상태시피해);
        breakerdto.set낙화피해량(낙화피해량);
        breakerdto.set풍랑치적(풍랑치적);
        breakerdto.set풍랑피해량(풍랑피해량);

        return breakerdto;
    }
}
