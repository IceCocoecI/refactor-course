/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.loops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 统计苹果信息
 *
 * @since 2021-09-02
 */
public class AppleStatistics {
    /**
     * 求每种颜色苹果的平均重量
     * 
     * @param appleStore 苹果信息
     * @return 每种颜色苹果的平均重量
     */
    public Map<String, Integer> averageWeightByColor(List<Apple> appleStore) {
        Map<String, Integer> result = new HashMap<>();
        // 按颜色分组.
        Map<String, List<Apple>> applesMap = appleStore.stream().collect(Collectors.groupingBy(Apple::getColor));

        // 求平均重量
        applesMap.forEach((key, value) -> {
            int weights = 0;
            for (Apple apple : value) {
                weights += apple.getWeight();
            }
            // get average
            result.put(key, weights / value.size());
        });
        return result;
    }
}
