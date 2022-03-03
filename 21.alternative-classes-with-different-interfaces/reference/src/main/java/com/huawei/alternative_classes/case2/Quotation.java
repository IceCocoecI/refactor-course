/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.alternative_classes.case2;

import java.math.BigDecimal;

import com.huawei.alternative_classes.exception.NotImplementedException;

/**
 * 报价单
 *
 * @since 2021-11-15
 */
public class Quotation extends AbstractSalesDocument {
    // 报价有效的终止时间
    private long expiryTime;

    public Quotation(String serialNumber, String buyer) {
        super(serialNumber, buyer);
    }

    // 根据报价单创建销售订单
    public SalesOrder createOrder(){
        throw new NotImplementedException();
    }

    // 创建一个新的报价单，并使用新的折扣率
    public Quotation cloneWithNewDiscount(BigDecimal discount) {
        throw new NotImplementedException();
    }
}
