/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.alternative_classes.case2;

import com.huawei.alternative_classes.case2.delivery.DeliveryVoucher;

/**
 * 销售订单
 *
 * @since 2021-11-15
 */
public class SalesOrder extends AbstractSalesDocument {
    // 收货地址
    private String shippingAddress;

    // 支付信息
    private String paymentReference;

    public SalesOrder(String serialNumber, String buyer) {
        super(serialNumber, buyer);
    }

    // 创建出库单
    public DeliveryVoucher createDeliveryVoucher(){
        return new DeliveryVoucher();
    }
}
