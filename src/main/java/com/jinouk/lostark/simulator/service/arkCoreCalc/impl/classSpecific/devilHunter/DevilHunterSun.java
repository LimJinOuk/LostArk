package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.devilHunter;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DevilHunterSun extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "데빌헌터";
    }

    @Override
    public String getArkGridCoreName() {
        return "질서의 해 코어";
    }

    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        validateItems(requestDto);

        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;


            if ("블러드 하운드".equals(name)) {
                calcBloodHound(effectsMap, point, grade);
            } else if ("데드 샷".equals(name)) {
                calcDeadShot(effectsMap, point, grade);
            } else if ("샷건 오버로드".equals(name)) {
                calcShotgunOverload(effectsMap, point, grade);
            } else if ("섀도우 불릿".equals(name)) {
                calcShadowBullet(effectsMap, point, grade);
            } else if ("히든 팽".equals(name)) {
                calcHiddenFang(effectsMap, point, grade);
            } else if ("데드 토스".equals(name)) {
                calcDeadToss(effectsMap, point, grade);
            }
        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }


    //블러드 하운드
    //진욱쿤 찬스(14포) -> 무력화x
    private void calcBloodHound(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 17: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); mergeEffect(effectsMap, "적주피", 5.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 5.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 5.00); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 5.00);  break;
                case 18: mergeEffect(effectsMap, "샷건 스킬 피증", 1.90); mergeEffect(effectsMap, "적주피해", 5.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 5.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 5.00); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 5.00);  break;
                case 19: mergeEffect(effectsMap, "샷건 스킬 피증", 2.10); mergeEffect(effectsMap, "적주피", 5.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 5.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 5.00); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 5.00);  break;
                case 20: mergeEffect(effectsMap, "샷건 스킬 피증", 2.30); mergeEffect(effectsMap, "적주피", 5.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 5.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 5.00); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 5.00);  break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 17: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); mergeEffect(effectsMap, "적주피", 5.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 5.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 7.00); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 7.00);  break;
                case 18: mergeEffect(effectsMap, "샷건 스킬 피증", 1.90); mergeEffect(effectsMap, "적주피해", 5.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 5.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 7.00); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 7.00);  break;
                case 19: mergeEffect(effectsMap, "샷건 스킬 피증", 2.10); mergeEffect(effectsMap, "적주피", 5.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 5.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 7.00); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 7.00);  break;
                case 20: mergeEffect(effectsMap, "샷건 스킬 피증", 2.30); mergeEffect(effectsMap, "적주피", 5.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 5.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 7.00); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 7.00);  break;
            }
        }
    }

    //데드 샷
    private void calcDeadShot(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이플 스킬 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "라이플 스킬 피증", 2.50); break; // 쿨초 메커니즘 제외
                case 17: mergeEffect(effectsMap, "라이플 스킬 피증", 2.50); mergeEffect(effectsMap, "피증", 30.00); break; // 퍼샷 피증 0% 제외
                case 18: mergeEffect(effectsMap, "라이플 스킬 피증", 2.75); mergeEffect(effectsMap, "피증", 30.00); break; // 2.5 + 0.25
                case 19: mergeEffect(effectsMap, "라이플 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "라이플 스킬 피증", 3.25); mergeEffect(effectsMap, "피증", 30.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이플 스킬 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "라이플 스킬 피증", 2.50); break; // 쿨초 메커니즘 제외
                case 17: mergeEffect(effectsMap, "라이플 스킬 피증", 2.50); mergeEffect(effectsMap, "피증", 30.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 7.00); break; // 퍼샷 피증 0% 제외
                case 18: mergeEffect(effectsMap, "라이플 스킬 피증", 2.75); mergeEffect(effectsMap, "피증", 30.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 7.00); break; // 2.5 + 0.25
                case 19: mergeEffect(effectsMap, "라이플 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", 30.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 7.00); break;
                case 20: mergeEffect(effectsMap, "라이플 스킬 피증", 3.25); mergeEffect(effectsMap, "피증", 30.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 7.00); break;
            }
        }
    }

    //샷건 오버로드
    private void calcShotgunOverload(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "샷건 스킬 피증", -5.30); break; // 1.7 - 7.0
                case 17: mergeEffect(effectsMap, "샷건 스킬 피증", -5.30); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "샷건 스킬 피증", -5.30); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 12.60); break;
                case 19: mergeEffect(effectsMap, "샷건 스킬 피증", -5.30); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 13.20); break;
                case 20: mergeEffect(effectsMap, "샷건 스킬 피증", -5.30); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 13.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "샷건 스킬 피증", -5.30); break; // 1.7 - 7.0
                case 17: mergeEffect(effectsMap, "샷건 스킬 피증", -5.30); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "샷건 스킬 피증", -5.30); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 15.60); break;
                case 19: mergeEffect(effectsMap, "샷건 스킬 피증", -5.30); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 16.20); break;
                case 20: mergeEffect(effectsMap, "샷건 스킬 피증", -5.30); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 16.80); break;
            }
        }
    }

    //섀도우 불릿
    private void calcShadowBullet(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "핸드건 스킬 피증", 5.60); break; // 1.6 + 4.0
                case 17: mergeEffect(effectsMap, "핸드건 스킬 피증", 5.60); mergeEffect(effectsMap, "데스페라도 스킬 피증", 8.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
                case 18: mergeEffect(effectsMap, "핸드건 스킬 피증", 5.76); mergeEffect(effectsMap, "데스페라도 스킬 피증", 8.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
                case 19: mergeEffect(effectsMap, "핸드건 스킬 피증", 5.92); mergeEffect(effectsMap, "데스페라도 스킬 피증", 8.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
                case 20: mergeEffect(effectsMap, "핸드건 스킬 피증", 6.08); mergeEffect(effectsMap, "데스페라도 스킬 피증", 8.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "핸드건 스킬 피증", 5.60); break; // 1.6 + 4.0
                case 17: mergeEffect(effectsMap, "핸드건 스킬 피증", 5.60); mergeEffect(effectsMap, "데스페라도 스킬 피증", 12.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
                case 18: mergeEffect(effectsMap, "핸드건 스킬 피증", 5.76); mergeEffect(effectsMap, "데스페라도 스킬 피증", 12.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
                case 19: mergeEffect(effectsMap, "핸드건 스킬 피증", 5.92); mergeEffect(effectsMap, "데스페라도 스킬 피증", 12.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
                case 20: mergeEffect(effectsMap, "핸드건 스킬 피증", 6.08); mergeEffect(effectsMap, "데스페라도 스킬 피증", 12.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
            }
        }
    }

    //히든 팽
    private void calcHiddenFang(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 40.00); break; // 피증 0% 제외
                case 18: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 40.50);break;
                case 19: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 41.00);break;
                case 20: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 41.50);break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 43.00); break; // 피증 0% 제외
                case 18: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 43.50);break;
                case 19: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 44.00);break;
                case 20: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 44.50);break;
            }
        }
    }

    //데드 토스
    private void calcDeadToss(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "핸드건(나선의 추적자 제외) 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "핸드건(나선의 추적자 제외) 스킬 피증", 14.50); break; // 8.0 + 6.5
                case 18: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "핸드건(나선의 추적자 제외) 스킬 피증", 14.50); mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 0.80); break;
                case 19: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "핸드건(나선의 추적자 제외) 스킬 피증", 14.50); mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 1.60); break;
                case 20: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "핸드건(나선의 추적자 제외) 스킬 피증", 14.50); mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 2.40); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "핸드건(나선의 추적자 제외) 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "핸드건(나선의 추적자 제외) 스킬 피증", 15.50); break; // 8.0 + 6.5
                case 18: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "핸드건(나선의 추적자 제외) 스킬 피증", 15.50); mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 0.80); break;
                case 19: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "핸드건(나선의 추적자 제외) 스킬 피증", 15.50); mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 1.60); break;
                case 20: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "핸드건(나선의 추적자 제외) 스킬 피증", 15.50); mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 2.40); break;
            }
        }
    }
}
