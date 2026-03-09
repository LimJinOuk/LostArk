package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.guardianKnight;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GuardianKnightStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "가디언나이트";
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

            if ("라스트 스탠드".equals(name)) {
                calcLastStand(effectsMap, point, grade);
            } else if ("엑스큐셔너".equals(name)) {
                calcExecutioner(effectsMap, point, grade);
            } else if ("추격 시작".equals(name)) {
                calcStartChase(effectsMap, point, grade);
            } else if ("그랜드 피날레".equals(name)) {
                calcGrandFinale(effectsMap, point, grade);
            } else if ("일당백".equals(name)) {
                calcMatchlessWarrior(effectsMap, point, grade);
            } else if ("파멸".equals(name)) {
                calcRuin(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //라스트 스탠드
    private void calcLastStand(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", 8.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", 8.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", 8.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 푸른 심장 트라이포드 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", 8.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", 8.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 푸른 심장 트라이포드 피증", 20.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 0.70); break;
                case 19: mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", 8.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", 8.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 푸른 심장 트라이포드 피증", 20.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 1.40); break;
                case 20: mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", 8.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", 8.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 푸른 심장 트라이포드 피증", 20.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 2.10); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", 8.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", 8.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", 8.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 푸른 심장 트라이포드 피증", 27.00); break;
                case 18: mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", 8.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", 8.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 푸른 심장 트라이포드 피증", 27.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 0.70); break;
                case 19: mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", 8.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", 8.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 푸른 심장 트라이포드 피증", 27.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 1.40); break;
                case 20: mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", 8.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", 8.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 푸른 심장 트라이포드 피증", 27.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 2.10); break;
            }
        }
    }

    //엑스큐셔너
    private void calcExecutioner(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "발현 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "발현 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "발현 스킬 피증", 5.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "발현 스킬 피증", 5.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 10.80); break;
                case 19: mergeEffect(effectsMap, "발현 스킬 피증", 5.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 11.60); break;
                case 20: mergeEffect(effectsMap, "발현 스킬 피증", 5.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 12.40); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "발현 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "발현 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "발현 스킬 피증", 5.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "발현 스킬 피증", 5.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 15.80); break;
                case 19: mergeEffect(effectsMap, "발현 스킬 피증", 5.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 16.60); break;
                case 20: mergeEffect(effectsMap, "발현 스킬 피증", 5.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 17.40); break;
            }
        }
    }

    //추격 시작
    private void calcStartChase(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 20.00); mergeEffect(effectsMap, "블레이즈 플래시 스킬 맹렬한 추격 트라이포드 피증", 16.00); break;
                case 18: mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 20.80); mergeEffect(effectsMap, "블레이즈 플래시 스킬 맹렬한 추격 트라이포드 피증", 16.00); break;
                case 19: mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 21.60); mergeEffect(effectsMap, "블레이즈 플래시 스킬 맹렬한 추격 트라이포드 피증", 16.00); break;
                case 20: mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 22.40); mergeEffect(effectsMap, "블레이즈 플래시 스킬 맹렬한 추격 트라이포드 피증", 16.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 20.00); mergeEffect(effectsMap, "블레이즈 플래시 스킬 맹렬한 추격 트라이포드 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 20.80); mergeEffect(effectsMap, "블레이즈 플래시 스킬 맹렬한 추격 트라이포드 피증", 25.00); break;
                case 19: mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 21.60); mergeEffect(effectsMap, "블레이즈 플래시 스킬 맹렬한 추격 트라이포드 피증", 25.00); break;
                case 20: mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 22.40); mergeEffect(effectsMap, "블레이즈 플래시 스킬 맹렬한 추격 트라이포드 피증", 25.00); break;
            }
        }
    }

    //그랜드 피날레
    //진욱쿤(14포, 17포 차지 조작)
    private void calcGrandFinale(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 12.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 죽음의 일격 트라이포드 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 12.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 죽음의 일격 트라이포드 피증", 20.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 말살 트라이포드 피증", 14.00); break;
                case 18: mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 12.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 죽음의 일격 트라이포드 피증", 20.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 말살 트라이포드 피증", 14.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.21); break;
                case 19: mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 12.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 죽음의 일격 트라이포드 피증", 20.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 말살 트라이포드 피증", 14.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.42); break;
                case 20: mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 12.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 죽음의 일격 트라이포드 피증", 20.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 말살 트라이포드 피증", 14.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.63); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 12.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 죽음의 일격 트라이포드 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 12.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 죽음의 일격 트라이포드 피증", 20.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 말살 트라이포드 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 12.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 죽음의 일격 트라이포드 피증", 20.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 말살 트라이포드 피증", 18.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.21); break;
                case 19: mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 12.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 죽음의 일격 트라이포드 피증", 20.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 말살 트라이포드 피증", 18.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.42); break;
                case 20: mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 12.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 죽음의 일격 트라이포드 피증", 20.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 말살 트라이포드 피증", 18.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.63); break;
            }
        }
    }

    //일당백
    private void calcMatchlessWarrior(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 천부적인 힘 트라이포드 피증", 8.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 맹습 트라이포드 피증", 80.00); break;
                case 17: mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 천부적인 힘 트라이포드 피증", 8.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 맹습 트라이포드 피증", 80.00); break;
                case 18: mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 8.80); mergeEffect(effectsMap, "길로틴 스핀 스킬 천부적인 힘 트라이포드 피증", 8.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 맹습 트라이포드 피증", 80.00); break;
                case 19: mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 9.60); mergeEffect(effectsMap, "길로틴 스핀 스킬 천부적인 힘 트라이포드 피증", 8.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 맹습 트라이포드 피증", 80.00); break;
                case 20: mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 10.40); mergeEffect(effectsMap, "길로틴 스핀 스킬 천부적인 힘 트라이포드 피증", 8.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 맹습 트라이포드 피증", 80.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 천부적인 힘 트라이포드 피증", 8.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 맹습 트라이포드 피증", 88.00); break;
                case 17: mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 천부적인 힘 트라이포드 피증", 8.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 맹습 트라이포드 피증", 88.00); break;
                case 18: mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 8.80); mergeEffect(effectsMap, "길로틴 스핀 스킬 천부적인 힘 트라이포드 피증", 8.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 맹습 트라이포드 피증", 88.00); break;
                case 19: mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 9.60); mergeEffect(effectsMap, "길로틴 스핀 스킬 천부적인 힘 트라이포드 피증", 8.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 맹습 트라이포드 피증", 88.00); break;
                case 20: mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 10.40); mergeEffect(effectsMap, "길로틴 스핀 스킬 천부적인 힘 트라이포드 피증", 8.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 맹습 트라이포드 피증", 88.00); break;
            }
        }
    }

    //파멸
    private void calcRuin(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 파멸의 오브 트라이포드 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 파멸의 오브 트라이포드 피증", 15.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 파멸의 오브 트라이포드 피증", 15.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 15.90); break;
                case 19: mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 파멸의 오브 트라이포드 피증", 15.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 16.80); break;
                case 20: mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 파멸의 오브 트라이포드 피증", 15.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 17.70); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 파멸의 오브 트라이포드 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 파멸의 오브 트라이포드 피증", 20.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 파멸의 오브 트라이포드 피증", 20.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 15.90); break;
                case 19: mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 파멸의 오브 트라이포드 피증", 20.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 16.80); break;
                case 20: mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 파멸의 오브 트라이포드 피증", 20.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 17.70); break;
            }
        }
    }
}
