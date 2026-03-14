package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.blasterdto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class blaster {

    public blasterdto blaster(String title , ArkPassiveDTO dto){

        blasterdto blasterdto = new blasterdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.get("깨달음");

        double 포격_스킬_피해량 = 0.0;
        double 포격_스킬_치적 = 0.0;
        double 포격_스킬_치피 = 0.0;
        double 적주피 = 0.0;
        double 일반_스킬_피해량 = 0.0;

        int 포격_출력_강화 = enlightment.get("포격 출력 강화");
        int ACT_호출 = enlightment.get("A.C.T 호출");
        int 신속_포격 = enlightment.get("신속 포격");

        if (포격_출력_강화 > 0 ){
            포격_스킬_피해량 += 6.0 * 포격_출력_강화;
            포격_스킬_치적 += 20.0 * 포격_출력_강화;
        }
        if (ACT_호출 > 0 ){
            적주피 += 6.0 * ACT_호출;
        }
        if (신속_포격 > 0 ){
            포격_스킬_치피 += 4.0 * 신속_포격;
        }

        int 과열 = enlightment.get("과열");
        int 포화_공격 = enlightment.get("포화 공격");

        if (과열 > 0){
            일반_스킬_피해량 += 22.0 * 과열;
        }
        if (포화_공격 > 0 ){
            적주피 += 4.0 * 포화_공격;
        }

        blasterdto.set포격_스킬_피해량(포격_스킬_피해량);
        blasterdto.set포격_스킬_치적(포격_스킬_치적);
        blasterdto.set포격_스킬_치피(포격_스킬_치피);
        blasterdto.set적주피(적주피);
        blasterdto.set일반_스킬_피해량(일반_스킬_피해량);

        return blasterdto;
    }
}
