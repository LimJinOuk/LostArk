package com.jinouk.lostark.simulator.dto.simulateRun.child;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class accessoriesDto {

    private Map<String, AccessoryItem> accessories;
    private BraceletItem bracelet;

    @Data
    public static class AccessoryItem {
        private String accStats;
        private Integer currentStat;
        private Map<String, Effect> effects;
    }
    @Data
    public static class BraceletItem {
        private Map<String, String> baseStats;
        private Map<String, Effect> effects;
    }

    @Data
    public static class Effect {
        private String name;
        private Double value;
    }
}
