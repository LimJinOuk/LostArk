package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.scouter;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScouterSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "스카우터";
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


            if ("퀀텀 오퍼레이티브".equals(name)) {
                calcQuantumOperative(effectsMap, point, grade);
            } else if ("에이전트 SMG".equals(name)) {
                calcAgentSmg(effectsMap, point, grade);
            } else if ("펄스 노바".equals(name)) {
                calcPulseNova(effectsMap, point, grade);
            } else if ("아스트라 슈트".equals(name)) {
                calcAstraSuit(effectsMap, point, grade);
            } else if ("퀘이사 캐넌 슈트".equals(name)) {
                calcQuasarCannonSuit(effectsMap, point, grade);
            } else if ("타이탄 슈트".equals(name)) {
                calcTitanSuit(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //퀀텀 오퍼레이티브
    private void calcQuantumOperative(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 피증", 20.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 5.50); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 피증", 20.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 20.00); break; // 기존 적주피 1.5 + 운명 강화 4.0
                case 18: mergeEffect(effectsMap, "적주피", 5.67); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 피증", 20.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 5.84); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 피증", 20.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 6.01); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 피증", 20.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 20.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 피증", 20.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 피증", 20.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 20.00); break; // 기존 적주피 1.5 + 운명 강화 4.0
                case 18: mergeEffect(effectsMap, "적주피", 6.67); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 피증", 20.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 6.84); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 피증", 20.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 7.01); mergeEffect(effectsMap, "명령: 베이비 드론 스킬 피증", 20.00); mergeEffect(effectsMap, "명령: 레이드 미사일 스킬 피증", 20.00); break;
            }
        }
    }

    //에이전트 SMG
    private void calcAgentSmg(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 50.00); mergeEffect(effectsMap, "아발란체 스킬 피증", 50.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 50.00); break; // 배터리 소모 및 쿨감 제외
                case 17: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 50.00); mergeEffect(effectsMap, "아발란체 스킬 피증", 50.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 95.00); break; // 기존 50.0 + 오토 슈레더 5중첩(45.0)
                case 18: mergeEffect(effectsMap, "피증", 4.40); mergeEffect(effectsMap, "전술 사격 스킬 피증", 50.00); mergeEffect(effectsMap, "아발란체 스킬 피증", 50.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 95.00); break;
                case 19: mergeEffect(effectsMap, "피증", 4.80); mergeEffect(effectsMap, "전술 사격 스킬 피증", 50.00); mergeEffect(effectsMap, "아발란체 스킬 피증", 50.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 95.00); break;
                case 20: mergeEffect(effectsMap, "피증", 5.20); mergeEffect(effectsMap, "전술 사격 스킬 피증", 50.00); mergeEffect(effectsMap, "아발란체 스킬 피증", 50.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 95.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 50.00); mergeEffect(effectsMap, "아발란체 스킬 피증", 50.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 50.00); break; // 배터리 소모 및 쿨감 제외
                case 17: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "전술 사격 스킬 피증", 50.00); mergeEffect(effectsMap, "아발란체 스킬 피증", 50.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 100.00); break; // 기존 50.0 + 오토 슈레더 5중첩(45.0)
                case 18: mergeEffect(effectsMap, "피증", 4.40); mergeEffect(effectsMap, "전술 사격 스킬 피증", 50.00); mergeEffect(effectsMap, "아발란체 스킬 피증", 50.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 100.00); break;
                case 19: mergeEffect(effectsMap, "피증", 4.80); mergeEffect(effectsMap, "전술 사격 스킬 피증", 50.00); mergeEffect(effectsMap, "아발란체 스킬 피증", 50.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 100.00); break;
                case 20: mergeEffect(effectsMap, "피증", 5.20); mergeEffect(effectsMap, "전술 사격 스킬 피증", 50.00); mergeEffect(effectsMap, "아발란체 스킬 피증", 50.00); mergeEffect(effectsMap, "어나힐레이션 모드 스킬 피증", 100.00); break;
            }
        }
    }

    //펄스 노바
    private void calcPulseNova(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "합작 스킬 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "합작 스킬 피증", 2.50); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 28.00); break;
                case 17: mergeEffect(effectsMap, "합작 스킬 피증", 2.50); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 52.00); break; // 기존 28.0 + 오버 에너지 5중첩(24.0)
                case 18: mergeEffect(effectsMap, "합작 스킬 피증", 2.75); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 52.00); break;
                case 19: mergeEffect(effectsMap, "합작 스킬 피증", 3.00); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 52.00); break;
                case 20: mergeEffect(effectsMap, "합작 스킬 피증", 3.25); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 52.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "합작 스킬 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "합작 스킬 피증", 2.50); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 28.00); break;
                case 17: mergeEffect(effectsMap, "합작 스킬 피증", 2.50); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 55.50); break; // 기존 28.0 + 오버 에너지 5중첩(24.0)
                case 18: mergeEffect(effectsMap, "합작 스킬 피증", 2.75); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 55.50); break;
                case 19: mergeEffect(effectsMap, "합작 스킬 피증", 3.00); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 55.50); break;
                case 20: mergeEffect(effectsMap, "합작 스킬 피증", 3.25); mergeEffect(effectsMap, "에너지 버스터 스킬 피증", 55.50); break;
            }
        }
    }

    //아스트라 슈트
    //진욱쿤(하이퍼 싱크 스킬? 피증)
    private void calcAstraSuit(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "치적", 6.00); break; // 시전 속도 제외
                case 17: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "치적", 6.00); mergeEffect(effectsMap, "하이퍼 싱크 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.67); mergeEffect(effectsMap, "치적", 6.00); mergeEffect(effectsMap, "하이퍼 싱크 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.84); mergeEffect(effectsMap, "치적", 6.00); mergeEffect(effectsMap, "하이퍼 싱크 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 2.01); mergeEffect(effectsMap, "치적", 6.00); mergeEffect(effectsMap, "하이퍼 싱크 스킬 피증", 20.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "치적", 6.00); break; // 시전 속도 제외
                case 17: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "치적", 6.00); mergeEffect(effectsMap, "하이퍼 싱크 스킬 피증", 22.00); break;
                case 18: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.67); mergeEffect(effectsMap, "치적", 6.00); mergeEffect(effectsMap, "하이퍼 싱크 스킬 피증", 22.00); break;
                case 19: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.84); mergeEffect(effectsMap, "치적", 6.00); mergeEffect(effectsMap, "하이퍼 싱크 스킬 피증", 22.00); break;
                case 20: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 2.01); mergeEffect(effectsMap, "치적", 6.00); mergeEffect(effectsMap, "하이퍼 싱크 스킬 피증", 22.00); break;
            }
        }
    }

    //퀘이사 캐넌 슈트
    private void calcQuasarCannonSuit(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break; // 쿨감 제외
                case 17: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 15.00); break; // 안티매터 빔 3중첩(15.0)
                case 18: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 15.70); break;
                case 19: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 16.40); break;
                case 20: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 17.10); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break; // 쿨감 제외
                case 17: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 19.50); break; // 안티매터 빔 3중첩(15.0)
                case 18: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 20.20); break;
                case 19: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 20.90); break;
                case 20: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "퀀텀 어셈블리 빔 스킬 피증", 21.60); break;
            }
        }
    }

    //타이탄 슈트
    private void calcTitanSuit(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", -20.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", -20.00); mergeEffect(effectsMap, "강화 레이저 블레이드 스킬 피증", 25.00); mergeEffect(effectsMap, "강화 버스트 블로우 스킬 피증", 25.00); break; // 쿨감 제외
                case 17: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", -20.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", -20.00); mergeEffect(effectsMap, "강화 레이저 블레이드 스킬 피증", 25.00); mergeEffect(effectsMap, "강화 버스트 블로우 스킬 피증", 25.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 64.00); break; // 마하 드라이브 4중첩(64.0)
                case 18: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", -20.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", -20.00); mergeEffect(effectsMap, "강화 레이저 블레이드 스킬 피증", 25.00); mergeEffect(effectsMap, "강화 버스트 블로우 스킬 피증", 25.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 64.90); break;
                case 19: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", -20.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", -20.00); mergeEffect(effectsMap, "강화 레이저 블레이드 스킬 피증", 25.00); mergeEffect(effectsMap, "강화 버스트 블로우 스킬 피증", 25.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 65.80); break;
                case 20: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", -20.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", -20.00); mergeEffect(effectsMap, "강화 레이저 블레이드 스킬 피증", 25.00); mergeEffect(effectsMap, "강화 버스트 블로우 스킬 피증", 25.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 66.70); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", -20.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", -20.00); mergeEffect(effectsMap, "강화 레이저 블레이드 스킬 피증", 25.00); mergeEffect(effectsMap, "강화 버스트 블로우 스킬 피증", 25.00); break; // 쿨감 제외
                case 17: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", -20.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", -20.00); mergeEffect(effectsMap, "강화 레이저 블레이드 스킬 피증", 25.00); mergeEffect(effectsMap, "강화 버스트 블로우 스킬 피증", 25.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 72.00); break; // 마하 드라이브 4중첩(64.0)
                case 18: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", -20.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", -20.00); mergeEffect(effectsMap, "강화 레이저 블레이드 스킬 피증", 25.00); mergeEffect(effectsMap, "강화 버스트 블로우 스킬 피증", 25.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 72.90); break;
                case 19: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", -20.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", -20.00); mergeEffect(effectsMap, "강화 레이저 블레이드 스킬 피증", 25.00); mergeEffect(effectsMap, "강화 버스트 블로우 스킬 피증", 25.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 73.80); break;
                case 20: mergeEffect(effectsMap, "싱크 계열 스킬 피증", 1.50); mergeEffect(effectsMap, "크림슨 브레이커 스킬 피증", -20.00); mergeEffect(effectsMap, "엑셀리온 빔 스킬 피증", -20.00); mergeEffect(effectsMap, "강화 레이저 블레이드 스킬 피증", 25.00); mergeEffect(effectsMap, "강화 버스트 블로우 스킬 피증", 25.00); mergeEffect(effectsMap, "소닉 임팩트 스킬 피증", 74.70); break;
            }
        }
    }
}
