package com.interest.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RainbowUtil {

    /**
     * 有字段为乱码，将其进行转换。
     * @param map
     * @return
     */
    public static HashMap decodeMap(HashMap<String, Object> map) {
        HashMap resultMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof byte[]) {
                try {
                    resultMap.put(entry.getKey(), new String((byte[]) entry.getValue(), "UTF-8"));
                } catch (Exception e){
                    resultMap.put(entry.getKey(), "");
                }
            } else {
                resultMap.put(entry.getKey(), entry.getValue());
            }
        }

        return resultMap;
    }

    public static List<HashMap> decodeList(List<HashMap> list) {
        List<HashMap> resultList = new ArrayList<>();
        for (HashMap map : list) {
            resultList.add(RainbowUtil.decodeMap(map));
        }
        return resultList;
    }
}
