package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.hawkeyedto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class hawkeye {

    public hawkeyedto hawkeye(String title , ArkPassiveDTO dto){
        hawkeyedto hawkeyedto = new hawkeyedto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.get("깨달음");

        double 적주피 = 0.0;
        double 치피 = 0.0;
        double 실버호크_강습_피해량 = 0.0;
        double 이속 = 0.0;
        double 실버호크_치적 = 0.0;
        double 공격력 = 0.0;
        double 스킬_피해량 = 0.0;
        double 실버호크_기본_공격_피해량 = 0.0;

        int 두_번째_동료 = enlightment.get("두 번째 동료");
        int 호크_서포트 = enlightment.get("호크 서포트");
        int 폭풍의_표적 = enlightment.get("폭풍의 표적");
        int 실버호크_강화 = enlightment.get("실버호크 강화");
        int 폭풍의_사냥꾼 = enlightment.get("폭풍의 사냥꾼");
        int 딥러닝 = enlightment.get("딥러닝");

        if (두_번째_동료 > 0 ){
            이속 += 8.0 * 두_번째_동료;
            실버호크_치적 += 13.0 * 두_번째_동료;
        }
        if (호크_서포트 > 0){
            공격력 += 8.0 * 호크_서포트;
        }
        if(폭풍의_표적 > 0 ){
            적주피 += 6.0 * 폭풍의_표적;
        }
        if (실버호크_강화 > 0){
            실버호크_기본_공격_피해량 += 5.0 * 실버호크_강화;
        }
        if (폭풍의_사냥꾼 > 0 ){
            스킬_피해량 += 8.0 * 폭풍의_사냥꾼;
            이속 += 12.0 * 폭풍의_사냥꾼;
        }
        if (딥러닝 > 0 ){
            적주피 += 1.0 * 딥러닝;
        }

        int 죽음의_습격 = enlightment.get("죽음의 습격");
        int 최후의_표적 = enlightment.get("최후의 표적");
        int 페일_노트 = enlightment.get("페일 노트");
        int 마나_회수 = enlightment.get("마나 회수");

        if (죽음의_습격 > 0){
            적주피 += 6.0 * 죽음의_습격;
        }
        if (최후의_표적 > 0 ){
            적주피 += 9.0* 최후의_표적;
        }
        if (페일_노트 > 0){
            치피 += 4.0 * 페일_노트;
        }
        if (마나_회수 > 0 ){
            실버호크_강습_피해량 += 2.0 * 마나_회수;
        }

        hawkeyedto.set적주피(적주피);
        hawkeyedto.set치피(치피);
        hawkeyedto.set실버호크_강습_피해량(실버호크_강습_피해량);
        hawkeyedto.set이속(이속);
        hawkeyedto.set실버호크_치적(실버호크_치적);
        hawkeyedto.set공격력(공격력);
        hawkeyedto.set스킬_피해량(스킬_피해량);
        hawkeyedto.set실버호크_기본_공격_피해량(실버호크_기본_공격_피해량);

        return hawkeyedto;
    }
}
