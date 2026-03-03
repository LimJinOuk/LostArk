package com.jinouk.lostark.simulator.service.arkCoreCalc.arkGridInterface;


import com.jinouk.lostark.simulator.dto.arkgrid.arkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.arkGridResponseDto;

public interface IArkGrid {
    String getClassName();
    String getArkGridCoreName();
    arkGridResponseDto getArkGrid(arkGridRequestDto requestDto);
}
