package com.jinouk.lostark.simulator.service.ArkPassiveService;

import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ArkPassiveService {

    public ResponseEntity<Map<String , ?>> getClass(ArkPassiveDTO dto){
        HashMap<String , String> map = new HashMap<>();
        String title = dto.getTitle();

        switch(title){
            case "고독한 기사":
            case "전투 태세":

            case "광기":
            case "광전사의 비기":

            case "분노의 망치":
            case "중력 수련":

            case "심판자":
            case "축복의 오라":

            case "포식자":
            case "처단자":

            case "초심":
            case "오의 강화":

            case "극의: 체술":
            case "충격 단련":

            case "세맥타통":
            case "역천지체":

            case "절정":
            case "절제":

            case "오의난무":
            case "일격필살":

            case "권왕파천무":
            case "수라의 길":

            case "전술 탄환":
            case "핸드거너":

            case "포격 강화":
            case "화력 강화":

            case "죽음의 습격":
            case "두 번째 동료":

            case "진화의 유산":
            case "아르데타인의 기술":

            case "피스메이커":
            case "사냥의 시간":

            case "절실한 구원":
            case "진실된 용맹":

            case "넘치는 교감":
            case "상급 소환사":

            case "황후의 은총":
            case "황제의 칙령":

            case "점화":
            case "환류":

            case "버스트":
            case "잔재된 기운":

            case "멈출 수 없는 충동":
            case "완벽한 억제":

            case "달의 소리":
            case "갈증":

            case "그믐의 경계":
            case "만월의 집행자":

            case "회귀":
            case "만개":

            default:
                map.put("Err Message" , "There is no Character Class Name");
                return ResponseEntity.badRequest().body(map);
        }
    }


}
