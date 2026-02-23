package com.jinouk.lostark.simulator.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArkPassiveDTO {

    private String title;

    private Map<String, Map<String, Integer>> nodes;

    private List<PointDTO> points;
}
