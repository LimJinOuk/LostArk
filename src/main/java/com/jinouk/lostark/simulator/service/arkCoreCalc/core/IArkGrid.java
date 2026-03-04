package com.jinouk.lostark.simulator.service.arkCoreCalc.core;


import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;

public interface IArkGrid {
    String getClassName();
    String getArkGridCoreName();
    ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto);
}
