package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.scouter;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScouterStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "스카우터";
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


            if ("배터리 출력 강화".equals(name)) {
                calcBatteryOutputBoost(effectsMap, point, grade);
            } else if ("소각 집행".equals(name)) {
                calcIncinerationExecution(effectsMap, point, grade);
            } else if ("제로백 버스트".equals(name)) {
                calcZeroToHundredBurst(effectsMap, point, grade);
            } else if ("초감각 동기화".equals(name)) {
                calcExtrasensorySync(effectsMap, point, grade);
            } else if ("아틸러리 스탠스".equals(name)) {
                calcArtilleryStance(effectsMap, point, grade);
            } else if ("코어 리액터 증폭".equals(name)) {
                calcCoreReactorAmplify(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //배터리 출력 강화
    private void calcBatteryOutputBoost(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 8.00); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 일심동체 트라이포드 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 8.00); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 일심동체 트라이포드 피증", 15.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 일심동체 트라이포드 피증", 24.00); break;
                case 18: mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 8.00); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 일심동체 트라이포드 피증", 15.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 일심동체 트라이포드 피증", 24.00); mergeEffect(effectsMap, "적주피", 0.17); break;
                case 19: mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 8.00); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 일심동체 트라이포드 피증", 15.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 일심동체 트라이포드 피증", 24.00); mergeEffect(effectsMap, "적주피", 0.34); break;
                case 20: mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 8.00); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 일심동체 트라이포드 피증", 15.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 일심동체 트라이포드 피증", 24.00); mergeEffect(effectsMap, "적주피", 0.51); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 8.00); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 일심동체 트라이포드 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 8.00); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 일심동체 트라이포드 피증", 15.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 일심동체 트라이포드 피증", 28.00); break;
                case 18: mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 8.00); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 일심동체 트라이포드 피증", 15.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 일심동체 트라이포드 피증", 28.00); mergeEffect(effectsMap, "적주피", 0.17); break;
                case 19: mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 8.00); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 일심동체 트라이포드 피증", 15.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 일심동체 트라이포드 피증", 28.00); mergeEffect(effectsMap, "적주피", 0.34); break;
                case 20: mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 8.00); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 일심동체 트라이포드 피증", 15.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 일심동체 트라이포드 피증", 28.00); mergeEffect(effectsMap, "적주피", 0.51); break;
            }
        }
    }

    //소각 집행
    private void calcIncinerationExecution(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "아발란체 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "아발란체 스킬 피증", 10.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "아발란체 스킬 피증", 10.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 12.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 편제 개편 트라이포드 피증", 80.00); break; // 쿨증, 시전 속도 제외
                case 18: mergeEffect(effectsMap, "아발란체 스킬 피증", 10.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 12.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 편제 개편 트라이포드 피증", 80.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 0.80); break;
                case 19: mergeEffect(effectsMap, "아발란체 스킬 피증", 10.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 12.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 편제 개편 트라이포드 피증", 80.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 1.60); break;
                case 20: mergeEffect(effectsMap, "아발란체 스킬 피증", 10.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 12.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 편제 개편 트라이포드 피증", 80.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 2.40); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "아발란체 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "아발란체 스킬 피증", 10.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "아발란체 스킬 피증", 10.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 12.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 편제 개편 트라이포드 피증", 90.00); break; // 쿨증, 시전 속도 제외
                case 18: mergeEffect(effectsMap, "아발란체 스킬 피증", 10.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 12.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 편제 개편 트라이포드 피증", 90.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 0.80); break;
                case 19: mergeEffect(effectsMap, "아발란체 스킬 피증", 10.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 12.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 편제 개편 트라이포드 피증", 90.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 1.60); break;
                case 20: mergeEffect(effectsMap, "아발란체 스킬 피증", 10.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 12.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 편제 개편 트라이포드 피증", 90.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 2.40); break;
            }
        }
    }

    //제로백 버스트
    private void calcZeroToHundredBurst(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 6.00); mergeEffect(effectsMap, "에너지 버스터 스킬 강인함 트라이포드 피증", 75.00); break;
                case 17: mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 6.00); mergeEffect(effectsMap, "에너지 버스터 스킬 강인함 트라이포드 피증", 75.00); mergeEffect(effectsMap, "에너지 버스터 스킬 숙련된 움직임 트라이포드 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 6.00); mergeEffect(effectsMap, "에너지 버스터 스킬 강인함 트라이포드 피증", 75.00); mergeEffect(effectsMap, "에너지 버스터 스킬 숙련된 움직임 트라이포드 피증", 25.00); mergeEffect(effectsMap, "합작 스킬 피증", 0.25); break;
                case 19: mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 6.00); mergeEffect(effectsMap, "에너지 버스터 스킬 강인함 트라이포드 피증", 75.00); mergeEffect(effectsMap, "에너지 버스터 스킬 숙련된 움직임 트라이포드 피증", 25.00); mergeEffect(effectsMap, "합작 스킬 피증", 0.50); break;
                case 20: mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 6.00); mergeEffect(effectsMap, "에너지 버스터 스킬 강인함 트라이포드 피증", 75.00); mergeEffect(effectsMap, "에너지 버스터 스킬 숙련된 움직임 트라이포드 피증", 25.00); mergeEffect(effectsMap, "합작 스킬 피증", 0.75); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 6.00); mergeEffect(effectsMap, "에너지 버스터 스킬 강인함 트라이포드 피증", 75.00); break;
                case 17: mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 6.00); mergeEffect(effectsMap, "에너지 버스터 스킬 강인함 트라이포드 피증", 75.00); mergeEffect(effectsMap, "에너지 버스터 스킬 숙련된 움직임 트라이포드 피증", 29.00); break;
                case 18: mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 6.00); mergeEffect(effectsMap, "에너지 버스터 스킬 강인함 트라이포드 피증", 75.00); mergeEffect(effectsMap, "에너지 버스터 스킬 숙련된 움직임 트라이포드 피증", 29.00); mergeEffect(effectsMap, "합작 스킬 피증", 0.25); break;
                case 19: mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 6.00); mergeEffect(effectsMap, "에너지 버스터 스킬 강인함 트라이포드 피증", 75.00); mergeEffect(effectsMap, "에너지 버스터 스킬 숙련된 움직임 트라이포드 피증", 29.00); mergeEffect(effectsMap, "합작 스킬 피증", 0.50); break;
                case 20: mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 6.00); mergeEffect(effectsMap, "에너지 버스터 스킬 강인함 트라이포드 피증", 75.00); mergeEffect(effectsMap, "에너지 버스터 스킬 숙련된 움직임 트라이포드 피증", 29.00); mergeEffect(effectsMap, "합작 스킬 피증", 0.75); break;
            }
        }
    }

    //초감각 동기화
    private void calcExtrasensorySync(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "EX - 제로 포인트 스킬 피증", 20.00); break;
                case 14: mergeEffect(effectsMap, "EX - 제로 포인트 스킬 피증", 20.00); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 8.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "EX - 제로 포인트 스킬 피증", 20.00); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 8.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 8.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "EX - 제로 포인트 스킬 피증", 20.00); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 8.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 8.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 15.00); mergeEffect(effectsMap, "싱크 계열 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "EX - 제로 포인트 스킬 피증", 20.00); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 8.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 8.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 15.00); mergeEffect(effectsMap, "싱크 계열 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "EX - 제로 포인트 스킬 피증", 20.00); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 8.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 8.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 15.00); mergeEffect(effectsMap, "싱크 계열 스킬 피증", 0.51); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "EX - 제로 포인트 스킬 피증", 20.00); break;
                case 14: mergeEffect(effectsMap, "EX - 제로 포인트 스킬 피증", 20.00); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 8.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "EX - 제로 포인트 스킬 피증", 20.00); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 8.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 8.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 22.00); break;
                case 18: mergeEffect(effectsMap, "EX - 제로 포인트 스킬 피증", 20.00); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 8.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 8.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 22.00); mergeEffect(effectsMap, "싱크 계열 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "EX - 제로 포인트 스킬 피증", 20.00); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 8.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 8.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 22.00); mergeEffect(effectsMap, "싱크 계열 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "EX - 제로 포인트 스킬 피증", 20.00); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 8.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 8.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 22.00); mergeEffect(effectsMap, "싱크 계열 스킬 피증", 0.51); break;
            }
        }
    }

    //아틸러리 스탠스
    private void calcArtilleryStance(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 20.00); break; // 쿨증 제외
                case 14: mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 20.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 20.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 12.00); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 10.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 20.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 12.00); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 10.00); mergeEffect(effectsMap, "싱크 계열 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 20.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 12.00); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 10.00); mergeEffect(effectsMap, "싱크 계열 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 20.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 12.00); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 10.00); mergeEffect(effectsMap, "싱크 계열 스킬 피증", 0.51); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 20.00); break; // 쿨증 제외
                case 14: mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 20.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 20.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 12.00); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 14.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 20.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 12.00); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 14.00); mergeEffect(effectsMap, "싱크 계열 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 20.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 12.00); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 14.00); mergeEffect(effectsMap, "싱크 계열 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", 20.00); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", 12.00); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 14.00); mergeEffect(effectsMap, "싱크 계열 스킬 피증", 0.51); break;
            }
        }
    }

    //코어 리액터 증폭
    private void calcCoreReactorAmplify(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "버스트 블로우 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "버스트 블로우 스킬 피증", 10.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 15.00); break; // 면역, 시전 속도 제외
                case 17: mergeEffect(effectsMap, "버스트 블로우 스킬 피증", 10.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 15.00); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "버스트 블로우 스킬 피증", 10.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 15.90); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "버스트 블로우 스킬 피증", 10.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 16.80); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "버스트 블로우 스킬 피증", 10.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 17.70); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 15.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "버스트 블로우 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "버스트 블로우 스킬 피증", 10.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 15.00); break; // 면역, 시전 속도 제외
                case 17: mergeEffect(effectsMap, "버스트 블로우 스킬 피증", 10.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 15.00); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 22.00); break;
                case 18: mergeEffect(effectsMap, "버스트 블로우 스킬 피증", 10.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 15.90); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 22.00); break;
                case 19: mergeEffect(effectsMap, "버스트 블로우 스킬 피증", 10.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 16.80); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 22.00); break;
                case 20: mergeEffect(effectsMap, "버스트 블로우 스킬 피증", 10.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 17.70); mergeEffect(effectsMap, "레이저 블레이드 스킬 피증", 22.00); break;
            }
        }
    }
}
