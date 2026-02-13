package com.jinouk.lostark.simulator.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class equipmentsDto {
    private int quality;           // 품질 (100)
    private int level;             // 재련 레벨 (25)
    private int tier;              // 티어 (4)
    private int advancedReinforce; // 상급 재련 (20)

}
