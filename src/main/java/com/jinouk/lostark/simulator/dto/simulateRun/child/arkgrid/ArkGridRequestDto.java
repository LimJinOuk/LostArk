package com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArkGridRequestDto {
    private String characterName;
    private String className;
    private List<GridItem> arkGridItems;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GridItem {
        private String arkGridCoreName;
        private String arkGridName;
        private String grade;
        private Integer arkGridPoint;
    }
}
