/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.feature_envy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 发票信息
 *
 * @version 1.0
 * @since 2021/10/30
 */
public class Invoice {
    private final String buyer;

    private final String seller;

    private final List<InvoiceLine> lines;

    public Invoice(String buyer, String seller, List<InvoiceLine> lines) {
        this.buyer = buyer;
        this.seller = seller;
        this.lines = new ArrayList<>(lines);
    }

    public String getBuyer() {
        return buyer;
    }

    public String getSeller() {
        return seller;
    }

    public List<InvoiceLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

    BigDecimal getAmount() {
        BigDecimal total = BigDecimal.ZERO;
        for (InvoiceLine line : getLines()) {
            BigDecimal lineTotal = line.getAmount();
            total = total.add(lineTotal);
        }
        return total;
    }
}
