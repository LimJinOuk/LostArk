package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class warlord {

    public String warlord(String title ,ArkPassiveDTO dto){
        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> evolution = nodes.get("진화");
        Map<String , Integer> enlightment = nodes.get("깨달음");
        Map<String , Integer> leap = nodes.get("도약");

        int 고독한_기사 = enlightment.get("고독한 기사");
        int 정교함 = enlightment.get("정교함");
        int 건랜스_수련 = enlightment.get("건랜스 수련");
        int 선봉장의_함성 = enlightment.get("선봉장의 함성");

        int 효율_증대 = enlightment.get("효율 증대");
        int 결사대 = enlightment.get("결사대");

        int 철옹성 = enlightment.get("철옹성");
        int 전투_태세 = enlightment.get("전투 태세");
        int 숙련된_전술가 = enlightment.get("숙련된 전술가");
        int 선봉장의_마음가짐 = enlightment.get("선봉장의 마음가짐");

        int 전술_훈련 = enlightment.get("전술 훈련");
        int 전술_이동 = enlightment.get("전술 이동");


        if(title == "고독한 기사"){

        }
        else {

        }
        return "";
    }
}
