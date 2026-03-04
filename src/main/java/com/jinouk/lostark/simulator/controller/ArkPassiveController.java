package com.jinouk.lostark.simulator.controller;


import com.jinouk.lostark.simulator.dto.ArkPassiveDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ArkPassiveController {

    @PostMapping("/sim")
    public ResponseEntity<Map<String , ?>> sim (@RequestBody ArkPassiveDTO dto){
        HashMap<String , ?> map = new HashMap<>();
        return ResponseEntity.ok(map);
    }
}
