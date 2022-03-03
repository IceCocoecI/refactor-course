/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change;

import static com.huawei.divergent_change.player.TheatricalPlayers.PlayType.COMEDY;
import static com.huawei.divergent_change.player.TheatricalPlayers.PlayType.TRAGEDY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.huawei.divergent_change.player.Performance;
import com.huawei.divergent_change.player.PerformanceRepositoryImpl;
import com.huawei.divergent_change.player.TheatricalPlayers;
import com.huawei.divergent_change.thirdparty.mysql.MysqlConfig;
import com.huawei.divergent_change.thirdparty.mysql.MysqlConnection;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;

/**
 * TheatricalPlayers测试类
 *
 * @since 2021-10-30
 */
public class TheatricalPlayersTest {
    @Tested
    private TheatricalPlayers theatricalPlayers;

    @Mocked
    private MysqlConnection mysqlConnection;

    @Test
    public void exampleStatement() {
        PerformanceRepositoryImpl.createConnection(new MysqlConfig());
        new Expectations() {
            {
                mysqlConnection.queryList(anyString, Performance.class);
                result = Arrays.asList(
                    new Performance("Hamlet", TRAGEDY, 55),
                    new Performance("As You Like It", COMEDY, 35),
                    new Performance("Othello", TRAGEDY, 40));
            }
        };

        String result = theatricalPlayers.getInvoiceData(1002);

        String expectResult = "Statement for 1002\n" +
            "Performances you've participated in :[Hamlet, As You Like It, Othello]\n" +
            "You earned $1,600.00\n" +
            "You earned 47 credits\n";
        assertEquals(expectResult, result);
    }
}