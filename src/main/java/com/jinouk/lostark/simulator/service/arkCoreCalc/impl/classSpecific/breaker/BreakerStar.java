package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.breaker;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BreakerStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "브레이커";
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


            if ("권왕십이식".equals(name)) {
                calcKwonwangSibiSik(effectsMap, point, grade);
            } else if ("파천 돌파".equals(name)) {
                calcPacheonBreakthrough(effectsMap, point, grade);
            } else if ("포스 건틀릿".equals(name)) {
                calcForceGauntlet(effectsMap, point, grade);
            } else if ("전천극".equals(name)) {
                calcJeoncheongeuk(effectsMap, point, grade);
            } else if ("수라".equals(name)) {
                calcSura(effectsMap, point, grade);
            } else if ("징벌".equals(name)) {
                calcPunishment(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //권왕십이식
    private void calcKwonwangSibiSik(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 8.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 8.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 8.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 8.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.40); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 8.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 8.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.60); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 8.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 8.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 11.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 11.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 11.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 11.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.40); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 11.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 11.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.60); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 11.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 11.00); break;
            }
        }
    }

    //파천 돌파
    private void calcPacheonBreakthrough(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파천섬광 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "파천섬광 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "파천섬광 스킬 피증", 2.00); mergeEffect(effectsMap, "파천섬광 스킬 한계 돌파 트라이포드 피증", 8.00); break;
                case 18: mergeEffect(effectsMap, "파천섬광 스킬 피증", 2.40); mergeEffect(effectsMap, "파천섬광 스킬 한계 돌파 트라이포드 피증", 8.00); break;
                case 19: mergeEffect(effectsMap, "파천섬광 스킬 피증", 2.80); mergeEffect(effectsMap, "파천섬광 스킬 한계 돌파 트라이포드 피증", 8.00); break;
                case 20: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.20); mergeEffect(effectsMap, "파천섬광 스킬 한계 돌파 트라이포드 피증", 8.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파천섬광 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "파천섬광 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "파천섬광 스킬 피증", 2.00); mergeEffect(effectsMap, "파천섬광 스킬 한계 돌파 트라이포드 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "파천섬광 스킬 피증", 2.40); mergeEffect(effectsMap, "파천섬광 스킬 한계 돌파 트라이포드 피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "파천섬광 스킬 피증", 2.80); mergeEffect(effectsMap, "파천섬광 스킬 한계 돌파 트라이포드 피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.20); mergeEffect(effectsMap, "파천섬광 스킬 한계 돌파 트라이포드 피증", 12.00); break;
            }
        }
    }

    //포스 건틀릿
    private void calcForceGauntlet(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "청월난무 스킬 피증", 12.00); mergeEffect(effectsMap, "연의붕권 스킬 피증", 12.00); mergeEffect(effectsMap, "천기심권 스킬 피증", 12.00); break;
                case 14: mergeEffect(effectsMap, "청월난무 스킬 피증", 112.00); mergeEffect(effectsMap, "연의붕권 스킬 피증", 12.00); mergeEffect(effectsMap, "천기심권 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "청월난무 스킬 피증", 112.00); mergeEffect(effectsMap, "연의붕권 스킬 피증", 12.00); mergeEffect(effectsMap, "천기심권 스킬 피증", 12.00); mergeEffect(effectsMap, "연의붕권 스킬 결정타 트라이포드 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "청월난무 스킬 피증", 112.00); mergeEffect(effectsMap, "연의붕권 스킬 피증", 14.00); mergeEffect(effectsMap, "천기심권 스킬 피증", 12.00); mergeEffect(effectsMap, "연의붕권 스킬 결정타 트라이포드 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "청월난무 스킬 피증", 112.00); mergeEffect(effectsMap, "연의붕권 스킬 피증", 16.00); mergeEffect(effectsMap, "천기심권 스킬 피증", 12.00); mergeEffect(effectsMap, "연의붕권 스킬 결정타 트라이포드 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "청월난무 스킬 피증", 112.00); mergeEffect(effectsMap, "연의붕권 스킬 피증", 18.00); mergeEffect(effectsMap, "천기심권 스킬 피증", 12.00); mergeEffect(effectsMap, "연의붕권 스킬 결정타 트라이포드 피증", 20.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "청월난무 스킬 피증", 12.00); mergeEffect(effectsMap, "연의붕권 스킬 피증", 12.00); mergeEffect(effectsMap, "천기심권 스킬 피증", 12.00); break;
                case 14: mergeEffect(effectsMap, "청월난무 스킬 피증", 112.00); mergeEffect(effectsMap, "연의붕권 스킬 피증", 12.00); mergeEffect(effectsMap, "천기심권 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "청월난무 스킬 피증", 112.00); mergeEffect(effectsMap, "연의붕권 스킬 피증", 12.00); mergeEffect(effectsMap, "천기심권 스킬 피증", 12.00); mergeEffect(effectsMap, "연의붕권 스킬 결정타 트라이포드 피증", 24.00); break;
                case 18: mergeEffect(effectsMap, "청월난무 스킬 피증", 112.00); mergeEffect(effectsMap, "연의붕권 스킬 피증", 14.00); mergeEffect(effectsMap, "천기심권 스킬 피증", 12.00); mergeEffect(effectsMap, "연의붕권 스킬 결정타 트라이포드 피증", 24.00); break;
                case 19: mergeEffect(effectsMap, "청월난무 스킬 피증", 112.00); mergeEffect(effectsMap, "연의붕권 스킬 피증", 16.00); mergeEffect(effectsMap, "천기심권 스킬 피증", 12.00); mergeEffect(effectsMap, "연의붕권 스킬 결정타 트라이포드 피증", 24.00); break;
                case 20: mergeEffect(effectsMap, "청월난무 스킬 피증", 112.00); mergeEffect(effectsMap, "연의붕권 스킬 피증", 18.00); mergeEffect(effectsMap, "천기심권 스킬 피증", 12.00); mergeEffect(effectsMap, "연의붕권 스킬 결정타 트라이포드 피증", 24.00); break;
            }
        }
    }

    //전천극
    private void calcJeoncheongeuk(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); mergeEffect(effectsMap, "파천섬광 스킬 전천극 트라이포드 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.70); mergeEffect(effectsMap, "파천섬광 스킬 전천극 트라이포드 피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "파천섬광 스킬 피증", 9.40); mergeEffect(effectsMap, "파천섬광 스킬 전천극 트라이포드 피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "파천섬광 스킬 피증", 10.10); mergeEffect(effectsMap, "파천섬광 스킬 전천극 트라이포드 피증", 12.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); mergeEffect(effectsMap, "파천섬광 스킬 전천극 트라이포드 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.70); mergeEffect(effectsMap, "파천섬광 스킬 전천극 트라이포드 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "파천섬광 스킬 피증", 9.40); mergeEffect(effectsMap, "파천섬광 스킬 전천극 트라이포드 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "파천섬광 스킬 피증", 10.10); mergeEffect(effectsMap, "파천섬광 스킬 전천극 트라이포드 피증", 15.00); break;
            }
        }
    }

    //수라
    //진욱쿤 찬스(수라결 기본 공격 피증)
    private void calcSura(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10:  break; // 받는 피해 감소 제외
                case 14: mergeEffect(effectsMap, "피증", 4.00); break;
                case 17: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "수라결 기본 공격 스킬 치명타 시 피해량 증가", 4.00); break;
                case 18: mergeEffect(effectsMap, "피증", 4.30); mergeEffect(effectsMap, "수라결 기본 공격 스킬 치명타 시 피해량 증가", 4.00); break;
                case 19: mergeEffect(effectsMap, "피증", 4.60); mergeEffect(effectsMap, "수라결 기본 공격 스킬 치명타 시 피해량 증가", 4.00); break;
                case 20: mergeEffect(effectsMap, "피증", 4.90); mergeEffect(effectsMap, "수라결 기본 공격 스킬 치명타 시 피해량 증가", 4.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10:  break; // 받는 피해 감소 제외
                case 14: mergeEffect(effectsMap, "피증", 4.00); break;
                case 17: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "수라결 기본 공격 스킬 치명타 시 피해량 증가", 5.50); break;
                case 18: mergeEffect(effectsMap, "피증", 4.30); mergeEffect(effectsMap, "수라결 기본 공격 스킬 치명타 시 피해량 증가", 5.50); break;
                case 19: mergeEffect(effectsMap, "피증", 4.60); mergeEffect(effectsMap, "수라결 기본 공격 스킬 치명타 시 피해량 증가", 5.50); break;
                case 20: mergeEffect(effectsMap, "피증", 4.90); mergeEffect(effectsMap, "수라결 기본 공격 스킬 치명타 시 피해량 증가", 5.50); break;
            }
        }
    }

    //징벌
    private void calcPunishment(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 20.00); mergeEffect(effectsMap, "징벌의 파도 스킬 암영결 트라이포드 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 21.00); mergeEffect(effectsMap, "징벌의 파도 스킬 암영결 트라이포드 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 22.00); mergeEffect(effectsMap, "징벌의 파도 스킬 암영결 트라이포드 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 23.00); mergeEffect(effectsMap, "징벌의 파도 스킬 암영결 트라이포드 피증", 20.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 20.00); mergeEffect(effectsMap, "징벌의 파도 스킬 암영결 트라이포드 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 21.00); mergeEffect(effectsMap, "징벌의 파도 스킬 암영결 트라이포드 피증", 30.00); break;
                case 19: mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 22.00); mergeEffect(effectsMap, "징벌의 파도 스킬 암영결 트라이포드 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 23.00); mergeEffect(effectsMap, "징벌의 파도 스킬 암영결 트라이포드 피증", 30.00); break;
            }
        }
    }
}
