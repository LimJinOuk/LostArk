package com.jinouk.lostark.simulator.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter@Setter
public class skillsr {
    private String type; // 지점 , 홀딩 , 차지 , 체인 등
    private String category; // 각 클래스별 스킬 종류 ex)범용스킬 , 집속스킬 , 해방스킬 등
    private String direct; // 타대 , 백 , 헤드
    private String name; //Skill's Name
    private Integer dmg; //Skill's Dmg
}
