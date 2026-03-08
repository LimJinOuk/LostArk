package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.guardianKnight;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GuardianKnightSun extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "가디언나이트";
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


            if ("피니셔".equals(name)) {
                calcFinisher(effectsMap, point, grade);
            } else if ("매니페스트".equals(name)) {
                calcManifest(effectsMap, point, grade);
            } else if ("붉은 날개".equals(name)) {
                calcRedWings(effectsMap, point, grade);
            } else if ("차지 인핸스".equals(name)) {
                calcChargeEnhance(effectsMap, point, grade);
            } else if ("브랜디쉬".equals(name)) {
                calcBrandish(effectsMap, point, grade);
            } else if ("에이펙스".equals(name)) {
                calcApex(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //피니셔
    private void calcFinisher(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 6.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 25.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 25.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 25.70); break;
                case 19: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 25.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 26.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 25.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 27.10); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 6.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 30.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 30.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 30.70); break;
                case 19: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 30.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 31.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 30.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 32.10); break;
            }
        }
    }

    //매니페스트
    private void calcManifest(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -70.00);mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", -70.00); mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", -70.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", -70.00); mergeEffect(effectsMap, "발현 스킬 스킬 피증", 50.00); break;
                case 17: mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -70.00);mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", -70.00); mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", -70.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", -70.00); mergeEffect(effectsMap, "발현 스킬 스킬 피증", 50.00); mergeEffect(effectsMap, "인페르노 버스트 스킬 피증", 24.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 24.00); break;
                case 18: mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -70.00);mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", -70.00); mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", -70.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", -70.00); mergeEffect(effectsMap, "발현 스킬 스킬 피증", 50.32); mergeEffect(effectsMap, "인페르노 버스트 스킬 피증", 24.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 24.00); break;
                case 19: mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -70.00);mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", -70.00); mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", -70.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", -70.00); mergeEffect(effectsMap, "발현 스킬 스킬 피증", 50.64); mergeEffect(effectsMap, "인페르노 버스트 스킬 피증", 24.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 24.00); break;
                case 20: mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -70.00);mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", -70.00); mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", -70.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", -70.00); mergeEffect(effectsMap, "발현 스킬 스킬 피증", 50.96); mergeEffect(effectsMap, "인페르노 버스트 스킬 피증", 24.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 24.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -70.00);mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", -70.00); mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", -70.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", -70.00); mergeEffect(effectsMap, "발현 스킬 스킬 피증", 50.00); break;
                case 17: mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -70.00);mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", -70.00); mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", -70.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", -70.00); mergeEffect(effectsMap, "발현 스킬 스킬 피증", 50.00); mergeEffect(effectsMap, "인페르노 버스트 스킬 피증", 30.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -70.00);mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", -70.00); mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", -70.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", -70.00); mergeEffect(effectsMap, "발현 스킬 스킬 피증", 50.32); mergeEffect(effectsMap, "인페르노 버스트 스킬 피증", 30.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 30.00); break;
                case 19: mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -70.00);mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", -70.00); mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", -70.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", -70.00); mergeEffect(effectsMap, "발현 스킬 스킬 피증", 50.64); mergeEffect(effectsMap, "인페르노 버스트 스킬 피증", 30.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -70.00);mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", -70.00); mergeEffect(effectsMap, "블레이즈 플래시 스킬 피증", -70.00); mergeEffect(effectsMap, "윙 래시 스킬 피증", -70.00); mergeEffect(effectsMap, "발현 스킬 스킬 피증", 50.96); mergeEffect(effectsMap, "인페르노 버스트 스킬 피증", 30.00); mergeEffect(effectsMap, "익스플로전 피니셔 스킬 피증", 30.00); break;
            }
        }
    }

    //붉은 날개
    private void calcRedWings(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -90.00); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 70.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -90.00); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 100.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -90.00); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 100.00); mergeEffect(effectsMap, "화신 스킬 피증", 0.23); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -90.00); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 100.00); mergeEffect(effectsMap, "화신 스킬 피증", 0.46); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -90.00); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 100.00); mergeEffect(effectsMap, "화신 스킬 피증", 0.69); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -90.00); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 70.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -90.00); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 114.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -90.00); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 114.00); mergeEffect(effectsMap, "화신 스킬 피증", 0.23); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -90.00); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 114.00); mergeEffect(effectsMap, "화신 스킬 피증", 0.46); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "아바돈 플레임 스킬 피증", -90.00); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 114.00); mergeEffect(effectsMap, "화신 스킬 피증", 0.69); break;
            }
        }
    }

    //차지 인핸스
    //진욱쿤(10포 차지 조작 스킬 14포 17포)
    private void calcChargeEnhance(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "윙 스팅어 스킬 피증", -70.00); mergeEffect(effectsMap, "차지 조작 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "윙 스팅어 스킬 피증", -70.00); mergeEffect(effectsMap, "(소울 디바이드) 피증", -45.00); mergeEffect(effectsMap, "차지 조작 스킬 피증", 4.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 138.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 138.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 138.00); break;
                case 17: mergeEffect(effectsMap, "윙 스팅어 스킬 피증", -70.00); mergeEffect(effectsMap, "(소울 디바이드) 피증", -45.00); mergeEffect(effectsMap, "차지 조작 스킬 피증", 16.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 138.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 138.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 138.00); break; // 4.0 + 6.0
                case 18: mergeEffect(effectsMap, "윙 스팅어 스킬 피증", -70.00); mergeEffect(effectsMap, "(소울 디바이드) 피증", -45.00); mergeEffect(effectsMap, "차지 조작 스킬 피증", 16.20); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 138.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 138.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 138.00); break;
                case 19: mergeEffect(effectsMap, "윙 스팅어 스킬 피증", -70.00); mergeEffect(effectsMap, "(소울 디바이드) 피증", -45.00); mergeEffect(effectsMap, "차지 조작 스킬 피증", 16.40); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 138.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 138.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 138.00); break;
                case 20: mergeEffect(effectsMap, "윙 스팅어 스킬 피증", -70.00); mergeEffect(effectsMap, "(소울 디바이드) 피증", -45.00); mergeEffect(effectsMap, "차지 조작 스킬 피증", 16.60); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 138.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 138.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 138.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "윙 스팅어 스킬 피증", -70.00); mergeEffect(effectsMap, "차지 조작 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "윙 스팅어 스킬 피증", -70.00); mergeEffect(effectsMap, "(소울 디바이드) 피증", -45.00); mergeEffect(effectsMap, "차지 조작 스킬 피증", 4.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 138.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 138.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 138.00); break;
                case 17: mergeEffect(effectsMap, "윙 스팅어 스킬 피증", -70.00); mergeEffect(effectsMap, "(소울 디바이드) 피증", -45.00); mergeEffect(effectsMap, "차지 조작 스킬 피증", 19.00); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 138.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 138.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 138.00); break; // 4.0 + 6.0
                case 18: mergeEffect(effectsMap, "윙 스팅어 스킬 피증", -70.00); mergeEffect(effectsMap, "(소울 디바이드) 피증", -45.00); mergeEffect(effectsMap, "차지 조작 스킬 피증", 19.20); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 138.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 138.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 138.00); break;
                case 19: mergeEffect(effectsMap, "윙 스팅어 스킬 피증", -70.00); mergeEffect(effectsMap, "(소울 디바이드) 피증", -45.00); mergeEffect(effectsMap, "차지 조작 스킬 피증", 19.40); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 138.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 138.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 138.00); break;
                case 20: mergeEffect(effectsMap, "윙 스팅어 스킬 피증", -70.00); mergeEffect(effectsMap, "(소울 디바이드) 피증", -45.00); mergeEffect(effectsMap, "차지 조작 스킬 피증", 19.60); mergeEffect(effectsMap, "퀘이크 스매시 스킬 피증", 138.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 138.00); mergeEffect(effectsMap, "렌딩 피니셔 스킬 피증", 138.00); break;
            }
        }
    }

    //브랜디쉬
    private void calcBrandish(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", -30.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", -30.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 20.00); break; // 프렌지 스윕 피증 0%는 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.66); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", -30.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.82); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", -30.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", -30.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 20.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", -30.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", -30.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 20.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 5.00); break; // 프렌지 스윕 피증 0%는 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.66); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", -30.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 20.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 5.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.82); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", -30.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 20.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 5.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", -30.00); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 20.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 5.00); break;
            }
        }
    }

    //에이펙스
    private void calcApex(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 7.50); break; // 1.5 + 6.0
                case 17: mergeEffect(effectsMap, "적주피", 12.50); break; // 1.5 + 11.0
                case 18: mergeEffect(effectsMap, "적주피", 12.66); break;
                case 19: mergeEffect(effectsMap, "적주피", 12.82); break;
                case 20: mergeEffect(effectsMap, "적주피", 12.98); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 7.50); break; // 1.5 + 6.0
                case 17: mergeEffect(effectsMap, "적주피", 13.50); break; // 1.5 + 11.0
                case 18: mergeEffect(effectsMap, "적주피", 13.66); break;
                case 19: mergeEffect(effectsMap, "적주피", 13.82); break;
                case 20: mergeEffect(effectsMap, "적주피", 13.98); break;
            }
        }
    }
}
