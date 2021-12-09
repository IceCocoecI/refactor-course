/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.message_chains;

import com.huawei.message_chains.bean.Person;
import com.huawei.message_chains.bean.Street;

/**
 * 信息服务类，作为代理解决
 *
 * @since 2021-11-11
 */
public class InformationClient {
    /**
     * 获取员工所在的部门地址街道名称
     *
     * @param person 当前员工
     * @return 街道名称
     */
    public String getServerStreetName(Person person) {
        return getStreet(person).getStreetName();
    }

    private Street getStreet(Person person) {
        return person.getDepartment().getAddress().getStreet();
    }

    /**
     * 获取员工所在的部门地址街道编号
     *
     * @param person 当前员工
     * @return 街道编号
     */
    public Integer getServerStreetNo(Person person) {
        return getStreet(person).getStreetNo();
    }
}
