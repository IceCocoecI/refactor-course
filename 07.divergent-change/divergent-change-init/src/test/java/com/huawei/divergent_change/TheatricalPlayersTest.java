/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change;

import static com.huawei.divergent_change.player.domain.PlayType.COMEDY;
import static com.huawei.divergent_change.player.domain.PlayType.TRAGEDY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.huawei.divergent_change.player.domain.Performance;
import com.huawei.divergent_change.player.domain.PerformanceRepository;
import com.huawei.divergent_change.player.application.usecase.TheatricalPlayers;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

/**
 * TheatricalPlayers测试类
 *
 * @since 2021-10-30
 */
public class TheatricalPlayersTest {
    @Tested
    private TheatricalPlayers theatricalPlayers;

    @Injectable
    private PerformanceRepository performanceRepository;

    @Test
    public void exampleStatement() {
        final int playerId = 1002;
        new Expectations() {
            {
                performanceRepository.getPerformances(playerId);
                result = Arrays.asList(
                    new Performance("Hamlet", TRAGEDY, 55),
                    new Performance("As You Like It", COMEDY, 35),
                    new Performance("Othello", TRAGEDY, 40));
            }
        };

        String result = theatricalPlayers.getInvoiceData(playerId);

        String expectResult = "Statement for 1002\n" +
            "Performances you've participated in :[Hamlet, As You Like It, Othello]\n" +
            "You earned $1,600.00\n" +
            "You earned 47 credits\n";
        assertEquals(expectResult, result);
    }
}