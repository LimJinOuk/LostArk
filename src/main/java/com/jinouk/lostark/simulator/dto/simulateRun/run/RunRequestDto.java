package com.jinouk.lostark.simulator.dto.simulateRun.run;


import com.jinouk.lostark.simulator.dto.simulateRun.child.*;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.skill.identitySkillsDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.skill.skillsDto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RunRequestDto {

    private String characterName;
    private equipmentsDto equipments;
    private accessoriesDto accessories;
    private JewelDto jewel;
    private gemEffectDto gemEffect;
    private engravingDto engraving;
    private ArkGridRequestDto arkGrid;
    private skillsDto skills;
    private identitySkillsDto identitySkills;
}
