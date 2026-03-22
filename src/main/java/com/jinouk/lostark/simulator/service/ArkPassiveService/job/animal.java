package com.jinouk.lostark.simulator.service.ArkPassiveService.job;

import com.jinouk.lostark.simulator.dto.simulateRun.child.ArkPassiveDTO;
import com.jinouk.lostark.simulator.dto.arkPassiveEnlight.animaldto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class animal {

    public animaldto animal(String title , ArkPassiveDTO dto){
        animaldto animaldto = new animaldto();

        Map<String , Map<String , Integer>> nodes = dto.getNodes();
        Map<String , Integer> enlightment = nodes.get("깨달음");

        double 둔갑_스킬_피해량 = 0.0;
        double 환수_스킬_피해량 = 0.0;
        double 환수_스킬_치피 = 0.0;
        double 둔갑_스킬_치적 = 0.0;
        double 적주피 = 0.0;
        double 이속 = 0.0;
        double 방깎 = 0.0;
        double 찢곰_피해량 = 0.0;
        double 여우별소나기_피해량 = 0.0;

        int 환수_각성 = enlightment.get("환수 각성");
        int 활기 = enlightment.get("활기");
        int 환수의_정기 = enlightment.get("환수의 정기");
        int 날렵한_걸음걸이 = enlightment.get("날렵한 걸음걸이");
        int 천부적_재능 = enlightment.get("천부적 재능");
        int 환수_술사 = enlightment.get("환수 술사");

        if (환수_각성 > 0) {
            이속 += 20.0 * 환수_각성;
        }
        if (활기 > 0 ){
            환수_스킬_피해량 += 6.0 * 활기;
        }
        if (환수의_정기 > 0) {
            환수_스킬_치피 += 20.0 * 환수의_정기;
        }
        if (날렵한_걸음걸이 > 0) {
            환수_스킬_피해량 += 8.0 * 날렵한_걸음걸이;
        }
        if (천부적_재능 > 0) {
            적주피 += 12.0 * 천부적_재능;
        }
        if (환수_술사 > 0) {
            환수_스킬_피해량 += 1.0 * 환수_술사;
        }

        int 야성 = enlightment.get("야성");
        int 깨어난_잠재력 = enlightment.get("깨어난 잠재력");
        int 야생의_충동 = enlightment.get("야생의 충동");
        int 사냥_본능 = enlightment.get("사냥 본능");
        int 야수의_공명 = enlightment.get("야수의 공명");
        int 기민함 = enlightment.get("기민함");

        if (야성 >0){
            방깎 += 12.0 * 야성;
        }
        if (깨어난_잠재력 > 0) {
            둔갑_스킬_치적 += 10.0 * 깨어난_잠재력;
        }
        if (야생의_충동 > 0) {
            둔갑_스킬_피해량 += 1.0 * 야생의_충동;
        }
        if (사냥_본능 > 0) {
            찢곰_피해량 += 40.0 * 사냥_본능;
            여우별소나기_피해량 += 40.0 * 사냥_본능;
        }
        if (야수의_공명 > 0) {
            둔갑_스킬_피해량 += 1.0 * 야수의_공명;
        }
        if (기민함 > 0) {
            둔갑_스킬_피해량 += 1.0 * 기민함;
        }

        animaldto.set둔갑_스킬_피해량(둔갑_스킬_피해량);
        animaldto.set환수_스킬_피해량(환수_스킬_피해량);
        animaldto.set환수_스킬_치피(환수_스킬_치피);
        animaldto.set둔갑_스킬_치적(둔갑_스킬_치적);
        animaldto.set적주피(적주피);
        animaldto.set이속(이속);
        animaldto.set방깎(방깎);
        animaldto.set찢곰_피해량(찢곰_피해량);
        animaldto.set여우별소나기_피해량(여우별소나기_피해량);

        return animaldto;
    }

}
