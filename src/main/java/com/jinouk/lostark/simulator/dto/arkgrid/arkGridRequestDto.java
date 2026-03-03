package com.jinouk.lostark.simulator.dto.arkgrid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class arkGridRequestDto {
    private String characterName;
    private String className;
    private List<GridItem> ariGridItems;

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
