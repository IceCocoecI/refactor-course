/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.repeated_switches_init.server.cost.pet;

import com.huawei.repeated_switches_init.model.Pet;

/**
 * 饲养宠物耗费精力
 *
 * @since 2021-06-18
 */
public abstract class PetCosts {
    protected final Pet pet;

    protected PetCosts(Pet pet) {
        this.pet = pet;
    }

    /**
     * 每天需要陪伴的时间
     * 
     * @return 每天需要陪伴的时间
     */
    public abstract String getDailyCompanyTime();

    /**
     * 每天需要花费的金钱
     * 
     * @return 每天需要花费的金钱
     */
    public abstract double getDailyPay();

    /**
     * 清理频率
     * 
     * @return 清理频率
     */
    public abstract String getCleanFrequency();
}