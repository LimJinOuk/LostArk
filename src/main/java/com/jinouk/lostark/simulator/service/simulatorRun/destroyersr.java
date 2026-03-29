package com.jinouk.lostark.simulator.service.simulatorRun;



import com.jinouk.lostark.simulator.dto.simulateRun.child.*;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.service.ArkPassiveService.job.destroyer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class destroyersr {
    private final destroyer destroyer;
    private final sR sr;

    //스킬 리스트 만들어 놔야 함.

    public ResponseEntity<?> srdestroyer(accessoriesDto accessoriesDto , ArkGridRequestDto arkGridRequestDto, ArkPassiveDTO arkPassiveDTO ,
                                         engravingDto engravingDto , equipmentsDto equipmentsDto ,
                                         gemEffectDto gemEffectDto , JewelDto jewelDto) {

        //(모션값 상수) x 추피 x 피증 x 적받피증 추정 상수 x 적방어력상수 x 치피증 x 치명타시피증
        //추피 x 피증 x 치피증 x 치명타시피증
        double 힘민지 = 0;
        double 무공 = 0;

        double 공증 = 0;
        double 공격력 = 0;

        double 추피 = 0;
        double 피증 = 0;

        double 치적 = 0;
        double 치피증 = 0;
        double 치명타시피증 = 0;

        double 적방어력 = 5850;

        sr.normal(accessoriesDto , arkGridRequestDto , engravingDto , equipmentsDto , gemEffectDto , jewelDto);

        //아크패시브
        destroyer.destroyer(arkPassiveDTO);
    }
}
