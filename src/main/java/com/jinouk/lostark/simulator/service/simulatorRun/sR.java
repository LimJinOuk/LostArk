package com.jinouk.lostark.simulator.service.simulatorRun;

import com.jinouk.lostark.simulator.dto.simulateRun.child.*;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.ArkPassiveService.job.destroyer;
import com.jinouk.lostark.simulator.service.arkCoreCalc.impl.common.ChaosMoon;
import com.jinouk.lostark.simulator.service.arkCoreCalc.impl.common.ChaosStar;
import com.jinouk.lostark.simulator.service.arkCoreCalc.impl.common.ChaosSun;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class sR {

    private final ChaosSun chaosSun;
    private final ChaosMoon chaosMoon;
    private final ChaosStar chaosStar;

    public Map<String , Double> normal(accessoriesDto accessoriesDto , ArkGridRequestDto arkGridRequestDto,
                                              engravingDto engravingDto , equipmentsDto equipmentsDto ,
                                              gemEffectDto gemEffectDto , JewelDto jewelDto){

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

        //악세사리
        Map<String, accessoriesDto.AccessoryItem> accessories = accessoriesDto.getAccessories();


        //목걸이
        accessoriesDto.AccessoryItem neck_0 = accessories.get("목걸이_0");
        //목걸이 힘민지
        int neckStat = neck_0.getCurrentStat();
        //목걸이 옵션1
        accessoriesDto.Effect neck_effect_1 = neck_0.getEffects().get("acc_effect_0");
        String Effect1 = neck_effect_1.getName();
        Double Value = neck_effect_1.getValue();
        if(Effect1.equals("적주피"))
        {
            피증 += Value;
        } else if (Effect1.equals("추피")) {
            추피 += Value;
        } else if (Effect1.contains("공격력")) {
            공격력 += Value;
        } else if (Effect1.contains("무공")) {
            무공 += Value;
        }

        //목걸이 옵션2
        accessoriesDto.Effect neck_effect_2 = neck_0.getEffects().get("acc_effect_1");
        String Effect2 = neck_effect_2.getName();
        Double Value2 = neck_effect_2.getValue();
        if(Effect1.equals("적주피"))
        {
            피증 += Value2;
        } else if (Effect2.equals("추피")) {
            추피 += Value2;
        } else if (Effect2.contains("공격력")) {
            공격력 += Value2;
        } else if (Effect2.contains("무공")) {
            무공 += Value2;
        }

        //목걸이 옵션3
        accessoriesDto.Effect neck_effect_3 = neck_0.getEffects().get("acc_effect_2");
        String Effect3 = neck_effect_3.getName();
        Double Value3 = neck_effect_3.getValue();
        if(Effect1.equals("적주피"))
        {
            피증 += Value3;
        } else if (Effect3.equals("추피")) {
            추피 += Value3;
        } else if (Effect3.contains("공격력")) {
            공격력 += Value3;
        } else if (Effect3.contains("무공")) {
            무공 += Value3;
        }


        //귀걸이 1
        accessoriesDto.AccessoryItem earring_1 = accessories.get("귀걸이_1");
        //귀걸이1 힘민지
        int earring_1_Stat = earring_1.getCurrentStat();
        //귀걸이1 옵션1
        accessoriesDto.Effect earring_1_effect_1 = earring_1.getEffects().get("acc_effect_0");
        String Effect4 = earring_1_effect_1.getName();
        Double Value4 = earring_1_effect_1.getValue();
        if(Effect4.equals("공격력(고정)")){
            공격력 += Value4;
        } else if (Effect4.equals("공격력(%)")) {
            공격력 += 공격력 * Value4;
        } else if(Effect4.equals("무공(고정)")){
            무공 += Value4;
        } else if (Effect4.equals("무공(%)")) {
            무공 += 무공 * Value4;
        }

        //귀걸이1 옵션2
        accessoriesDto.Effect earring_1_effect_2 = earring_1.getEffects().get("acc_effect_1");
        String Effect5 = earring_1_effect_2.getName();
        Double Value5 = earring_1_effect_2.getValue();
        if(Effect5.equals("공격력(고정)")){
            공격력 += Value5;
        } else if (Effect5.equals("공격력(%)")) {
            공격력 += 공격력 * Value5;
        } else if(Effect5.equals("무공(고정)")){
            무공 += Value5;
        } else if (Effect5.equals("무공(%)")) {
            무공 += 무공 * Value5;
        }

        //귀걸이1 옵션3
        accessoriesDto.Effect earring_1_effect_3 = earring_1.getEffects().get("acc_effect_2");
        String Effect6 = earring_1_effect_3.getName();
        Double Value6 = earring_1_effect_3.getValue();
        if(Effect6.equals("공격력(고정)")){
            공격력 += Value6;
        } else if (Effect6.equals("공격력(%)")) {
            공격력 += 공격력 * Value6;
        } else if(Effect6.equals("무공(고정)")){
            무공 += Value6;
        } else if (Effect6.equals("무공(%)")) {
            무공 += 무공 * Value6;
        }


        //귀걸이 2
        accessoriesDto.AccessoryItem earring_2 = accessories.get("귀걸이_2");
        //귀걸이2 힘민지
        int earring_2_Stat = earring_2.getCurrentStat();
        //귀걸이2 옵션1
        accessoriesDto.Effect earring_2_effect_1 = earring_2.getEffects().get("acc_effect_0");
        String Effect7 = earring_2_effect_1.getName();
        Double Value7 = earring_2_effect_1.getValue();
        if(Effect7.equals("공격력(고정)")){
            공격력 += Value7;
        } else if (Effect7.equals("공격력(%)")) {
            공격력 += 공격력 * Value7;
        } else if(Effect7.equals("무공(고정)")){
            무공 += Value7;
        } else if (Effect7.equals("무공(%)")) {
            무공 += 무공 * Value7;
        }

        //귀걸이2 옵션2
        accessoriesDto.Effect earring_2_effect_2 = earring_2.getEffects().get("acc_effect_1");
        String Effect8 = earring_2_effect_2.getName();
        Double Value8 = earring_2_effect_2.getValue();
        if(Effect8.equals("공격력(고정)")){
            공격력 += Value8;
        } else if (Effect8.equals("공격력(%)")) {
            공격력 += 공격력 * Value8;
        } else if(Effect8.equals("무공(고정)")){
            무공 += Value8;
        } else if (Effect8.equals("무공(%)")) {
            무공 += 무공 * Value8;
        }

        //귀걸이2 옵션3
        accessoriesDto.Effect earring_2_effect_3 = earring_2.getEffects().get("acc_effect_2");
        String Effect9 = earring_2_effect_3.getName();
        Double Value9 = earring_2_effect_3.getValue();
        if(Effect9.equals("공격력(고정)")){
            공격력 += Value9;
        } else if (Effect9.equals("공격력(%)")) {
            공격력 += 공격력 * Value9;
        } else if(Effect9.equals("무공(고정)")){
            무공 += Value9;
        } else if (Effect9.equals("무공(%)")) {
            무공 += 무공 * Value9;
        }


        //반지 3
        accessoriesDto.AccessoryItem ring_3 = accessories.get("반지_3");
        //반지 3 힘민지
        int ring_3_Stat = ring_3.getCurrentStat();
        //반지 3 옵션1
        accessoriesDto.Effect ring_1_effect_1 = ring_3.getEffects().get("acc_effect_0");
        String Effect10 = ring_1_effect_1.getName();
        Double Value10 = ring_1_effect_1.getValue();
        if (Effect10.equals("치적")){
            치적 += Value10;
        } else if (Effect10.equals("치피")) {
            치피증 += Value10;
        } else if (Effect10.equals("공격력(고정)")) {
            공격력 += Value10;
        } else if (Effect10.equals("무공(고정)")) {
            무공 += Value10;
        }
        //반지 3 옵션2
        accessoriesDto.Effect ring_1_effect_2 = ring_3.getEffects().get("acc_effect_1");
        String Effect11 = ring_1_effect_2.getName();
        Double Value11 = ring_1_effect_2.getValue();
        if (Effect11.equals("치적")){
            치적 += Value11;
        } else if (Effect11.equals("치피")) {
            치피증 += Value11;
        } else if (Effect11.equals("공격력(고정)")) {
            공격력 += Value11;
        } else if (Effect11.equals("무공(고정)")) {
            무공 += Value11;
        }
        //반지 3 옵션3
        accessoriesDto.Effect ring_1_effect_3 = ring_3.getEffects().get("acc_effect_2");
        String Effect12 = ring_1_effect_3.getName();
        Double Value12 = ring_1_effect_3.getValue();
        if (Effect12.equals("치적")){
            치적 += Value12;
        } else if (Effect12.equals("치피")) {
            치피증 += Value12;
        } else if (Effect12.equals("공격력(고정)")) {
            공격력 += Value12;
        } else if (Effect12.equals("무공(고정)")) {
            무공 += Value12;
        }


        //반지4
        accessoriesDto.AccessoryItem ring_4 = accessories.get("반지_3");
        //반지4 힘민지
        int ring_4_Stat = ring_4.getCurrentStat();
        //반지4 옵션1
        accessoriesDto.Effect ring_2_effect_1 = ring_4.getEffects().get("acc_effect_0");
        String Effect13 = ring_2_effect_1.getName();
        Double Value13 = ring_2_effect_1.getValue();
        if (Effect13.equals("치적")){
            치적 += Value13;
        } else if (Effect13.equals("치피")) {
            치피증 += Value13;
        } else if (Effect13.equals("공격력(고정)")) {
            공격력 += Value13;
        } else if (Effect13.equals("무공(고정)")) {
            무공 += Value13;
        }

        //반지4 옵션2
        accessoriesDto.Effect ring_2_effect_2 = ring_4.getEffects().get("acc_effect_1");
        String Effect14 = ring_2_effect_2.getName();
        Double Value14 = ring_2_effect_2.getValue();
        if (Effect14.equals("치적")){
            치적 += Value14;
        } else if (Effect14.equals("치피")) {
            치피증 += Value14;
        } else if (Effect14.equals("공격력(고정)")) {
            공격력 += Value14;
        } else if (Effect14.equals("무공(고정)")) {
            무공 += Value14;
        }

        //반지4 옵션3
        accessoriesDto.Effect ring_2_effect_3 = ring_4.getEffects().get("acc_effect_2");
        String Effect15 = ring_2_effect_3.getName();
        Double Value15 = ring_2_effect_3.getValue();
        if (Effect15.equals("치적")){
            치적 += Value15;
        } else if (Effect15.equals("치피")) {
            치피증 += Value15;
        } else if (Effect15.equals("공격력(고정)")) {
            공격력 += Value15;
        } else if (Effect15.equals("무공(고정)")) {
            무공 += Value15;
        }

        //악세 힘민지
        힘민지 += neckStat + earring_1_Stat + earring_2_Stat + ring_3_Stat + ring_4_Stat;

        //혼돈 아크 그리드
        //해
        ArkGridResponseDto chaosSunEffects = chaosSun.getArkGrid(arkGridRequestDto);
        치명타시피증 += chaosSunEffects.getEffects().get("치피증");
        피증 += chaosSunEffects.getEffects().get("적주피");
        피증 += chaosSunEffects.getEffects().get("추피");


        //달
        ArkGridResponseDto chaosMoonEffects = chaosMoon.getArkGrid(arkGridRequestDto);
        치명타시피증 += chaosMoonEffects.getEffects().get("치피증");
        피증 += chaosMoonEffects.getEffects().get("적주피");
        치적 += chaosMoonEffects.getEffects().get("치적");
        적방어력 -= chaosMoonEffects.getEffects().get("방깎");


        //별
        ArkGridResponseDto chaosStarEffects = chaosStar.getArkGrid(arkGridRequestDto);
        공격력 += chaosStarEffects.getEffects().get("공격력");
        공격력 += 공격력 * chaosStarEffects.getEffects().get("공퍼력");
        무공 += chaosStarEffects.getEffects().get("무공");
        무공 += 무공 * chaosStarEffects.getEffects().get("무공퍼");


        Map<String , Double> res = new HashMap<>();
        res.put("힘민지" , 힘민지);
        res.put("무공" , 무공);
        res.put("공증" , 공증);
        res.put("공격력" , 공격력);
        res.put("추피" , 추피);
        res.put("피증" , 피증);
        res.put("치적" , 치적);
        res.put("치피증" , 치피증);
        res.put("치명타시피증" , 치명타시피증);
        res.put("적방어력" , 적방어력);

        return res;
    }
}
