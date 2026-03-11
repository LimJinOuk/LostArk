package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.demonic;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class  DemonicStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "데모닉";
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


            if ("피의 폭발".equals(name)) {
                calcBloodExplosion(effectsMap, point, grade);
            } else if ("치명적인 할퀴기".equals(name)) {
                calcFatalScratch(effectsMap, point, grade);
            } else if ("혼돈의 악마".equals(name)) {
                calcChaosDemon(effectsMap, point, grade);
            } else if ("페이탈 스트라이크".equals(name)) {
                calcFatalStrike(effectsMap, point, grade);
            } else if ("죽음의 부메랑".equals(name)) {
                calcDeathBoomerang(effectsMap, point, grade);
            } else if ("파괴 광선".equals(name)) {
                calcDestructionBeam(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //피의 폭발
    private void calcBloodExplosion(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "고어 블리딩 스킬 피증", 15.00); break;
                case 14: mergeEffect(effectsMap, "고어 블리딩 스킬 피증", 15.00); mergeEffect(effectsMap, "리프 블로우 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "고어 블리딩 스킬 피증", 15.00); mergeEffect(effectsMap, "리프 블로우 스킬 피증", 15.00); mergeEffect(effectsMap, "블러드 매서커 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "고어 블리딩 스킬 피증", 15.00); mergeEffect(effectsMap, "리프 블로우 스킬 피증", 15.00); mergeEffect(effectsMap, "블러드 매서커 스킬 피증", 15.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "고어 블리딩 스킬 피증", 15.00); mergeEffect(effectsMap, "리프 블로우 스킬 피증", 15.00); mergeEffect(effectsMap, "블러드 매서커 스킬 피증", 15.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "고어 블리딩 스킬 피증", 15.00); mergeEffect(effectsMap, "리프 블로우 스킬 피증", 15.00); mergeEffect(effectsMap, "블러드 매서커 스킬 피증", 15.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "고어 블리딩 스킬 피증", 15.00); break;
                case 14: mergeEffect(effectsMap, "고어 블리딩 스킬 피증", 15.00); mergeEffect(effectsMap, "리프 블로우 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "고어 블리딩 스킬 피증", 15.00); mergeEffect(effectsMap, "리프 블로우 스킬 피증", 15.00); mergeEffect(effectsMap, "블러드 매서커 스킬 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "고어 블리딩 스킬 피증", 15.00); mergeEffect(effectsMap, "리프 블로우 스킬 피증", 15.00); mergeEffect(effectsMap, "블러드 매서커 스킬 피증", 25.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "고어 블리딩 스킬 피증", 15.00); mergeEffect(effectsMap, "리프 블로우 스킬 피증", 15.00); mergeEffect(effectsMap, "블러드 매서커 스킬 피증", 25.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "고어 블리딩 스킬 피증", 15.00); mergeEffect(effectsMap, "리프 블로우 스킬 피증", 15.00); mergeEffect(effectsMap, "블러드 매서커 스킬 피증", 25.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.60); break;
            }
        }
    }

    //치명적인 할퀴기
    private void calcFatalScratch(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 재사용 대기 시간 및 시전 속도 제외
                case 14: mergeEffect(effectsMap, "블러드 볼텍스 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "블러드 볼텍스 스킬 피증", 10.00); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 9.00); break;
                case 18: mergeEffect(effectsMap, "블러드 볼텍스 스킬 피증", 10.00); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 9.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "블러드 볼텍스 스킬 피증", 10.00); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 9.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "블러드 볼텍스 스킬 피증", 10.00); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 9.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 재사용 대기 시간 및 시전 속도 제외
                case 14: mergeEffect(effectsMap, "블러드 볼텍스 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "블러드 볼텍스 스킬 피증", 10.00); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 14.00); break;
                case 18: mergeEffect(effectsMap, "블러드 볼텍스 스킬 피증", 10.00); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 14.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "블러드 볼텍스 스킬 피증", 10.00); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 14.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "블러드 볼텍스 스킬 피증", 10.00); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 14.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.60); break;
            }
        }
    }

    //혼돈의 악마
    private void calcChaosDemon(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 재사용 대기 시간 감소 및 경직 면역 제외
                case 14: mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 5.00); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 5.00); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 10.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 5.00); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 10.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 5.00); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 10.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 재사용 대기 시간 감소 및 경직 면역 제외
                case 14: mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 5.00); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 5.00); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 18.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 5.00); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 18.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 5.00); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 18.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.60); break;
            }
        }
    }

    //페이탈 스트라이크
    private void calcFatalStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "데몰리션 스킬 빠른 공격 트라이포드 피증", 82.00); break;
                case 14: mergeEffect(effectsMap, "데몰리션 스킬 빠른 공격 트라이포드 피증", 82.00); mergeEffect(effectsMap, "샤펀 컷 스킬 잠입 공격 트라이포드 피증", 203.00); break;
                case 17: mergeEffect(effectsMap, "데몰리션 스킬 빠른 공격 트라이포드 피증", 82.00); mergeEffect(effectsMap, "샤펀 컷 스킬 잠입 공격 트라이포드 피증", 203.00); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 잠식 해방 트라이포드 피증", 40.00); break;
                case 18: mergeEffect(effectsMap, "데몰리션 스킬 빠른 공격 트라이포드 피증", 82.00); mergeEffect(effectsMap, "샤펀 컷 스킬 잠입 공격 트라이포드 피증", 203.00); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 잠식 해방 트라이포드 피증", 40.00); mergeEffect(effectsMap, "피증", 0.20); mergeEffect(effectsMap, "잠식 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "데몰리션 스킬 빠른 공격 트라이포드 피증", 82.00); mergeEffect(effectsMap, "샤펀 컷 스킬 잠입 공격 트라이포드 피증", 203.00); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 잠식 해방 트라이포드 피증", 40.00); mergeEffect(effectsMap, "피증", 0.40); mergeEffect(effectsMap, "잠식 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "데몰리션 스킬 빠른 공격 트라이포드 피증", 82.00); mergeEffect(effectsMap, "샤펀 컷 스킬 잠입 공격 트라이포드 피증", 203.00); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 잠식 해방 트라이포드 피증", 40.00); mergeEffect(effectsMap, "피증", 0.60); mergeEffect(effectsMap, "잠식 스킬 피증", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "데몰리션 스킬 빠른 공격 트라이포드 피증", 82.00); break;
                case 14: mergeEffect(effectsMap, "데몰리션 스킬 빠른 공격 트라이포드 피증", 82.00); mergeEffect(effectsMap, "샤펀 컷 스킬 잠입 공격 트라이포드 피증", 203.00); break;
                case 17: mergeEffect(effectsMap, "데몰리션 스킬 빠른 공격 트라이포드 피증", 82.00); mergeEffect(effectsMap, "샤펀 컷 스킬 잠입 공격 트라이포드 피증", 203.00); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 잠식 해방 트라이포드 피증", 48.00); break;
                case 18: mergeEffect(effectsMap, "데몰리션 스킬 빠른 공격 트라이포드 피증", 82.00); mergeEffect(effectsMap, "샤펀 컷 스킬 잠입 공격 트라이포드 피증", 203.00); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 잠식 해방 트라이포드 피증", 48.00); mergeEffect(effectsMap, "피증", 0.20); mergeEffect(effectsMap, "잠식 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "데몰리션 스킬 빠른 공격 트라이포드 피증", 82.00); mergeEffect(effectsMap, "샤펀 컷 스킬 잠입 공격 트라이포드 피증", 203.00); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 잠식 해방 트라이포드 피증", 48.00); mergeEffect(effectsMap, "피증", 0.40); mergeEffect(effectsMap, "잠식 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "데몰리션 스킬 빠른 공격 트라이포드 피증", 82.00); mergeEffect(effectsMap, "샤펀 컷 스킬 잠입 공격 트라이포드 피증", 203.00); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 잠식 해방 트라이포드 피증", 48.00); mergeEffect(effectsMap, "피증", 0.60); mergeEffect(effectsMap, "잠식 스킬 피증", 0.60); break;
            }
        }
    }

    //죽음의 부메랑
    private void calcDeathBoomerang(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "스피닝 웨폰 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "스피닝 웨폰 스킬 피증", 8.00); mergeEffect(effectsMap, "크루얼 커터 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "스피닝 웨폰 스킬 피증", 8.00); mergeEffect(effectsMap, "크루얼 커터 스킬 피증", 10.00); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 8.00); break;
                case 18: mergeEffect(effectsMap, "스피닝 웨폰 스킬 피증", 8.00); mergeEffect(effectsMap, "크루얼 커터 스킬 피증", 10.00); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 8.00);  mergeEffect(effectsMap, "피증", 0.20); mergeEffect(effectsMap, "잠식 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "스피닝 웨폰 스킬 피증", 8.00); mergeEffect(effectsMap, "크루얼 커터 스킬 피증", 10.00); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 8.00);  mergeEffect(effectsMap, "피증", 0.40); mergeEffect(effectsMap, "잠식 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "스피닝 웨폰 스킬 피증", 8.00); mergeEffect(effectsMap, "크루얼 커터 스킬 피증", 10.00); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 8.00);  mergeEffect(effectsMap, "피증", 0.60); mergeEffect(effectsMap, "잠식 스킬 피증", 0.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "스피닝 웨폰 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "스피닝 웨폰 스킬 피증", 8.00); mergeEffect(effectsMap, "크루얼 커터 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "스피닝 웨폰 스킬 피증", 8.00); mergeEffect(effectsMap, "크루얼 커터 스킬 피증", 10.00); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 8.00); mergeEffect(effectsMap, "피증", 1.00); break;
                case 18: mergeEffect(effectsMap, "스피닝 웨폰 스킬 피증", 8.00); mergeEffect(effectsMap, "크루얼 커터 스킬 피증", 10.00); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 8.00);  mergeEffect(effectsMap, "피증", 1.20); mergeEffect(effectsMap, "잠식 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "스피닝 웨폰 스킬 피증", 8.00); mergeEffect(effectsMap, "크루얼 커터 스킬 피증", 10.00); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 8.00);  mergeEffect(effectsMap, "피증", 1.40); mergeEffect(effectsMap, "잠식 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "스피닝 웨폰 스킬 피증", 8.00); mergeEffect(effectsMap, "크루얼 커터 스킬 피증", 10.00); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 8.00);  mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "잠식 스킬 피증", 0.60); break;
            }
        }
    }

    //파괴 광선
    private void calcDestructionBeam(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "데몬 비전 스킬 즉시 방출 트라이포드 피증", 215.00); break;
                case 14: mergeEffect(effectsMap, "데몬 비전 스킬 즉시 방출 트라이포드 피증", 215.00); mergeEffect(effectsMap, "데시메이트 스킬 치적", 50.00); break; // 치명타 적중률 제외
                case 17: mergeEffect(effectsMap, "데몬 비전 스킬 즉시 방출 트라이포드 피증", 215.00);  mergeEffect(effectsMap, "데시메이트 스킬 치적", 50.00); mergeEffect(effectsMap, "데몬 그랩 스킬 피증", 10.00); mergeEffect(effectsMap, "피어스 쏜 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "데몬 비전 스킬 즉시 방출 트라이포드 피증", 215.00); mergeEffect(effectsMap, "데시메이트 스킬 치적", 50.00); mergeEffect(effectsMap, "데몬 그랩 스킬 피증", 10.00);mergeEffect(effectsMap, "피어스 쏜 스킬 피증", 10.00); mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "잠식 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "데몬 비전 스킬 즉시 방출 트라이포드 피증", 215.00); mergeEffect(effectsMap, "데시메이트 스킬 치적", 50.00); mergeEffect(effectsMap, "데몬 그랩 스킬 피증", 10.00); mergeEffect(effectsMap, "피어스 쏜 스킬 피증", 10.00); mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "잠식 스킬 피증", 0.40); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "데몬 비전 스킬 즉시 방출 트라이포드 피증", 215.00); break;
                case 14: mergeEffect(effectsMap, "데몬 비전 스킬 즉시 방출 트라이포드 피증", 215.00); mergeEffect(effectsMap, "데시메이트 스킬 치적", 50.00); break; // 치명타 적중률 제외
                case 17: mergeEffect(effectsMap, "데몬 비전 스킬 즉시 방출 트라이포드 피증", 215.00);  mergeEffect(effectsMap, "데시메이트 스킬 치적", 50.00); mergeEffect(effectsMap, "데몬 그랩 스킬 피증", 10.00); mergeEffect(effectsMap, "피어스 쏜 스킬 피증", 10.00); mergeEffect(effectsMap, "잠식 스킬 피증", 1.00); break;
                case 18: mergeEffect(effectsMap, "데몬 비전 스킬 즉시 방출 트라이포드 피증", 215.00); mergeEffect(effectsMap, "데시메이트 스킬 치적", 50.00); mergeEffect(effectsMap, "데몬 그랩 스킬 피증", 10.00);mergeEffect(effectsMap, "피어스 쏜 스킬 피증", 10.00); mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "잠식 스킬 피증", 1.20); break;
                case 19: mergeEffect(effectsMap, "데몬 비전 스킬 즉시 방출 트라이포드 피증", 215.00); mergeEffect(effectsMap, "데시메이트 스킬 치적", 50.00); mergeEffect(effectsMap, "데몬 그랩 스킬 피증", 10.00); mergeEffect(effectsMap, "피어스 쏜 스킬 피증", 10.00); mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "잠식 스킬 피증", 1.40); break;
            }
        }
    }
}
