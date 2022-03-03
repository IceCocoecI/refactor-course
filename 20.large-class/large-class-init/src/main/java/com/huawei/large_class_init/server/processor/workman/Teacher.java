/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class_init.server.processor.workman;

import com.huawei.large_class_init.server.processor.Workman;
import com.huawei.large_class_init.server.processor.enums.Gender;
import com.huawei.large_class_init.server.processor.model.CareerInfo;
import com.huawei.large_class_init.server.processor.model.Contacts;

/**
 * 功能描述
 *
 * @since 2021-12-13
 */
public class Teacher extends Workman {
    public Teacher(String name, Gender gender, CareerInfo careerInfo, Contacts contacts) {
        super(name, gender, careerInfo, contacts);
    }
}
