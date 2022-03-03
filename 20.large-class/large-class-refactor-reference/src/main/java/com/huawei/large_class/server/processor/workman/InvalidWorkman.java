/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class.server.processor.workman;

import com.huawei.large_class.server.processor.Workman;
import com.huawei.large_class.server.processor.enums.Gender;
import com.huawei.large_class.server.processor.model.CareerInfo;
import com.huawei.large_class.server.processor.model.Contacts;

/**
 * 无效人员
 *
 * @since 2021-08-25
 */
public class InvalidWorkman extends Workman {
    public InvalidWorkman(String name, Gender gender, Contacts contacts, CareerInfo careerInfo) {
        super(name, gender, contacts, careerInfo);
    }

    @Override
    public String generatePersonInfo() {
        return "invalidPersonInfo";
    }
}
