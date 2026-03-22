package com.jinouk.lostark.simulator.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Data

public class PointDTO {
    @JsonAlias({"Name", "name"})
    private String name;

    @JsonAlias({"Value", "value"})
    private Integer value;

    @JsonAlias({"Description", "description"})
    private String description;

    @JsonAlias({"Tooltip", "tooltip"})
    private String tooltip;

}
