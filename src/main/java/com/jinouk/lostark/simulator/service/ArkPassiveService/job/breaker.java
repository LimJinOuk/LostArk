package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.breakerdto;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;
import org.springframework.stereotype.Service;

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
        Map<String , Integer> evolution = nodes.get("진화");
        Map<String , Integer> enlightment = nodes.get("깨달음");

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

        int 치명적인_주먹 = enlightment.get("치명적인 주먹");
        int 수라강체 = enlightment.get("수라강체");
        int 전면전 = enlightment.get("전면전");
        int 무아지경 = enlightment.get("무아지경");
        
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

        int 권왕파천무 = enlightment.get("권왕파천무");
        int 단전_호흡 = enlightment.get("단전 호흡");
        int 낙화강화 = enlightment.get("권왕십이식 : 낙화 강화");
        int 풍랑 = enlightment.get("권왕십이식 : 풍랑");
        int 권왕심법 = enlightment.get("권왕심법");
        int 호신강기 = enlightment.get("호신강기");

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
