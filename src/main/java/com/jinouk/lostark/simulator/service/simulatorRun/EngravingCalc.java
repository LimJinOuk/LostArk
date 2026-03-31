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
        handlers.put("돌격대장", (v, r) -> { r.put("돌대피증", v.get(0));});

        handlers.put("결투의 대가", (v, r) -> { r.put("피증", v.get(0)); r.put("헤드어택시 추가 피증", v.get(1));});
        handlers.put("기습의 대가", (v, r) ->{ r.put("피증", v.get(0)); r.put("백어택시 추가 피증", v.get(1));});
        handlers.put("타격의 대가", (v, r) -> { r.put("피증", v.get(0));r.put("타대공격시 추가 피증", v.get(1));});
        handlers.put("마나 효율 증가", (v, r) -> { r.put("피증", v.get(0));});
        handlers.put("바리케이드", (v, r) -> { r.put("피증", v.get(0));});
        handlers.put("속전속결", (v, r) -> {  r.put("피증", v.get(0));});
        handlers.put("슈퍼 차지", (v, r) -> { r.put("피증", v.get(0));});
        handlers.put("시선 집중", (v, r) -> { r.put("피증", v.get(0));});
        handlers.put("안정된 상태", (v, r) -> { r.put("피증", v.get(0));});
        handlers.put("약자 무시", (v, r) -> { r.put("피증", v.get(0));});

        handlers.put("원한", (v, r) -> { r.put("피증", v.get(0));});
        handlers.put("저주받은 인형", (v, r) -> { r.put("피증", v.get(0));});

        handlers.put("승부사", (v, r) ->{ r.put("공증", v.get(0));});
        handlers.put("아드레날린", (v, r) -> { r.put("공증", v.get(0)); r.put("치적", v.get(1)); });

        handlers.put("예리한 둔기", (v, r) -> { r.put("치피증", v.get(0));});

        handlers.put("정기 흡수", (v, r) -> {  r.put("이속증", v.get(0));});
        handlers.put("정밀 단도", (v, r) -> { r.put("치적", v.get(0)); r.put("치피감소", v.get(1)); });

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
        System.out.println("sex : " + values);
        return values;
    }
}
