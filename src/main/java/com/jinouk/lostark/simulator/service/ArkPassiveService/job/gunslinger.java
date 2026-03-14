package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.gunslingerdto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class gunslinger {

    public gunslingerdto gunslinger(String title , ArkPassiveDTO dto){
        gunslingerdto gunslingerdto = new gunslingerdto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.get("깨달음");

        double 치적 = 0.0;
        double 적주피 = 0.0;;
        double 이속 = 0.0;;
        double 치피 = 0.0;;

        int 라이플숙련 = enlightment.get("라이플 숙련");
        int 일발필중 = enlightment.get("일발필중");
        int 급소전문가 = enlightment.get("급소 전문가");
        int 저격수의의지 = enlightment.get("저격수의 의지");

        if (라이플숙련 > 0) {
            치적 += 25.0 * 라이플숙련;
        }
        if (일발필중 > 0){
            적주피 += 40.0 * 일발필중;
        }
        if (급소전문가 > 0){
            치적 += 1.2 * 급소전문가;
        }
        if (저격수의의지 > 0){
            이속 += 0.9 * 저격수의의지;
            치피 += 3.0 * 저격수의의지;
        }

        int 피메샷건 = enlightment.get("피스메이커 - 샷건");
        int 피메라이플 = enlightment.get("피스메이커 - 라이플");
        int 평화주의자 = enlightment.get("평화주의자");
        int 시크릿_불릿 = enlightment.get("시크릿 불릿");
        int 총기_교체_기술 = enlightment.get("총기 교체 기술");

        if (피메샷건 > 0){
            치적 += 3.0 * 피메샷건;
            적주피 += 3.0 * 피메샷건;
        }
        if (피메라이플 > 0){
            적주피 += 13.0 * 피메라이플;
        }
        if (평화주의자 > 0){
            치적 += 10.0 * 평화주의자;
            적주피 += 38.0 * 평화주의자;
        }
        if (시크릿_불릿 > 0){
            적주피 += 2.0 * 시크릿_불릿;
            적주피 += 25.0 * 시크릿_불릿;
        }
        if (총기_교체_기술 > 0){
            적주피 += 1.0 * 총기_교체_기술;
        }

        gunslingerdto.set치적(치적);
        gunslingerdto.set적주피(적주피);
        gunslingerdto.set이속(이속);
        gunslingerdto.set치피(치피);

        return gunslingerdto;
    }
}
