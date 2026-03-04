package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.demonic;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DemonicMoon implements IArkGrid {
    @Override
    public String getClassName() {
        return "데모닉";
    }

    @Override
    public String getArkGridCoreName() {
        return "질서의 달 코어";
    }

    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;

            /*
            if ("스트림 오브 엣지".equals(name)) {
                calcStreamOfEdge(effectsMap, point, grade);
            } else if ("페이탈 핸드".equals(name)) {
                calcFatalHand(effectsMap, point, grade);
            }

             */
        });

        for (Map.Entry<String, Double> entry : effectsMap.entrySet()) {
            String key = entry.getKey();
            double value = entry.getValue();
            System.out.println(key + ": " + value);
        }
        return new ArkGridResponseDto(effectsMap);
    }
}
