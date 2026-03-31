package com.jinouk.lostark.simulator.service.simulatorRun;



import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.destroyerdto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.*;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class destroyersr {
    private final destroyer destroyer;
    private final evolutioncalc evolutioncalc;
    private final sR sr;



    public ResponseEntity<?> srdestroyer(accessoriesDto accessoriesDto , ArkGridRequestDto arkGridRequestDto, ArkPassiveDTO arkPassiveDTO ,
                                         engravingDto engravingDto , equipmentsDto equipmentsDto ,
                                         gemEffectDto gemEffectDto , JewelDto jewelDto) throws IOException {

        //스킬 리스트 만들어 놔야 함.
        ObjectMapper mapper = new ObjectMapper();
        List<skillsr> skills = mapper.readValue(
                new ClassPathResource("skillJSON/destroyer/destroyer.json").getInputStream(),
                new TypeReference<List<skillsr>>() {}
        );

        //(모션값 상수) x 추피 x 피증 x 적받피증 추정 상수 x 적방어력상수 x 치피증 x 치명타시피증
        //추피 x 피증 x 치피증 x 치명타시피증
        double 힘민지 = 0;
        double 무공 = 0;

        double 공증 = 0;
        double 공격력 = 0;

        double 추피 = 0;
        double 피증 = 0;
        double 헤드피증 = 0;
        double 백피증 = 0;
        double 타대피증 = 0;
        double 돌대피증 = 0;

        double 이속증 = 0;

        double 치적 = 0;
        double 치피증 = 0;
        double 치피감소 = 0;
        double 치명타시피증 = 0;

        double 적방어력 = 5850;

        double 치명타_적중률 = 0.0;
        double 치명타_피해 = 0.0;
        double 적주피= 0.0;
        double 해방_스킬_피해= 0.0;
        double 중수_치적= 0.0;
        double 중수_피해= 0.0;
        double 중수_치피= 0.0;

        //공통 로직
        Map<String , Double> normal = sr.normal(accessoriesDto , arkGridRequestDto , engravingDto , equipmentsDto , gemEffectDto , jewelDto);

        //아크패시브
        destroyerdto dt = destroyer.destroyer(arkPassiveDTO);

        힘민지 = normal.get("힘민지");
        무공 = normal.get("무공");
        공격력 = normal.get("공격력");

        공증 = normal.get("공증");
        추피 = normal.get("추피");
        피증 = normal.get("피증");

        헤드피증 = normal.get("헤드피증");
        백피증 = normal.get("백피증");
        타대피증 = normal.get("타대피증");
        돌대피증 = normal.get("돌대피증");

        이속증 = normal.get("이속증");

        치적 = normal.get("치적");

        치피증 = normal.get("치피증");
        치피감소 = normal.get("치피감소");
        치명타시피증 = normal.get("치명타시피증");

        적방어력 = normal.get("적방어력");

        치명타_적중률 = dt.get치명타_적중률();
        치명타_피해 = dt.get치명타_피해();
        적주피= dt.get적주피();
        해방_스킬_피해= dt.get해방_스킬_피해();
        중수_치적= dt.get중수_치적();
        중수_피해= dt.get중수_피해();
        중수_치피= dt.get중수_치피();



        //(모션값 상수) x 추피 x 피증 x 적받피증 추정 상수 x 적방어력상수 x 치피증 x 치명타시피증
        //추피 x 피증 x 치피증 x 치명타시피증


        return ResponseEntity.ok(normal);
    }
}
