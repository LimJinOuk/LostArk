package com.jinouk.lostark.simulator.service.simulatorRun;



import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.destroyerdto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.*;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.run.RunRequestDto;
import com.jinouk.lostark.simulator.dto.skillsr;
import com.jinouk.lostark.simulator.service.ArkPassiveService.evolutioncalc;
import com.jinouk.lostark.simulator.service.ArkPassiveService.job.destroyer;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class destroyersr {
    private final destroyer destroyer;
    private final evolutioncalc evolutioncalc;
    private final sR sr;
    private final evolutioncalc evolutioncalc1;

    public ResponseEntity<?> srdestroyer(accessoriesDto accessoriesDto , ArkGridRequestDto arkGridRequestDto, ArkPassiveDTO arkPassiveDTO ,
                                         engravingDto engravingDto , equipmentsDto equipmentsDto ,
                                         gemEffectDto gemEffectDto , JewelDto jewelDto , List<Map<String , Integer>> profileData) throws IOException {

        //스킬 리스트 만들어 놔야 함.
        ObjectMapper mapper = new ObjectMapper();
        List<skillsr> skills = mapper.readValue(
                new ClassPathResource("skillJSON/destroyer/destroyer.json").getInputStream(),
                new TypeReference<List<skillsr>>() {}
        );

        //(모션값 상수) x 추피 x 피증 x 적받피증 추정 상수 x 적방어력상수 x 치피증 x 치명타시피증
        //추피 x 피증 x 치피증 x 치명타시피증

        int 치명 = 0;
        int 특화 = 0;
        int 신속 = 0;

        for (Map<String, Integer> p : profileData) {
            if (p.get("치명") != null) {
                치명 = p.get("치명");
            }
            if (p.get("특화") != null) {
                특화 = p.get("특화");
            }
            if (p.get("신속") != null) {
                신속 = p.get("신속");
            }
        }

        double 공증 = 1;
        double 공격력 = 1;

        double 추피 = 1;
        double 피증 = 1;
        double 헤드피증 = 1;
        double 백피증 = 1;
        double 타대피증 = 1;
        double 돌대피증 = 0;


        double 치적 = 0;
        double 치피증 = 0;
        double 치피감소 = 1;
        double 치명타시피증 = 1;

        double 적방어력 = 0;

        double 치명타_적중률 = 0.0;
        double 치명타_피해 = 1.0;
        double 적주피= 1.0;
        double 해방_스킬_피해= 1.0;
        double 중수_치적= 1.0;
        double 중수_피해= 1.0;
        double 중수_치피= 1.0;

        //공통 로직
        Map<String , Double> normal = sr.normal(accessoriesDto , arkGridRequestDto , engravingDto , equipmentsDto , gemEffectDto , jewelDto);

        //아크패시브
        destroyerdto dt = destroyer.destroyer(arkPassiveDTO , 치명 , 특화 ,신속);

        공격력 = normal.get("공격력");

        공증 += normal.get("공증");
        추피 += normal.get("추피");
        피증 += normal.get("피증");

        헤드피증 += normal.get("헤드피증");
        백피증 += normal.get("백피증");
        타대피증 += normal.get("타대피증");
        돌대피증 += normal.get("돌대피증");


        치적 += normal.get("치적");

        치피증 += normal.get("치피증");
        System.out.println("치피증 : " + 치피증);
        치피감소 += normal.get("치피감소");
        치명타시피증 += normal.get("치명타시피증");

        적방어력 += normal.get("적방어력");

        치명타_적중률 += dt.get치명타_적중률() + 치적; //치적은 완성된듯?
        치명타_피해 += dt.get치명타_피해() + 치피증;
        적주피 += dt.get적주피() + 피증;
        해방_스킬_피해 += dt.get해방_스킬_피해();
        중수_치적 += dt.get중수_치적();
        중수_피해 += dt.get중수_피해();
        중수_치피 += dt.get중수_치피();

        System.out.println(
                "공격력 : " + 공격력+
                "\n" +"공증 : " + 공증+
                "\n"+"적주피 : " + 적주피+
                "\n"+"돌대피증 : " + 돌대피증+
                "\n"+"치피증 : " + 치명타_피해+
                "\n"+"치명타시_피증 : " + 치명타시피증+
                "\n"+"추피 : " + 추피+
                "\n"+"중수_피해 : " + 중수_피해+
                "\n"+"중수_치피 : " + 중수_치피+
                "\n"+"적방어력 : " + 적방어력+
                "\n"+"치피감소 : " + 치피감소+
                "\n"+"해방_스킬_피해 : " + 해방_스킬_피해
        );

        //(모션값 상수) x 추피 x 피증 x 적받피증 추정 상수 x 적방어력상수 x 치피증 x 치명타시피증
        //추피 x 피증 x 치피증 x 치명타시피증
        Map<String , String> res = new HashMap<>();
        DecimalFormat df = new DecimalFormat("#,###");
        for(skillsr s : skills){
            long dmg = (long) ((s.getDmg() * 공격력 * 공증 * (적주피 + 돌대피증) * 치명타_피해 * 치명타시피증 * 추피 * 중수_피해 * 중수_치피 * 적방어력 / 치피감소) / 100000000);
            if (s.getDirect().contains("헤드")){
                dmg *= (헤드피증/100);
            }
            if (s.getDirect().contains("백")){
                dmg *= (백피증/100);
            }
            if (s.getDirect().equals("헤드백")){
                dmg *= 100;
            }
            if (s.getCategory().equals("해방스킬")){
                dmg *= (해방_스킬_피해/100);
            }

            res.put(s.getName() , df.format(dmg));
        }

        return ResponseEntity.ok(res);
    }
}
