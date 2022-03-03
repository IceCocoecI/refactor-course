/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class.server.interfaces;

import com.huawei.large_class.server.interfaces.dto.WorkmanInfoDto;
import com.huawei.large_class.server.processor.Workman;
import com.huawei.large_class.server.processor.WorkmanFactory;

/**
 * 对外暴露的生成工作人员信息的方法
 *
 * @since 2021-08-25
 */
public class WorkmanInfoGenerator {
    /**
     * 获取工作人员信息
     *
     * @param workmanInfoDto workmanInfo数据传输对象
     * @return 工作人员信息String
     */
    public String getWorkmanInfo(WorkmanInfoDto workmanInfoDto) {
        Workman workmanINfo =
            new WorkmanFactory().createWorkman(workmanInfoDto.getName(), workmanInfoDto.getGender(),
                workmanInfoDto.getContacts(), workmanInfoDto.getCareerInfo());
        return workmanINfo.generatePersonInfo();
    }
}
