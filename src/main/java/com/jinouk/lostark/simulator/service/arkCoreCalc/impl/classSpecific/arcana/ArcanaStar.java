package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.arcana;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArcanaStar extends AbstractArkGrid {

    @Override
    public String getClassName() {
        return "아르카나";
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

            if ("스트림 오브 엣지".equals(name)) {
                calcStreamOfEdge(effectsMap, point, grade);
            } else if ("페이탈 핸드".equals(name)) {
                calcFatalHand(effectsMap, point, grade);
            } else if ("루인 마이너셋".equals(name)) {
                calcRuin(effectsMap,point,grade);
            } else if ("다크 콜렉션".equals(name)) {
                calcDarkCollection(effectsMap,point,grade);
            } else if ("셔플 댄스".equals(name)) {
                calcShuffleDance(effectsMap,point,grade);
            } else if ("스피드 메이트".equals(name)) {
                calcSpeedMate(effectsMap,point,grade);
            }
        });

        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    // --- 스트림 오브 엣지 계산 로직 ---
    private void calcStreamOfEdge(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "셀레스티얼 레인 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "셀레스티얼 레인 스킬 피증", 8.00); mergeEffect(effectsMap, "스트림 오브 엣지 스킬 다크니스 엣지 트라이포드 치피증", 1.60); break;
                case 18: mergeEffect(effectsMap, "셀레스티얼 레인 스킬 피증", 8.80); mergeEffect(effectsMap, "스트림 오브 엣지 스킬 다크니스 엣지 트라이포드 치피증", 1.60); break;
                case 19: mergeEffect(effectsMap, "셀레스티얼 레인 스킬 피증", 9.60); mergeEffect(effectsMap, "스트림 오브 엣지 스킬 다크니스 엣지 트라이포드 치피증", 1.60); break;
                case 20: mergeEffect(effectsMap, "셀레스티얼 레인 스킬 피증", 10.40); mergeEffect(effectsMap, "스트림 오브 엣지 스킬 다크니스 엣지 트라이포드 치피증", 1.60); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "셀레스티얼 레인 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "셀레스티얼 레인 스킬 피증", 8.00); mergeEffect(effectsMap, "스트림 오브 엣지 스킬 다크니스 엣지 트라이포드 치피증", 2.20); break;
                case 18: mergeEffect(effectsMap, "셀레스티얼 레인 스킬 피증", 8.80); mergeEffect(effectsMap, "스트림 오브 엣지 스킬 다크니스 엣지 트라이포드 치피증", 2.20); break;
                case 19: mergeEffect(effectsMap, "셀레스티얼 레인 스킬 피증", 9.60); mergeEffect(effectsMap, "스트림 오브 엣지 스킬 다크니스 엣지 트라이포드 치피증", 2.20); break;
                case 20: mergeEffect(effectsMap, "셀레스티얼 레인 스킬 피증", 10.40); mergeEffect(effectsMap, "스트림 오브 엣지 스킬 다크니스 엣지 트라이포드 치피증", 2.20); break;
            }
        }
    }

    // --- 페이탈 핸드 계산 로직 ---
    private void calcFatalHand(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "도태 카드 치피증", 20.00);  break;
                case 17: mergeEffect(effectsMap, "도태 카드 치피증", 20.00);  break;
                case 18: mergeEffect(effectsMap, "도태 카드 치피증", 20.00); mergeEffect(effectsMap, "루인 스킬 피증", 0.15); break;
                case 19: mergeEffect(effectsMap, "도태 카드 치피증", 20.00); mergeEffect(effectsMap, "루인 스킬 피증", 0.15); break;
                case 20: mergeEffect(effectsMap, "도태 카드 치피증", 20.00); mergeEffect(effectsMap, "루인 스킬 피증", 0.15); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "도태 카드 치피증", 20.00);  break;
                case 17: mergeEffect(effectsMap, "도태 카드 치피증", 20.00);  break;
                case 18: mergeEffect(effectsMap, "도태 카드 치피증", 20.00); mergeEffect(effectsMap, "루인 스킬 피증", 0.15); break;
                case 19: mergeEffect(effectsMap, "도태 카드 치피증", 20.00); mergeEffect(effectsMap, "루인 스킬 피증", 0.15); break;
                case 20: mergeEffect(effectsMap, "도태 카드 치피증", 20.00); mergeEffect(effectsMap, "루인 스킬 피증", 0.15); break;
            }
        }
    }

    //루인 마이너셋
    private void calcRuin(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "세렌디피티 스킬 피증", 20.00);  break;
                case 17: mergeEffect(effectsMap, "세렌디피티 스킬 피증", 20.00); mergeEffect(effectsMap, "포카드 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "세렌디피티 스킬 피증", 20.00); mergeEffect(effectsMap, "포카드 스킬 피증", 22.00); break;
                case 19: mergeEffect(effectsMap, "세렌디피티 스킬 피증", 20.00); mergeEffect(effectsMap, "포카드 스킬 피증", 24.00); break;
                case 20: mergeEffect(effectsMap, "세렌디피티 스킬 피증", 20.00); mergeEffect(effectsMap, "포카드 스킬 피증", 26.00); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "세렌디피티 스킬 피증", 20.00);  break;
                case 17: mergeEffect(effectsMap, "세렌디피티 스킬 피증", 20.00); mergeEffect(effectsMap, "포카드 스킬 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "세렌디피티 스킬 피증", 20.00); mergeEffect(effectsMap, "포카드 스킬 피증", 32.00); break;
                case 19: mergeEffect(effectsMap, "세렌디피티 스킬 피증", 20.00); mergeEffect(effectsMap, "포카드 스킬 피증", 34.00); break;
                case 20: mergeEffect(effectsMap, "세렌디피티 스킬 피증", 20.00); mergeEffect(effectsMap, "포카드 스킬 피증", 36.00); break;
            }
        }
    }

    //다크 콜렉션
    private void calcDarkCollection(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "다크리저렉션 스킬 피증", 6.00); mergeEffect(effectsMap, "다크리저렉션 스킬 죽음의 공포 트라이포드 중독 피증", 70.00); break;
                case 14: mergeEffect(effectsMap, "다크리저렉션 스킬 피증", 6.00); mergeEffect(effectsMap, "다크리저렉션 스킬 죽음의 공포 트라이포드 중독 피증", 70.00);break;
                case 17: mergeEffect(effectsMap, "다크리저렉션 스킬 피증", 6.00); mergeEffect(effectsMap, "다크리저렉션 스킬 죽음의 공포 트라이포드 중독 피증", 70.00);mergeEffect(effectsMap, "이보크 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "다크리저렉션 스킬 피증", 6.00); mergeEffect(effectsMap, "다크리저렉션 스킬 죽음의 공포 트라이포드 중독 피증", 70.00); mergeEffect(effectsMap, "이보크 스킬 피증", 16.50); break;
                case 19: mergeEffect(effectsMap, "다크리저렉션 스킬 피증", 6.00); mergeEffect(effectsMap, "다크리저렉션 스킬 죽음의 공포 트라이포드 중독 피증", 70.00); mergeEffect(effectsMap, "이보크 스킬 피증", 18.00); break;
                case 20: mergeEffect(effectsMap, "다크리저렉션 스킬 피증", 6.00); mergeEffect(effectsMap, "다크리저렉션 스킬 죽음의 공포 트라이포드 중독 피증", 70.00); mergeEffect(effectsMap, "이보크 스킬 피증", 19.50); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10:  mergeEffect(effectsMap, "다크리저렉션 스킬 피증", 6.00); mergeEffect(effectsMap, "다크리저렉션 스킬 죽음의 공포 트라이포드 중독 피증", 70.00);break;
                case 14: mergeEffect(effectsMap, "다크리저렉션 스킬 피증", 6.00);  mergeEffect(effectsMap, "다크리저렉션 스킬 죽음의 공포 트라이포드 중독 피증", 70.00);break;
                case 17: mergeEffect(effectsMap, "다크리저렉션 스킬 피증", 6.00); mergeEffect(effectsMap, "다크리저렉션 스킬 죽음의 공포 트라이포드 중독 피증", 70.00);mergeEffect(effectsMap, "이보크 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "다크리저렉션 스킬 피증", 6.00); mergeEffect(effectsMap, "다크리저렉션 스킬 죽음의 공포 트라이포드 중독 피증", 70.00);mergeEffect(effectsMap, "이보크 스킬 피증", 21.50); break;
                case 19: mergeEffect(effectsMap, "다크리저렉션 스킬 피증", 6.00); mergeEffect(effectsMap, "다크리저렉션 스킬 죽음의 공포 트라이포드 중독 피증", 70.00);mergeEffect(effectsMap, "이보크 스킬 피증", 23.00); break;
                case 20: mergeEffect(effectsMap, "다크리저렉션 스킬 피증", 6.00); mergeEffect(effectsMap, "다크리저렉션 스킬 죽음의 공포 트라이포드 중독 피증", 70.00);mergeEffect(effectsMap, "이보크 스킬 피증", 24.50); break;
            }
        }
    }

    //셔플 댄스
    private void calcShuffleDance(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 페이크 플립 트라이포드 치명적 가시 피증", 130.00); break;
                case 14: mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 페이크 플립 트라이포드 치명적 가시 피증", 260.00); break;
                case 17: mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 페이크 플립 트라이포드 치명적 가시 피증", 260.00); mergeEffect(effectsMap, "언리미티드 스킬 피증", 90.00); break;
                case 18: mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 페이크 플립 트라이포드 치명적 가시 피증", 260.00); mergeEffect(effectsMap, "언리미티드 스킬 피증", 90.00); mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 피증", 1.60); break;
                case 19: mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 페이크 플립 트라이포드 치명적 가시 피증", 260.00); mergeEffect(effectsMap, "언리미티드 스킬 피증", 90.00); mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 피증", 3.20); break;
                case 20: mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 페이크 플립 트라이포드 치명적 가시 피증", 260.00); mergeEffect(effectsMap, "언리미티드 스킬 피증", 90.00); mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 피증", 4.80); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 페이크 플립 트라이포드 치명적 가시 피증", 130.00); break;
                case 14: mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 페이크 플립 트라이포드 치명적 가시 피증", 260.00); break;
                case 17: mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 페이크 플립 트라이포드 치명적 가시 피증", 260.00); mergeEffect(effectsMap, "언리미티드 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 페이크 플립 트라이포드 치명적 가시 피증", 260.00); mergeEffect(effectsMap, "언리미티드 스킬 피증", 100.00); mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 피증", 1.60); break;
                case 19: mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 페이크 플립 트라이포드 치명적 가시 피증", 260.00); mergeEffect(effectsMap, "언리미티드 스킬 피증", 100.00); mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 피증", 3.20); break;
                case 20: mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 페이크 플립 트라이포드 치명적 가시 피증", 260.00); mergeEffect(effectsMap, "언리미티드 스킬 피증", 100.00); mergeEffect(effectsMap, "댄싱 오브 스파인플라워 스킬 피증", 4.80); break;
            }
        }
    }

    //스피드 메이트
    private void calcSpeedMate(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "이보크 스킬 마나 중독 피증", 100.00); break;
                case 17: mergeEffect(effectsMap, "이보크 스킬 마나 중독 피증", 100.00); mergeEffect(effectsMap, "이보크 스킬 마나 중독 트라이포드 중독 피증", 100.00); mergeEffect(effectsMap, "체크메이트 스킬 피증", 16.00); break;
                case 18: mergeEffect(effectsMap, "이보크 스킬 마나 중독 피증", 100.00); mergeEffect(effectsMap, "이보크 스킬 마나 중독 트라이포드 중독 피증", 100.00); mergeEffect(effectsMap, "체크메이트 스킬 피증", 16.80); break;
                case 19: mergeEffect(effectsMap, "이보크 스킬 마나 중독 피증", 100.00); mergeEffect(effectsMap, "이보크 스킬 마나 중독 트라이포드 중독 피증", 100.00); mergeEffect(effectsMap, "체크메이트 스킬 피증", 17.60); break;
                case 20: mergeEffect(effectsMap, "이보크 스킬 마나 중독 피증", 100.00); mergeEffect(effectsMap, "이보크 스킬 마나 중독 트라이포드 중독 피증", 100.00); mergeEffect(effectsMap, "체크메이트 스킬 피증", 18.40); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "이보크 스킬 마나 중독 피증", 100.00); break;
                case 17: mergeEffect(effectsMap, "이보크 스킬 마나 중독 피증", 100.00); mergeEffect(effectsMap, "이보크 스킬 마나 중독 트라이포드 중독 피증", 100.00); mergeEffect(effectsMap, "체크메이트 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "이보크 스킬 마나 중독 피증", 100.00); mergeEffect(effectsMap, "이보크 스킬 마나 중독 트라이포드 중독 피증", 100.00); mergeEffect(effectsMap, "체크메이트 스킬 피증", 20.80); break;
                case 19: mergeEffect(effectsMap, "이보크 스킬 마나 중독 피증", 100.00); mergeEffect(effectsMap, "이보크 스킬 마나 중독 트라이포드 중독 피증", 100.00); mergeEffect(effectsMap, "체크메이트 스킬 피증", 21.60); break;
                case 20: mergeEffect(effectsMap, "이보크 스킬 마나 중독 피증", 100.00); mergeEffect(effectsMap, "이보크 스킬 마나 중독 트라이포드 중독 피증", 100.00); mergeEffect(effectsMap, "체크메이트 스킬 피증", 22.40); break;
            }
        }
    }
}