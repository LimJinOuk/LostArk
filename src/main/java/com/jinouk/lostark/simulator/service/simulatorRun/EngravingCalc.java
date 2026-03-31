package com.jinouk.lostark.simulator.service.simulatorRun;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EngravingCalc {

    private static final Map<String, BiConsumer<List<Double>, Map<String, Double>>> handlers = new HashMap<>();

    static {
        handlers.put("각성", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("강령술", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("강화 방패", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("결투의 대가", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("구슬동자", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("굳은 의지", (v, r) -> {  r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("급소 타격", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("기습의 대가", (v, r) ->{ r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("긴급구조", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("달인의 저력", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("돌격대장", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("마나 효율 증가", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("마나의 흐름", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("바리케이드", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("번개의 분노", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("부러진 뼈", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("분쇄의 주먹", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("불굴", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("선수필승", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("속전속결", (v, r) -> {  r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("슈퍼 차지", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("승부사", (v, r) ->{ r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("시선 집중", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("실드관통", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("아드레날린", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("안정된 상태", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("약자 무시", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("에테르 포식자", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("여신의 가호", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("예리한 둔기", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("원한", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("위기 모면", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("저주받은 인형", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("전문의", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("정기 흡수", (v, r) -> {  r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("정밀 단도", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("중갑 착용", (v, r) ->{ r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("질량 증가", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("최대 마나 증가", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("추진력", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("타격의 대가", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("탈출의 명수", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
        handlers.put("폭발물 전문가", (v, r) -> { r.put("여기에", v.get(0)); r.put("효과", v.get(1)); });
    }

    public static Map<String, Double> calc(String name, String description) {
        Map<String, Double> result = new HashMap<>();
        List<Double> values = extractValues(description);

        if (handlers.containsKey(name) && !values.isEmpty()) {
            handlers.get(name).accept(values, result);
        }

        return result;
    }

    private static List<Double> extractValues(String text) {
        List<Double> values = new ArrayList<>();
        if (text == null || text.isEmpty()) return values;

        Pattern pattern = Pattern.compile("([0-9]*\\.?[0-9]+)(?=%)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            values.add(Double.parseDouble(matcher.group()));
        }
        return values;
    }
}
