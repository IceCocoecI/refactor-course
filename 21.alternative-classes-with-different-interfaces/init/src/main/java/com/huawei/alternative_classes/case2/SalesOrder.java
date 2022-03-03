/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.alternative_classes.case2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.huawei.alternative_classes.case2.delivery.DeliveryVoucher;
import com.huawei.alternative_classes.case2.line.ProductLine;

/**
 * 销售订单
 *
 * @since 2021-11-15
 */
public class SalesOrder {
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

    // 收货地址
    private String shippingAddress;

    // 支付信息
    private String paymentReference;

    public SalesOrder(String serialNumber, String buyer) {

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

    // 创建出库单
    public DeliveryVoucher createDeliveryVoucher() {
        return new DeliveryVoucher();
    }
}
