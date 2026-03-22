package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.lanceMaster;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LanceMasterStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "창술사";
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


            if ("진화의 끝".equals(name)) {
                calcEndOfEvolution(effectsMap, point, grade);
            } else if ("한 점 돌파".equals(name)) {
                calcSinglePointBreakthrough(effectsMap, point, grade);
            } else if ("맹룡 회도".equals(name)) {
                calcFierceDragonRevolve(effectsMap, point, grade);
            } else if ("이중 비기".equals(name)) {
                calcDualSecretArt(effectsMap, point, grade);
            } else if ("환영".equals(name)) {
                calcIllusion(effectsMap, point, grade);
            } else if ("연격 난무".equals(name)) {
                calcComboWildDance(effectsMap, point, grade);
            }

        });

        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //진화의 끝
    private void calcEndOfEvolution(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); break; // 진화하는 창술 시전 속도 50% 포함
                case 17: mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); mergeEffect(effectsMap, "적룡포 스킬 진화하는 창술 트라이포드 피증", -30.00); mergeEffect(effectsMap, "치적", 100.00); break; // 5.0 - 30.0 / 적룡포 치적 100% 증가 포함
                case 18: mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); mergeEffect(effectsMap, "적룡포 스킬 진화하는 창술 트라이포드 피증", -30.00); mergeEffect(effectsMap, "치적", 100.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); mergeEffect(effectsMap, "적룡포 스킬 진화하는 창술 트라이포드 피증", -30.00); mergeEffect(effectsMap, "치적", 100.00);mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); mergeEffect(effectsMap, "적룡포 스킬 진화하는 창술 트라이포드 피증", -30.00); mergeEffect(effectsMap, "치적", 100.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); break; // 진화하는 창술 시전 속도 50% 포함
                case 17: mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); mergeEffect(effectsMap, "적룡포 스킬 진화하는 창술 트라이포드 피증", -30.00); mergeEffect(effectsMap, "치적", 100.00); mergeEffect(effectsMap, "집중 스킬 피증", 1.00); break; // 5.0 - 30.0 / 적룡포 치적 100% 증가 포함
                case 18: mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); mergeEffect(effectsMap, "적룡포 스킬 진화하는 창술 트라이포드 피증", -30.00); mergeEffect(effectsMap, "치적", 100.00); mergeEffect(effectsMap, "집중 스킬 피증", 1.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); mergeEffect(effectsMap, "적룡포 스킬 진화하는 창술 트라이포드 피증", -30.00); mergeEffect(effectsMap, "치적", 100.00); mergeEffect(effectsMap, "집중 스킬 피증", 1.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); mergeEffect(effectsMap, "적룡포 스킬 진화하는 창술 트라이포드 피증", -30.00); mergeEffect(effectsMap, "치적", 100.00); mergeEffect(effectsMap, "집중 스킬 피증", 1.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        }
    }

    //한 점 돌파
    private void calcSinglePointBreakthrough(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 3.00); mergeEffect(effectsMap, "사두룡격 스킬 피증", 7.00); mergeEffect(effectsMap, "굉열파 스킬 피증", 7.00); break;
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 3.00); mergeEffect(effectsMap, "사두룡격 스킬 피증", 7.00); mergeEffect(effectsMap, "굉열파 스킬 피증", 7.00); mergeEffect(effectsMap, "유성강천 스킬 피증", 5.00); mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 3.00); mergeEffect(effectsMap, "사두룡격 스킬 피증", 7.00); mergeEffect(effectsMap, "굉열파 스킬 피증", 7.00); mergeEffect(effectsMap, "유성강천 스킬 피증", 5.00); mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 3.00); mergeEffect(effectsMap, "사두룡격 스킬 피증", 7.00); mergeEffect(effectsMap, "굉열파 스킬 피증", 7.00); mergeEffect(effectsMap, "유성강천 스킬 피증", 5.00); mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 3.00); mergeEffect(effectsMap, "사두룡격 스킬 피증", 7.00); mergeEffect(effectsMap, "굉열파 스킬 피증", 7.00); mergeEffect(effectsMap, "유성강천 스킬 피증", 5.00); mergeEffect(effectsMap, "적룡포 스킬 피증", 5.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 3.00); mergeEffect(effectsMap, "사두룡격 스킬 피증", 7.00); mergeEffect(effectsMap, "굉열파 스킬 피증", 7.00); break;
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 3.00); mergeEffect(effectsMap, "사두룡격 스킬 피증", 7.00); mergeEffect(effectsMap, "굉열파 스킬 피증", 7.00); mergeEffect(effectsMap, "유성강천 스킬 피증", 8.00); mergeEffect(effectsMap, "적룡포 스킬 피증", 8.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 3.00); mergeEffect(effectsMap, "사두룡격 스킬 피증", 7.00); mergeEffect(effectsMap, "굉열파 스킬 피증", 7.00); mergeEffect(effectsMap, "유성강천 스킬 피증", 8.00); mergeEffect(effectsMap, "적룡포 스킬 피증", 8.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 3.00); mergeEffect(effectsMap, "사두룡격 스킬 피증", 7.00); mergeEffect(effectsMap, "굉열파 스킬 피증", 7.00); mergeEffect(effectsMap, "유성강천 스킬 피증", 8.00); mergeEffect(effectsMap, "적룡포 스킬 피증", 8.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 3.00); mergeEffect(effectsMap, "사두룡격 스킬 피증", 7.00); mergeEffect(effectsMap, "굉열파 스킬 피증", 7.00); mergeEffect(effectsMap, "유성강천 스킬 피증", 8.00); mergeEffect(effectsMap, "적룡포 스킬 피증", 8.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        }
    }

    //맹룡 회도
    private void calcFierceDragonRevolve(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 우회 베기 트라이포드 피증", 30.00); break; // 무력화 30% 포함
                case 17: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 우회 베기 트라이포드 피증", 30.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 13.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "맹룡열파 스킬 우회 베기 트라이포드 피증", 30.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 13.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.40); mergeEffect(effectsMap, "맹룡열파 스킬 우회 베기 트라이포드 피증", 30.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 13.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.60); mergeEffect(effectsMap, "맹룡열파 스킬 우회 베기 트라이포드 피증", 30.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 13.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 우회 베기 트라이포드 피증", 30.00); break; // 무력화 30% 포함
                case 17: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 우회 베기 트라이포드 피증", 30.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "맹룡열파 스킬 우회 베기 트라이포드 피증", 30.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.40); mergeEffect(effectsMap, "맹룡열파 스킬 우회 베기 트라이포드 피증", 30.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.60); mergeEffect(effectsMap, "맹룡열파 스킬 우회 베기 트라이포드 피증", 30.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 20.00); break;
            }
        }
    }

    //이중 비기
    private void calcDualSecretArt(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.00); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 10.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 10.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 10.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 10.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.00); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 10.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 10.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 1.20); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 10.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 1.40); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 1.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 10.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 1.60); break;
            }
        }
    }

    //환영
    private void calcIllusion(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "연가비기 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "연가비기 스킬 피증", 5.00); mergeEffect(effectsMap, "청룡출수 스킬 환영 출수 트라이포드 피증", 18.00); break;
                case 17: mergeEffect(effectsMap, "연가비기 스킬 피증", 5.00); mergeEffect(effectsMap, "청룡출수 스킬 환영 출수 트라이포드 피증", 18.00); mergeEffect(effectsMap, "선풍참혼 스킬 협력 강화 트라이포드 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "연가비기 스킬 피증", 5.00); mergeEffect(effectsMap, "청룡출수 스킬 환영 출수 트라이포드 피증", 18.00); mergeEffect(effectsMap, "선풍참혼 스킬 협력 강화 트라이포드 피증", 20.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "연가비기 스킬 피증", 5.00); mergeEffect(effectsMap, "청룡출수 스킬 환영 출수 트라이포드 피증", 18.00); mergeEffect(effectsMap, "선풍참혼 스킬 협력 강화 트라이포드 피증", 20.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "연가비기 스킬 피증", 5.00); mergeEffect(effectsMap, "청룡출수 스킬 환영 출수 트라이포드 피증", 18.00); mergeEffect(effectsMap, "선풍참혼 스킬 협력 강화 트라이포드 피증", 20.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "연가비기 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "연가비기 스킬 피증", 5.00); mergeEffect(effectsMap, "청룡출수 스킬 환영 출수 트라이포드 피증", 18.00); break;
                case 17: mergeEffect(effectsMap, "연가비기 스킬 피증", 5.00); mergeEffect(effectsMap, "청룡출수 스킬 환영 출수 트라이포드 피증", 18.00); mergeEffect(effectsMap, "선풍참혼 스킬 협력 강화 트라이포드 피증", 20.00); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 18: mergeEffect(effectsMap, "연가비기 스킬 피증", 5.00); mergeEffect(effectsMap, "청룡출수 스킬 환영 출수 트라이포드 피증", 18.00); mergeEffect(effectsMap, "선풍참혼 스킬 협력 강화 트라이포드 피증", 20.00); mergeEffect(effectsMap, "적주피", 1.20); break;
                case 19: mergeEffect(effectsMap, "연가비기 스킬 피증", 5.00); mergeEffect(effectsMap, "청룡출수 스킬 환영 출수 트라이포드 피증", 18.00); mergeEffect(effectsMap, "선풍참혼 스킬 협력 강화 트라이포드 피증", 20.00); mergeEffect(effectsMap, "적주피", 1.40); break;
                case 20: mergeEffect(effectsMap, "연가비기 스킬 피증", 5.00); mergeEffect(effectsMap, "청룡출수 스킬 환영 출수 트라이포드 피증", 18.00); mergeEffect(effectsMap, "선풍참혼 스킬 협력 강화 트라이포드 피증", 20.00); mergeEffect(effectsMap, "적주피", 1.60); break;
            }
        }
    }

    //연격 난무
    private void calcComboWildDance(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "이연격 스킬 피증", 250.00); break; // 재감 페널티 포함
                case 14: mergeEffect(effectsMap, "이연격 스킬 피증", 250.00); mergeEffect(effectsMap, "공의연무 스킬 피증", 350.00); break;
                case 17: mergeEffect(effectsMap, "이연격 스킬 피증", 250.00); mergeEffect(effectsMap, "공의연무 스킬 피증", 350.00); mergeEffect(effectsMap, "맹룡열파 스킬 추가 베기 트라이포드 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "이연격 스킬 피증", 250.00); mergeEffect(effectsMap, "공의연무 스킬 피증", 350.00); mergeEffect(effectsMap, "맹룡열파 스킬 추가 베기 트라이포드 피증", 10.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "이연격 스킬 피증", 250.00); mergeEffect(effectsMap, "공의연무 스킬 피증", 350.00); mergeEffect(effectsMap, "맹룡열파 스킬 추가 베기 트라이포드 피증", 10.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "이연격 스킬 피증", 250.00); mergeEffect(effectsMap, "공의연무 스킬 피증", 350.00); mergeEffect(effectsMap, "맹룡열파 스킬 추가 베기 트라이포드 피증", 10.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "이연격 스킬 피증", 250.00); break; // 재감 페널티 포함
                case 14: mergeEffect(effectsMap, "이연격 스킬 피증", 250.00); mergeEffect(effectsMap, "공의연무 스킬 피증", 350.00); break;
                case 17: mergeEffect(effectsMap, "이연격 스킬 피증", 250.00); mergeEffect(effectsMap, "공의연무 스킬 피증", 350.00); mergeEffect(effectsMap, "맹룡열파 스킬 추가 베기 트라이포드 피증", 10.00); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 18: mergeEffect(effectsMap, "이연격 스킬 피증", 250.00); mergeEffect(effectsMap, "공의연무 스킬 피증", 350.00); mergeEffect(effectsMap, "맹룡열파 스킬 추가 베기 트라이포드 피증", 10.00); mergeEffect(effectsMap, "적주피", 1.20); break;
                case 19: mergeEffect(effectsMap, "이연격 스킬 피증", 250.00); mergeEffect(effectsMap, "공의연무 스킬 피증", 350.00); mergeEffect(effectsMap, "맹룡열파 스킬 추가 베기 트라이포드 피증", 10.00); mergeEffect(effectsMap, "적주피", 1.40); break;
                case 20: mergeEffect(effectsMap, "이연격 스킬 피증", 250.00); mergeEffect(effectsMap, "공의연무 스킬 피증", 350.00); mergeEffect(effectsMap, "맹룡열파 스킬 추가 베기 트라이포드 피증", 10.00); mergeEffect(effectsMap, "적주피", 1.60); break;
            }
        }
    }
}
