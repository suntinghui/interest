package com.interest.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringUtil {

    /**
     * 判断String是否位数字
     *
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static List<String> str2List(String str) {
        ArrayList list = new ArrayList();

        if (str == null || str.length() == 0)
            return list;

        for (String temp : str.split(","))
            list.add(temp);

        return list;
    }

}
