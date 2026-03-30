package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.summonerdto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class summoner {

    public summonerdto summoner(String title , ArkPassiveDTO dto){
        summonerdto summonerdto = new summonerdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

        double 이속 = 0.0;
        double 적주피 = 0.0;
        double 켈시온_피해량 = 0.0;
        double 마리린_피해량 = 0.0;
        double 파우루_피해량 = 0.0;
        double 엘씨드_피해량 = 0.0;
        double 슈르디_피해량 = 0.0;
        double 이그나_피해량 = 0.0;
        double 소환_스킬_피해량 = 0.0;
        double 명령_스킬_피해량 = 0.0;
        double 일반_스킬_피해량 = 0.0;
        double 이그나의_명령_스킬_피해량 = 0.0;
        double 고대의정령_스킬_피해량 = 0.0;
        double 소환_스킬_치적 = 0.0;
        double 일반_스킬_치적 = 0.0;
        double 고대의정령_스킬_치적 = 0.0;
        double 알리마지_피해량 = 0.0;
        double 피닉스_피해량 = 0.0;

        int 정신집중 = enlightment.getOrDefault("정신 집중" , 0);
        int 고대의힘 = enlightment.getOrDefault("고대의 힘" , 0);
        int 고대의_축복 = enlightment.getOrDefault("고대의 축복" , 0);
        int 고대의_바람 = enlightment.getOrDefault("고대의 바람" , 0);
        int 고대의_속삭임 = enlightment.getOrDefault("고대의 속삭임" , 0);

        if (정신집중 > 0){
            일반_스킬_피해량 += 7.0 * 정신집중;
            고대의정령_스킬_피해량 += 7.0 * 정신집중;
        }
        if (고대의힘 > 0){
            일반_스킬_치적 += 5.0 * 고대의힘;
            고대의정령_스킬_치적 += 5.0 * 고대의힘;
        }
        if (고대의_축복 > 0){
            일반_스킬_피해량 += 21.0 * 정신집중;
            고대의정령_스킬_피해량 += 21.0 * 정신집중;
        }
        if (고대의_바람 > 0){
            이속 += 10.0 * 고대의_바람;
            일반_스킬_피해량 += 0.9 * 고대의_바람;
            고대의정령_스킬_피해량 += 0.9 * 고대의_바람;
        }
        if (고대의_속삭임 > 0){
            알리마지_피해량 += 80.0 * 고대의_속삭임;
            피닉스_피해량 += 80.0 * 고대의_속삭임;
        }

        int 정령의_교감 = enlightment.getOrDefault("정령의 교감" , 0);
        int 정령_폭주 = enlightment.getOrDefault("정령 폭주" , 0);
        int 교감_강화 = enlightment.getOrDefault("교감 강화" , 0);
        int 절대적인_명령 = enlightment.getOrDefault("절대적인 명령" , 0);

        if (정령의_교감 > 0){
            켈시온_피해량 += 23.0 * 정령의_교감;
            소환_스킬_피해량 += 23.0 * 정령의_교감;
        }
        if (정령_폭주 > 0){
            켈시온_피해량 += 14.0 * 정령_폭주;
            마리린_피해량 += 14.0 * 정령_폭주;
            파우루_피해량 += 14.0 * 정령_폭주;
            엘씨드_피해량 += 14.0 * 정령_폭주;
            슈르디_피해량 += 14.0 * 정령_폭주;
            이그나_피해량 += 14.0 * 정령_폭주;
        }
        if (교감_강화 > 0){
            소환_스킬_치적 += 1.4 * 교감_강화;
        }
        if (절대적인_명령 > 0){
            명령_스킬_피해량 += 102.0 * 절대적인_명령;
            이그나의_명령_스킬_피해량 += 1.0 * 절대적인_명령;
        }

        summonerdto.set켈시온_피해량(켈시온_피해량);
        summonerdto.set마리린_피해량(마리린_피해량);
        summonerdto.set파우루_피해량(파우루_피해량);
        summonerdto.set엘씨드_피해량(엘씨드_피해량);
        summonerdto.set슈르디_피해량(슈르디_피해량);
        summonerdto.set이그나_피해량(이그나_피해량);
        summonerdto.set소환_스킬_피해량(소환_스킬_피해량);
        summonerdto.set명령_스킬_피해량(명령_스킬_피해량);
        summonerdto.set일반_스킬_피해량(일반_스킬_피해량);
        summonerdto.set소환_스킬_치적(소환_스킬_치적);
        summonerdto.set일반_스킬_치적(일반_스킬_치적);
        summonerdto.set이속(이속);
        summonerdto.set적주피(적주피);
        summonerdto.set이그나의_명령_스킬_피해량(이그나의_명령_스킬_피해량);
        summonerdto.set고대의정령_스킬_피해량(고대의정령_스킬_피해량);
        summonerdto.set고대의정령_스킬_치적(고대의정령_스킬_치적);
        summonerdto.set알리마지_피해량(알리마지_피해량);
        summonerdto.set피닉스_피해량(피닉스_피해량);

        return summonerdto;
    }

}
