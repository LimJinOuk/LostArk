package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.gunSilinger;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GunSilingerStar extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "건슬링어";
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

            if ("올라운더".equals(name)) {
                calcAllRounder(effectsMap, point, grade);
            } else if ("블로우 백".equals(name)) {
                calcBlowBack(effectsMap, point, grade);
            } else if ("핀포인트".equals(name)) {
                calcPinpoint(effectsMap, point, grade);
            } else if ("정밀 타격".equals(name)) {
                calcPrecisionStrike(effectsMap, point, grade);
            } else if ("풀 매거진".equals(name)) {
                calcFullMagazine(effectsMap, point, grade);
            } else if ("힐 스트라이크".equals(name)) {
                calcHeelStrike(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //올라운더
    private void calcAllRounder(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00);
                    break;
                case 14:
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00);
                    mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 9.00);
                    break;
                case 17:
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00);
                    mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 9.00);
                    mergeEffect(effectsMap, "포커스 샷 스킬 피증", 13.00);
                    break;
                case 18:
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00);
                    mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 9.00);
                    mergeEffect(effectsMap, "포커스 샷 스킬 피증", 14.00);
                    break;
                case 19:
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00);
                    mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 9.00);
                    mergeEffect(effectsMap, "포커스 샷 스킬 피증", 15.00);
                    break;
                case 20:
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00);
                    mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 9.00);
                    mergeEffect(effectsMap, "포커스 샷 스킬 피증", 16.00);
                    break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00);
                    break;
                case 14:
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00);
                    mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 9.00);
                    break;
                case 17:
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00);
                    mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 9.00);
                    mergeEffect(effectsMap, "포커스 샷 스킬 피증", 19.00);
                    break;
                case 18:
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00);
                    mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 9.00);
                    mergeEffect(effectsMap, "포커스 샷 스킬 피증", 20.00);
                    break;
                case 19:
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00);
                    mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 9.00);
                    mergeEffect(effectsMap, "포커스 샷 스킬 피증", 21.00);
                    break;
                case 20:
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00);
                    mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 9.00);
                    mergeEffect(effectsMap, "포커스 샷 스킬 피증", 22.00);
                    break;
            }
        }
    }

    //블로우 백
    private void calcBlowBack(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "샷건 연사 스킬 피증", 14.00);
                    break;
                case 14:
                    mergeEffect(effectsMap, "샷건 연사 스킬 피증", 18.00);
                    break; // 14.0 + 4.0
                case 17:
                    mergeEffect(effectsMap, "샷건 연사 스킬 피증", 18.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 반동 회피 트라이포드 피증", 45.00);
                    break;
                case 18:
                    mergeEffect(effectsMap, "샷건 연사 스킬 피증", 18.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 반동 회피 트라이포드 피증", 45.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 1.00);
                    break;
                case 19:
                    mergeEffect(effectsMap, "샷건 연사 스킬 피증", 18.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 반동 회피 트라이포드 피증", 45.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 2.00);
                    break;
                case 20:
                    mergeEffect(effectsMap, "샷건 연사 스킬 피증", 18.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 반동 회피 트라이포드 피증", 45.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 3.00);
                    break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "샷건 연사 스킬 피증", 14.00);
                    break;
                case 14:
                    mergeEffect(effectsMap, "샷건 연사 스킬 피증", 18.00);
                    break; // 14.0 + 4.0
                case 17:
                    mergeEffect(effectsMap, "샷건 연사 스킬 피증", 18.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 반동 회피 트라이포드 피증", 55.00);
                    break;
                case 18:
                    mergeEffect(effectsMap, "샷건 연사 스킬 피증", 18.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 반동 회피 트라이포드 피증", 55.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 1.00);
                    break;
                case 19:
                    mergeEffect(effectsMap, "샷건 연사 스킬 피증", 18.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 반동 회피 트라이포드 피증", 55.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 2.00);
                    break;
                case 20:
                    mergeEffect(effectsMap, "샷건 연사 스킬 피증", 18.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 반동 회피 트라이포드 피증", 55.00);
                    mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 3.00);
                    break;
            }
        }
    }

    //핀포인트
    private void calcPinpoint(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 5.00);
                    break;
                case 14:
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 5.00);
                    mergeEffect(effectsMap, "타겟 다운 스킬 치피증", 20.00);
                    break;
                case 17:
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 63.00);
                    mergeEffect(effectsMap, "타겟 다운 스킬 치피증", 20.00);
                    break; // 5.0 + 58.0
                case 18:
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 63.60);
                    mergeEffect(effectsMap, "타겟 다운 스킬 치피증", 20.00);
                    break;
                case 19:
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 64.20);
                    mergeEffect(effectsMap, "타겟 다운 스킬 치피증", 20.00);
                    break;
                case 20:
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 64.80);
                    mergeEffect(effectsMap, "타겟 다운 스킬 치피증", 20.00);
                    break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 5.00);
                    break;
                case 14:
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 5.00);
                    mergeEffect(effectsMap, "타겟 다운 스킬 치피증", 20.00);
                    break;
                case 17:
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 68.00);
                    mergeEffect(effectsMap, "타겟 다운 스킬 치피증", 20.00);
                    break; // 5.0 + 58.0
                case 18:
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 68.60);
                    mergeEffect(effectsMap, "타겟 다운 스킬 치피증", 20.00);
                    break;
                case 19:
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 69.20);
                    mergeEffect(effectsMap, "타겟 다운 스킬 치피증", 20.00);
                    break;
                case 20:
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 69.80);
                    mergeEffect(effectsMap, "타겟 다운 스킬 치피증", 20.00);
                    break;
            }
        }
    }

    //정밀 타격
    private void calcPrecisionStrike(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "라이플 스킬 피증", 1.30);
                    break;
                case 14:
                    mergeEffect(effectsMap, "라이플 스킬 피증", 1.30);
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 16.00);
                    break;
                case 17:
                    mergeEffect(effectsMap, "라이플 스킬 피증", 1.30);
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 16.00);
                    mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 6.50);
                    break;
                case 18:
                    mergeEffect(effectsMap, "라이플 스킬 피증", 1.48);
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 16.00);
                    mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 6.50);
                    break;
                case 19:
                    mergeEffect(effectsMap, "라이플 스킬 피증", 1.66);
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 16.00);
                    mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 6.50);
                    break;
                case 20:
                    mergeEffect(effectsMap, "라이플 스킬 피증", 1.84);
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 16.00);
                    mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 6.50);
                    break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "라이플 스킬 피증", 1.30);
                    break;
                case 14:
                    mergeEffect(effectsMap, "라이플 스킬 피증", 1.30);
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 16.00);
                    break;
                case 17:
                    mergeEffect(effectsMap, "라이플 스킬 피증", 1.30);
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 16.00);
                    mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 9.00);
                    break;
                case 18:
                    mergeEffect(effectsMap, "라이플 스킬 피증", 1.48);
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 16.00);
                    mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 9.00);
                    break;
                case 19:
                    mergeEffect(effectsMap, "라이플 스킬 피증", 1.66);
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 16.00);
                    mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 9.00);
                    break;
                case 20:
                    mergeEffect(effectsMap, "라이플 스킬 피증", 1.84);
                    mergeEffect(effectsMap, "타겟 다운 스킬 피증", 16.00);
                    mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 9.00);
                    break;
            }
        }
    }

    //풀 매거진
    private void calcFullMagazine(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 8.00);
                    break;
                case 14:
                    mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 130.00);
                    break; // 8.0 + 122.0
                case 17:
                    mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 145.00);
                    break; // 130.0 + 15.0
                case 18:
                    mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 145.60);
                    break;
                case 19:
                    mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 146.20);
                    break;
                case 20:
                    mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 146.80);
                    break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 8.00);
                    break;
                case 14:
                    mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 130.00);
                    break; // 8.0 + 122.0
                case 17:
                    mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 153.00);
                    break; // 130.0 + 15.0
                case 18:
                    mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 153.60);
                    break;
                case 19:
                    mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 154.20);
                    break;
                case 20:
                    mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 154.80);
                    break;
            }
        }
    }

    //힐 스트라이크
    private void calcHeelStrike(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "피스키퍼 스킬 피증", 10.00);
                    break;
                case 14:
                    mergeEffect(effectsMap, "피스키퍼 스킬 피증", 10.00);
                    mergeEffect(effectsMap, "피스키퍼 스킬 기절 효과 트라이포드 피증", 148.00);
                    break;
                case 17:
                    mergeEffect(effectsMap, "피스키퍼 스킬 피증", 10.00);
                    mergeEffect(effectsMap, "피스키퍼 스킬 기절 효과 트라이포드 피증", 148.00);
                    mergeEffect(effectsMap, "피스키퍼 스킬 케나인 CQC 트라이포드 피증", 20.00);
                    break;
                case 18:
                    mergeEffect(effectsMap, "피스키퍼 스킬 피증", 10.60);
                    mergeEffect(effectsMap, "피스키퍼 스킬 기절 효과 트라이포드 피증", 148.00);
                    mergeEffect(effectsMap, "피스키퍼 스킬 케나인 CQC 트라이포드 피증", 20.00);
                    break;
                case 19:
                    mergeEffect(effectsMap, "피스키퍼 스킬 피증", 11.20);
                    mergeEffect(effectsMap, "피스키퍼 스킬 기절 효과 트라이포드 피증", 148.00);
                    mergeEffect(effectsMap, "피스키퍼 스킬 케나인 CQC 트라이포드 피증", 20.00);
                    break;
                case 20:
                    mergeEffect(effectsMap, "피스키퍼 스킬 피증", 11.80);
                    mergeEffect(effectsMap, "피스키퍼 스킬 기절 효과 트라이포드 피증", 148.00);
                    mergeEffect(effectsMap, "피스키퍼 스킬 케나인 CQC 트라이포드 피증", 20.00);
                    break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "피스키퍼 스킬 피증", 10.00);
                    break;
                case 14:
                    mergeEffect(effectsMap, "피스키퍼 스킬 피증", 10.00);
                    mergeEffect(effectsMap, "피스키퍼 스킬 기절 효과 트라이포드 피증", 148.00);
                    break;
                case 17:
                    mergeEffect(effectsMap, "피스키퍼 스킬 피증", 10.00);
                    mergeEffect(effectsMap, "피스키퍼 스킬 기절 효과 트라이포드 피증", 148.00);
                    mergeEffect(effectsMap, "피스키퍼 스킬 케나인 CQC 트라이포드 피증", 25.00);
                    break;
                case 18:
                    mergeEffect(effectsMap, "피스키퍼 스킬 피증", 10.60);
                    mergeEffect(effectsMap, "피스키퍼 스킬 기절 효과 트라이포드 피증", 148.00);
                    mergeEffect(effectsMap, "피스키퍼 스킬 케나인 CQC 트라이포드 피증", 25.00);
                    break;
                case 19:
                    mergeEffect(effectsMap, "피스키퍼 스킬 피증", 11.20);
                    mergeEffect(effectsMap, "피스키퍼 스킬 기절 효과 트라이포드 피증", 148.00);
                    mergeEffect(effectsMap, "피스키퍼 스킬 케나인 CQC 트라이포드 피증", 25.00);
                    break;
                case 20:
                    mergeEffect(effectsMap, "피스키퍼 스킬 피증", 11.80);
                    mergeEffect(effectsMap, "피스키퍼 스킬 기절 효과 트라이포드 피증", 148.00);
                    mergeEffect(effectsMap, "피스키퍼 스킬 케나인 CQC 트라이포드 피증", 25.00);
                    break;
            }
        }
    }
}
