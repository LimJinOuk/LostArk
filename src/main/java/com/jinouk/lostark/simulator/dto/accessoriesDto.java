package com.jinouk.lostark.simulator.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class accessoriesDto {

    private Map<String, AccessoryItem> accessories;
    private BraceletItem bracelet;

    @Data
    public static class AccessoryItem {
        private String accStats;
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
        private Object value;
    }
}
