package com.jinouk.lostark.simulator.service.simulatorRun;

import com.jinouk.lostark.simulator.dto.simulateRun.child.*;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.impl.common.ChaosMoon;
import com.jinouk.lostark.simulator.service.arkCoreCalc.impl.common.ChaosStar;
import com.jinouk.lostark.simulator.service.arkCoreCalc.impl.common.ChaosSun;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

        double 힘민지 = 0;
        double 무공 = 1;

        double 공증 = 0;
        double 공격력 = 1;

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

        double 적방어력 = 100;

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
            System.out.println("목걸이 옵션 중 옵션 1번 :  적주피 옵션 값: " + Value);
            System.out.println("목걸이 옵션 중 옵션 1번 : 적주피로 인해 계산된 피증 값 : " + 피증);
        } else if (Effect1.equals("추피")) {
            추피 += Value;
            System.out.println("목걸이 옵션 중 옵션 1번 : 추피 옵션 값 : " + Value);
            System.out.println("목걸이 옵션 중 옵션 1번 : 추피로 인해 계산된 추피 값 : " + 추피);
        } else if (Effect1.contains("공격력")) {
            공격력 += Value;
            System.out.println("목걸이 옵션 중 옵션 1번 : 공격력 옵션 값 : "+ Value);
            System.out.println("목걸이 옵션 중 옵션 1번 : 공격력으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect1.contains("무공")) {
            무공 += Value;
            System.out.println("목걸이 옵션 중 옵션 1번 : 무공 옵션 값 : "+ Value);
            System.out.println("목걸이 옵션 중 옵션 1번 : 무공으로 인해 계산된 무공 값 : " + 무공);
        }

        //목걸이 옵션2
        accessoriesDto.Effect neck_effect_2 = neck_0.getEffects().get("acc_effect_1");
        String Effect2 = neck_effect_2.getName();
        Double Value2 = neck_effect_2.getValue();
        if(Effect2.equals("적주피"))
        {
            피증 += Value2;
            System.out.println("목걸이 옵션 중 옵션 2번 :  적주피 옵션 값: " + Value2);
            System.out.println("목걸이 옵션 중 옵션 1 ~ 2번 : 적주피로 인해 계산된 피증 값 : " + 피증);
        } else if (Effect2.equals("추피")) {
            추피 += Value2;
            System.out.println("목걸이 옵션 중 옵션 2번 : 추피 옵션 값 : " + Value2);
            System.out.println("목걸이 옵션 중 옵션 1~2번 : 추피로 인해 계산된 추피 값 : " + 추피);
        } else if (Effect2.contains("공격력")) {
            공격력 += Value2;
            System.out.println("목걸이 옵션 중 옵션 2번 : 공격력 옵션 값 : "+ Value2);
            System.out.println("목걸이 옵션 중 옵션 1~2번 : 공격력으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect2.contains("무공")) {
            무공 += Value2;
            System.out.println("목걸이 옵션 중 옵션 2번 : 무공 옵션 값 : "+ Value2);
            System.out.println("목걸이 옵션 중 옵션 1~2번 : 무공으로 인해 계산된 무공 값 : " + 무공);
        }

        //목걸이 옵션3
        accessoriesDto.Effect neck_effect_3 = neck_0.getEffects().get("acc_effect_2");
        String Effect3 = neck_effect_3.getName();
        Double Value3 = neck_effect_3.getValue();
        if(Effect1.equals("적주피"))
        {
            피증 += Value3;
            System.out.println("목걸이 옵션 중 옵션 3번 :  적주피 옵션 값: " + Value3);
            System.out.println("목걸이 옵션 중 옵션 1 ~ 3번 : 적주피로 인해 계산된 피증 값 : " + 피증);
        } else if (Effect3.equals("추피")) {
            추피 += Value3;
            System.out.println("목걸이 옵션 중 옵션 3번 : 추피 옵션 값 : " + Value3);
            System.out.println("목걸이 옵션 중 옵션 1~3번 : 추피로 인해 계산된 추피 값 : " + 추피);
        } else if (Effect3.contains("공격력")) {
            공격력 += Value3;
            System.out.println("목걸이 옵션 중 옵션 3번 : 공격력 옵션 값 : "+ Value3);
            System.out.println("목걸이 옵션 중 옵션 1~3번 : 공격력으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect3.contains("무공")) {
            무공 += Value3;
            System.out.println("목걸이 옵션 중 옵션 3번 : 무공 옵션 값 : "+ Value3);
            System.out.println("목걸이 옵션 중 옵션 1~3번 : 무공으로 인해 계산된 무공 값 : " + 무공);
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
            System.out.println("귀걸이 1 옵션 중 옵션 1번 : 공격력(고정) 옵션 값 : " + Value4);
            System.out.println("귀걸이 1 옵션 중 옵션 1번 : 공격력(고정) 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect4.equals("공격력(%)")) {
            공격력 = 공격력 * Value4;
            System.out.println("귀걸이 1 옵션 중 옵션 1번 : 공격력(퍼센트) 옵션 값 : " + Value4);
            System.out.println("귀걸이 1 옵션 중 옵션 1번 : 공격력(퍼센트) 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if(Effect4.equals("무공(고정)")){
            무공 += Value4;
            System.out.println("귀걸이 1 옵션 중 옵션 1번 : 무공(고정) 옵션 값 : " + Value4);
            System.out.println("귀걸이 1 옵션 중 옵션 1번 : 무공(고정) 옵션 으로 인해 계산된 무공 값 : " + 무공);
        } else if (Effect4.equals("무공(%)")) {
            무공 = 무공 * Value4;
            System.out.println("귀걸이 1 옵션 중 옵션 1번 : 무공(퍼센트) 옵션 값 : " + Value4);
            System.out.println("귀걸이 1 옵션 중 옵션 1번 : 무공(퍼센트) 옵션 으로 인해 계산된 무공 값 : " + 무공);
        }

        //귀걸이1 옵션2
        accessoriesDto.Effect earring_1_effect_2 = earring_1.getEffects().get("acc_effect_1");
        String Effect5 = earring_1_effect_2.getName();
        Double Value5 = earring_1_effect_2.getValue();
        if(Effect5.equals("공격력(고정)")){
            공격력 += Value5;
            System.out.println("귀걸이1 옵션 중 옵션 2번 : 공격력(고정) 옵션 값 : " + Value5);
            System.out.println("귀걸이 1 옵션 중 옵션 1번 : 공격력(고정) 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect5.equals("공격력(%)")) {
            공격력 = 공격력 * Value5;
            System.out.println("귀걸이1 옵션 중 옵션 2번 : 공격력(퍼센트) 옵션 값 : " + Value5);
            System.out.println("귀걸이 1 옵션 중 옵션 1번 : 공격력(퍼센트) 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if(Effect5.equals("무공(고정)")){
            무공 += Value5;
            System.out.println("귀걸이1 옵션 중 옵션 2번 : 무공(고정) 옵션 값 : " + Value5);
            System.out.println("귀걸이 1 옵션 중 옵션 1번 : 무공(고정) 옵션 으로 인해 계산된 무공 값 : " + 무공);
        } else if (Effect5.equals("무공(%)")) {
            무공 = 무공 * Value5;
            System.out.println("귀걸이1 옵션 중 옵션 2번 : 무공(퍼센트) 옵션 값 : " + Value5);
            System.out.println("귀걸이 1 옵션 중 옵션 1번 : 무공(퍼센트) 옵션 으로 인해 계산된 무공 값 : " + 무공);
        }

        //귀걸이1 옵션3
        accessoriesDto.Effect earring_1_effect_3 = earring_1.getEffects().get("acc_effect_2");
        String Effect6 = earring_1_effect_3.getName();
        Double Value6 = earring_1_effect_3.getValue();
        if(Effect6.equals("공격력(고정)")){
            공격력 += Value6;
            System.out.println("귀걸이 1 옵션 중 옵션 3번 : 공격력(고정) 옵션 값 : " + Value6);
            System.out.println("귀걸이 1 옵션 중 옵션 3번 : 공격력(고정) 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect6.equals("공격력(%)")) {
            공격력 = 공격력 * Value6;
            System.out.println("귀걸이 1 옵션 중 옵션 3번 : 공격력(퍼센트) 옵션 값 : " + Value6);
            System.out.println("귀걸이 1 옵션 중 옵션 3번 : 공격력(퍼센트) 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if(Effect6.equals("무공(고정)")){
            무공 += Value6;
            System.out.println("귀걸이 1 옵션 중 옵션 3번 : 무공(고정) 옵션 값 : " + Value6);
            System.out.println("귀걸이 1 옵션 중 옵션 3번 : 무공(고정) 옵션 으로 인해 계산된 무공 값 : " + 무공);
        } else if (Effect6.equals("무공(%)")) {
            무공 = 무공 * Value6;
            System.out.println("귀걸이 1 옵션 중 옵션 3번 : 무공(퍼센트) 옵션 값 : " + Value6);
            System.out.println("귀걸이 1 옵션 중 옵션 3번 : 무공(퍼센트) 옵션 으로 인해 계산된 무공 값 : " + 무공);
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
            System.out.println("귀걸이 2 옵션 중 옵션 1번 : 공격력(고정) 옵션 값 : " + Value7);
            System.out.println("귀걸이 2 옵션 중 옵션 1번 : 공격력(고정) 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect7.equals("공격력(%)")) {
            공격력 = 공격력 * Value7;
            System.out.println("귀걸이 2 옵션 중 옵션 1번 : 공격력(퍼센트) 옵션 값 : " + Value7);
            System.out.println("귀걸이 2 옵션 중 옵션 1번 : 공격력(퍼센트) 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if(Effect7.equals("무공(고정)")){
            무공 += Value7;
            System.out.println("귀걸이 2 옵션 중 옵션 1번 : 무공(고정) 옵션 값 : " + Value7);
            System.out.println("귀걸이 2 옵션 중 옵션 1번 : 무공(고정) 옵션 으로 인해 계산된 무공 값 : " + 무공);
        } else if (Effect7.equals("무공(%)")) {
            무공 = 무공 * Value7;
            System.out.println("귀걸이 2 옵션 중 옵션 1번 : 무공(퍼센트) 옵션 값 : " + Value7);
            System.out.println("귀걸이 2 옵션 중 옵션 1번 : 무공(퍼센트) 옵션 으로 인해 계산된 무공 값 : " + 무공);
        }

        //귀걸이2 옵션2
        accessoriesDto.Effect earring_2_effect_2 = earring_2.getEffects().get("acc_effect_1");
        String Effect8 = earring_2_effect_2.getName();
        Double Value8 = earring_2_effect_2.getValue();
        if(Effect8.equals("공격력(고정)")){
            공격력 += Value8;
            System.out.println("귀걸이 2 옵션 중 옵션 2번 : 공격력(고정) 옵션 값 : " + Value8);
            System.out.println("귀걸이 2 옵션 중 옵션 2번 : 공격력(고정) 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect8.equals("공격력(%)")) {
            공격력 = 공격력 * Value8;
            System.out.println("귀걸이 2 옵션 중 옵션 2번 : 공격력(퍼센트) 옵션 값 : " + Value8);
            System.out.println("귀걸이 2 옵션 중 옵션 2번 : 공격력(퍼센트) 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if(Effect8.equals("무공(고정)")){
            무공 += Value8;
            System.out.println("귀걸이 2 옵션 중 옵션 2번 : 무공(고정) 옵션 값 : " + Value8);
            System.out.println("귀걸이 2 옵션 중 옵션 2번 : 무공(고정) 옵션 으로 인해 계산된 무공 값 : " + 무공);
        } else if (Effect8.equals("무공(%)")) {
            무공 = 무공 * Value8;
            System.out.println("귀걸이 2 옵션 중 옵션 2번 : 무공(퍼센트) 옵션 값 : " + Value8);
            System.out.println("귀걸이 2 옵션 중 옵션 2번 : 무공(퍼센트) 옵션 으로 인해 계산된 무공 값 : " + 무공);
        }

        //귀걸이2 옵션3
        accessoriesDto.Effect earring_2_effect_3 = earring_2.getEffects().get("acc_effect_2");
        String Effect9 = earring_2_effect_3.getName();
        Double Value9 = earring_2_effect_3.getValue();
        if(Effect9.equals("공격력(고정)")){
            공격력 += Value9;
            System.out.println("귀걸이 2 옵션 중 옵션 3번 : 공격력(고정) 옵션 값 : " + Value9);
            System.out.println("귀걸이 2 옵션 중 옵션 3번 : 공격력(고정) 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect9.equals("공격력(%)")) {
            공격력 = 공격력 * Value9;
            System.out.println("귀걸이 2 옵션 중 옵션 3번 : 공격력(퍼센트) 옵션 값 : " + Value9);
            System.out.println("귀걸이 2 옵션 중 옵션 3번 : 공격력(퍼센트) 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if(Effect9.equals("무공(고정)")){
            무공 += Value9;
            System.out.println("귀걸이 2 옵션 중 옵션 3번 : 무공(고정) 옵션 값 : " + Value9);
            System.out.println("귀걸이 2 옵션 중 옵션 3번 : 무공(고정) 옵션 으로 인해 계산된 무공 값 : " + 무공);
        } else if (Effect9.equals("무공(%)")) {
            무공 = 무공 * Value9;
            System.out.println("귀걸이 2 옵션 중 옵션 3번 : 무공(퍼센트) 옵션 값 : " + Value9);
            System.out.println("귀걸이 2 옵션 중 옵션 3번 : 무공(퍼센트) 옵션 으로 인해 계산된 무공 값 : " + 무공);
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
            System.out.println("반지 1 옵션 중 옵션 1번 : 치적 옵션 값 : " + Value10);
            System.out.println("반지 1 옵션 중 옵션 1번 : 치적 옵션 으로 인해 계산된 치적 값 : " + 치적);
        } else if (Effect10.equals("치피")) {
            치피증 += Value10;
            System.out.println("반지 1 옵션 중 옵션 1번 : 치피증 옵션 값 : " + Value10);
            System.out.println("반지 1 옵션 중 옵션 1번 : 치피증 옵션 으로 인해 계산된 치피증 값 : " + 치피증);
        } else if (Effect10.equals("공격력(고정)")) {
            공격력 += Value10;
            System.out.println("반지 1 옵션 중 옵션 1번 : 공격력 옵션 값 : " + Value10);
            System.out.println("반지 1 옵션 중 옵션 1번 : 공격력 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect10.equals("무공(고정)")) {
            무공 += Value10;
            System.out.println("반지 1 옵션 중 옵션 1번 : 무공 옵션 값 : " + Value10);
            System.out.println("반지 1 옵션 중 옵션 1번 : 무공 옵션 으로 인해 계산된 무공 값 : " + 무공);
        }
        //반지 3 옵션2
        accessoriesDto.Effect ring_1_effect_2 = ring_3.getEffects().get("acc_effect_1");
        String Effect11 = ring_1_effect_2.getName();
        Double Value11 = ring_1_effect_2.getValue();
        if (Effect11.equals("치적")){
            치적 += Value11;
            System.out.println("반지 1 옵션 중 옵션 2번 : 치적 옵션 값 : " + Value11);
            System.out.println("반지 1 옵션 중 옵션 2번 : 치적 옵션 으로 인해 계산된 치적 값 : " + 치적);
        } else if (Effect11.equals("치피")) {
            치피증 += Value11;
            System.out.println("반지 1 옵션 중 옵션 2번 : 치피증 옵션 값 : " + Value11);
            System.out.println("반지 1 옵션 중 옵션 2번 : 치피증 옵션 으로 인해 계산된 치피증 값 : " + 치피증);
        } else if (Effect11.equals("공격력(고정)")) {
            공격력 += Value11;
            System.out.println("반지 1 옵션 중 옵션 2번 : 공격력 옵션 값 : " + Value11);
            System.out.println("반지 1 옵션 중 옵션 2번 : 공격력 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect11.equals("무공(고정)")) {
            무공 += Value11;
            System.out.println("반지 1 옵션 중 옵션 2번 : 무공 옵션 값 : " + Value11);
            System.out.println("반지 1 옵션 중 옵션 2번 : 무공 옵션 으로 인해 계산된 무공 값 : " + 무공);
        }
        //반지 3 옵션3
        accessoriesDto.Effect ring_1_effect_3 = ring_3.getEffects().get("acc_effect_2");
        String Effect12 = ring_1_effect_3.getName();
        Double Value12 = ring_1_effect_3.getValue();
        if (Effect12.equals("치적")){
            치적 += Value12;
            System.out.println("반지 1 옵션 중 옵션 2번 : 치적 옵션 값 : " + Value12);
            System.out.println("반지 1 옵션 중 옵션 2번 : 치적 옵션 으로 인해 계산된 치적 값 : " + 치적);
        } else if (Effect12.equals("치피")) {
            치피증 += Value12;
            System.out.println("반지 1 옵션 중 옵션 2번 : 치피증 옵션 값 : " + Value12);
            System.out.println("반지 1 옵션 중 옵션 2번 : 치피증 옵션 으로 인해 계산된 치피증 값 : " + 치피증);
        } else if (Effect12.equals("공격력(고정)")) {
            공격력 += Value12;
            System.out.println("반지 1 옵션 중 옵션 2번 : 공격력 옵션 값 : " + Value12);
            System.out.println("반지 1 옵션 중 옵션 2번 : 공격력 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect12.equals("무공(고정)")) {
            무공 += Value12;
            System.out.println("반지 1 옵션 중 옵션 2번 : 무공 옵션 값 : " + Value12);
            System.out.println("반지 1 옵션 중 옵션 2번 : 무공 옵션 으로 인해 계산된 무공 값 : " + 무공);
        }


        //반지4
        accessoriesDto.AccessoryItem ring_4 = accessories.get("반지_4");
        //반지4 힘민지
        int ring_4_Stat = ring_4.getCurrentStat();
        //반지4 옵션1
        accessoriesDto.Effect ring_2_effect_1 = ring_4.getEffects().get("acc_effect_0");
        String Effect13 = ring_2_effect_1.getName();
        Double Value13 = ring_2_effect_1.getValue();
        if (Effect13.equals("치적")){
            치적 += Value13;
            System.out.println("반지 2 옵션 중 옵션 1번 : 치적 옵션 값 : " + Value13);
            System.out.println("반지 2 옵션 중 옵션 1번 : 치적 옵션 으로 인해 계산된 치적 값 : " + 치적);
        } else if (Effect13.equals("치피")) {
            치피증 += Value13;
            System.out.println("반지 2 옵션 중 옵션 1번 : 치피증 옵션 값 : " + Value13);
            System.out.println("반지 2 옵션 중 옵션 1번 : 치피증 옵션 으로 인해 계산된 치피증 값 : " + 치피증);
        } else if (Effect13.equals("공격력(고정)")) {
            공격력 += Value13;
            System.out.println("반지 2 옵션 중 옵션 1번 : 공격력 옵션 값 : " + Value13);
            System.out.println("반지 2 옵션 중 옵션 1번 : 공격력 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect13.equals("무공(고정)")) {
            무공 += Value13;
            System.out.println("반지 2 옵션 중 옵션 1번 : 무공 옵션 값 : " + Value13);
            System.out.println("반지 2 옵션 중 옵션 1번 : 무공 옵션 으로 인해 계산된 무공 값 : " + 무공);
        }

        //반지4 옵션2
        accessoriesDto.Effect ring_2_effect_2 = ring_4.getEffects().get("acc_effect_1");
        String Effect14 = ring_2_effect_2.getName();
        Double Value14 = ring_2_effect_2.getValue();
        if (Effect14.equals("치적")){
            치적 += Value14;
            System.out.println("반지 2 옵션 중 옵션 2번 : 치적 옵션 값 : " + Value14);
            System.out.println("반지 2 옵션 중 옵션 2번 : 치적 옵션 으로 인해 계산된 치적 값 : " + 치적);
        } else if (Effect14.equals("치피")) {
            치피증 += Value14;
            System.out.println("반지 2 옵션 중 옵션 2번 : 치피증 옵션 값 : " + Value14);
            System.out.println("반지 2 옵션 중 옵션 2번 : 치피증 옵션 으로 인해 계산된 치피증 값 : " + 치피증);
        } else if (Effect14.equals("공격력(고정)")) {
            공격력 += Value14;
            System.out.println("반지 2 옵션 중 옵션 2번 : 공격력 옵션 값 : " + Value14);
            System.out.println("반지 2 옵션 중 옵션 2번 : 공격력 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect14.equals("무공(고정)")) {
            무공 += Value14;
            System.out.println("반지 2 옵션 중 옵션 2번 : 무공 옵션 값 : " + Value14);
            System.out.println("반지 2 옵션 중 옵션 2번 : 무공 옵션 으로 인해 계산된 무공 값 : " + 무공);
        }

        //반지4 옵션3
        accessoriesDto.Effect ring_2_effect_3 = ring_4.getEffects().get("acc_effect_2");
        String Effect15 = ring_2_effect_3.getName();
        Double Value15 = ring_2_effect_3.getValue();
        if (Effect15.equals("치적")){
            치적 += Value15;
            System.out.println("반지 2 옵션 중 옵션 2번 : 치적 옵션 값 : " + Value15);
            System.out.println("반지 2 옵션 중 옵션 2번 : 치적 옵션 으로 인해 계산된 치적 값 : " + 치적);
        } else if (Effect15.equals("치피")) {
            치피증 += Value15;
            System.out.println("반지 2 옵션 중 옵션 2번 : 치피증 옵션 값 : " + Value15);
            System.out.println("반지 2 옵션 중 옵션 2번 : 치피증 옵션 으로 인해 계산된 치피증 값 : " + 치적);
        } else if (Effect15.equals("공격력(고정)")) {
            공격력 += Value15;
            System.out.println("반지 2 옵션 중 옵션 2번 : 공격력 옵션 값 : " + Value15);
            System.out.println("반지 2 옵션 중 옵션 2번 : 공격력 옵션 으로 인해 계산된 공격력 값 : " + 공격력);
        } else if (Effect15.equals("무공(고정)")) {
            무공 += Value15;
            System.out.println("반지 2 옵션 중 옵션 2번 : 무공 옵션 값 : " + Value15);
            System.out.println("반지 2 옵션 중 옵션 2번 : 무공 옵션 으로 인해 계산된 무공 값 : " + 무공);
        }

        //악세 힘민지
        힘민지 += neckStat + earring_1_Stat + earring_2_Stat + ring_3_Stat + ring_4_Stat;
        System.out.println("악세사리 (목걸이 / 귀걸이 1 / 귀걸이 2 / 반지 1 / 반지 2)에서 총합 계산된 힘민지 : " + 힘민지);
        //혼돈 아크 그리드
        //해
        ArkGridResponseDto chaosSunEffects = chaosSun.getArkGrid(arkGridRequestDto);
        if(chaosSunEffects.getEffects().get("치피증") != null){
            치명타시피증 += chaosSunEffects.getEffects().get("치피증");
            System.out.println("혼돈의 해 코어에서 추출된 치피증 값 :  " + chaosSunEffects.getEffects().get("치피증"));
            System.out.println("혼돈의 해 코어에서 추출된 치피증 값으로 계산된 총 치명타시피증 값 : " + 치명타시피증);
        }
        if (chaosSunEffects.getEffects().get("적주피") != null){
            피증 += chaosSunEffects.getEffects().get("적주피");
            System.out.println("혼돈의 해 코어에서 추출된 적주피 값 :  " + chaosSunEffects.getEffects().get("적주피"));
            System.out.println("혼돈의 해 코어에서 추출된 적주피 값으로 계산된 총 피증 값 : " + 피증);
        }
        if (chaosSunEffects.getEffects().get("추피")!=null){
            피증 += chaosSunEffects.getEffects().get("추피");
            System.out.println("혼돈의 해 코어에서 추출된 추피 값 :  " + chaosSunEffects.getEffects().get("추피"));
            System.out.println("혼돈의 해 코어에서 추출된 추피 값으로 계산된 총 피증 값 : " + 피증);
        }


        //달
        ArkGridResponseDto chaosMoonEffects = chaosMoon.getArkGrid(arkGridRequestDto);
        if (chaosMoonEffects.getEffects().get("치피증")!=null){
            치명타시피증 += chaosMoonEffects.getEffects().get("치피증");
            System.out.println("혼돈의 달 코어에서 추출된 치피증 값 :  " + chaosMoonEffects.getEffects().get("치피증"));
            System.out.println("혼돈의 달 코어에서 추출된 치피증 값으로 계산된 총 치명타시피증 값 : " + 치명타시피증);
        }
        if (chaosMoonEffects.getEffects().get("적주피")!=null){
            피증 += chaosMoonEffects.getEffects().get("적주피");
            System.out.println("혼돈의 달 코어에서 추출된 적주피 값 :  " + chaosMoonEffects.getEffects().get("적주피"));
            System.out.println("혼돈의 달 코어에서 추출된 적주피 값으로 계산된 총 피증 값 : " + 피증);
        }
        if (chaosMoonEffects.getEffects().get("치적")!=null){
            치적 += chaosMoonEffects.getEffects().get("치적");
            System.out.println("혼돈의 달 코어에서 추출된 치적 값 :  " + chaosMoonEffects.getEffects().get("치적"));
            System.out.println("혼돈의 달 코어에서 추출된 치적 값으로 계산된 총 치적 값 : " + 치적);
        }
        if (chaosMoonEffects.getEffects().get("방깎")!=null){
            적방어력 -= chaosMoonEffects.getEffects().get("방깎");
            System.out.println("혼돈의 달 코어에서 추출된 방깎 값 :  " + chaosMoonEffects.getEffects().get("방깎"));
            System.out.println("혼돈의 달 코어에서 추출된 방깎 값으로 계산된 총 적방어력 값 : " + 적방어력);
        }


        //별
        ArkGridResponseDto chaosStarEffects = chaosStar.getArkGrid(arkGridRequestDto);
        if (chaosStarEffects.getEffects().get("공격력")!=null){
            공격력 += chaosStarEffects.getEffects().get("공격력");
            System.out.println("혼돈의 별 코어에서 추출된 공격력 값 :  " + chaosStarEffects.getEffects().get("공격력"));
            System.out.println("혼돈의 별 코어에서 추출된 공격력 값으로 계산된 총 공격력 값 : " + 공격력);
        }
        if (chaosStarEffects.getEffects().get("공퍼력")!=null){
            공격력 += 공격력 * chaosStarEffects.getEffects().get("공퍼력");
            System.out.println("혼돈의 별 코어에서 추출된 공퍼력 값 :  " + chaosStarEffects.getEffects().get("공퍼력"));
            System.out.println("혼돈의 별 코어에서 추출된 공퍼력 값으로 계산된 총 공격력 값 : " + 공격력);
        }
        if (chaosStarEffects.getEffects().get("무공")!=null){
            무공 += chaosStarEffects.getEffects().get("무공");
            System.out.println("혼돈의 별 코어에서 추출된 무공 값 :  " + chaosStarEffects.getEffects().get("무공"));
            System.out.println("혼돈의 별 코어에서 추출된 무공 값으로 계산된 총 무공 값 : " + 무공);
        }
        if (chaosStarEffects.getEffects().get("무공퍼")!=null){
            무공 += 무공 * chaosStarEffects.getEffects().get("무공퍼");
            System.out.println("혼돈의 별 코어에서 추출된 무공퍼 값 :  " + chaosStarEffects.getEffects().get("무공퍼"));
            System.out.println("혼돈의 별 코어에서 추출된 무공퍼 값으로 계산된 총 무공 값 : " + 무공);
        }


        //장비
        double AdditionalDmg = equipmentsDto.getAdditionalDamage();
        추피 += AdditionalDmg;
        System.out.println("장비에서 추출된 추가피해 값 :  " + AdditionalDmg);
        System.out.println("장비에서 추출된 추가피해 값 으로 계산된 추피 값:  " + 추피);

        int weaponAttack = equipmentsDto.getWeaponAttack();
        무공 += weaponAttack;
        System.out.println("장비에서 추출된 무공 값 :  " + weaponAttack);
        System.out.println("장비에서 추출된 무공 값 으로 계산된 무공 값:  " + 무공);

        int BaseAttack = equipmentsDto.getFinalBaseAttack();
        공격력 += BaseAttack;
        System.out.println("장비에서 추출된 공격력 값 :  " + BaseAttack);
        System.out.println("장비에서 추출된 공격력 값 으로 계산된 공격력 값:  " + 공격력);

        //Gem
        double Add_Dmg = gemEffectDto.getAdd_pct();
        추피 += Add_Dmg;
        System.out.println("젬에서 추출된 추피 값 :  " + Add_Dmg);
        System.out.println("젬에서 추출된 추피 값 으로 계산된 추피 값:  " + 추피);
        
        double BossDmg = gemEffectDto.getBoss_pct();
        피증 += BossDmg;
        System.out.println("젬에서 추출된 피증 값 :  " + BossDmg);
        System.out.println("젬에서 추출된 피증 값 으로 계산된 피증 값:  " + 피증);

        double attck = gemEffectDto.getAtk_pct();
        공격력 += attck;
        System.out.println("젬에서 추출된 공격력 값 :  " + attck);
        System.out.println("젬에서 추출된 공격력 값 으로 계산된 공격력 값:  " + 공격력);

        //보석
        double jewelbonus = jewelDto.getTotalGemAtkBonus();
        공증 += jewelbonus;
        System.out.println("보석에서 추출된 공증 값 :  " + attck);
        System.out.println("보석에서 추출된 공증 값 으로 계산된 공증 값:  " + 공증);

        //각인
        List<engravingDto.engravingsList> engravingsLists = engravingDto.getEngravings();

        for (engravingDto.engravingsList engravings : engravingsLists) {
            String engravingName = engravings.getName();
            String engravingGrade = engravings.getGrade();
            int engravingLevel = engravings.getLevel();
            int abillityStoneLv = engravings.getAbilityStoneLevel();
            String description = engravings.getDescription();
            Map<String, Double> calcDescription = EngravingCalc.calc(engravingName, description);
            if (calcDescription.containsKey("피증")){
                피증 += calcDescription.get("피증");
                System.out.println(engravingName + "각인에서 추출된 각인 이름 값 :  " + engravingName);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 값(유물 or 전설) :  " + engravingGrade);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 레벨 값 :  " + engravingLevel);
                System.out.println(engravingName + "각인에서 추출된 각인 어빌스톤 등급 레벨 값 :  " + abillityStoneLv);
                System.out.println(engravingName + "각인에서 추출된 피증 값 :  " + calcDescription.get("피증"));
                System.out.println(engravingName + "각인에서 추출된 피증 값 으로 계산된 피증 값:  " + 피증);

                if (calcDescription.get("헤드어택시 추가 피증") != null){
                    헤드피증 += calcDescription.get("헤드어택시 추가 피증");
                    System.out.println(engravingName + "각인에서 추출된 각인 이름 값 :  " + engravingName);
                    System.out.println(engravingName + "각인에서 추출된 각인 등급 값(유물 or 전설) :  " + engravingGrade);
                    System.out.println(engravingName + "각인에서 추출된 각인 등급 레벨 값 :  " + engravingLevel);
                    System.out.println(engravingName + "각인에서 추출된 각인 어빌스톤 등급 레벨 값 :  " + abillityStoneLv);
                    System.out.println(engravingName + "각인에서 추출된 헤드피증 값 :  " + calcDescription.get("헤드어택시 추가 피증"));
                    System.out.println(engravingName + "각인에서 추출된 헤드피증 값 으로 계산된 헤드피증 값:  " + 헤드피증);
                }

                if (calcDescription.get("백어택시 추가 피증")!=null){
                    백피증 += calcDescription.get("백어택시 추가 피증");
                    System.out.println(engravingName + "각인에서 추출된 각인 이름 값 :  " + engravingName);
                    System.out.println(engravingName + "각인에서 추출된 각인 등급 값(유물 or 전설) :  " + engravingGrade);
                    System.out.println(engravingName + "각인에서 추출된 각인 등급 레벨 값 :  " + engravingLevel);
                    System.out.println(engravingName + "각인에서 추출된 각인 어빌스톤 등급 레벨 값 :  " + abillityStoneLv);
                    System.out.println(engravingName + "각인에서 추출된 백피증 값 :  " + calcDescription.get("백어택시 추가 피증"));
                    System.out.println(engravingName + "각인에서 추출된 백피증 값 으로 계산된 백피증 값:  " + 백피증);
                }

                if (calcDescription.get("타대공격시 추가 피증")!=null){
                    타대피증 += calcDescription.get("타대공격시 추가 피증");
                    System.out.println(engravingName + "각인에서 추출된 각인 이름 값 :  " + engravingName);
                    System.out.println(engravingName + "각인에서 추출된 각인 등급 값(유물 or 전설) :  " + engravingGrade);
                    System.out.println(engravingName + "각인에서 추출된 각인 등급 레벨 값 :  " + engravingLevel);
                    System.out.println(engravingName + "각인에서 추출된 각인 어빌스톤 등급 레벨 값 :  " + abillityStoneLv);
                    System.out.println(engravingName + "각인에서 추출된 타대피증 값 :  " + calcDescription.get("타대공격시 추가 피증"));
                    System.out.println(engravingName + "각인에서 추출된 타대피증 값 으로 계산된 타대피증 값:  " + 타대피증);
                }
            }
            if (calcDescription.get("돌대피증")!= null){
                돌대피증 += calcDescription.get("돌대피증");
                System.out.println(engravingName + "각인에서 추출된 각인 이름 값 :  " + engravingName);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 값(유물 or 전설) :  " + engravingGrade);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 레벨 값 :  " + engravingLevel);
                System.out.println(engravingName + "각인에서 추출된 각인 어빌스톤 등급 레벨 값 :  " + abillityStoneLv);
                System.out.println(engravingName + "각인에서 추출된 돌대피증 값 :  " + calcDescription.get("돌대피증"));
                System.out.println(engravingName + "각인에서 추출된 돌대피증 값 으로 계산된 돌대피증 값:  " + 돌대피증);
            }
            if (calcDescription.get("공증")!=null){
                공증 += calcDescription.get("공증");
                System.out.println(engravingName + "각인에서 추출된 각인 이름 값 :  " + engravingName);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 값(유물 or 전설) :  " + engravingGrade);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 레벨 값 :  " + engravingLevel);
                System.out.println(engravingName + "각인에서 추출된 각인 어빌스톤 등급 레벨 값 :  " + abillityStoneLv);
                System.out.println(engravingName + "각인에서 추출된 공증 값 :  " + calcDescription.get("공증"));
                System.out.println(engravingName + "각인에서 추출된 공증 값 으로 계산된 공증 값:  " + 공증);
            }
            if (calcDescription.get("치피증")!=null){
                치피증 += calcDescription.get("치피증");
                System.out.println(engravingName + "각인에서 추출된 각인 이름 값 :  " + engravingName);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 값(유물 or 전설) :  " + engravingGrade);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 레벨 값 :  " + engravingLevel);
                System.out.println(engravingName + "각인에서 추출된 각인 어빌스톤 등급 레벨 값 :  " + abillityStoneLv);
                System.out.println(engravingName + "각인에서 추출된 치피증 값 :  " + calcDescription.get("치피증"));
                System.out.println(engravingName + "각인에서 추출된 치피증 값 으로 계산된 치피증 값:  " + 치피증);
            }
            if (calcDescription.get("이속증")!=null){
                이속증 += calcDescription.get("이속증");
                System.out.println(engravingName + "각인에서 추출된 각인 이름 값 :  " + engravingName);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 값(유물 or 전설) :  " + engravingGrade);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 레벨 값 :  " + engravingLevel);
                System.out.println(engravingName + "각인에서 추출된 각인 어빌스톤 등급 레벨 값 :  " + abillityStoneLv);
                System.out.println(engravingName + "각인에서 추출된 이속증 값 :  " + calcDescription.get("이속증"));
                System.out.println(engravingName + "각인에서 추출된 이속증 값 으로 계산된 이속증 값:  " + 이속증);
            }
            if (calcDescription.get("치피감소")!=null){
                치피감소 += calcDescription.get("치피감소");
                System.out.println(engravingName + "각인에서 추출된 각인 이름 값 :  " + engravingName);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 값(유물 or 전설) :  " + engravingGrade);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 레벨 값 :  " + engravingLevel);
                System.out.println(engravingName + "각인에서 추출된 각인 어빌스톤 등급 레벨 값 :  " + abillityStoneLv);
                System.out.println(engravingName + "각인에서 추출된 치피감소 값 :  " + calcDescription.get("치피감소"));
                System.out.println(engravingName + "각인에서 추출된 치피감소 값 으로 계산된 치피감소 값:  " + 치피감소);
            }
            if (calcDescription.get("치적")!=null){
                치적 += calcDescription.get("치적");
                System.out.println(engravingName + "각인에서 추출된 각인 이름 값 :  " + engravingName);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 값(유물 or 전설) :  " + engravingGrade);
                System.out.println(engravingName + "각인에서 추출된 각인 등급 레벨 값 :  " + engravingLevel);
                System.out.println(engravingName + "각인에서 추출된 각인 어빌스톤 등급 레벨 값 :  " + abillityStoneLv);
                System.out.println(engravingName + "각인에서 추출된 치적 값 :  " + calcDescription.get("치적"));
                System.out.println(engravingName + "각인에서 추출된 치적 값 으로 계산된 치적 값:  " + 치적);
            }
        }


        Map<String , Double> res = new HashMap<>();
        res.put("힘민지" , 힘민지);
        res.put("무공" , 무공);
        res.put("공증" , 공증);
        res.put("공격력" , 공격력);
        res.put("추피" , 추피);
        res.put("피증" , 피증);
        res.put("헤드피증" , 헤드피증);
        res.put("백피증" , 백피증);
        res.put("타대피증" , 타대피증);
        res.put("돌대피증" , 돌대피증);
        res.put("이속증" , 이속증);
        res.put("치적" , 치적);
        res.put("치피증" , 치피증);
        res.put("치피감소" , 치피감소);
        res.put("치명타시피증" , 치명타시피증);
        res.put("적방어력" , 적방어력);

        return res;
    }
}
