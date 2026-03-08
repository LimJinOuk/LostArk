package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.sorceress;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SorceressStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "소서리스";
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


            if ("원소의 잔향".equals(name)) {
                calcElementalResonance(effectsMap, point, grade);
            } else if ("삼중 파동".equals(name)) {
                calcTripleWave(effectsMap, point, grade);
            } else if ("종말의 시".equals(name)) {
                calcPoemOfApocalypse(effectsMap, point, grade);
            } else if ("화뇌".equals(name)) {
                calcFireThunder(effectsMap, point, grade);
            } else if ("무결".equals(name)) {
                calcFlawless(effectsMap, point, grade);
            } else if ("청뢰".equals(name)) {
                calcBlueThunder(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //원소의 잔향
    private void calcElementalResonance(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "인페르노 스킬 피증", 20.00); break;
                case 14: mergeEffect(effectsMap, "인페르노 스킬 피증", 20.00); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 20.00); break; // 시전 속도 제외
                case 17: mergeEffect(effectsMap, "인페르노 스킬 피증", 20.00); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 20.00);  mergeEffect(effectsMap, "아이스 애로우 스킬 강인함 트라이포드 피증", 76.00); break; // 기존 20.0 + 신규 76.0 (쿨감 제외)
                case 18: mergeEffect(effectsMap, "인페르노 스킬 피증", 24.00); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 20.00); mergeEffect(effectsMap, "아이스 애로우 스킬 강인함 트라이포드 피증", 76.00); break;
                case 19: mergeEffect(effectsMap, "인페르노 스킬 피증", 28.00); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 20.00); mergeEffect(effectsMap, "아이스 애로우 스킬 강인함 트라이포드 피증", 76.00); break;
                case 20: mergeEffect(effectsMap, "인페르노 스킬 피증", 32.00); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 20.00); mergeEffect(effectsMap, "아이스 애로우 스킬 강인함 트라이포드 피증", 76.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "인페르노 스킬 피증", 20.00); break;
                case 14: mergeEffect(effectsMap, "인페르노 스킬 피증", 20.00); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 20.00); break; // 시전 속도 제외
                case 17: mergeEffect(effectsMap, "인페르노 스킬 피증", 20.00); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 20.00);  mergeEffect(effectsMap, "아이스 애로우 스킬 강인함 트라이포드 피증", 92.00); break; // 기존 20.0 + 신규 76.0 (쿨감 제외)
                case 18: mergeEffect(effectsMap, "인페르노 스킬 피증", 24.00); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 20.00); mergeEffect(effectsMap, "아이스 애로우 스킬 강인함 트라이포드 피증", 92.00); break;
                case 19: mergeEffect(effectsMap, "인페르노 스킬 피증", 28.00); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 20.00); mergeEffect(effectsMap, "아이스 애로우 스킬 강인함 트라이포드 피증", 92.00); break;
                case 20: mergeEffect(effectsMap, "인페르노 스킬 피증", 32.00); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 20.00); mergeEffect(effectsMap, "아이스 애로우 스킬 강인함 트라이포드 피증", 92.00); break;
            }
        }
    }

    //삼중 파동
    private void calcTripleWave(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 쿨감 제외
                case 14: mergeEffect(effectsMap, "익스플로전 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "익스플로전 스킬 피증", 8.00); mergeEffect(effectsMap, "천벌 스킬 피증", 9.00); break;
                case 18: mergeEffect(effectsMap, "익스플로전 스킬 피증", 8.70); mergeEffect(effectsMap, "천벌 스킬 피증", 9.00); break;
                case 19: mergeEffect(effectsMap, "익스플로전 스킬 피증", 9.40); mergeEffect(effectsMap, "천벌 스킬 피증", 9.00); break;
                case 20: mergeEffect(effectsMap, "익스플로전 스킬 피증", 10.10); mergeEffect(effectsMap, "천벌 스킬 피증", 9.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 쿨감 제외
                case 14: mergeEffect(effectsMap, "익스플로전 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "익스플로전 스킬 피증", 8.00); mergeEffect(effectsMap, "천벌 스킬 피증", 13.00); break;
                case 18: mergeEffect(effectsMap, "익스플로전 스킬 피증", 8.70); mergeEffect(effectsMap, "천벌 스킬 피증", 13.00); break;
                case 19: mergeEffect(effectsMap, "익스플로전 스킬 피증", 9.40); mergeEffect(effectsMap, "천벌 스킬 피증", 13.00); break;
                case 20: mergeEffect(effectsMap, "익스플로전 스킬 피증", 10.10); mergeEffect(effectsMap, "천벌 스킬 피증", 13.00); break;
            }
        }
    }

    //종말의 시
    private void calcPoemOfApocalypse(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 캐스팅 속도 제외
                case 14: mergeEffect(effectsMap, "종말의 날 스킬 피증", 3.00); break; // 마나 소모 제외
                case 17: mergeEffect(effectsMap, "종말의 날 스킬 피증", 8.00); break; // 기존 3.0 + 신규 5.0
                case 18: mergeEffect(effectsMap, "종말의 날 스킬 피증", 8.40); break;
                case 19: mergeEffect(effectsMap, "종말의 날 스킬 피증", 8.80); break;
                case 20: mergeEffect(effectsMap, "종말의 날 스킬 피증", 9.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 캐스팅 속도 제외
                case 14: mergeEffect(effectsMap, "종말의 날 스킬 피증", 3.00); break; // 마나 소모 제외
                case 17: mergeEffect(effectsMap, "종말의 날 스킬 피증", 10.00); break; // 기존 3.0 + 신규 5.0
                case 18: mergeEffect(effectsMap, "종말의 날 스킬 피증", 10.40); break;
                case 19: mergeEffect(effectsMap, "종말의 날 스킬 피증", 10.80); break;
                case 20: mergeEffect(effectsMap, "종말의 날 스킬 피증", 11.20); break;
            }
        }
    }

    //화뇌
    private void calcFireThunder(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "천벌 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "천벌 스킬 피증", 8.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 14.00); break; // 쿨감 조건 제외
                case 17: mergeEffect(effectsMap, "천벌 스킬 피증", 24.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 14.00); break; // 기존 8.0 + 신규 16.0
                case 18: mergeEffect(effectsMap, "천벌 스킬 피증", 24.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 15.20); break;
                case 19: mergeEffect(effectsMap, "천벌 스킬 피증", 24.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 16.40); break;
                case 20: mergeEffect(effectsMap, "천벌 스킬 피증", 24.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 17.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "천벌 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "천벌 스킬 피증", 8.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 14.00); break; // 쿨감 조건 제외
                case 17: mergeEffect(effectsMap, "천벌 스킬 피증", 30.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 14.00); break; // 기존 8.0 + 신규 16.0
                case 18: mergeEffect(effectsMap, "천벌 스킬 피증", 30.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 15.20); break;
                case 19: mergeEffect(effectsMap, "천벌 스킬 피증", 30.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 16.40); break;
                case 20: mergeEffect(effectsMap, "천벌 스킬 피증", 30.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 17.60); break;
            }
        }
    }

    //무결
    private void calcFlawless(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "에너지 방출 스킬 에너지 폭격 트라이포드 피증", 250.00); break; // 쿨증 제외
                case 14: mergeEffect(effectsMap, "에너지 방출 스킬 에너지 폭격 트라이포드 피증", 250.00); mergeEffect(effectsMap, "리버스 그래비티 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "에너지 방출 스킬 에너지 폭격 트라이포드 피증", 250.00); mergeEffect(effectsMap, "리버스 그래비티 스킬 피증", 10.00); mergeEffect(effectsMap, "엘리멘탈 리액트 스킬 피증", 16.00); break;
                case 18: mergeEffect(effectsMap, "에너지 방출 스킬 에너지 폭격 트라이포드 피증", 250.00); mergeEffect(effectsMap, "리버스 그래비티 스킬 피증", 10.80); mergeEffect(effectsMap, "엘리멘탈 리액트 스킬 피증", 16.00); break;
                case 19: mergeEffect(effectsMap, "에너지 방출 스킬 에너지 폭격 트라이포드 피증", 250.00); mergeEffect(effectsMap, "리버스 그래비티 스킬 피증", 11.60); mergeEffect(effectsMap, "엘리멘탈 리액트 스킬 피증", 16.00); break;
                case 20: mergeEffect(effectsMap, "에너지 방출 스킬 에너지 폭격 트라이포드 피증", 250.00); mergeEffect(effectsMap, "리버스 그래비티 스킬 피증", 12.40); mergeEffect(effectsMap, "엘리멘탈 리액트 스킬 피증", 16.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "에너지 방출 스킬 에너지 폭격 트라이포드 피증", 250.00); break; // 쿨증 제외
                case 14: mergeEffect(effectsMap, "에너지 방출 스킬 에너지 폭격 트라이포드 피증", 250.00); mergeEffect(effectsMap, "리버스 그래비티 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "에너지 방출 스킬 에너지 폭격 트라이포드 피증", 250.00); mergeEffect(effectsMap, "리버스 그래비티 스킬 피증", 10.00); mergeEffect(effectsMap, "엘리멘탈 리액트 스킬 피증", 22.00); break;
                case 18: mergeEffect(effectsMap, "에너지 방출 스킬 에너지 폭격 트라이포드 피증", 250.00); mergeEffect(effectsMap, "리버스 그래비티 스킬 피증", 10.80); mergeEffect(effectsMap, "엘리멘탈 리액트 스킬 피증", 22.00); break;
                case 19: mergeEffect(effectsMap, "에너지 방출 스킬 에너지 폭격 트라이포드 피증", 250.00); mergeEffect(effectsMap, "리버스 그래비티 스킬 피증", 11.60); mergeEffect(effectsMap, "엘리멘탈 리액트 스킬 피증", 22.00); break;
                case 20: mergeEffect(effectsMap, "에너지 방출 스킬 에너지 폭격 트라이포드 피증", 250.00); mergeEffect(effectsMap, "리버스 그래비티 스킬 피증", 12.40); mergeEffect(effectsMap, "엘리멘탈 리액트 스킬 피증", 22.00); break;
            }
        }
    }

    //청뢰
    private void calcBlueThunder(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이트닝 볼트 스킬 안정화 트라이포드 피증", 60.00); break; // 발사 시간 감소 제외
                case 14: mergeEffect(effectsMap, "라이트닝 볼트 스킬 안정화 트라이포드 피증", 60.00); mergeEffect(effectsMap, "라이트닝 볼트 스킬 피증", 35.00); break; // 쿨증 제외
                case 17: mergeEffect(effectsMap, "라이트닝 볼트 스킬 안정화 트라이포드 피증", 60.00); mergeEffect(effectsMap, "라이트닝 볼트 스킬 피증", 35.00); mergeEffect(effectsMap, "라이트닝 볼트 스킬 치명타 시 피해량 증가", 15.00); break;
                case 18: mergeEffect(effectsMap, "라이트닝 볼트 스킬 안정화 트라이포드 피증", 60.00); mergeEffect(effectsMap, "라이트닝 볼트 스킬 피증", 35.40); mergeEffect(effectsMap, "라이트닝 볼트 스킬 치명타 시 피해량 증가", 15.00); break;
                case 19: mergeEffect(effectsMap, "라이트닝 볼트 스킬 안정화 트라이포드 피증", 60.00); mergeEffect(effectsMap, "라이트닝 볼트 스킬 피증", 35.80); mergeEffect(effectsMap, "라이트닝 볼트 스킬 치명타 시 피해량 증가", 15.00); break;
                case 20: mergeEffect(effectsMap, "라이트닝 볼트 스킬 안정화 트라이포드 피증", 60.00); mergeEffect(effectsMap, "라이트닝 볼트 스킬 피증", 36.20); mergeEffect(effectsMap, "라이트닝 볼트 스킬 치명타 시 피해량 증가", 15.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이트닝 볼트 스킬 안정화 트라이포드 피증", 60.00); break; // 발사 시간 감소 제외
                case 14: mergeEffect(effectsMap, "라이트닝 볼트 스킬 안정화 트라이포드 피증", 60.00); mergeEffect(effectsMap, "라이트닝 볼트 스킬 피증", 35.00); break; // 쿨증 제외
                case 17: mergeEffect(effectsMap, "라이트닝 볼트 스킬 안정화 트라이포드 피증", 60.00); mergeEffect(effectsMap, "라이트닝 볼트 스킬 피증", 35.00); mergeEffect(effectsMap, "라이트닝 볼트 스킬 치명타 시 피해량 증가", 20.00); break;
                case 18: mergeEffect(effectsMap, "라이트닝 볼트 스킬 안정화 트라이포드 피증", 60.00); mergeEffect(effectsMap, "라이트닝 볼트 스킬 피증", 35.40); mergeEffect(effectsMap, "라이트닝 볼트 스킬 치명타 시 피해량 증가", 20.00); break;
                case 19: mergeEffect(effectsMap, "라이트닝 볼트 스킬 안정화 트라이포드 피증", 60.00); mergeEffect(effectsMap, "라이트닝 볼트 스킬 피증", 35.80); mergeEffect(effectsMap, "라이트닝 볼트 스킬 치명타 시 피해량 증가", 20.00); break;
                case 20: mergeEffect(effectsMap, "라이트닝 볼트 스킬 안정화 트라이포드 피증", 60.00); mergeEffect(effectsMap, "라이트닝 볼트 스킬 피증", 36.20); mergeEffect(effectsMap, "라이트닝 볼트 스킬 치명타 시 피해량 증가", 20.00); break;
            }
        }
    }
}
