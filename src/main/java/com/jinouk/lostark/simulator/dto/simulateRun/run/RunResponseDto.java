package com.jinouk.lostark.simulator.dto.simulateRun.run;

import com.jinouk.lostark.simulator.dto.simulateRun.child.*;
import com.jinouk.lostark.simulator.dto.simulateRun.child.skill.identitySkillsDto;
import com.jinouk.lostark.simulator.postProcess.skillPostProcess;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RunResponseDto {

    private String characterName;
    private equipmentsDto equipments;
    private accessoriesDto accessories;
    private JewelDto jewel;
    private gemEffectDto gemEffect;
    private engravingDto engraving;
    private Map<String, Double> arkGrid;
    private List<skillPostProcess> skills;
    private identitySkillsDto identitySkills;
}
