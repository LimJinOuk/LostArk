package com.jinouk.lostark.simulator.service.ArkCoreCalc.Chaos;


import com.jinouk.lostark.simulator.dto.ArkCoreCalcDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChaosMoonArkCoreCalcService {
    private double 적주피 = 0;
    private double 치적 = 0;
    private double 방깎 = 0;
    private double 치피증 = 0;

    public Map<String , Double> calcMoonArkCoreDamage(ArkCoreCalcDto dto){
        Map<String , Double> res = new HashMap<>();

        if(dto.getCoreGrade() == "고대"){
            if(dto.getCoreName() == "불타는 일격"){
                switch (dto.getCorePoints()){
                    case 10:
                    case 14:
                        적주피 += 0.5;
                        break;
                    case 17:
                        적주피 +=2.5;
                        break;
                    case 18:
                        적주피 += 2.66;
                        break;
                    case 19:
                        적주피 += 2.82;
                        break;
                    case 20:
                        적주피 += 2.98;
                        break;
                    default:
                        break;
                }
            }
        } else if (dto.getCoreName() == "흡수의 일격") {
            switch (dto.getCorePoints()){
                case 14:
                    적주피 += 0.5;
                    break;
                case 17:
                    적주피 += 2.5;
                    break;
                case 18:
                    적주피 += 2.66;
                    break;
                case 19:
                    적주피 += 2.82;
                    break;
                case 20:
                    적주피 += 2.98;
                    break;
                default:
                    break;
            }
        } else if (dto.getCoreName() == "부수는 일격") {
            switch (dto.getCorePoints()){
                case 14:
                    치적 += 0.65;
                    break;
                case 17:
                    치적 += 3.25;
                    break;
                case 18:
                    치적 += 3.46;
                    break;
                case 19:
                    치적 += 3.67;
                    break;
                case 20:
                    치적 += 3.88;
                    break;
                default:
                    break;
            }
        } else if (dto.getCoreName() == "낙인의 흔적") {
            switch (dto.getCorePoints()){
                case 10:
                    적주피 += 0.1;
                    break;
                case 17:
                    적주피 += 0.5;
                    break;
                default:
                    break;
            }
        } else if (dto.getCoreName() == "강철의 흔적") {
            switch (dto.getCorePoints()){
                case 10:
                    방깎 += 0.2;
                    break;
                case 17:
                    방깎 += 1;
                    break;
                default:
                    break;
            }
        } else if (dto.getCoreName() == "치명적인 흔적") {
            switch (dto.getCorePoints()){
                case 10:
                    치피증 += 0.3;
                    break;
                case 17:
                    치피증 += 1.5;
                    break;
                default:
                    break;
            }
        } else {
            적주피 += 0;
            치적 += 0;
            방깎 +=0;
            치피증 +=0;
        }

        if(dto.getCoreGrade() == "유물"){
            if(dto.getCoreName() == "불타는 일격"){
                switch (dto.getCorePoints()){
                    case 10:
                    case 14:
                        적주피 += 0.5;
                        break;
                    case 17:
                        적주피 +=1.5;
                        break;
                    case 18:
                        적주피 += 1.66;
                        break;
                    case 19:
                        적주피 += 1.82;
                        break;
                    case 20:
                        적주피 += 1.98;
                        break;
                    default:
                        break;
                }
            }
        } else if (dto.getCoreName() == "흡수의 일격") {
            switch (dto.getCorePoints()){
                case 14:
                    적주피 += 0.5;
                    break;
                case 17:
                    적주피 += 1.5;
                    break;
                case 18:
                    적주피 += 1.66;
                    break;
                case 19:
                    적주피 += 1.82;
                    break;
                case 20:
                    적주피 += 1.98;
                    break;
                default:
                    break;
            }
        } else if (dto.getCoreName() == "부수는 일격") {
            switch (dto.getCorePoints()){
                case 14:
                    치적 += 0.65;
                    break;
                case 17:
                    치적 += 1.95;
                    break;
                case 18:
                    치적 += 2.16;
                    break;
                case 19:
                    치적 += 2.37;
                    break;
                case 20:
                    치적 += 2.58;
                    break;
                default:
                    break;
            }
        } else if (dto.getCoreName() == "낙인의 흔적") {
            switch (dto.getCorePoints()){
                case 10:
                    적주피 += 0.1;
                    break;
                case 17:
                    적주피 += 0.3;
                    break;
                default:
                    break;
            }
        } else if (dto.getCoreName() == "강철의 흔적") {
            switch (dto.getCorePoints()){
                case 10:
                    방깎 += 0.2;
                    break;
                case 17:
                    방깎 += 0.6;
                    break;
                default:
                    break;
            }
        } else if (dto.getCoreName() == "치명적인 흔적") {
            switch (dto.getCorePoints()){
                case 10:
                    치피증 += 0.3;
                    break;
                case 17:
                    치피증 += 0.9;
                    break;
                default:
                    break;
            }
        } else {
            적주피 += 0;
            치적 += 0;
            방깎 +=0;
            치피증 +=0;
        }

        res.put("적주피 :" , 적주피);
        res.put("치적 :" , 치적);
        res.put("방깎 :" , 방깎);
        res.put("치피증 :" , 치피증);

        return res;
    }
}
