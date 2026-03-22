package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.warLord;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WarLordStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "워로드";
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


            if ("방어 포격".equals(name)) {
                calcDefensiveBombardment(effectsMap, point, grade);
            } else if ("확정된 포격".equals(name)) {
                calcConfirmedArtillery(effectsMap, point, grade);
            } else if ("크로스 랜스".equals(name)) {
                calcCrossLance(effectsMap, point, grade);
            } else if ("방패 타격".equals(name)) {
                calcShieldBash(effectsMap, point, grade);
            } else if ("전차 돌진".equals(name)) {
                calcChariotCharge(effectsMap, point, grade);
            } else if ("광역 낙뢰".equals(name)) {
                calcAreaThunderbolt(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //방어 포
    private void calcDefensiveBombardment(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "카운터 스피어 스킬 피증", 30.00); break;
                case 17: mergeEffect(effectsMap, "카운터 스피어 스킬 피증", 30.00); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 14.00); break;
                case 18: mergeEffect(effectsMap, "카운터 스피어 스킬 피증", 30.35); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 14.35); break;
                case 19: mergeEffect(effectsMap, "카운터 스피어 스킬 피증", 30.70); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 14.70); break;
                case 20: mergeEffect(effectsMap, "카운터 스피어 스킬 피증", 31.05); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 15.05); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "카운터 스피어 스킬 피증", 30.00); break;
                case 17: mergeEffect(effectsMap, "카운터 스피어 스킬 피증", 30.00); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 16.00); break;
                case 18: mergeEffect(effectsMap, "카운터 스피어 스킬 피증", 30.35); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 16.35); break;
                case 19: mergeEffect(effectsMap, "카운터 스피어 스킬 피증", 30.70); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 16.70); break;
                case 20: mergeEffect(effectsMap, "카운터 스피어 스킬 피증", 31.05); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 17.05); break;
            }
        }
    }

    //확정된 포격
    private void calcConfirmedArtillery(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 35.00); break;
                case 17: mergeEffect(effectsMap, "버스트 캐넌 스킬 확정된 공격 트라이포드 피증", 35.00); mergeEffect(effectsMap, "스피어 샷 스킬 폭멸창 트라이포드 피증", 39.00); break;
                case 18: mergeEffect(effectsMap, "버스트 캐넌 스킬 확정된 공격 트라이포드 피증", 35.00); mergeEffect(effectsMap, "스피어 샷 스킬 폭멸창 트라이포드 피증", 39.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 0.38); break;
                case 19: mergeEffect(effectsMap, "버스트 캐넌 스킬 확정된 공격 트라이포드 피증", 35.00); mergeEffect(effectsMap, "스피어 샷 스킬 폭멸창 트라이포드 피증", 39.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 0.76); break;
                case 20: mergeEffect(effectsMap, "버스트 캐넌 스킬 확정된 공격 트라이포드 피증", 35.00); mergeEffect(effectsMap, "스피어 샷 스킬 폭멸창 트라이포드 피증", 39.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 1.14); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 35.00); break;
                case 17: mergeEffect(effectsMap, "버스트 캐넌 스킬 확정된 공격 트라이포드 피증", 35.00); mergeEffect(effectsMap, "스피어 샷 스킬 폭멸창 트라이포드 피증", 41.00); break;
                case 18: mergeEffect(effectsMap, "버스트 캐넌 스킬 확정된 공격 트라이포드 피증", 35.00); mergeEffect(effectsMap, "스피어 샷 스킬 폭멸창 트라이포드 피증", 41.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 0.38); break;
                case 19: mergeEffect(effectsMap, "버스트 캐넌 스킬 확정된 공격 트라이포드 피증", 35.00); mergeEffect(effectsMap, "스피어 샷 스킬 폭멸창 트라이포드 피증", 41.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 0.76); break;
                case 20: mergeEffect(effectsMap, "버스트 캐넌 스킬 확정된 공격 트라이포드 피증", 35.00); mergeEffect(effectsMap, "스피어 샷 스킬 폭멸창 트라이포드 피증", 41.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 1.14); break;
            }
        }
    }

    //크로스 랜스
    private void calcCrossLance(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "라이징 스피어 스킬 대지파편 트라이포드 피증", 150.00); break;
                case 17: mergeEffect(effectsMap, "라이징 스피어 스킬 대지파편 트라이포드 피증", 150.00); mergeEffect(effectsMap, "차지 스팅거 스킬 라스트 차지 트라이포드 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "라이징 스피어 스킬 대지파편 트라이포드 피증", 150.00); mergeEffect(effectsMap, "차지 스팅거 스킬 라스트 차지 트라이포드 피증", 12.00); mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 0.45); break;
                case 19: mergeEffect(effectsMap, "라이징 스피어 스킬 대지파편 트라이포드 피증", 150.00); mergeEffect(effectsMap, "차지 스팅거 스킬 라스트 차지 트라이포드 피증", 12.00); mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 0.90); break;
                case 20: mergeEffect(effectsMap, "라이징 스피어 스킬 대지파편 트라이포드 피증", 150.00); mergeEffect(effectsMap, "차지 스팅거 스킬 라스트 차지 트라이포드 피증", 12.00); mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 1.35); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "라이징 스피어 스킬 대지파편 트라이포드 피증", 150.00); break;
                case 17: mergeEffect(effectsMap, "라이징 스피어 스킬 대지파편 트라이포드 피증", 150.00); mergeEffect(effectsMap, "차지 스팅거 스킬 라스트 차지 트라이포드 피증", 14.00); break;
                case 18: mergeEffect(effectsMap, "라이징 스피어 스킬 대지파편 트라이포드 피증", 150.00); mergeEffect(effectsMap, "차지 스팅거 스킬 라스트 차지 트라이포드 피증", 14.00); mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 0.45); break;
                case 19: mergeEffect(effectsMap, "라이징 스피어 스킬 대지파편 트라이포드 피증", 150.00); mergeEffect(effectsMap, "차지 스팅거 스킬 라스트 차지 트라이포드 피증", 14.00); mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 0.90); break;
                case 20: mergeEffect(effectsMap, "라이징 스피어 스킬 대지파편 트라이포드 피증", 150.00); mergeEffect(effectsMap, "차지 스팅거 스킬 라스트 차지 트라이포드 피증", 14.00); mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 1.35); break;
            }
        }
    }

    //방패 타격
    private void calcShieldBash(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 5.00); mergeEffect(effectsMap, "방패 격동 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 5.00); mergeEffect(effectsMap, "방패 격동 스킬 피증", 10.00); mergeEffect(effectsMap, "방패 밀치기 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "방패 밀치기 스킬 피증", 15.25); mergeEffect(effectsMap, "방패 돌진 스킬 피증", 5.25); mergeEffect(effectsMap, "방패 격동 스킬 피증", 10.25); break;
                case 19: mergeEffect(effectsMap, "방패 밀치기 스킬 피증", 15.50); mergeEffect(effectsMap, "방패 돌진 스킬 피증", 5.50); mergeEffect(effectsMap, "방패 격동 스킬 피증", 10.50); break;
                case 20: mergeEffect(effectsMap, "방패 밀치기 스킬 피증", 15.75); mergeEffect(effectsMap, "방패 돌진 스킬 피증", 5.75); mergeEffect(effectsMap, "방패 격동 스킬 피증", 10.75); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 5.00); mergeEffect(effectsMap, "방패 격동 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 5.00); mergeEffect(effectsMap, "방패 격동 스킬 피증", 10.00); mergeEffect(effectsMap, "방패 밀치기 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "방패 밀치기 스킬 피증", 20.25); mergeEffect(effectsMap, "방패 돌진 스킬 피증", 5.25); mergeEffect(effectsMap, "방패 격동 스킬 피증", 10.25); break;
                case 19: mergeEffect(effectsMap, "방패 밀치기 스킬 피증", 20.50); mergeEffect(effectsMap, "방패 돌진 스킬 피증", 5.50); mergeEffect(effectsMap, "방패 격동 스킬 피증", 10.50); break;
                case 20: mergeEffect(effectsMap, "방패 밀치기 스킬 피증", 20.75); mergeEffect(effectsMap, "방패 돌진 스킬 피증", 5.75); mergeEffect(effectsMap, "방패 격동 스킬 피증", 10.75); break;
            }
        }
    }

    //전차 돌진
    private void calcChariotCharge(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 40.00); break;
                case 17: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 40.00); mergeEffect(effectsMap, "방패 돌진 스킬 파괴 전차 트라이포드 피증", 6.00); break;
                case 18: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 40.55); mergeEffect(effectsMap, "방패 돌진 스킬 파괴 전차 트라이포드 피증", 6.00); break;
                case 19: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 41.10); mergeEffect(effectsMap, "방패 돌진 스킬 파괴 전차 트라이포드 피증", 6.00); break;
                case 20: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 41.65); mergeEffect(effectsMap, "방패 돌진 스킬 파괴 전차 트라이포드 피증", 6.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 40.00); break;
                case 17: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 40.00); mergeEffect(effectsMap, "방패 돌진 스킬 파괴 전차 트라이포드 피증", 9.00); break;
                case 18: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 40.55); mergeEffect(effectsMap, "방패 돌진 스킬 파괴 전차 트라이포드 피증", 9.00); break;
                case 19: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 41.10); mergeEffect(effectsMap, "방패 돌진 스킬 파괴 전차 트라이포드 피증", 9.00); break;
                case 20: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 41.65); mergeEffect(effectsMap, "방패 돌진 스킬 파괴 전차 트라이포드 피증", 9.00); break;
            }
        }
    }

    //광역 낙뢰
    private void calcAreaThunderbolt(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "가디언의 낙뢰 스킬 치피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "가디언의 낙뢰 스킬 치피증", 10.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 넓은 타격 트라이포드 피증", 75.00); break;
                case 17: mergeEffect(effectsMap, "가디언의 낙뢰 스킬 치피증", 10.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 넓은 타격 트라이포드 피증", 75.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 9.00); break;
                case 18: mergeEffect(effectsMap, "가디언의 낙뢰 스킬 치피증", 10.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 넓은 타격 트라이포드 피증", 75.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 9.40); break;
                case 19: mergeEffect(effectsMap, "가디언의 낙뢰 스킬 치피증", 10.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 넓은 타격 트라이포드 피증", 75.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 9.80); break;
                case 20: mergeEffect(effectsMap, "가디언의 낙뢰 스킬 치피증", 10.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 넓은 타격 트라이포드 피증", 75.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 10.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "가디언의 낙뢰 스킬 치피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "가디언의 낙뢰 스킬 치피증", 10.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 넓은 타격 트라이포드 피증", 75.00); break;
                case 17: mergeEffect(effectsMap, "가디언의 낙뢰 스킬 치피증", 10.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 넓은 타격 트라이포드 피증", 75.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 14.00); break;
                case 18: mergeEffect(effectsMap, "가디언의 낙뢰 스킬 치피증", 10.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 넓은 타격 트라이포드 피증", 75.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 14.40); break;
                case 19: mergeEffect(effectsMap, "가디언의 낙뢰 스킬 치피증", 10.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 넓은 타격 트라이포드 피증", 75.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 14.80); break;
                case 20: mergeEffect(effectsMap, "가디언의 낙뢰 스킬 치피증", 10.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 넓은 타격 트라이포드 피증", 75.00); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 15.20); break;
            }
        }
    }
}
