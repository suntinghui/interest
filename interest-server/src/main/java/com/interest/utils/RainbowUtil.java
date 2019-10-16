package com.interest.utils;

import java.util.HashMap;
import java.util.Map;

public class RainbowUtil {

    /**
     * 有字段为乱码，将其进行转换。
     * @param map
     * @return
     */
    public static HashMap<String, String> decodeMap(HashMap<String, Object> map) {
        HashMap<String, String> resultMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof byte[]) {
                try {
                    resultMap.put(entry.getKey(), new String((byte[]) entry.getValue(), "UTF-8"));
                } catch (Exception e){
                    resultMap.put(entry.getKey(), "");
                }
            } else {
                resultMap.put(entry.getKey(), entry.getValue().toString());
            }
        }

        return resultMap;
    }
}
