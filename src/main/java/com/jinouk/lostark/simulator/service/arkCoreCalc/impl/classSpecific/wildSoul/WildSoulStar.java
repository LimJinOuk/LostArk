package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.wildSoul;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WildSoulStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "환수사";
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


            if ("돌격 곰 여우".equals(name)) {
                calcBearFoxCharge(effectsMap, point, grade);
            } else if ("필살 곰".equals(name)) {
                calcFatalBearStrike(effectsMap, point, grade);
            } else if ("별빛 여우".equals(name)) {
                calcStarlightFox(effectsMap, point, grade);
            } else if ("환영 곰".equals(name)) {
                calcPhantomBear(effectsMap, point, grade);
            } else if ("붕붕 펀치".equals(name)) {
                calcSwingingPunch(effectsMap, point, grade);
            } else if ("까마귀 대난투".equals(name)) {
                calcCrowBrawl(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //돌격 곰 여우
    private void calcBearFoxCharge(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "슈웅 곰 스킬 피증", 15.00); break;
                case 14: mergeEffect(effectsMap, "슈웅 곰 스킬 피증", 15.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "슈웅 곰 스킬 피증", 15.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 피증", 20.00); mergeEffect(effectsMap, "슈웅 곰 스킬 치명타 시 피해량 증가", 6.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 치명타 시 피해량 증가", 6.00); break;
                case 18: mergeEffect(effectsMap, "슈웅 곰 스킬 피증", 15.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 피증", 20.00); mergeEffect(effectsMap, "슈웅 곰 스킬 치명타 시 피해량 증가", 6.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 치명타 시 피해량 증가", 6.00); mergeEffect(effectsMap, "둔갑 스킬 피증", 0.13); break;
                case 19: mergeEffect(effectsMap, "슈웅 곰 스킬 피증", 15.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 피증", 20.00); mergeEffect(effectsMap, "슈웅 곰 스킬 치명타 시 피해량 증가", 6.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 치명타 시 피해량 증가", 6.00); mergeEffect(effectsMap, "둔갑 스킬 피증", 0.26); break;
                case 20: mergeEffect(effectsMap, "슈웅 곰 스킬 피증", 15.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 피증", 20.00); mergeEffect(effectsMap, "슈웅 곰 스킬 치명타 시 피해량 증가", 6.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 치명타 시 피해량 증가", 6.00); mergeEffect(effectsMap, "둔갑 스킬 피증", 0.39); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "슈웅 곰 스킬 피증", 15.00); break;
                case 14: mergeEffect(effectsMap, "슈웅 곰 스킬 피증", 15.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "슈웅 곰 스킬 피증", 15.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 피증", 20.00); mergeEffect(effectsMap, "슈웅 곰 스킬 치명타 시 피해량 증가", 8.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 치명타 시 피해량 증가", 8.00); break;
                case 18: mergeEffect(effectsMap, "슈웅 곰 스킬 피증", 15.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 피증", 20.00); mergeEffect(effectsMap, "슈웅 곰 스킬 치명타 시 피해량 증가", 8.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 치명타 시 피해량 증가", 8.00); mergeEffect(effectsMap, "둔갑 스킬 피증", 0.13); break;
                case 19: mergeEffect(effectsMap, "슈웅 곰 스킬 피증", 15.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 피증", 20.00); mergeEffect(effectsMap, "슈웅 곰 스킬 치명타 시 피해량 증가", 8.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 치명타 시 피해량 증가", 8.00); mergeEffect(effectsMap, "둔갑 스킬 피증", 0.26); break;
                case 20: mergeEffect(effectsMap, "슈웅 곰 스킬 피증", 15.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 피증", 20.00); mergeEffect(effectsMap, "슈웅 곰 스킬 치명타 시 피해량 증가", 8.00); mergeEffect(effectsMap, "여우 꼬리물기 스킬 치명타 시 피해량 증가", 8.00); mergeEffect(effectsMap, "둔갑 스킬 피증", 0.39); break;
            }
        }
    }

    //필살 곰
    private void calcFatalBearStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "바위 곰 스킬 피증", 9.00); break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "바위 곰 스킬 피증", 21.00); mergeEffect(effectsMap, "뒤집 곰 스킬 대지 충격 트라이포드 피증", 10.00); break; // 9.0 + 12.0
                case 17: mergeEffect(effectsMap, "바위 곰 스킬 피증", 21.00); mergeEffect(effectsMap, "뒤집 곰 스킬 대지 충격 트라이포드 피증", 10.00); mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "바위 곰 스킬 피증", 21.00); mergeEffect(effectsMap, "뒤집 곰 스킬 대지 충격 트라이포드 피증", 10.00); mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 10.30); break;
                case 19: mergeEffect(effectsMap, "바위 곰 스킬 피증", 21.00); mergeEffect(effectsMap, "뒤집 곰 스킬 대지 충격 트라이포드 피증", 10.00); mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 10.60); break;
                case 20: mergeEffect(effectsMap, "바위 곰 스킬 피증", 21.00); mergeEffect(effectsMap, "뒤집 곰 스킬 대지 충격 트라이포드 피증", 10.00); mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 10.90); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "바위 곰 스킬 피증", 9.00); break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "바위 곰 스킬 피증", 21.00); mergeEffect(effectsMap, "뒤집 곰 스킬 대지 충격 트라이포드 피증", 10.00); break; // 9.0 + 12.0
                case 17: mergeEffect(effectsMap, "바위 곰 스킬 피증", 21.00); mergeEffect(effectsMap, "뒤집 곰 스킬 대지 충격 트라이포드 피증", 10.00); mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 11.50); break;
                case 18: mergeEffect(effectsMap, "바위 곰 스킬 피증", 21.00); mergeEffect(effectsMap, "뒤집 곰 스킬 대지 충격 트라이포드 피증", 10.00); mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 11.80); break;
                case 19: mergeEffect(effectsMap, "바위 곰 스킬 피증", 21.00); mergeEffect(effectsMap, "뒤집 곰 스킬 대지 충격 트라이포드 피증", 10.00); mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 12.10); break;
                case 20: mergeEffect(effectsMap, "바위 곰 스킬 피증", 21.00); mergeEffect(effectsMap, "뒤집 곰 스킬 대지 충격 트라이포드 피증", 10.00); mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 12.40); break;
            }
        }
    }

    //별빛 여우
    private void calcStarlightFox(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "여우 불꽃 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "여우 불꽃 스킬 피증", 18.00); break; // 8.0 + 10.0
                case 17: mergeEffect(effectsMap, "여우 불꽃 스킬 피증", 18.00); mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 7.00); break;
                case 18: mergeEffect(effectsMap, "여우 불꽃 스킬 피증", 18.00); mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 7.35); break;
                case 19: mergeEffect(effectsMap, "여우 불꽃 스킬 피증", 18.00); mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 7.70); break;
                case 20: mergeEffect(effectsMap, "여우 불꽃 스킬 피증", 18.00); mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 8.05); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "여우 불꽃 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "여우 불꽃 스킬 피증", 18.00); break; // 8.0 + 10.0
                case 17: mergeEffect(effectsMap, "여우 불꽃 스킬 피증", 18.00); mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 9.00); break;
                case 18: mergeEffect(effectsMap, "여우 불꽃 스킬 피증", 18.00); mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 9.35); break;
                case 19: mergeEffect(effectsMap, "여우 불꽃 스킬 피증", 18.00); mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 9.70); break;
                case 20: mergeEffect(effectsMap, "여우 불꽃 스킬 피증", 18.00); mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 10.05); break;
            }
        }
    }

    //환영 곰
    //환수 각성 상태
    private void calcPhantomBear(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "바위 곰 스킬 피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "바위 곰 스킬 피증", 6.00); mergeEffect(effectsMap, "바위 곰 스킬 환수 변환 트라이포드 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "바위 곰 스킬 피증", 6.70); mergeEffect(effectsMap, "바위 곰 스킬 환수 변환 트라이포드 피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "바위 곰 스킬 피증", 7.40); mergeEffect(effectsMap, "바위 곰 스킬 환수 변환 트라이포드 피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "바위 곰 스킬 피증", 8.10); mergeEffect(effectsMap, "바위 곰 스킬 환수 변환 트라이포드 피증", 12.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "바위 곰 스킬 피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "바위 곰 스킬 피증", 6.00); mergeEffect(effectsMap, "바위 곰 스킬 환수 변환 트라이포드 피증", 16.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "바위 곰 스킬 피증", 6.70); mergeEffect(effectsMap, "바위 곰 스킬 환수 변환 트라이포드 피증", 16.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "바위 곰 스킬 피증", 7.40); mergeEffect(effectsMap, "바위 곰 스킬 환수 변환 트라이포드 피증", 16.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "바위 곰 스킬 피증", 8.10); mergeEffect(effectsMap, "바위 곰 스킬 환수 변환 트라이포드 피증", 16.00); break;
            }
        }
    }

    //붕붕 펀치
    private void calcSwingingPunch(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 5.00); mergeEffect(effectsMap, "빙글빙글 꽝 스킬 야수의 보호 트라이포드 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 5.35); mergeEffect(effectsMap, "빙글빙글 꽝 스킬 야수의 보호 트라이포드 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 5.70); mergeEffect(effectsMap, "빙글빙글 꽝 스킬 야수의 보호 트라이포드 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 6.05); mergeEffect(effectsMap, "빙글빙글 꽝 스킬 야수의 보호 트라이포드 피증", 15.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 5.00); mergeEffect(effectsMap, "빙글빙글 꽝 스킬 야수의 보호 트라이포드 피증", 17.00); break;
                case 18: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 5.35); mergeEffect(effectsMap, "빙글빙글 꽝 스킬 야수의 보호 트라이포드 피증", 17.00); break;
                case 19: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 5.70); mergeEffect(effectsMap, "빙글빙글 꽝 스킬 야수의 보호 트라이포드 피증", 17.00); break;
                case 20: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 6.05); mergeEffect(effectsMap, "빙글빙글 꽝 스킬 야수의 보호 트라이포드 피증", 17.00); break;
            }
        }
    }

    //까마귀 대난투
    private void calcCrowBrawl(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 50.00); break;
                case 14: mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 110.00); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 60.00); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 60.00); break; // 50.0 + 60.0 (재사용 대기시간 제외)
                case 17: mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 110.00); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 60.00); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 60.00); mergeEffect(effectsMap, "까마귀 대소동 스킬 어둠의 왕 트라이포드 피증", 69.00); break;
                case 18: mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 110.00); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 60.00); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 61.80); mergeEffect(effectsMap, "까마귀 대소동 스킬 어둠의 왕 트라이포드 피증", 69.00); break;
                case 19: mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 110.00); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 60.00); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 63.60); mergeEffect(effectsMap, "까마귀 대소동 스킬 어둠의 왕 트라이포드 피증", 69.00); break;
                case 20: mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 110.00); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 60.00); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 65.40); mergeEffect(effectsMap, "까마귀 대소동 스킬 어둠의 왕 트라이포드 피증", 69.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "아피강", 1.50); break;
                case 14: mergeEffect(effectsMap, "아피강", 1.50); break;
                case 17: mergeEffect(effectsMap, "아피강", 1.50); mergeEffect(effectsMap, "저무는 달 스킬 아피강", 10.00); break;
                case 18: mergeEffect(effectsMap, "아피강", 1.67); mergeEffect(effectsMap, "저무는 달 스킬 아피강", 10.00); break;
                case 19: mergeEffect(effectsMap, "아피강", 1.84); mergeEffect(effectsMap, "저무는 달 스킬 아피강", 10.00); break;
                case 20: mergeEffect(effectsMap, "아피강", 2.01); mergeEffect(effectsMap, "저무는 달 스킬 아피강", 10.00); break;
            }
        }
    }
}
