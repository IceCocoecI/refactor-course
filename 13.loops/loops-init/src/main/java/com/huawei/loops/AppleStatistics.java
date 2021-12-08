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

        // 求平均重量
        appleStore.stream().collect(Collectors.groupingBy(Apple::getColor)).forEach((key, value) -> {
            // get average
            result.put(key, value.stream().mapToInt(Apple::getWeight).sum() / value.size());
        });
        return result;
    }
}
