package com.jinouk.lostark.simulator.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jinouk.lostark.service.armoriesAPIService;
import com.jinouk.lostark.simulator.dto.simulateRun.child.skill.skillsDto;
import com.jinouk.lostark.simulator.postProcess.skillPostProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class simulatorSkillService {

    private final armoriesAPIService armoriesAPIService;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Pattern SKILL_CATEGORY_PATTERN = Pattern.compile("\\[([^\\]]+)]");

    public Mono<List<skillPostProcess>> parsingSkillPostProcess(String name, skillsDto skillsDto) {
        return armoriesAPIService.getArmoriesCharacterCombatSkills(name)
                .map(list -> list.stream()
                        .filter(item -> skillsDto.getSkillName().containsKey(item.getName()))
                        .map(item -> {
                            var skillInfo = skillsDto.getSkillName().get(item.getName());
                            var dtoTripodList = skillInfo == null ? null : skillInfo.getTripodName();

                            skillPostProcess.RuneDto rune = null;
                            if (skillInfo != null && skillInfo.getRuneData() != null) {
                                var rd = skillInfo.getRuneData();
                                rune = skillPostProcess.RuneDto.builder()
                                        .name(rd.getRuneName())
                                        .grade(rd.getRuneGrade())
                                        .icon(rd.getRuneIcon())
                                        .tooltip(rd.getRuneDescription())
                                        .build();
                            }

                            var selectedTripods = item.getTripods() == null
                                    ? List.<skillPostProcess.TripodDto>of()
                                    : item.getTripods().stream()
                                    .filter(t -> dtoTripodList != null && dtoTripodList.contains(t.getName()))
                                    .map(t -> skillPostProcess.TripodDto.builder()
                                            .tier(t.getTier())
                                            .slot(t.getSlot())
                                            .name(t.getName())
                                            .icon(t.getIcon())
                                            .tooltip(t.getTooltip())
                                            .build())
                                    .toList();

                            return skillPostProcess.builder()
                                    .name(item.getName())
                                    .level(item.getLevel())
                                    .type(item.getType())
                                    .skillCategory(extractSkillCategory(item.getTooltip())) // 추가
                                    .icon(item.getIcon())
                                    .tooltip(item.getTooltip())
                                    .rune(rune)
                                    .selectedTripods(selectedTripods)
                                    .build();
                        })
                        .toList());
    }

    private String extractSkillCategory(String tooltip) {
        if (tooltip == null || tooltip.isBlank()) {
            return null;
        }

        try {
            JsonNode root = OBJECT_MAPPER.readTree(tooltip);

            String levelText = root.path("Element_001")
                    .path("value")
                    .path("level")
                    .asText("");

            if (levelText.isBlank()) {
                return null;
            }

            Matcher matcher = SKILL_CATEGORY_PATTERN.matcher(levelText);
            return matcher.find() ? matcher.group(1) : null;

        } catch (Exception e) {
            return null;
        }
    }
}