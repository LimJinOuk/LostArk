package com.jinouk.lostark.simulator.service.ArkPassiveService;

import com.jinouk.lostark.simulator.dto.arkPassiveEv.arkPassiveEvdto;
import org.springframework.stereotype.Service;

@Service
public class evolutioncalc {
    arkPassiveEvdto arkPassiveEvdto = new arkPassiveEvdto();

    double 치적 = 0.0;
    double 진피 = 0.0;
    double 공이속 = 100.0;
    double 치피증 = 100.0;
    double 치피 = 200.0;
    public double get치적(int 치명 , int 예리한_감각 , int 혼신의_강타 , int 일격 , int 달인 , int 뭉툭한_가시){
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
                    진피 = 52.5;
                }
                else {
                    진피 = EvDmg;
                }
                System.out.println("뭉가 1 채택시 진화 노드 계산으로 인한 치적 값 : " + 80.0);
                System.out.println("뭉가 1 채택시 진화 노드 계산으로 인한 진피 값 : " + 진피);
                return 80.0;
            }
            else {
                System.out.println("뭉가 1 채택시 진화 노드 계산으로 인한 치적 값 : " + 80.0);
                System.out.println("뭉가 1 채택시 진화 노드 계산으로 인한 진피 값 : " + 진피);
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
                    진피 = 75;
                }
                else {
                    진피 = EvDmg;
                }
                System.out.println("뭉가 2 채택시 진화 노드 계산으로 인한 치적 값 : " + 80.0);
                System.out.println("뭉가 2 채택시 진화 노드 계산으로 인한 진피 값 : " + 진피);
                return 80.0;
            }
            else {
                System.out.println("뭉가 2 채택시 진화 노드 계산으로 인한 치적 값 : " + 80.0);
                System.out.println("뭉가 2 채택시 진화 노드 계산으로 인한 진피 값 : " + 진피);
                return 80.0;
            }

        } else {
            CritProb += 치명 * 0.0357;
            CritProb += 예리한_감각 * 4.0;
            CritProb += 혼신의_강타 * 12.0;
            CritProb += 일격 * 10.0;
            CritProb += 달인 * 7.0;
            치적 = CritProb;
            System.out.println("뭉가 0 채택시 진화 노드 계산으로 인한 치적 값 : " + 치적);
            System.out.println("뭉가 0 채택시 진화 노드 계산으로 인한 진피 값 : " + 진피);
            System.out.println("진화 노드 계산으로 인한 치적 값 : " + 치적);
            return 치적;
        }
    }

    public double get치피 (int 일격)
    {
        치피 += 일격  * 16;
        System.out.println("진화 노드 계산으로 인한 치피 값 : " + 치피);
        return 치피;
    }

    public double get공이속 (int 신속){
        공이속 += 신속 * 0.0172;
        System.out.println("진화 노드 계산으로 인한 공이속 값 : " + 공이속);
        return 공이속;
    }

    public double get진피(int 금단의_주문 , int 예리한_감각 , int 한계_돌파
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

    public double get치피증 (int 일격 , int 회심){
        if (일격 > 0){
            치피증 += 16.0 * 일격;
        }
        if(회심 > 0){
            치피증 += 12.0 * 회심;
        }
        return 치피증;
    }
}
