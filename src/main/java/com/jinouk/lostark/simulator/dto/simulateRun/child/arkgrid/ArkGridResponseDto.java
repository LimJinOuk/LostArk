package com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class ArkGridResponseDto {
    private Map<String, Double> effects;
}
