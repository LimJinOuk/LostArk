package com.jinouk.lostark.simulator.dto.skill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class skillsDto {

    private Map<String, TripodListDto> skillName;

    @Getter
    @AllArgsConstructor
    public static class TripodListDto {

        private List<String> tripodName;
    }
}

