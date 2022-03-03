/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.alternative_classes.case2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.huawei.alternative_classes.case2.line.ProductLine;
import com.huawei.alternative_classes.exception.NotImplementedException;

/**
 * 报价单
 *
 * @since 2021-11-15
 */
public class Quotation {
    /**
     * 序列号
     */
    private final String serialNumber;

    /**
     * 买家
     */
    private final String buyer;

    /**
     * 创建时间
     */
    private final long createTime = System.currentTimeMillis();

    /**
     * 明细行
     */
    protected final List<ProductLine> lines = new ArrayList<>();

    // 报价有效的终止时间
    private long expiryTime;

    public Quotation(String serialNumber, String buyer) {
        this.serialNumber = serialNumber;
        this.buyer = buyer;
    }

    public List<ProductLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBuyer() {
        return buyer;
    }

    public long getCreateTime() {
        return createTime;
    }

    public BigDecimal getAmount() {
        return lines.stream()
            .map(ProductLine::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // 根据报价单创建销售订单
    public SalesOrder createOrder() {
        throw new NotImplementedException();
    }

    // 创建一个新的报价单，并使用新的折扣率
    public Quotation cloneWithNewDiscount(BigDecimal discount) {
        throw new NotImplementedException();
    }
}
