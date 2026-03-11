package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.devilHunter;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DevilHunterStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "데빌헌터";
    }

    @Override
    public String getArkGridCoreName() {
        return "질서의 별 코어";
    }


    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        validateItems(requestDto);

        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;

            if ("탄환 폭발".equals(name)) {
                calcBulletExplosion(effectsMap, point, grade);
            } else if ("아이언 사이트".equals(name)) {
                calcIronSight(effectsMap, point, grade);
            } else if ("지배자의 탄환".equals(name)) {
                calcRulersBullet(effectsMap, point, grade);
            } else if ("불릿 샤워".equals(name)) {
                calcBulletShower(effectsMap, point, grade);
            } else if ("실버 불릿".equals(name)) {
                calcSilverBullet(effectsMap, point, grade);
            } else if ("끝없는 나선".equals(name)) {
                calcEndlessSpiral(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //탄환 폭발
    private void calcBulletExplosion(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 9.00); break;
                case 14: mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 9.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 9.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 10.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 11.00); break;
                case 18: mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 9.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 10.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 11.70); break; // 11.0 + 0.7
                case 19: mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 9.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 10.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 12.40); break;
                case 20: mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 9.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 10.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 13.10); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 9.00); break;
                case 14: mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 9.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 9.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 10.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 16.00); break;
                case 18: mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 9.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 10.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 16.70); break; // 11.0 + 0.7
                case 19: mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 9.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 10.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 17.40); break;
                case 20: mergeEffect(effectsMap, "최후의 만찬 스킬 피증", 9.00); mergeEffect(effectsMap, "샷건 연사 스킬 피증", 10.00); mergeEffect(effectsMap, "심판의 날 스킬 피증", 18.10); break;
            }
        }
    }

    //아이언 사이트
    private void calcIronSight(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 7.00); mergeEffect(effectsMap, "종말의 전조 스킬 풀레인지 트라이포드 피증", 11.00); break;
                case 14: mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 7.00); mergeEffect(effectsMap, "종말의 전조 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 완벽한 조준 트라이포드 피증", 70.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 풀레인지 트라이포드 피증", 11.00); break;
                case 17: mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 7.00); mergeEffect(effectsMap, "종말의 전조 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 완벽한 조준 트라이포드 피증", 70.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 준비된 사수 트라이포드 피증", 160.00); mergeEffect(effectsMap, "샷건 연사 스킬 풀레인지 트라이포드 피증", 11.00); break; // 쿨증 제외
                case 18: mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 7.50); mergeEffect(effectsMap, "종말의 전조 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 완벽한 조준 트라이포드 피증", 70.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 준비된 사수 트라이포드 피증", 160.00); mergeEffect(effectsMap, "샷건 연사 스킬 풀레인지 트라이포드 피증", 11.00); break; // 7.0 + 0.5
                case 19: mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 8.00); mergeEffect(effectsMap, "종말의 전조 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 완벽한 조준 트라이포드 피증", 70.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 준비된 사수 트라이포드 피증", 160.00); mergeEffect(effectsMap, "샷건 연사 스킬 풀레인지 트라이포드 피증", 11.00); break;
                case 20: mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 8.50); mergeEffect(effectsMap, "종말의 전조 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 완벽한 조준 트라이포드 피증", 70.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 준비된 사수 트라이포드 피증", 160.00); mergeEffect(effectsMap, "샷건 연사 스킬 풀레인지 트라이포드 피증", 11.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 7.00); mergeEffect(effectsMap, "종말의 전조 스킬 풀레인지 트라이포드 피증", 11.00); break;
                case 14: mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 7.00); mergeEffect(effectsMap, "종말의 전조 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 완벽한 조준 트라이포드 피증", 70.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 풀레인지 트라이포드 피증", 11.00); break;
                case 17: mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 7.00); mergeEffect(effectsMap, "종말의 전조 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 완벽한 조준 트라이포드 피증", 70.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 준비된 사수 트라이포드 피증", 170.00); mergeEffect(effectsMap, "샷건 연사 스킬 풀레인지 트라이포드 피증", 11.00); break; // 쿨증 제외
                case 18: mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 7.50); mergeEffect(effectsMap, "종말의 전조 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 완벽한 조준 트라이포드 피증", 70.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 준비된 사수 트라이포드 피증", 170.00); mergeEffect(effectsMap, "샷건 연사 스킬 풀레인지 트라이포드 피증", 11.00); break; // 7.0 + 0.5
                case 19: mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 8.00); mergeEffect(effectsMap, "종말의 전조 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 완벽한 조준 트라이포드 피증", 70.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 준비된 사수 트라이포드 피증", 170.00); mergeEffect(effectsMap, "샷건 연사 스킬 풀레인지 트라이포드 피증", 11.00); break;
                case 20: mergeEffect(effectsMap, "퍼펙트 샷 스킬 피증", 8.50); mergeEffect(effectsMap, "종말의 전조 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 완벽한 조준 트라이포드 피증", 70.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 풀레인지 트라이포드 피증", 11.00); mergeEffect(effectsMap, "퍼펙트 샷 스킬 준비된 사수 트라이포드 피증", 170.00); mergeEffect(effectsMap, "샷건 연사 스킬 풀레인지 트라이포드 피증", 11.00); break;
            }
        }
    }

    //지배자의 탄환
    private void calcRulersBullet(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 3.50); break;
                case 14: mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 3.50); mergeEffect(effectsMap, "샷건의 지배자 스킬 슈퍼 샷건 트라이포드 피증", 17.00); break;
                case 17: mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 3.50); mergeEffect(effectsMap, "샷건의 지배자 스킬 슈퍼 샷건 트라이포드 피증", 17.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 지배자의 의지 트라이포드 피증", 24.00); break;
                case 18: mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 4.10); mergeEffect(effectsMap, "샷건의 지배자 스킬 슈퍼 샷건 트라이포드 피증", 17.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 지배자의 의지 트라이포드 피증", 24.00); break; // 3.5 + 0.6
                case 19: mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 4.70); mergeEffect(effectsMap, "샷건의 지배자 스킬 슈퍼 샷건 트라이포드 피증", 17.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 지배자의 의지 트라이포드 피증", 24.00); break;
                case 20: mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 5.30); mergeEffect(effectsMap, "샷건의 지배자 스킬 슈퍼 샷건 트라이포드 피증", 17.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 지배자의 의지 트라이포드 피증", 24.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 3.50); break;
                case 14: mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 3.50); mergeEffect(effectsMap, "샷건의 지배자 스킬 슈퍼 샷건 트라이포드 피증", 17.00); break;
                case 17: mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 3.50); mergeEffect(effectsMap, "샷건의 지배자 스킬 슈퍼 샷건 트라이포드 피증", 17.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 지배자의 의지 트라이포드 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 4.10); mergeEffect(effectsMap, "샷건의 지배자 스킬 슈퍼 샷건 트라이포드 피증", 17.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 지배자의 의지 트라이포드 피증", 30.00); break; // 3.5 + 0.6
                case 19: mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 4.70); mergeEffect(effectsMap, "샷건의 지배자 스킬 슈퍼 샷건 트라이포드 피증", 17.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 지배자의 의지 트라이포드 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 5.30); mergeEffect(effectsMap, "샷건의 지배자 스킬 슈퍼 샷건 트라이포드 피증", 17.00); mergeEffect(effectsMap, "샷건의 지배자 스킬 지배자의 의지 트라이포드 피증", 30.00); break;
            }
        }
    }

    //불릿 샤워
    private void calcBulletShower(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "잔혹한 추적자 스킬 피증", 12.00); break;
                case 14: mergeEffect(effectsMap, "잔혹한 추적자 스킬 피증", 12.00); mergeEffect(effectsMap, "퀵 샷 스킬 피증", 18.00); break;
                case 17: mergeEffect(effectsMap, "잔혹한 추적자 스킬 피증", 12.00); mergeEffect(effectsMap, "퀵 샷 스킬 피증", 18.00); mergeEffect(effectsMap, "데스페라도 스킬 피증", 12.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "잔혹한 추적자 스킬 피증", 12.00); mergeEffect(effectsMap, "퀵 샷 스킬 피증", 18.00); mergeEffect(effectsMap, "데스페라도 스킬 피증", 13.00); break; // 12.0 + 1.0
                case 19: mergeEffect(effectsMap, "잔혹한 추적자 스킬 피증", 12.00); mergeEffect(effectsMap, "퀵 샷 스킬 피증", 18.00); mergeEffect(effectsMap, "데스페라도 스킬 피증", 14.00); break;
                case 20: mergeEffect(effectsMap, "잔혹한 추적자 스킬 피증", 12.00); mergeEffect(effectsMap, "퀵 샷 스킬 피증", 18.00); mergeEffect(effectsMap, "데스페라도 스킬 피증", 15.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "잔혹한 추적자 스킬 피증", 12.00); break;
                case 14: mergeEffect(effectsMap, "잔혹한 추적자 스킬 피증", 12.00); mergeEffect(effectsMap, "퀵 샷 스킬 피증", 18.00); break;
                case 17: mergeEffect(effectsMap, "잔혹한 추적자 스킬 피증", 12.00); mergeEffect(effectsMap, "퀵 샷 스킬 피증", 18.00); mergeEffect(effectsMap, "데스페라도 스킬 피증", 18.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "잔혹한 추적자 스킬 피증", 12.00); mergeEffect(effectsMap, "퀵 샷 스킬 피증", 18.00); mergeEffect(effectsMap, "데스페라도 스킬 피증", 19.00); break; // 12.0 + 1.0
                case 19: mergeEffect(effectsMap, "잔혹한 추적자 스킬 피증", 12.00); mergeEffect(effectsMap, "퀵 샷 스킬 피증", 18.00); mergeEffect(effectsMap, "데스페라도 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "잔혹한 추적자 스킬 피증", 12.00); mergeEffect(effectsMap, "퀵 샷 스킬 피증", 18.00); mergeEffect(effectsMap, "데스페라도 스킬 피증", 21.00); break;
            }
        }
    }

    //실버 불릿
    private void calcSilverBullet(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "비밀 병기 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "비밀 병기 스킬 피증", 8.00); break; // 3.0 + 5.0
                case 17: mergeEffect(effectsMap, "비밀 병기 스킬 피증", 8.00); mergeEffect(effectsMap, "비밀 병기 치명타 시 피해량 증가", 7.00); break;
                case 18: mergeEffect(effectsMap, "비밀 병기 스킬 피증", 8.50); mergeEffect(effectsMap, "비밀 병기 치명타 시 피해량 증가", 7.00); break; // 8.0 + 0.5
                case 19: mergeEffect(effectsMap, "비밀 병기 스킬 피증", 9.00); mergeEffect(effectsMap, "비밀 병기 치명타 시 피해량 증가", 7.00); break;
                case 20: mergeEffect(effectsMap, "비밀 병기 스킬 피증", 9.50); mergeEffect(effectsMap, "비밀 병기 치명타 시 피해량 증가", 7.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "비밀 병기 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "비밀 병기 스킬 피증", 8.00); break; // 3.0 + 5.0
                case 17: mergeEffect(effectsMap, "비밀 병기 스킬 피증", 8.00); mergeEffect(effectsMap, "비밀 병기 치명타 시 피해량 증가", 10.00); break;
                case 18: mergeEffect(effectsMap, "비밀 병기 스킬 피증", 8.50); mergeEffect(effectsMap, "비밀 병기 치명타 시 피해량 증가", 10.00); break; // 8.0 + 0.5
                case 19: mergeEffect(effectsMap, "비밀 병기 스킬 피증", 9.00); mergeEffect(effectsMap, "비밀 병기 치명타 시 피해량 증가", 10.00); break;
                case 20: mergeEffect(effectsMap, "비밀 병기 스킬 피증", 9.50); mergeEffect(effectsMap, "비밀 병기 치명타 시 피해량 증가", 10.00); break;
            }
        }
    }

    //끝없는 나선
    private void calcEndlessSpiral(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 28.00); break; // 마나 소모량 제외
                case 14: mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 28.00); mergeEffect(effectsMap, "나선의 추적자 스킬 소용돌이 트라이포드 피증", -65.00); break; // 쿨감 제외
                case 17: mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 28.00); mergeEffect(effectsMap, "나선의 추적자 스킬 소용돌이 트라이포드 피증", -10.00); break; // -65.0 + 55.0
                case 18: mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 28.80); mergeEffect(effectsMap, "나선의 추적자 스킬 소용돌이 트라이포드 피증", -10.00); break; // 28.0 + 0.8
                case 19: mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 29.60); mergeEffect(effectsMap, "나선의 추적자 스킬 소용돌이 트라이포드 피증", -10.00); break;
                case 20: mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 30.40); mergeEffect(effectsMap, "나선의 추적자 스킬 소용돌이 트라이포드 피증", -10.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 28.00); break; // 마나 소모량 제외
                case 14: mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 28.00); mergeEffect(effectsMap, "나선의 추적자 스킬 소용돌이 트라이포드 피증", -65.00); break; // 쿨감 제외
                case 17: mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 28.00); break; // -65.0 + 55.0
                case 18: mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 28.80); break; // 28.0 + 0.8
                case 19: mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 29.60); break;
                case 20: mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 30.40); break;
            }
        }
    }
}
