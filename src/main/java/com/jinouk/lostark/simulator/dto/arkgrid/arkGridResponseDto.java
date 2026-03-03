package com.jinouk.lostark.simulator.dto.arkgrid;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class arkGridResponseDto {
    private Map<String, Double> effects;
}
