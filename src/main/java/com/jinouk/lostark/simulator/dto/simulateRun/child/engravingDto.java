package com.jinouk.lostark.simulator.dto.simulateRun.child;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class engravingDto {
    private String characterName;
    private List<engravingsList> engravings;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class engravingsList {
        private String name;
        private String grade;
        private Integer level;
        private Integer abilityStoneLevel;
    }
}
