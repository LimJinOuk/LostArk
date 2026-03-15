package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.reaperdto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class reaper {

    public reaperdto reaper(String title , ArkPassiveDTO dto){
        reaperdto reaperdto = new reaperdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.get("깨달음");

        double 페르소나_아닐_경우_급습_스킬_피해량 = 0.0;
        double 페르소나_상태시_급습_스킬_피해량 = 0.0;
        double 그림자_스킬_피해량 = 0.0;
        double 단검_스킬_피해량 = 0.0;
        double 급습_스킬_피해량 = 0.0;
        double 급습_스킬_치피 = 0.0;
        double 공격력 = 0.0;
        double 적주피 = 0.0;
        double 치적 = 0.0;

        int 피냄새 = enlightment.get("피냄새");
        int 갈증 = enlightment.get("갈증");
        int 살인귀 = enlightment.get("살인귀");
        int 암살자의_손놀림 = enlightment.get("암살자의 손놀림");
        int 혼돈_강화 = enlightment.get("혼돈 강화");

        if (피냄새 > 0){
            치적 = 18.0 * 피냄새;
        }
        if (갈증 > 0){
            공격력 += 13.0 * 갈증;
        }
        if (살인귀 > 0){
            단검_스킬_피해량 += 20.0 * 살인귀;
            그림자_스킬_피해량 += 20.0 * 살인귀;
            급습_스킬_피해량 += 20.0 * 살인귀;
        }
        if (암살자의_손놀림 > 0){
            적주피 += 0.8 * 암살자의_손놀림;
        }
        if (혼돈_강화 > 0){
            단검_스킬_피해량 += 1.2 * 혼돈_강화;
            그림자_스킬_피해량 += 1.2 * 혼돈_강화;
            급습_스킬_피해량 += 1.2 * 혼돈_강화;
        }

        int 달의_소리 = enlightment.get("달의 소리");
        int 유령_무회 = enlightment.get("유령 무회");
        int 그림자_밟기 = enlightment.get("그림자 밟기");
        int 급소_확보 = enlightment.get("급소 확보");
        int 곡예사 = enlightment.get("곡예사");
        int 잠행 = enlightment.get("잠행");

        if (달의_소리 > 0){
            급습_스킬_피해량 += 30.0 * 달의_소리;
        }
        if (유령_무회 > 0){
            치적 += 3.0 * 유령_무회;
        }
        if (그림자_밟기 > 0 ){
            급습_스킬_피해량 += 108.0 * 그림자_밟기;
        }
        if (급소_확보 > 0){
            급습_스킬_피해량 += 28.0 * 급소_확보;
        }
        if (곡예사 > 0){
            급습_스킬_치피 += 3.0 * 곡예사;
        }
        if (잠행 > 0){
            페르소나_아닐_경우_급습_스킬_피해량 -= 50.0 * 잠행;
            if (페르소나_아닐_경우_급습_스킬_피해량 < 0){페르소나_아닐_경우_급습_스킬_피해량 =0;}
            페르소나_상태시_급습_스킬_피해량 += 3.0 * 잠행;
        }

        reaperdto.set페르소나_아닐_경우_급습_스킬_피해량(페르소나_아닐_경우_급습_스킬_피해량);
        reaperdto.set페르소나_상태시_급습_스킬_피해량(페르소나_상태시_급습_스킬_피해량);
        reaperdto.set그림자_스킬_피해량(그림자_스킬_피해량);
        reaperdto.set단검_스킬_피해량(단검_스킬_피해량);
        reaperdto.set급습_스킬_피해량(급습_스킬_피해량);
        reaperdto.set급습_스킬_치피(급습_스킬_치피);
        reaperdto.set공격력(공격력);
        reaperdto.set적주피(적주피);
        reaperdto.set치적(치적);

        return reaperdto;
    }
}
