package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.scouter;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScouterMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "스카우터";
    }

    @Override
    public String getArkGridCoreName() {
        return "질서의 달 코어";
    }


    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        validateItems(requestDto);

        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;


            if ("생체 개조 기술".equals(name)) {
                calcBioModificationTech(effectsMap, point, grade);
            } else if ("불릿 템페스트".equals(name)) {
                calcBulletTempest(effectsMap, point, grade);
            } else if ("에너지 아포칼립스".equals(name)) {
                calcEnergyApocalypse(effectsMap, point, grade);
            } else if ("퍼펙트 싱크".equals(name)) {
                calcPerfectSync(effectsMap, point, grade);
            } else if ("제로 펄스 에너지".equals(name)) {
                calcZeroPulseEnergy(effectsMap, point, grade);
            } else if ("어썰트 타이탄".equals(name)) {
                calcAssaultTitan(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //생체 개조 기술
    private void calcBioModificationTech(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 기동 타격 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "적주피", 5.50); break; // 기존 적주피 1.5 + 신규 적주피 4.0
                case 18: mergeEffect(effectsMap, "적주피", 5.67); break;
                case 19: mergeEffect(effectsMap, "적주피", 5.84); break;
                case 20: mergeEffect(effectsMap, "적주피", 6.01); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 기동 타격 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "적주피", 6.50); break; // 기존 적주피 1.5 + 신규 적주피 4.0
                case 18: mergeEffect(effectsMap, "적주피", 6.67); break;
                case 19: mergeEffect(effectsMap, "적주피", 6.84); break;
                case 20: mergeEffect(effectsMap, "적주피", 7.01); break;
            }
        }
    }

    //불릿 템페스트
    private void calcBulletTempest(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "피증", 4.00); break; // 불릿 해일 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "불릿 해일 스킬 피증", 16.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 16.00); break;
                case 18: mergeEffect(effectsMap, "피증", 4.40); mergeEffect(effectsMap, "불릿 해일 스킬 피증", 16.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 16.00); break;
                case 19: mergeEffect(effectsMap, "피증", 4.80); mergeEffect(effectsMap, "불릿 해일 스킬 피증", 16.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 16.00); break;
                case 20: mergeEffect(effectsMap, "피증", 5.20); mergeEffect(effectsMap, "불릿 해일 스킬 피증", 16.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 16.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "피증", 4.00); break; // 불릿 해일 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "불릿 해일 스킬 피증", 19.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 19.00); break;
                case 18: mergeEffect(effectsMap, "피증", 4.40); mergeEffect(effectsMap, "불릿 해일 스킬 피증", 19.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 19.00); break;
                case 19: mergeEffect(effectsMap, "피증", 4.80); mergeEffect(effectsMap, "불릿 해일 스킬 피증", 19.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 19.00); break;
                case 20: mergeEffect(effectsMap, "피증", 5.20); mergeEffect(effectsMap, "불릿 해일 스킬 피증", 19.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 19.00); break;
            }
        }
    }

    //에너지 아포칼립스
    private void calcEnergyApocalypse(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "합작 스킬 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "합작 스킬 피증", 2.50); break; // 과충전 배터리 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "합작 스킬 피증", 2.50); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 16.00); break;
                case 18: mergeEffect(effectsMap, "합작 스킬 피증", 2.75); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 16.00); break;
                case 19: mergeEffect(effectsMap, "합작 스킬 피증", 3.00); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 16.00); break;
                case 20: mergeEffect(effectsMap, "합작 스킬 피증", 3.25); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 16.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "합작 스킬 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "합작 스킬 피증", 2.50); break; // 과충전 배터리 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "합작 스킬 피증", 2.50); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "합작 스킬 피증", 2.75); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "합작 스킬 피증", 3.00); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "합작 스킬 피증", 3.25); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 20.00); break;
            }
        }
    }

    //퍼펙트 싱크
    private void calcPerfectSync(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break; // EX-제로 포인트 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 5.50); break; // 기존 1.5 + 신규 4.0 / 배터리 회복 제외
                case 18: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 5.67); break;
                case 19: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 5.84); break;
                case 20: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 6.01); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break; // EX-제로 포인트 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 6.50); break; // 기존 1.5 + 신규 4.0 / 배터리 회복 제외
                case 18: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 6.67); break;
                case 19: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 6.84); break;
                case 20: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 7.01); break;
            }
        }
    }

    //제로 펄스 에너지
    private void calcZeroPulseEnergy(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break; // 제로 싱크 스킬 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 20.00); break; // 배터리 소모 감소 제외
                case 18: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 20.70); break;
                case 19: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 21.40); break;
                case 20: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 22.10); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break; // 제로 싱크 스킬 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 24.00); break; // 배터리 소모 감소 제외
                case 18: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 24.70); break;
                case 19: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 25.40); break;
                case 20: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 26.10); break;
            }
        }
    }

    //어썰트 타이탄
    private void calcAssaultTitan(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break; // 코멧 스트라이크 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 40.00); break; // 강화 효과(버프 형태) 제외
                case 18: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 40.90); break;
                case 19: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 41.80); break;
                case 20: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 42.70); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break; // 코멧 스트라이크 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 45.00); break; // 강화 효과(버프 형태) 제외
                case 18: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 45.90); break;
                case 19: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 46.80); break;
                case 20: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 47.70); break;
            }
        }
    }
}
