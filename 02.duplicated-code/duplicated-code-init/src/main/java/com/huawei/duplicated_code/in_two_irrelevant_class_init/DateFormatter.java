package com.huawei.duplicated_code.in_two_irrelevant_class_init;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    static String getDate() {
        Long time = System.currentTimeMillis();  // 获取当前时间戳
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date(Long.parseLong(String.valueOf(time))));
    }
}