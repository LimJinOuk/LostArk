package com.jinouk.lostark.simulator.service.ArkCoreCalc.Chaos;

import com.jinouk.lostark.simulator.dto.ArkCoreCalcDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChaosStarArkCoreCalc {
    private double 공격력 = 0;
    private double 공퍼력 = 0;
    private double 무공 = 0;
    private double 무공퍼 = 0;
    private double 이속 =0;

    public Map<String , Double> calcStarArkCoreDamage(ArkCoreCalcDto dto){
        Map<String , Double> res = new HashMap<>();

        if(dto.getCoreGrade() == "고대"){
            if(dto.getCoreName() == "공격"){
                switch (dto.getCorePoints()){
                    case 10:
                        공격력 += 900;
                        break;
                    case 14:
                        공퍼력 +=0.55;
                        break;
                    case 17:
                        공퍼력 += 2.3;
                        공격력 += 3600;
                        break;
                    case 18:
                        공퍼력 += 2.46;
                        break;
                    case 19:
                        공퍼력 += 2.62;
                        break;
                    case 20:
                        공퍼력 += 2.78;
                        break;
                    default:
                        break;
                }
            } else if (dto.getCoreName() == "무기"){
                switch (dto.getCorePoints()){
                    case 10:
                        무공 += 1300;
                        break;
                    case 14:
                        무공퍼 += 0.75;
                        break;
                    case 17:
                        무공퍼 += 3;
                        무공 += 4200;
                        break;
                    case 18:
                        무공퍼 += 3.23;
                        break;
                    case 19:
                        무공퍼 += 3.46;
                        break;
                    case 20:
                        무공퍼 += 3.69;
                        break;
                    default:
                        break;
                }
                
            } else if (dto.getCoreName() == "속도") {
                switch (dto.getCorePoints()){
                    case 10:
                        이속 += 0.9;
                        break;
                    case 14:
                        이속 += 1.7;
                        break;
                    case 17:
                        이속 += 4.4;
                        break;
                    case 18:
                        이속 += 4.7;
                        break;
                    case 19:
                        이속 += 5.0;
                        break;
                    case 20:
                        이속 += 5.3;
                        break;
                    default:
                        break;
                }
                
            }
        }

        if(dto.getCoreGrade() == "유물"){
            if(dto.getCoreName() == "공격"){
                switch (dto.getCorePoints()){
                    case 10:
                        공격력 += 900;
                        break;
                    case 14:
                        공퍼력 +=0.55;
                        break;
                    case 17:
                        공퍼력 += 1.8;
                        공격력 += 2700;
                        break;
                    case 18:
                        공퍼력 += 1.96;
                        break;
                    case 19:
                        공퍼력 += 2.12;
                        break;
                    case 20:
                        공퍼력 += 2.28;
                        break;
                    default:
                        break;
                }
            } else if (dto.getCoreName() == "무기"){
                switch (dto.getCorePoints()){
                    case 10:
                        무공 += 1300;
                        break;
                    case 14:
                        무공퍼 += 0.75;
                        break;
                    case 17:
                        무공퍼 += 2.25;
                        무공 += 3900;
                        break;
                    case 18:
                        무공퍼 += 2.48;
                        break;
                    case 19:
                        무공퍼 += 2.71;
                        break;
                    case 20:
                        무공퍼 += 2.94;
                        break;
                    default:
                        break;
                }

            } else if (dto.getCoreName() == "속도") {
                switch (dto.getCorePoints()){
                    case 10:
                        이속 += 0.9;
                        break;
                    case 14:
                        이속 += 1.7;
                        break;
                    case 17:
                        이속 += 3.5;
                        break;
                    case 18:
                        이속 += 3.8;
                        break;
                    case 19:
                        이속 += 4.1;
                        break;
                    case 20:
                        이속 += 4.4;
                        break;
                    default:
                        break;
                }

            }
        }

        res.put("공격력 :" , 공격력);
        res.put("공퍼력 :" , 공퍼력);
        res.put("무공 :" , 무공);
        res.put("무공퍼 :" , 무공퍼);
        res.put("이속 :" , 이속);

        return res;
    }
}
