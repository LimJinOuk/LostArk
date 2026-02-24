package com.jinouk.lostark.simulator.service.ArkPassiveService;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class evolutioncalc {

    double 치적 = 0.0;
    double 진피 = 0.0;
    double 피증 = 0.0;
    double 공이속 = 100.0;

    public String ev(ArkPassiveDTO dto) {
        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.get("진화");
        int 치명 = evolution.get("치명");
        int 특화 = evolution.get("특화");
        int 신속 = evolution.get("신속");
        int 금단의_주문 = evolution.get("금단의 주문");
        int 예리한_감각 = evolution.get("예리한 감각");
        int 한계_돌파 = evolution.get("한계 돌파");
        int 최적화_훈련 = evolution.get("최적화 훈련");
        int 무한한_마력 = evolution.get("무한한 마력");
        int 혼신의_강타 = evolution.get("혼신의 강타");
        int 일격 = evolution.get("일격");
        int 파괴_전차 = evolution.get("파괴 전차");
        int 타이밍_지배 = evolution.get("타이밍 지배");
        int 회심 = evolution.get("회심");
        int 달인 = evolution.get("달인");
        int 분쇄 = evolution.get("분쇄");
        int 뭉툭한_가시 = evolution.get("뭉툭한 가시");
        int 음속_돌파 = evolution.get("음속 돌파");
        int 인파이팅 = evolution.get("인파이팅");
        int 입식_타격가 = evolution.get("입식타격가");
        int 마나_용광로 = evolution.get("마나 용광로");

        Map<String , Double> result = new HashMap<String , Double>();

        치적 = CritProbCalc(치명 , 예리한_감각 , 혼신의_강타 , 일격 , 달인 , 뭉툭한_가시);

        result.put("치적" , 치적);
        result.put("진피" , 진피);
        result.put("피증" , 피증);
        return "";
    }

    public double CritProbCalc (int 치명 , int 예리한_감각 , int 혼신의_강타 , int 일격 , int 달인 , int 뭉툭한_가시){
        double CritProb = 0.0;
        if(뭉툭한_가시 == 1){
            double CritProbForEvDmg = 0.0;

            CritProb += 치명 * 0.0357;
            CritProb += 예리한_감각 * 4.0;
            CritProb += 혼신의_강타 * 12.0;
            CritProb += 일격 * 10.0;
            CritProb += 달인 * 7.0;
            CritProbForEvDmg = CritProb - 80.0;
            if(CritProbForEvDmg >0){
                double EvDmg = CritProbForEvDmg * 1.25;
                if(EvDmg > 52.5){
                    진피 += 52.5;
                }
                else {
                    진피 += EvDmg;
                }
                return 80.0;
            }
            else {
                return 80.0;
            }
        } else if (뭉툭한_가시 == 2){
            double CritProbForEvDmg = 0.0;

            CritProb += 치명 * 0.0357;
            CritProb += 예리한_감각 * 4.0;
            CritProb += 혼신의_강타 * 12.0;
            CritProb += 일격 * 10.0;
            CritProb += 달인 * 7.0;
            CritProbForEvDmg = CritProb - 80.0;
            if(CritProbForEvDmg >0){
                double EvDmg = CritProbForEvDmg * 1.50;
                if(EvDmg > 75){
                    진피 += 75;
                }
                else {
                    진피 += EvDmg;
                }
                return 80.0;
            }
            else {
                return 80.0;
            }

        } else {
            CritProb += 치명 * 0.0357;
            CritProb += 예리한_감각 * 4.0;
            CritProb += 혼신의_강타 * 12.0;
            CritProb += 일격 * 10.0;
            CritProb += 달인 * 7.0;
            return CritProb;
        }
    }

    public double get공이속 (int 신속){
        공이속 += 신속 * 0.0172;
        return 공이속;
    }

    public double EvDmgCalc(int 금단의_주문 , int 예리한_감각 , int 한계_돌파
            , int 최적화_훈련 , int 무한한_마력, int 혼신의_강타 , int 파괴_전차
            , int 타이밍_지배 , int 분쇄, int 뭉툭한_가시 , int 음속_돌파
            , int 인파이팅 , int 입식_타격가 , int 마나_용광로)
    {
        진피 += 금단의_주문 * 5;
        진피 += 예리한_감각 * 5;
        진피 += 한계_돌파 * 10;
        진피 += 최적화_훈련 * 5;
        진피 += 무한한_마력 * 8;
        진피 += 혼신의_강타 * 2;
        진피 += 파괴_전차 * 12;
        진피 += 타이밍_지배 * 8;
        진피 += 분쇄 * 20;
        진피 += 뭉툭한_가시 * 7.5;
        진피 += 인파이팅 * 9;
        진피 += 입식_타격가 * 9.8;

        if(음속_돌파 > 0){
            진피 += (공이속 - 100.0) * 5*음속_돌파;
            if(공이속 > 140){
                진피 += 4*음속_돌파;
                double 진피temp = (공이속 - 140) * 0.15*음속_돌파;
                if(진피temp <= 12*음속_돌파){
                    진피 += 진피temp;
                }
                else {
                    진피 += 12*음속_돌파;
                }
            }
        }
        
        진피 += 마나_용광로 * 1;
        return 진피;
    }
}
