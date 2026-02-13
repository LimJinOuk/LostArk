package com.jinouk.lostark.simulator.service.ArkCoreCalc.Chaos;

import com.jinouk.lostark.simulator.dto.ArkCoreCalcDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChaosSunArkCoreCalcService {
    private double 치피증 = 0;
    private double 추피 = 0;
    private double 적주피 = 0;
    public Map<String, Double> calcSunArkCoreDamage(ArkCoreCalcDto dto){
        Map<String , Double> res = new HashMap<>();

        if(dto.getCoreGrade() == "고대"){
            if (dto.getCoreName() == "현란한 공격"){
                switch (dto.getCorePoints()){
                    case 10:
                        적주피 += 0;
                        치피증 += 0.55;
                        break;
                    case 14:
                        적주피 += 0.5;
                        치피증 += 0.55;
                        break;
                    case 17:
                        적주피 += 2.0;
                        치피증 += 1.65;
                        break;
                    case 18:
                        적주피 += 2.16;
                        치피증 += 1.65;
                        break;
                    case 19:
                        적주피 += 2.32;
                        치피증 += 1.65;
                        break;
                    case 20:
                        적주피 += 2.48;
                        치피증 += 1.65;
                        break;
                    default:
                        break;
                }
            } else if (dto.getCoreName() == "안정적인 공격") {
                switch (dto.getCorePoints()){
                    case 10:
                        break;
                    case 14:
                        추피 += 0.7;
                        break;
                    case 17:
                        추피 += 3.5;
                        break;
                    case 18:
                        추피 += 3.73;
                        break;
                    case 19:
                        추피 += 3.96;
                        break;
                    case 20:
                        추피 += 4.19;
                        break;
                    default:
                        break;
                }
            } else if (dto.getCoreName() == "재빠른 공격"){
                switch (dto.getCorePoints()){
                    case 10:
                        break;
                    case 14:
                        치피증 += 1.4;
                        break;
                    case 17:
                        치피증 += 7;
                        break;
                    case 18:
                        치피증 += 7.45;
                        break;
                    case 19:
                        치피증 += 7.9;
                        break;
                    case 20:
                        치피증 += 8.35;
                        break;
                    default:
                        break;
                }
            } else  {
                추피 += 0;
                치피증 += 0;
                적주피 += 0;
            }


        } else if (dto.getCoreGrade() == "유물") {

            if (dto.getCoreName() == "현란한 공격"){
                switch (dto.getCorePoints()){
                    case 10:
                        적주피 += 0;
                        치피증 += 0.55;
                        break;
                    case 14:
                        적주피 += 0.5;
                        치피증 += 0.55;
                        break;
                    case 17:
                        적주피 += 1.5;
                        치피증 += 1.1;
                        break;
                    case 18:
                        적주피 += 1.66;
                        치피증 += 1.1;
                        break;
                    case 19:
                        적주피 += 1.82;
                        치피증 += 1.1;
                        break;
                    case 20:
                        적주피 += 1.98;
                        치피증 += 1.1;
                        break;
                    default:
                        break;
                }
            } else if (dto.getCoreName() == "안정적인 공격") {
                switch (dto.getCorePoints()){
                    case 10:
                        break;
                    case 14:
                        추피 += 0.7;
                        break;
                    case 17:
                        추피 += 2.1;
                        break;
                    case 18:
                        추피 += 2.33;
                        break;
                    case 19:
                        추피 += 2.56;
                        break;
                    case 20:
                        추피 += 2.79;
                        break;
                    default:
                        break;
                }
            } else if (dto.getCoreName() == "재빠른 공격"){
                switch (dto.getCorePoints()){
                    case 10:
                        break;
                    case 14:
                        치피증 += 1.4;
                        break;
                    case 17:
                        치피증 += 4.2;
                        break;
                    case 18:
                        치피증 += 4.65;
                        break;
                    case 19:
                        치피증 += 5.1;
                        break;
                    case 20:
                        치피증 += 5.55;
                        break;
                    default:
                        break;
                }
            } else
            {
                추피 += 0;
                치피증 += 0;
                적주피 += 0;
            }
        }
        res.put("추피 :" , 추피);
        res.put("치피증 :" , 치피증);
        res.put("적주피 :" , 적주피);
        return res;
    }
}
