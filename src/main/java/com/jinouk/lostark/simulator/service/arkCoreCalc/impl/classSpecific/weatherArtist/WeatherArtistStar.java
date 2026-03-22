package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.weatherArtist;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherArtistStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "기상술사";
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


            if ("휘몰아치기".equals(name)) {
                calcWhirlwind(effectsMap, point, grade);
            } else if ("일점돌파".equals(name)) {
                calcSinglePointBreakthrough(effectsMap, point, grade);
            } else if ("강풍일섬".equals(name)) {
                calcGaleFlash(effectsMap, point, grade);
            } else if ("눈에 돌넣기".equals(name)) {
                calcStoneInTheEye(effectsMap, point, grade);
            } else if ("우르릉 쾅쾅쾅".equals(name)) {
                calcRumbleAndCrash(effectsMap, point, grade);
            } else if ("나그네의 외투를 벗긴건".equals(name)) {
                calcSunScorcher(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //휘몰아치기
    private void calcWhirlwind(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 및 면역은 X
                case 14: mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 55.00); break;
                case 17: mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 55.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 55.70); mergeEffect(effectsMap, "몰아치기 스킬 피증", 12.70); break;
                case 19: mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 56.40); mergeEffect(effectsMap, "몰아치기 스킬 피증", 13.40); break;
                case 20: mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 57.10); mergeEffect(effectsMap, "몰아치기 스킬 피증", 14.10); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 및 면역은 X
                case 14: mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 55.00); break;
                case 17: mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 55.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 55.70); mergeEffect(effectsMap, "몰아치기 스킬 피증", 18.70); break;
                case 19: mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 56.40); mergeEffect(effectsMap, "몰아치기 스킬 피증", 19.40); break;
                case 20: mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 57.10); mergeEffect(effectsMap, "몰아치기 스킬 피증", 20.10); break;
            }
        }
    }

    //일점돌파
    private void calcSinglePointBreakthrough(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도는 X
                case 14: mergeEffect(effectsMap, "바람송곳 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "바람송곳 스킬 피증", 25.00); break; // 10.0 + 15.0
                case 18: mergeEffect(effectsMap, "바람송곳 스킬 피증", 25.80); break;
                case 19: mergeEffect(effectsMap, "바람송곳 스킬 피증", 26.60); break;
                case 20: mergeEffect(effectsMap, "바람송곳 스킬 피증", 27.40); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도는 X
                case 14: mergeEffect(effectsMap, "바람송곳 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "바람송곳 스킬 피증", 30.00); break; // 10.0 + 15.0
                case 18: mergeEffect(effectsMap, "바람송곳 스킬 피증", 30.80); break;
                case 19: mergeEffect(effectsMap, "바람송곳 스킬 피증", 31.60); break;
                case 20: mergeEffect(effectsMap, "바람송곳 스킬 피증", 32.40); break;
            }
        }
    }

    //강풍일섬
    private void calcGaleFlash(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도는 X
                case 14: mergeEffect(effectsMap, "칼바람 스킬 피증", 30.00); break; // 재사용 대기시간 증가는 무시
                case 17: mergeEffect(effectsMap, "칼바람 스킬 피증", 36.00); break; // 30.0 + 6.0
                case 18: mergeEffect(effectsMap, "칼바람 스킬 피증", 36.50); break;
                case 19: mergeEffect(effectsMap, "칼바람 스킬 피증", 37.00); break;
                case 20: mergeEffect(effectsMap, "칼바람 스킬 피증", 37.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도는 X
                case 14: mergeEffect(effectsMap, "칼바람 스킬 피증", 39.00); break; // 재사용 대기시간 증가는 무시
                case 17: mergeEffect(effectsMap, "칼바람 스킬 피증", 39.00); break; // 30.0 + 6.0
                case 18: mergeEffect(effectsMap, "칼바람 스킬 피증", 39.50); break;
                case 19: mergeEffect(effectsMap, "칼바람 스킬 피증", 40.00); break;
                case 20: mergeEffect(effectsMap, "칼바람 스킬 피증", 40.50); break;
            }
        }
    }

    //눈에 돌넣기
    //여우비 스킬
    private void calcStoneInTheEye(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "센바람 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "센바람 스킬 피증", 20.00); break; // 8.0 + 12.0
                case 17: mergeEffect(effectsMap, "센바람 스킬 피증", 20.00); mergeEffect(effectsMap, "여우비 스킬 피증", 400.00); break;
                case 18: mergeEffect(effectsMap, "센바람 스킬 피증", 20.00); mergeEffect(effectsMap, "여우비 스킬 피증", 404.00); break;
                case 19: mergeEffect(effectsMap, "센바람 스킬 피증", 20.00); mergeEffect(effectsMap, "여우비 스킬 피증", 408.00); break;
                case 20: mergeEffect(effectsMap, "센바람 스킬 피증", 20.00); mergeEffect(effectsMap, "여우비 스킬 피증", 412.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "센바람 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "센바람 스킬 피증", 20.00); break; // 8.0 + 12.0
                case 17: mergeEffect(effectsMap, "센바람 스킬 피증", 20.00); mergeEffect(effectsMap, "여우비 스킬 피증", 500.00); break;
                case 18: mergeEffect(effectsMap, "센바람 스킬 피증", 20.00); mergeEffect(effectsMap, "여우비 스킬 피증", 504.00); break;
                case 19: mergeEffect(effectsMap, "센바람 스킬 피증", 20.00); mergeEffect(effectsMap, "여우비 스킬 피증", 508.00); break;
                case 20: mergeEffect(effectsMap, "센바람 스킬 피증", 20.00); mergeEffect(effectsMap, "여우비 스킬 피증", 512.00); break;
            }
        }
    }

    //우르릉 쾅쾅쾅
    private void calcRumbleAndCrash(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); break;
                case 14: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 8.00); mergeEffect(effectsMap, "소나기 스킬 낙뢰주의보 트라이포드 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 9.00); mergeEffect(effectsMap, "소나기 스킬 낙뢰주의보 트라이포드 피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 10.00); mergeEffect(effectsMap, "소나기 스킬 낙뢰주의보 트라이포드 피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 11.00); mergeEffect(effectsMap, "소나기 스킬 낙뢰주의보 트라이포드 피증", 12.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); break;
                case 14: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 8.00); mergeEffect(effectsMap, "소나기 스킬 낙뢰주의보 트라이포드 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 9.00); mergeEffect(effectsMap, "소나기 스킬 낙뢰주의보 트라이포드 피증", 18.00); break;
                case 19: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 10.00); mergeEffect(effectsMap, "소나기 스킬 낙뢰주의보 트라이포드 피증", 18.00); break;
                case 20: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 11.00); mergeEffect(effectsMap, "소나기 스킬 낙뢰주의보 트라이포드 피증", 18.00); break;
            }
        }
    }

    //나그네의 외투를 벗긴건
    private void calcSunScorcher(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 3.00); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 3.00); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 3.00); mergeEffect(effectsMap, "뙤약볕 스킬 빛의 부름 트라이포드 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 23.00); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 23.00); mergeEffect(effectsMap, "뙤약볕 스킬 빛의 부름 트라이포드 피증", 20.00); break; // 3.0 + 20.0 (재사용 대기시간 증가는 무시)
                case 18: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 23.40); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 23.40); mergeEffect(effectsMap, "뙤약볕 스킬 빛의 부름 트라이포드 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 23.80); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 23.80); mergeEffect(effectsMap, "뙤약볕 스킬 빛의 부름 트라이포드 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 24.20); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 24.20); mergeEffect(effectsMap, "뙤약볕 스킬 빛의 부름 트라이포드 피증", 20.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 3.00); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 3.00); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 3.00); mergeEffect(effectsMap, "뙤약볕 스킬 빛의 부름 트라이포드 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 28.00); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 28.00); mergeEffect(effectsMap, "뙤약볕 스킬 빛의 부름 트라이포드 피증", 20.00); break; // 3.0 + 20.0 (재사용 대기시간 증가는 무시)
                case 18: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 28.40); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 28.40); mergeEffect(effectsMap, "뙤약볕 스킬 빛의 부름 트라이포드 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 28.80); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 28.80); mergeEffect(effectsMap, "뙤약볕 스킬 빛의 부름 트라이포드 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 29.20); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 29.20); mergeEffect(effectsMap, "뙤약볕 스킬 빛의 부름 트라이포드 피증", 20.00); break;
            }
        }
    }
}
