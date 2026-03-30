package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.devilhunterdto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class devilhunter {

    public devilhunterdto devilhunter(String title , ArkPassiveDTO dto){

        devilhunterdto devilhunterdto = new devilhunterdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

        double 적주피 = 0.0;
        double 샷건_스킬_피해량 = 0.0;
        double 이속 = 0.0;
        double 핸드건_스킬_피해량 = 0.0;
        double 치적 = 0.0;
        double 치피 = 0.0;

        int 핸드_거너 = enlightment.getOrDefault("핸드 거너" , 0);
        int 핸드건_강화 = enlightment.getOrDefault("핸드건 강화" , 0);
        int 퀵_드로우 = enlightment.getOrDefault("퀵 드로우" , 0);
        int 빛나는_탄 = enlightment.getOrDefault("빛나는 탄" , 0);

        if (핸드_거너 > 0){
            이속 += 8.0 * 핸드_거너;
        }
        if (핸드건_강화 > 0 ){
            핸드건_스킬_피해량 += 65.0 * 핸드건_강화;
        }
        if(퀵_드로우 >0){
            치적 += 1.0 * 퀵_드로우;
        }
        if (빛나는_탄 > 0){
            핸드건_스킬_피해량 += 1.4 * 빛나는_탄;
        }

        int 전술_탄환 = enlightment.getOrDefault("전술 탄환" , 0);
        int 정밀_사격_훈련 = enlightment.getOrDefault("정밀 사격 훈련" , 0);
        int 전략적_군장 = enlightment.getOrDefault("전략적 군장" , 0);
        int 해결사의_움직임 = enlightment.getOrDefault("해결사의 움직임" , 0);
        int 고폭탄 = enlightment.getOrDefault("고폭탄" , 0);

        if (전술_탄환 > 0){
            적주피 += 3.0 * 전술_탄환;
        }
        if (정밀_사격_훈련 > 0 ){
            치적 += 8.0 * 정밀_사격_훈련;
            치피 += 4.0 * 정밀_사격_훈련;
        }
        if (전략적_군장 >0){
            샷건_스킬_피해량 += 5.0 * 전략적_군장;
        }
        if (해결사의_움직임 >0){
            적주피 += 0.8 * 해결사의_움직임;
        }
        if (고폭탄 > 0){
            샷건_스킬_피해량 += 1.2 * 고폭탄;
        }

        devilhunterdto.set적주피(적주피);
        devilhunterdto.set샷건_스킬_피해량(샷건_스킬_피해량);
        devilhunterdto.set이속(이속);
        devilhunterdto.set핸드건_스킬_피해량(핸드건_스킬_피해량);
        devilhunterdto.set치적(치적);
        devilhunterdto.set치피(치피);

        return devilhunterdto;
    }
}
