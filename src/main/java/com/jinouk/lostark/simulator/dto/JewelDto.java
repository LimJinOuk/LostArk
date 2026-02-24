package com.jinouk.lostark.simulator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelDto {
    private double totalGemAtkBonus;
    private Map<String, Integer> gemSkillDamageMap;
}
