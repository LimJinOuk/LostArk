package com.jinouk.lostark.simulator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ariGridDto {
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
