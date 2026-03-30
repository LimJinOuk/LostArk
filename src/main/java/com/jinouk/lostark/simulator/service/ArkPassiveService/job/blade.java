package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.bladedto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class blade {
    public bladedto blade(String title , ArkPassiveDTO dto){
        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.getOrDefault("깨달음" , new HashMap<>());

        bladedto bladedto = new bladedto();

        double 버스트_피해량 = 0.0;
        double 적주피 = 0.0;
        double 이속 = 0.0;
        double 공격력 = 0.0;
        double 일반_스킬_피해량 = 0.0;

        int 신속한_일격 = enlightment.getOrDefault("신속한 일격" , 0);
        int 잔재된_기운 = enlightment.getOrDefault("잔재된 기운" , 0);
        int 확고한_의지 = enlightment.getOrDefault("확고한 의지" , 0);
        int 극한의_몸놀림 = enlightment.getOrDefault("극한의 몸놀림" , 0);
        int 검술_강화 = enlightment.getOrDefault("검술 강화" , 0);
        int 오브_순환 = enlightment.getOrDefault("오브 순환" , 0);

        if (신속한_일격 > 0 ){
            버스트_피해량 -= 30.0 * 신속한_일격;
            if (버스트_피해량 < 0){버스트_피해량 = 0;}
        }
        if (잔재된_기운 > 0 ){
            이속 += 6.0 * 잔재된_기운;
        }
        if (확고한_의지 > 0){
            공격력 += 24.0 * 확고한_의지;
        }
        if (극한의_몸놀림 > 0 ){
            적주피 += 7.0 * 극한의_몸놀림;
        }
        if (검술_강화 > 0){
            일반_스킬_피해량 += 1.2 * 검술_강화;
        }
        if (오브_순환 > 0 ){
            적주피 += 0.5 * 오브_순환;
        }

        int 오브_압축 = enlightment.getOrDefault("오브 압축" , 0);
        int 한계_돌파 = enlightment.getOrDefault("한계 돌파" , 0);
        int 검기_압축 = enlightment.getOrDefault("검기 압축" , 0);
        int 오브_제어 = enlightment.getOrDefault("오브 제어" , 0);
        int 에너지_강화 = enlightment.getOrDefault("에너지 강화" , 0);

        if (오브_압축 > 0 ){
            버스트_피해량 += 25.0 * 오브_압축;
        }
        if (한계_돌파 > 0){
            버스트_피해량 += 45.0 * 한계_돌파;
        }
        if (검기_압축 > 0){
            버스트_피해량 += 10.0 * 검기_압축;
        }
        if (오브_제어 > 0){
            적주피 += 0.8 * 오브_제어;
        }
        if (에너지_강화 > 0){
            버스트_피해량 += 2.0 * 에너지_강화;
        }

        bladedto.set버스트_피해량(버스트_피해량);
        bladedto.set적주피(적주피);
        bladedto.set이속(이속);
        bladedto.set공격력(공격력);
        bladedto.set일반_스킬_피해량(일반_스킬_피해량);

        return bladedto;
    }
}
