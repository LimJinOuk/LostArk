package com.jinouk.lostark.simulator.dto.simulateRun.run;


import com.jinouk.lostark.simulator.dto.simulateRun.child.*;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.skill.identitySkillsDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.skill.skillsDto;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RunRequestDto {

    private String characterName;
    private String characterClass;
    private equipmentsDto equipments;
    private accessoriesDto accessories;
    private JewelDto jewel;
    private gemEffectDto gemEffect;
    private engravingDto engraving;
    private ArkGridRequestDto arkGrid;
    private skillsDto skills;
    private identitySkillsDto identitySkills;
    private ArkPassiveDTO arkPassive;
    private List<profileData> profiles;

    @Getter
    @AllArgsConstructor
    private static class profileData{
        private Map<String, Integer> data;
    }
}
