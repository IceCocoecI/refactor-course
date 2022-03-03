/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.loops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class AppleStatisticsTest {
    @Test
    void should_color_equals_avg() {
        List<Apple> appleStore = new ArrayList<>();
        appleStore.add(new Apple(1, "red", 500, "河南"));
        appleStore.add(new Apple(2, "red", 400, "河南"));
        appleStore.add(new Apple(3, "green", 300, "河南"));
        appleStore.add(new Apple(4, "green", 200, "天津"));
        appleStore.add(new Apple(5, "green", 100, "天津"));

        AppleStatistics appleStatistics = new AppleStatistics();
        Map<String, Integer> result = appleStatistics.averageWeightByColor(appleStore);

        assertEquals(result.get("red"), 450);
        assertEquals(result.get("green"), 200);
    }
}
