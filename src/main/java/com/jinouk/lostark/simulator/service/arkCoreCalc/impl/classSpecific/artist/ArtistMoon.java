package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.artist;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArtistMoon extends AbstractArkGrid{
    @Override
    public String getClassName() {
        return "도화가";
    }

    @Override
    public String getArkGridCoreName() {
        return "질서의 달 코어";
    }

    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        validateItems(requestDto);

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
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }
}
