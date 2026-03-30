package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.scouterdto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class scouter {

    public scouterdto scouter(String title , ArkPassiveDTO dto){
        scouterdto scouterdto = new scouterdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

        double 싱크_계열_스킬_피해량 = 0.0;
        double 일부_하이퍼_싱크_스킬_피해량 = 0.0;
        double 제로_싱크_스킬_피해량 = 0.0;
        double 이속 = 0.0;
        double 일반_스킬_피해량 = 0.0;
        double 드론_스킬_피해량 = 0.0;
        double 합작_스킬_피해량 = 0.0;
        double 치적 = 0.0;
        double 적주피 = 0.0;

        int 아르데타인의_기술 = enlightment.getOrDefault("아르데타인의 기술" , 0);
        int 기술_업그레이드 = enlightment.getOrDefault("기술 업그레이드" , 0);
        int 코어_인챈트 = enlightment.getOrDefault("코어 인챈트" , 0);
        int 전술_재장전 = enlightment.getOrDefault("전술 재장전" , 0);
        int 최고의_합작 = enlightment.getOrDefault("최고의 합작" , 0);

        if (아르데타인의_기술 > 0){
            이속 += 10.0 * 아르데타인의_기술;
        }
        if (기술_업그레이드 > 0){
            일반_스킬_피해량 += 20.0 * 기술_업그레이드;
            드론_스킬_피해량 += 20.0 * 기술_업그레이드;
            합작_스킬_피해량 += 20.0 * 기술_업그레이드;
        }
        if (코어_인챈트 > 0){
            치적 += 3.0 * 코어_인챈트;
            적주피 += 5.0 * 코어_인챈트;
        }
        if (전술_재장전 > 0){
            적주피 += 1.0 * 전술_재장전;
            이속 += 1.0 * 전술_재장전;
        }
        if (최고의_합작 > 0){
            드론_스킬_피해량 += 1.2 * 최고의_합작;
            합작_스킬_피해량 += 1.2 * 최고의_합작;
        }


        int 전투_모드 = enlightment.getOrDefault("전투 모드" , 0);
        int 제로_모드 = enlightment.getOrDefault("제로 모드" , 0);
        int 코어_반응_증폭 = enlightment.getOrDefault("코어 반응 증폭" , 0);
        int 제로_코어_에너지 = enlightment.getOrDefault("제로 코어 에너지" , 0);

        if (전투_모드 > 0){
            싱크_계열_스킬_피해량 += 7.0 * 전투_모드;
        }
        if (제로_모드 > 0){
            일부_하이퍼_싱크_스킬_피해량 += 40.0 * 제로_모드;
        }
        if (코어_반응_증폭 > 0){
            싱크_계열_스킬_피해량 += 1.0 * 코어_반응_증폭;
        }
        if (제로_코어_에너지 > 0){
            제로_싱크_스킬_피해량 += 3.5 * 제로_코어_에너지;
        }

        scouterdto.set싱크_계열_스킬_피해량(싱크_계열_스킬_피해량);
        scouterdto.set일부_하이퍼_싱크_스킬_피해량(일부_하이퍼_싱크_스킬_피해량);
        scouterdto.set제로_싱크_스킬_피해량(제로_싱크_스킬_피해량);
        scouterdto.set이속(이속);
        scouterdto.set일반_스킬_피해량(일반_스킬_피해량);
        scouterdto.set드론_스킬_피해량(드론_스킬_피해량);
        scouterdto.set합작_스킬_피해량(합작_스킬_피해량);
        scouterdto.set치적(치적);
        scouterdto.set적주피(적주피);

        return scouterdto;
    }
}
